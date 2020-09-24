package Java_Core_Module_4;

public class Task_4_2_7 {
    public static class Car implements AutoCloseable {
        public void close() {
            System.out.println("Машина закрывается...");
        }
        public void drive() {
            System.out.println("Машина поехала.");
        }
    }

    public static void main(String[] args) {
        try(Car car = new Car();) {
            car.drive();
        } catch (RuntimeException ex) {

        };
    }
}
