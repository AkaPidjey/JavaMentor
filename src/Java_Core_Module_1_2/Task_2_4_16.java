package Java_Core_Module_1_2;

public class Task_2_4_16 {
    public int[] evenArray(int number) {
        int temp = 0;
        int[] result = new int[number / 2];

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                result[temp] = i;
                temp++;
            }
        }

        for (int x : result) {
            System.out.print(x + " ");
        }

        return result;
    }

    public static void main(String[] args) {
        Task_2_4_16 vivod = new Task_2_4_16();
        vivod.evenArray(0);
    }
}
