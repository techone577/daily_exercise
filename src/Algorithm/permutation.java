package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class permutation {
    public static void solution(int []nums){
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> bag = new LinkedList<>();
        int []visited = new int [nums.length];
        helper(list,bag,nums,visited);
        System.out.print(visited[0]);
        System.out.print(list);

    }
    private static void helper(List<List<Integer>> list,List<Integer> bag ,int []nums,int []visited){
        if(bag.size()==nums.length){
            list.add(bag);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==0){
                bag.add(nums[i]);
                visited[i]=1;
                List<Integer> t = new LinkedList<>(bag);
                helper(list,bag,nums,visited);
                visited[i]=0;
                bag = t;
                bag.remove(bag.size()-1);
            }
        }
    }
    public static void main(String []args){
        permutation.solution(new int[]{1,2,3});
    }
}
