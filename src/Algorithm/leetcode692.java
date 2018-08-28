package Algorithm;

import java.util.*;


public class leetcode692 {
    public  List<String> topKFrequent (String[] words, int k) {
        if (words.length == 0)
            return null;
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i],1);
        }
        List<Map.Entry<String,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue()!=o2.getValue())
                    return o1.getValue().compareTo(o2.getValue());
                else
                    return -o1.getKey().compareTo(o2.getKey());
            }
        });
        for(int i=list.size()-1;k>0;k--,i--){
            res.add(list.get(i).getKey());
        }
        return res;
    }
    public static void main(String []args){
            new leetcode692().topKFrequent(new String[]{ "a", "b","b", "c", "c", "d", "b","d"},1);
    }
}
