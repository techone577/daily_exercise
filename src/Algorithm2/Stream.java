package Algorithm2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * java8 stream表达式
 */
public class Stream {
    List<Integer> list = new ArrayList<>();
    Map<Integer, String> map = new HashMap<>();

    public Stream () {
        for (int i = 0; i < 12; i++) {
            list.add(i);
            map.put(i, new StringBuilder().append((char) i).toString());
        }
    }

    /**
     * filter
     * 过滤
     */
    public void filter () {
        list = list.stream().filter(item -> item > 10).collect(Collectors.toList());
        System.out.println("filter():" + list.toString());
    }

    /**
     * limit
     * 截取流的前几个元素
     */
    public void limit () {
        list = list.stream().limit(5).collect(Collectors.toList());
        System.out.println("limit():" + list.toString());
    }

    /**
     * skip
     * 跳过流中前几个元素
     */
    public void skip () {
        list = list.stream().skip(5).collect(Collectors.toList());
        System.out.println("skip():" + list.toString());
    }

    /**
     * reduce
     * 按一定规则归约
     */
    public void reduce () {
        Optional t = list.stream().reduce((res, acc) -> {
            res += acc;
            return res;
        });
        Optional max = list.stream().reduce((m, acc) -> {
            m = Math.max(m, acc);
            return m;
        });
        System.out.println(t.get() + " " + max.get());
    }

    /**
     * findFirst
     * 获取第一次出现的元素
     * findAny
     * 返回任意一个值（区别主要在并行流上）
     */
    public void findFirst () {
        Optional t = list.stream().filter(i -> i > 7).findFirst();
        System.out.println(t.get());
    }

    /**
     * flatMap
     * 将若干个集合并在一起
     */
    public void flatMap () {
        List<List<Integer>> l = new ArrayList<>();
        l.add(list);
        list.add(12);
        l.add(list);
        list = l.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(list);
        //聚合去重
        Set<Integer> set = l.stream().flatMap(List::stream).collect(Collectors.toSet());
        System.out.println(set.toString());
    }

    /**
     * map
     * 映射操作
     */
    public void map(){
        List<Integer> res = map.keySet().stream().map(i->i*2).collect(Collectors.toList());
        System.out.println(res);
    }

    /**
     * max
     */
    public void max(){
        Optional t = list.stream().max(Comparator.comparing(Integer::valueOf));
        System.out.println(t.get());
    }

    /**
     * count
     */
    public void count(){
        long count = list.stream().filter(i->i>7).count();
        System.out.println(count);
    }

    /**
     * distinct
     */
    public void distinct(){
        List<List<Integer>> l = new ArrayList<>();
        l.add(list);
        list.add(12);
        l.add(list);
        list = l.stream().flatMap(List::stream).collect(Collectors.toList());
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list.toString());
    }
    public static void main (String[] args) {
        new Stream().filter();
        new Stream().limit();
        new Stream().skip();
        new Stream().reduce();
        new Stream().findFirst();
        new Stream().flatMap();
        new Stream().map();
        new Stream().max();
        new Stream().count();
        new Stream().distinct();
    }
}
