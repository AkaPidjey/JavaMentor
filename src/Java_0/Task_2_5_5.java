package Java_0;

public class Task_2_5_5 {
    public static boolean determineAdult(int age) {
        if (age < 0) {
            System.out.println("Ошибка! Введите правильный возраст.");
            return false;
        } else if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(determineAdult(20));
    }
}
