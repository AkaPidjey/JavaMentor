package Java_Core_Module_6;

import javax.lang.model.type.UnionType;
import java.util.*;

public class Task_6_2_13 {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2)  {
        Set<T> temp1 = new TreeSet<>();
        Set<T> temp2 = new TreeSet<>();
        Set<T> result = new TreeSet<>();
        temp1.addAll(set1);
        temp2.addAll(set2);
        temp1.removeAll(set2);
        temp2.removeAll(set1);
        result.addAll(temp1);
        result.addAll(temp2);
        return result;
    }


    public static void main(String[] args) {
        Set s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        HashSet s2 = new HashSet<>();
        s2.add(0);
        s2.add(1);
        s2.add(2);

        Set result = symmetricDifference(s1,s2);
        System.out.println(result);
    }
}
