package Algorithm;

/**
 * 实现 atoi，将字符串转为整数。
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来,
 * 这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * 若函数不能执行有效的转换，返回 0。
 * 说明：假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */

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
