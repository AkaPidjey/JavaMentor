package Java_Core_Module_1_2;

public class Task_2_4_17 {
    public static void printOddNumbers(int[] arr) {
        int count = 0;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                sb.append(arr[i]);
                sb.append(",");
            }
        }

        count = sb.length();
        sb.deleteCharAt(count - 1);
        System.out.print(sb);
        System.out.println("");
    }

    public static void main(String[] args) {
        printOddNumbers(new int[]{3, 5, 20, 8, 7, 3, 100});
    }
}
