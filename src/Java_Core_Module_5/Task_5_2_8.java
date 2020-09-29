package Java_Core_Module_5;

import java.io.*;

public class Task_5_2_8 {
    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int temp = 0;

        while (inputStream.available() > 0) {
            temp = (byte)inputStream.read();

            if (temp % 2 == 0) {
                outputStream.write(temp);
                outputStream.flush();
            }
        }

    }
}
