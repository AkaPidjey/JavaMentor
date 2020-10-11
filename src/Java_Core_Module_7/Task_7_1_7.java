package Java_Core_Module_7;

import java.util.function.UnaryOperator;

public class Task_7_1_7 {
    public static UnaryOperator<Integer> sqrt() {
        return x -> x * x;
    }


    public static void main(String[] args) {
        System.out.println(sqrt().apply(5));
    }

}
