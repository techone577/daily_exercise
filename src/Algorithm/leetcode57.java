package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class leetcode57 {

    public class Interval {
        int start;
        int end;

        Interval () {
            start = 0;
            end = 0;
        }

        Interval (int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> insert (List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }

    public List<Interval> merge (List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare (Interval o1, Interval o2) {
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
                intervals.set(i, mergeInterval);
            } else
                res.add(intervals.get(i - 1));
        }
        res.add(intervals.get(intervals.size() - 1));
        return res;
    }
}
