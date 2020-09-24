package Java_Core_Module_4;

import Java_Core_Module_3.Task_3_3_11;

public class Task_4_1_7 {
    public class MyNewException extends Exception {

    }

    public void testExp() throws MyNewException {
        throw new MyNewException();
    }

    public static void main(String[] args) throws MyNewException {
        Task_4_1_7 t = new Task_4_1_7();
        t.testExp();
    }
}
