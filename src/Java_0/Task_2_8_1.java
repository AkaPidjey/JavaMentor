package Java_0;

public class Task_2_8_1 {
    public static int getMinFromTwo(int x, int y) {
        int min;
        min = x < y ? x : y;
        return min;
    }

    public static int getMinFromFour(int x, int y, int m, int n) {
        int temp1 = getMinFromTwo(x, y);
        int temp2 = getMinFromTwo(m, n);
        int result = temp1 < temp2 ? temp1 : temp2;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getMinFromFour(20, 10, 0, -8));
    }
}
