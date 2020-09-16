package Java_Core_Module_3;


import org.w3c.dom.ls.LSOutput;

public class Task_3_3_11 {
    public static class Cat {
        public void sayHello() {
            System.out.println("Мяу!");
        }
    }

    public static class Dog {
        public void sayHello() {
            System.out.println("Гав!");
        }
        public void catchCat(Cat cat1) {
            System.out.println("Кошка поймана");
            Dog dog = new Dog();
            dog.sayHello();
            cat1.sayHello();
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.catchCat(new Cat());
    }
}
