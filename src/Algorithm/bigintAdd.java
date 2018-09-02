package Algorithm;

public class bigintAdd {

    public static String bigadd (String n1, String n2) {
        StringBuilder s1 = new StringBuilder(n1);
        StringBuilder s2 = new StringBuilder(n2);
        s1.reverse();
        s2.reverse();
        StringBuilder res = new StringBuilder();
        addHelper(s1, s2, false, 0, res);
        res = res.reverse();
        return res.toString();
    }

    private static void addHelper (StringBuilder n1, StringBuilder n2, boolean iscarry, int pos, StringBuilder res) {
        if (pos < n1.length() || pos < n2.length()) {
            char num1 = pos < n1.length() ? n1.charAt(pos) : '0';
            char num2 = pos < n2.length() ? n2.charAt(pos) : '0';
            int temp = add(num1, num2);
            if (iscarry)
                temp += 1;
            boolean carry = false;
            if (temp >= 10) {
                carry = true;
                temp -= 10;
            }
            res.append(temp);
            addHelper(n1, n2, carry, ++pos, res);

        } else {
            if (iscarry)
                res.append('1');
            return;
        }

    }

    private static int add (char num1, char num2) {
        return Integer.parseInt(String.valueOf(num1))
                + Integer.parseInt(String.valueOf(num2));
    }

    public static String norecursion (String n1, String n2) {
        StringBuilder s1 = new StringBuilder(n1);
        StringBuilder s2 = new StringBuilder(n2);
        s1.reverse();
        s2.reverse();
        StringBuilder res = new StringBuilder();
        int i = 0;
        Boolean carry = false;
        while (i < s1.length() || i < s2.length()) {
            char num1 = i < s1.length() ? s1.charAt(i) : '0';
            char num2 = i < s2.length() ? s2.charAt(i) : '0';
            int temp = add(num1, num2);
            if (carry) {
                ++temp;
            }
            if (temp >= 10) {
                temp -= 10;
                carry = true;
            }else{
                carry =false;
            }
            res.append(temp);
            ++i;
        }
        if(carry)
            res.append('1');
        return res.reverse().toString();
    }

    public static void main (String[] args) {
        bigintAdd.norecursion("1239", "1271");
    }
}
