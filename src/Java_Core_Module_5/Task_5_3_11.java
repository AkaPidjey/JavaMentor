package Java_Core_Module_5;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class Task_5_3_11 {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int count;
        byte[] data = new byte[1024];
        while ((count = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, count);
        }
        buffer.flush();
        return new String(buffer.toByteArray(), charset);
    }

////      Вариант 3  
//        BufferedInputStream bis = new BufferedInputStream(inputStream);
//        ByteArrayOutputStream buf = new ByteArrayOutputStream();
//        int result = bis.read();
//        while (result != -1) {
//            buf.write((byte)result);
//            result = bis.read();
//        }
//        return buf.toString(charset);
    

////      Вариант # 2
//        ByteArrayOutputStream result = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int lenght;
//        while ((lenght = inputStream.read(buffer)) != -1) {
//            result.write(buffer, 0, lenght);
//        }
//        return result.toString(charset);

////      Вариант # 1
//        String result = null;
//        String temp;
//        InputStreamReader isr = new InputStreamReader(inputStream);
//        BufferedReader br = new BufferedReader(isr);
//
//        while ((temp = br.readLine()) != null) {
//            result = new String(temp.getBytes(charset));
//        }
//        return result;

    public static void main(String[] args) throws IOException {
        byte[] bb = new byte[] {48, 49, 50, 51}; //0, 1, 2, 3
        ByteArrayInputStream bis = new ByteArrayInputStream(bb);
        System.out.println(readAsString(bis, Charset.forName("ASCII")));
    }
}
