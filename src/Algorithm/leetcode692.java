package Algorithm;

import java.util.*;

/**
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 放到map中按次数排序再按字典序排序
 * 重写比较器，可以这么写Comparator.comparing(Map.Entry<String,Integer>::getValue)
 * 但是感觉不灵活，也不好用
 */
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
                //次数不相等按次数排序
                if(o1.getValue()!=o2.getValue())
                    return o1.getValue().compareTo(o2.getValue());
                //相等按字典序排序
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
