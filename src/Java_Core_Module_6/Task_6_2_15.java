package Java_Core_Module_6;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_6_2_15 {
    public static Map<String, Long> getSalesMap(Reader reader) {
        Map<String, Long> map = new HashMap<>();
        Scanner s = new Scanner(reader);
        while (s.hasNext()) {
            String tempS = s.next();
            Long tempL = s.nextLong();
            if (map.containsKey(tempS)) {
                map.merge(tempS, tempL, (oldVal, newVal) -> oldVal + newVal);
            } else {
                map.put(tempS, tempL);
            }
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("D:\\1.txt");
        System.out.println(getSalesMap(reader));
    }
}
