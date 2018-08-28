package Algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class unionFind {
    public static int solution (List<List<Integer>> list) {
        int[] size = new int[10];
        int[] parent = new int[10];
        for (int i = 0; i < size.length; i++) {
            size[i] = 0;
            parent[i] = i;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() != 0) {
                Set<Integer> set = new HashSet<>();
                if (parent[i] != i)
                    set.add(parent[i]);
                for (Integer t : list.get(i)) {
                    int root = find(t, parent);
                    if (root != t) {
                        set.add(root);
                        continue;
                    }
                    if (parent[i] != t) {
                        parent[t] = i;
                        size[i]++;
                        size[t]--;
                    }
                }
                for (Integer t : set) {
                    union(t, i, size, parent);
                }
            }
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != find(i, parent)) {
                size[i] += size[parent[i]];
                size[parent[i]] = -1;
                parent[i] = find(i, parent);
            }
        }
        int count = 0;
        for (int i = 0; i < size.length; i++)
            if (size[i] >= 0)
                count++;
        return count;
    }

    private static int find (int x, int[] parent) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x], parent);
    }

    private static void union (int l, int r, int[] size, int[] parent) {
        int xparent = find(l, parent);
        int yparent = find(r, parent);
        if (xparent == yparent)
            return;
        for (int i = 0; i < parent.length; i++) {
            if (find(i, parent) == yparent) {
                parent[i] = xparent;
                size[xparent]++;
                size[yparent]--;
            }
        }
    }

    public static void main (String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
        list.get(0).add(1);
        list.get(0).add(2);
        list.get(1).add(3);
        list.get(1).add(0);
        list.get(5).add(1);

        unionFind.solution(list);
    }

}
