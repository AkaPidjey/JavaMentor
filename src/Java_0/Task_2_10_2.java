package Java_0;

public class Task_2_10_2 {
    public static class Human {
        String name;
        int age;

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void sayHello() {
            System.out.println("Привет, меня зовут " + name + ", мне " + age + " лет.");
        }
    }

    public static void main(String[] args) {
        Human human = new Human("Aleksey", 35);
        human.sayHello();
    }

}
