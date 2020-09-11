package Java_Core_Module_1_2;

public class Task_2_3_10 {
    public static boolean isPalindrome(String text) {
        String str1 = text.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        String str2 = new StringBuilder(str1).reverse().toString();

        if (str1.equalsIgnoreCase(str2)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A palindrome is a word, number, phrase, or other sequence of " +
                "characters which reads the same backward as forward, such as madam or racecar or the number 10801"));
    }
}
