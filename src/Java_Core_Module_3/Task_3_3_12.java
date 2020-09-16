package Java_Core_Module_3;

import Java_0.Task_2_10_2;

public class Task_3_3_12 {
    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human((byte) 18, "Ivan", "Ivanov");
        Human human3 = new Human((byte) 31, "Ivan", "Ivanov", "box");
    }

    public static class Human {
        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        public Human() {}

        public Human(byte age, String name, String secondName) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }

        public Human(byte age, String name, String secondName, String favoriteSport) {
            this(age, name, secondName);
            this.favoriteSport = favoriteSport;
        }
    }
}
