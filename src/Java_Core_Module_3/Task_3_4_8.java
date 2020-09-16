package Java_Core_Module_3;

public class Task_3_4_8 {
    public static class ComplexNumber {
        private double re;
        private double im;

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            ComplexNumber cn = (ComplexNumber) obj;
            return re == cn.re && im == cn.im;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 53 * hash + (int)this.re;
            hash = 53 * hash + (int)this.im;
            return hash;
        }

        public static void main(String[] args) {
            ComplexNumber cn1 = new ComplexNumber(3.0, 5.0);
            ComplexNumber cn2 = new ComplexNumber(3.0, 5.0);
            Boolean result = cn1.equals(cn2);
            System.out.println(result);
        }

    }
}
