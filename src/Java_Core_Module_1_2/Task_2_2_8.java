package Java_Core_Module_1_2;

public class Task_2_2_8 {
    public static boolean isPowerOfTwo(int value) {
        value = Math.abs(value);
        if (value == 0) {
            return false;
        }
        while (value != 1) {
            if (value % 2 != 0) {
                return false;
            }
            value = value / 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-2));
    }
}
