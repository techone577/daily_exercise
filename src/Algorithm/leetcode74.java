package Algorithm;

/**
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性;
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 两次二分查找
 */
public class leetcode74 {
    public static  boolean searchMatrix (int[][] matrix, int target) {
        int n = matrix.length;
        if(n==0)
            return false;
        int m = matrix[0].length;
        if(m==0)
            return false;
        int i = 0, j = n - 1, midColumn = 0;
        while (i <= j) {
            midColumn = (i + j) / 2;
            if (matrix[midColumn][0] <= target && target <= matrix[midColumn][m - 1])
                break;
            if(target<matrix[midColumn][0])
                j=midColumn-1;
            else
                i=midColumn+1;
        }
        if (i > j)
            return false;
        int p = 0, q = m - 1, midRow = 0;
        while (p <= q) {
            midRow = (p + q) / 2;
            if (matrix[midColumn][midRow] == target)
                return true;
            else if(matrix[midColumn][midRow]<target)
                p=midRow+1;
            else
                q=midRow-1;
        }
        return false;
    }

    public static void main(String []args) {
        int[][] matrix = {{1,3}};
        System.out.print(leetcode74.searchMatrix(matrix,3));
    }
}
