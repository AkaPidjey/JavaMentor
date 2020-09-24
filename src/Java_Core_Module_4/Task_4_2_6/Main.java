package Java_Core_Module_4.Task_4_2_6;

public class Main implements BankWorker {
    public static void main(String[] args) {
        BankClient client1 = new BankClient("Bad");
        BankClient client2 = new BankClient("Problem with law");
        BankClient client3 = new BankClient("Good history");
        Main m = new Main();

        System.out.println(m.getCreditForClient(m, client1));
        System.out.println(m.getCreditForClient(m, client2));
        System.out.println(m.getCreditForClient(m, client3));
    }

    public boolean getCreditForClient(BankWorker bankWorker, BankClient bankClient)  {
        try {
           return bankWorker.checkClientForCredit(bankClient);
        } catch (BadCreditHistoryException ex ) {
            System.out.println(ex);
            return false;
        } catch (ProblemWithLawException ex) {
            return false;
        }
    }


    @Override
    public boolean checkClientForCredit(BankClient bc) throws BadCreditHistoryException, ProblemWithLawException {
        if (bc.name.equals("Problem with law")) {
            throw new BadCreditHistoryException("Проблемы с банковской историей");
        } else if (bc.name.equals("Bad")) {
            throw new ProblemWithLawException("");
        } else {
            return true;
        }
    }
}
