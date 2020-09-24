package Java_Core_Module_4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Task_4_3_6 {

    public static void logging() {
        final Logger LOG = Logger.getLogger(Task_4_3_6.class.getName());
        LOG.log(Level.INFO, "Все хорошо");
        LOG.log(Level.WARNING, "Произошла ошибка");
    }

    public static void main(String[] args) {
        logging();
    }
}
