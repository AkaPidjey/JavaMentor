package Java_Core_Module_5;

import java.io.*;

public class Task_5_2_7 {
    public int sumOfStream(InputStream inputStream) throws IOException {
        int result = 0;
        while (inputStream.available() > 0) {
            result += (byte)inputStream.read();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        byte[] array = new byte[] {1, -2, 12, 10};
        ByteArrayInputStream bais = new ByteArrayInputStream(array);
        Task_5_2_7 temp = new Task_5_2_7();
        System.out.println(temp.sumOfStream(bais));
    }

}
