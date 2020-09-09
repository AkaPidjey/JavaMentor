package Java_Core;

public class Task_2_4_15 {
    public int determineGroup(int age) {
        if (age >= 7 && age <= 13) {
            return 1;
        } else if (age >= 14 && age <= 17) {
            return 2;
        } else if (age >= 18 && age <= 65) {
            return 3;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Task_2_4_15 temp = new Task_2_4_15();
        System.out.println(temp.determineGroup(6));
    }
}
