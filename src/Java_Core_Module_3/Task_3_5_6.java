package Java_Core_Module_3;

import java.util.Arrays;

public class Task_3_5_6 {
    public static class AsciiCharSequence implements java.lang.CharSequence  {
        private byte[] in;

        public AsciiCharSequence(byte[] in) {
            this.in = in;
        }

        @Override
        public int length() {
            return in.length;
        }

        @Override
        public char charAt(int index) {
            return (char)in[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(java.util.Arrays.copyOfRange(in, start, end));
        }

        @Override
        public String toString() {
            return new String(in);
        }

        public static void main(String[] args) {
            AsciiCharSequence acs = new AsciiCharSequence(new byte[] {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110});
            System.out.println(acs.toString());
        }
    }
}
