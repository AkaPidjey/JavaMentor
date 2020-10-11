package Java_Core_Module_7;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_7_2_11 {

    public <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<?> list = stream
                .sorted(order)
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept((T)list.get(0), (T) list.get(list.size() - 1));

        }
    }
}
