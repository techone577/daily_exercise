package Algorithm;

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
