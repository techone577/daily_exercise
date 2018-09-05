package Algorithm;

public class sqrt {
    //牛顿迭代法
    public static double Sqrt(int x) {
        double res = 0;
        double last = x;
        while (Math.abs(res - last) > 0.000000001) {
            res = last;
            last = (res + (x / res)) / 2;
        }
        return res;
    }

    public static double cmark(int number) {
        int i;
        float x2, y;
        float threehalfs = 1.5F;
        x2 = number * 0.5F;
        y = number;
        i = Float.floatToRawIntBits(y); // evil floating point bit level hacking
        i = 0x5f3759df - (i >> 1); // what the fuck?
        y = Float.intBitsToFloat(i);
        y = y * (threehalfs - (x2 * y * y)); // 1st iteration
        //y = y * (threehalfs - (x2 * y * y)); // 2nd iteration, this can be removed
        return 1 / y;
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(sqrt.cmark(1234567));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        long t3 = System.currentTimeMillis();
        System.out.println(sqrt.Sqrt(1234567));
        long t4 = System.currentTimeMillis();
        System.out.println(t4-t3);
        long t5 = System.currentTimeMillis();
        System.out.println(Math.sqrt(1234567));
        long t6 = System.currentTimeMillis();
        System.out.println(t6-t5);
    }
}
