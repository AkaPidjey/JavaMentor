package Java_0;

public class Task_2_6_2 {
    public static long determineRainfall(double area, double rainfallAmount) {
        double result = area * 1_000_000 * rainfallAmount * 2;
        long itog = (long) result;
        return itog;
    }

    public static void main(String[] args) {
        System.out.println(determineRainfall(8, 12));
    }
}
