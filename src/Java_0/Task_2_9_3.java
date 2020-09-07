package Java_0;

public class Task_2_9_3 {
    static int[] fillArray(int x) {
        int[] result = new int[x];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
//        for (int a : result) {
//            System.out.println(a);
//        }
        return result;
    }

    public static void main(String[] args) {
        fillArray(3);
    }
}
