package Algorithm;

import java.util.*;

public class LRU {
    public static void lruByLinkedHashMap () {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(20, (float) 0.75, true) {
            @Override
            protected boolean removeEldestEntry (Map.Entry<Integer, Integer> eldest) {
                return size() > 10;
            }
        };
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        System.out.println(map.toString());
        map.get(1);
        System.out.println("访问元素1后: " + map.toString());
        map.put(11, 11);
        System.out.println("添加元素11后: " + map.toString());
    }

    public static void lruCacheByHand () {
        Map<Integer, Integer> buffer = new LinkedHashMap<>(10, 0.75f, false);
        for (int i = 0; i < 10; i++) {
            buffer.put(i, i);
        }
        System.out.println(buffer.toString());
        getByHand(buffer,1);
        System.out.println("手动访问元素1后: " + buffer.toString());
        addByHand(buffer,11);
        System.out.println("手动添加元素11后: " + buffer.toString());
    }

    private static void addByHand (Map<Integer, Integer> buffer, int num) {
        if (buffer.size() < 10)
            buffer.put(num, num);
        else {
            buffer.remove(buffer.entrySet().iterator().next().getKey());
            buffer.put(num, num);
        }
    }

    private static void getByHand (Map<Integer, Integer> buffer, int num) {
        if (buffer.containsKey(num)) {
            Integer key = num;
            Integer value = buffer.get(key);
            buffer.remove(key);
            buffer.put(key, value);
        } else {
            return;
        }
    }

    public static void main (String[] args) {
        LRU.lruByLinkedHashMap();
        LRU.lruCacheByHand();
    }
}
