package Java_Core_Module_7;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task_7_2_10 {

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> ((x * x) / 10 ) % 1000);
    }

    public static void main(String[] args) {
        IntStream i = pseudoRandomStream(13);
        i.limit(20).forEach(System.out::println);
    }
}
