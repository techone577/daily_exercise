package Algorithm;

public class revertInteger {
    public static int  reverse(int x) {
        String str = new StringBuilder(String.valueOf(x)).reverse().toString();
        str = str.split("-")[0];
        int res=0;
        try{
            res = Integer.valueOf(str);
        }catch(Exception e){
            res=0;
        }
        return  x<0?0-res:res;
    }
    public static void main(String []args){
        revertInteger.reverse(-10);
    }
}
