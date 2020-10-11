package Java_Core_Module_7;

public class Task_7_1_8 {

    @FunctionalInterface
    public interface NumberGenerator< T extends Number> {
        boolean cond(T arg);
    }

    public static NumberGenerator<? super Number> getGenerator() {
        return x -> x.intValue() > 0;
    }

    public static void main(String[] args) {
        NumberGenerator numGen = getGenerator();
        System.out.println(numGen.cond(123456L));
        System.out.println(numGen.cond(123456.56));
        System.out.println(numGen.cond(132));
        System.out.println(numGen.cond(Byte.MAX_VALUE));
        System.out.println(numGen.cond(-5.5));
        System.out.println(numGen.cond(-1253523525L));
        System.out.println(numGen.cond(0));
        System.out.println(numGen.cond(-2));
        System.out.println(numGen.cond(Byte.MIN_VALUE));
    }
}
