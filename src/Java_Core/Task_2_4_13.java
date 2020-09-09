package Java_Core;

import java.math.BigInteger;

public class Task_2_4_13 {
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for (int a = 1; a <= value; a++) {
            result = result.multiply(BigInteger.valueOf(a));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(0));
    }
}
