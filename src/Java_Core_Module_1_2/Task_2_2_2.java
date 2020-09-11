package Java_Core_Module_1_2;

public class Task_2_2_2 {
    public static char charExpression(int a) {
//        char input = '\\';
//        char result = (char)((int)input + a);
//        return result;

        return (char)('\\' + a);
    }

    public static void main(String[] args) {
        System.out.println(charExpression(10));
    }

}
