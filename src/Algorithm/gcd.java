package Algorithm;

public class gcd {
    public static int Gcd (int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public  static void main(String []args){
        gcd.Gcd(16,4);

    }
}
