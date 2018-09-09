package Algorithm;

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 按照左边界排序，然后两两合并
 */
public class leetcode56 {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        List<Interval> res = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval left = intervals.get(i - 1);
            Interval right = intervals.get(i);
            Interval mergeInterval = new Interval();
            if (right.start <= left.end) {
                mergeInterval = new Interval(left.start, Math.max(left.end, right.end));
                intervals.set(i,mergeInterval);
            } else
                res.add(intervals.get(i - 1));
        }
        res.add(intervals.get(intervals.size() - 1));
        return res;
    }

    public static void main(String []args) {
        Interval a1 = new Interval(1,3);
        Interval a2 = new Interval(2,6);
        Interval a3 = new Interval(8,10);
        Interval a4 = new Interval(15,18);
        List<Interval> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        new leetcode56().merge(list);
    }
}
