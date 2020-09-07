package Java_0;

public class Task_2_5_2 {
    static int incrementIfPositive(int a) {
        if (a > 0) {
            a += 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(incrementIfPositive(-10));
    }
}
