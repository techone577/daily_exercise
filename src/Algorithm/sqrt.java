package Algorithm;

public class sqrt {
    public static double Sqrt (int x) {
        double res=0;
        double last=x;
        while(Math.abs(res-last)>0.000000001){
            res = last;
            last = (res+(x/res))/2;
        }
        return res;
    }

    public static double cmark(int number){
        int i;
        float x2, y;
        float threehalfs = 1.5F;
        x2 = number * 0.5F;
        y = number;
        i = Float.floatToRawIntBits(y); // evil floating point bit level hacking
        i = 0x5f3759df - ( i >> 1 ); // what the fuck?
        y =Float.intBitsToFloat(i);
        y = y * ( threehalfs - ( x2 * y * y ) ); // 1st iteration
        y = y * ( threehalfs - ( x2 * y * y ) ); // 2nd iteration, this can be removed
        return 1/y;
    }

    public static void main (String[] args) {
       System.out.println(sqrt.cmark(2));
       System.out.println(sqrt.Sqrt(2));
       System.out.println(Math.sqrt(2));
    }
}
