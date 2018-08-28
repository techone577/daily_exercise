package Algorithm;

public class leetcode8 {
    public static int myAtoi(String str) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) != ' '){
                str =str.substring(i);
                break;
            }
        }
        if(str.length()==0)
            return 0;
        if(str.length()>=2&&str.charAt(0)=='+'&&(str.charAt(1)<'0'|| str.charAt(1)>'9'))
            return 0;
        if(str.length()==1&& (str.charAt(0)=='-'||str.charAt(0)=='+'))
            return 0;
        if(str.charAt(0)=='+')
            str=str.substring(1);
        if(str.length()>=2&&str.charAt(0)=='-'&&(str.charAt(1)<'0'|| str.charAt(1)>'9'))
            return 0;
        if((str.charAt(0)<'0'|| str.charAt(0)>'9')&&str.charAt(0)!='-')
            return 0;
        if(str.equals(String.valueOf(Integer.MAX_VALUE)))
            return Integer.MAX_VALUE;
        if(str.equals(String.valueOf(Integer.MIN_VALUE)))
            return Integer.MIN_VALUE;
        int length = str.length();
        int ans=0;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<length;i++){
            if( i==0 && str.charAt(i)=='-') {
                result.append('-');
                continue;
            }
            if(str.charAt(i)<'0'|| str.charAt(i)>'9')
                break;
            else
                result.append(str.charAt(i));
        }
        char f = result.charAt(0);
        String s = new StringBuilder(result.reverse().toString().split("-")[0]).reverse().toString();
        try{
            ans = Integer.valueOf(s);
        }catch(Exception e){
            ans= f=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        return f=='-'?0-ans:ans;
    }

    public static void main(String []args){
       System.out.print( leetcode8.myAtoi("-w"));
    }
}
