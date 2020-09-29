package Java_Core_Module_5;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

/*
Task 5_3_12
 */
public class Task_5_3_12 {
    public static void main(String[] args) {
        final DecimalFormat df = new DecimalFormat("#0.000000");
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);
        double result = 0;
        while (scan.hasNext()) {
            if (scan.hasNextDouble()) {
                result += scan.nextDouble();
            } else {
                scan.next();
            }
        }
        System.out.print(df.format(result));
    }
}
