package Java_Core_Module_1_2;

public class Task_2_4_18 {
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int countA1 = 0;
        int countA2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (countA1 > a1.length - 1) {
                int a = a2[countA2];
                result[i] = a;
                countA2++;
            } else if (countA2 > a2.length - 1) {
                int a = a1[countA1];
                result[i] = a;
                countA1++;
            } else if (a1[countA1] < a2[countA2]) {
                int a = a1[countA1];
                result[i] = a;
                countA1++;
            } else {
                int a = a2[countA2];
                result[i] = a;
                countA2++;
            }
        }

        for (int x : result) {
            System.out.println(x);
        }

        return result;
    }

    public static void main(String[] args) {
        mergeArrays(new int[]{0, 0, 1}, new int[]{2, 5});
    }
}
