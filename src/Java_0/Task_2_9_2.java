package Java_0;

public class Task_2_9_2 {
    static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        int[] temp = new int[]{1, 3, 5};
        printArray(temp);
    }
}
