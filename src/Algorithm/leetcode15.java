package Algorithm;

import java.util.*;

public class leetcode15 {

    public static List<List<Integer>> threeSum (int[] nums) {
        Map<Integer, Integer> twosum = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3)
            return res;
        for (int i = 0; i < nums.length; i++)
            twosum.put(nums[i], i);
        Set<Integer> set = new HashSet<>();
        Set<List<Integer>> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            if (set.contains(target))
                continue;
            set.add(target);
            for (int j = i + 1; j < nums.length; j++) {
                if (twosum.containsKey(target - nums[j])) {
                    if (twosum.get(target - nums[j]) > i + 1 && twosum.get(target - nums[j]) != j) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(target - nums[j]);
                        Collections.sort(list);
                        s.add(list);
                    }
                }
            }
        }
        for (List<Integer> l : s)
            res.add(l);
        return res;
    }

    public static List<List<Integer>> bestSolution (int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return res;
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;

    }

    public static void main (String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        leetcode15.bestSolution(nums);

    }
}
