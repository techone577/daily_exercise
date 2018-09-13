package Algorithm;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */

public class leetcode73 {

    public void setZeroes (int[][] matrix) {
        int row0Flag = 1, colum0Flag = 1;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                row0Flag = 0;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colum0Flag = 0;
                break;
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][i] = 0;
                    break;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    break;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; ++i) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0Flag == 0) {
            for (int i = 0; i < matrix[0].length; ++i) {
                matrix[0][i] = 0;
            }
        }
        if (colum0Flag == 0) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][0] = 0;
            }
        }

    }
}

