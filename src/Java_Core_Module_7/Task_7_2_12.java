package Java_Core_Module_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Task_7_2_12 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
            br.lines().map(line -> line.toLowerCase()
                    .replaceAll("\\p{Punct}", " ").split("\\s+"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Comparator.comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue)
                            .reversed())
                    .map(n -> n.getKey()).limit(10)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
