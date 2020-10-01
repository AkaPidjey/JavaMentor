package Java_Core_Module_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_6_2_14 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            list.add(s.nextInt());
        }

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {
                result.add(list.get(i));
            }
        }

        for (int a = result.size() - 1; a >= 0; a--) {
            System.out.print(result.get(a) + " ");
        }
    }

}
