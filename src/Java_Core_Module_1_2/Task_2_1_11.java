package Java_Core_Module_1_2;

public class Task_2_1_11 {
    public static int drawisMonitorsCounter(int monitors, int programmers) {
        int result = monitors % programmers;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(drawisMonitorsCounter(10, 3));
    }
}
