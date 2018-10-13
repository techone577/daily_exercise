package Algorithm2;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class leetcode14 {
    public String longestCommonPrefix (String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int length = strs[0].length() < strs[1].length() ? strs[0].length() : strs[1].length();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i <length;++i){
            if(strs[0].charAt(i) == strs[1].charAt(i))
                prefix.append(strs[0].charAt(i));
            else
                break;
        }
        if(prefix.length() == 0)
            return "";
        for(int i=2;i<strs.length;++i){
            int l = prefix.length()<strs[i].length()?prefix.length():strs[i].length();
            for(int j=0;j<l;++j){
                if(prefix.charAt(j)!=strs[i].charAt(j)) {
                    prefix = prefix.delete(j, prefix.length());
                    break;
                }
            }
            if(prefix.length()>strs[i].length())
                prefix = new StringBuilder(strs[i]);

        }
        return prefix.toString();
    }

    public static void main(String []args){
        String []strs = new String[]{"abcc","abcc","abcd"};
        System.out.println(new leetcode14().longestCommonPrefix(strs));
    }
}
