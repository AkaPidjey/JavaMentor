package Java_Core;

public class Task_2_1_10 {
    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) < 0.0001;
    }

    public static void main(String[] args) {
        System.out.println(doubleExpression(0.100, 0.200, 0.300));
    }
}
