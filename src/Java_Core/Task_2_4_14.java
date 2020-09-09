package Java_Core;

import java.math.BigInteger;

public class Task_2_4_14 {
    public static BigInteger factorial(int value) {
        if (value == 0 || value == 1) {
            return BigInteger.valueOf(1);
        } else if (value < 0) {
            System.out.println("Введено число меньше 0");
            return null;
        } else {
            return BigInteger.valueOf(value).multiply( factorial(value - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(0));
    }
}
