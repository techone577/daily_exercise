package Algorithm;


import java.util.LinkedList;
import java.util.List;

/**
给数字n、m，求从1-n中数字相加为m的所有组合
 */
public class nm {

    public static void solution(int n,int m){
        List<Integer> bag = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        long before = System.currentTimeMillis();
        helper(list,1,n,m,0,bag);
        long after = System.currentTimeMillis();
        System.out.println(after - before);
        System.out.print(list);
    }

    private static void helper(List<List<Integer>> list,int pos,int n,int m,int sum, List<Integer> bag){
        for(int i=pos;i<=n;i++){
            if(sum+i<m) {
                bag.add(i);
                List<Integer> t = new LinkedList<>(bag);
                helper(list,i+1,n,m,sum+i,bag);
                bag=t;
                bag.remove(bag.size()-1);

            }else if(sum+i==m){
                bag.add(i);
                list.add(bag);
            }else{
                break;
            }
        }
    }
    public static void main(String []args){
        nm.solution(100,100);
    }
}
