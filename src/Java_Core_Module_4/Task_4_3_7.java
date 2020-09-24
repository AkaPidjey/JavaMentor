package Java_Core_Module_4;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task_4_3_7 {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    /*
      Интерфейс: сущность, которую можно отправить по почте.
      У такой сущности можно получить от кого и кому направляется письмо.
    */
    public static interface Sendable {
        String getFrom();
        String getTo();
    }



    /*
      Абстрактный класс,который позволяет абстрагировать логику хранения
      источника и получателя письма в соответствующих полях класса.
    */
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }



    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }



    /*
       Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }



    /*
       Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }


    /*
      Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }




    /*
      Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            return mail;
        }
    }



    /*
      UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
      чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект
      набору третьих лиц, а затем, в конце концов, передает получившийся объект
      непосредственно экземпляру RealMailService. У UntrustworthyMailWorker должен быть конструктор
      от массива MailService (результат вызова processMail первого элемента массива передается
      на вход processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает
      ссылку на внутренний экземпляр RealMailService, он не приходит масивом в конструкторе
      и не настраивается извне класса.
    */
    public static class UntrustworthyMailWorker implements MailService {
        private MailService[] ms;
        private static final RealMailService rms = new RealMailService();

        public UntrustworthyMailWorker(MailService[] ms) {
            this.ms = ms;
        }

        public RealMailService getRealMailService(){
            return rms;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService msa : ms) {
                mail = msa.processMail(mail);
            }
            return rms.processMail(mail);
        }
    }


    /*
      Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
      Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
      Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения
      (в выражениях нужно заменить части в фигурных скобках на значения полей почты):
      2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог
      сообщение с уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
      2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
    */
    public static class Spy implements MailService {
        Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getFrom().equals(AUSTIN_POWERS) || mail.getTo().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[] {mail.getFrom(), mail.getTo(), ((MailMessage)mail).getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[] {mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }

    }



    /*
      Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает
      в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
      Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную
      стоимость всех посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки,
      которая пришла вору, он отдает новую, такую же, только с нулевой ценностью
      и содержимым посылки "stones instead of {content}".
    */
    public static class Thief implements MailService {
        private int minPrice;
        private int stolenValue;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {
                MailPackage mp = (MailPackage)mail;
                int price = mp.getContent().getPrice();
                if (price >= minPrice) {
                    stolenValue += price;
                    return new MailPackage(mp.getFrom(), mp.getTo(),
                            new Package("stones instead of " + mp.getContent().getContent(), 0));
                }
            }
            return mail;
        }
    }



    /*
      Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу
      в виде исключения, если была обнаружена подобная посылка. Если он заметил запрещенную посылку
      с одним из запрещенных содержимым ("weapons" и "banned substance"), то он бросает IllegalPackageException.
      Если он находит посылку, состоящую из камней (содержит слово "stones"), то тревога прозвучит
      в виде StolenPackageException. Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.
    */
    public static class Inspector implements MailService {

        public Inspector() {
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                String str = ((MailPackage) mail).getContent().getContent();
                if (str.contains(WEAPONS) || str.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                if (str.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {
        }
    }


    public static class Solution {

        public static final String AUSTIN_POWERS = "Austin Powers";
        public static final String WEAPONS = "weapons";
        public static final String BANNED_SUBSTANCE = "banned substance";

        public static void main(String[] args) throws UnsupportedEncodingException {

            Logger logger = Logger.getLogger(Solution.class.getName());
            logger.setLevel(Level.INFO);
            Inspector inspector = new Inspector();
            Spy spy = new Spy(logger);
            Thief thief = new Thief(100);
            MailService variousWorkers[] = new MailService[]{spy, thief, inspector};
            UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);
            Package pack1 = new Package("ВВЖ", 32);
            Package pack2 = new Package("рпакетный двигатель ", 2500000);
            Package pack3 = new Package("stones", 1000);
            Package pack4 = new Package("banned substance", 99);
            Package pack5 = new Package("tiny bomb", 9000);
            AbstractSendable correspondence[] = {
                    new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                            "Ты же вылез из мамы под мой дисс на Бабана...."),
                    new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                            "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                    new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                    new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                    new MailPackage("берег", "море", pack1),
                    new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                    new MailPackage(AUSTIN_POWERS, "NASA", pack2),
                    new MailPackage(AUSTIN_POWERS, "NASA", pack3),
                    new MailPackage("Китай", "КНДР", pack4),
                    new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", pack5),
                    new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
            };
            Arrays.stream(correspondence).forEach(parcell -> {
                try {
                    worker.processMail(parcell);
                } catch (StolenPackageException e) {
                    logger.log(Level.WARNING, "Inspector found stolen package: " + e);
                } catch (IllegalPackageException e) {
                    logger.log(Level.WARNING, "Inspector found illegal package: " + e);
                }
            });

            System.out.println(thief.getStolenValue());
            System.out.println(thief.stolenValue);
        }

    }





}
