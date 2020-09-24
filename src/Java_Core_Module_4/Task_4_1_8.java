package Java_Core_Module_4;

public class Task_4_1_8 {
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] ste = new Exception().getStackTrace();
        if (ste.length < 3) {
            return null;
        } else {
            return ste[2].getClassName() + "#" + ste[2].getMethodName();
        }
    }

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
    }
}
