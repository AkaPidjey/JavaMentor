package Java_Core_Module_6;

public class Task_6_1_11 {

    public static class Box<T> {
        private T object;

        public static <T> Box<T> getBox() {
            return new Box<>();
        }
    }
}
