package Java_Core_Module_6;

import java.util.ArrayList;
import java.util.Arrays;

public class Task_6_1_13 {

    public static class DynamicArray <T> {
        private int size = 0;
        Object[] array = new Object[1];
        private int count = 0;

        public DynamicArray() {
        }

        public void add(T el) {
            if (size == array.length) {
                array = Arrays.copyOf(array, array.length + 1);
            }
            array[size] = el;
            size++;
        }

        public void remove(int index) {
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        }


//                Object[] temp = new Object[array.length - 1];
//                for (int i = 0; i < array.length; i++) {
//
//                    if (i == index) {
//                        continue;
//                    } else {
//                        temp[count] = array[i];
//                        count++;
//                    }
//                }
//                array = temp;


        public T get(int index) {
            return (T) array[index];
        }
    }

    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        da.add("раз");
        da.add("два");
        da.add("три");
        da.remove(1);
        System.out.println(da);
        System.out.println(da.get(1));
    }



}
