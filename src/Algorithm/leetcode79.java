package Algorithm;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class leetcode79 {
    public boolean exist (char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean helper (char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length())
            return true;
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0)
            return false;
        if (word.charAt(pos) != board[i][j])
            return false;
        boolean res = false;
        char temp = board[i][j];
        //表示已经访问不能再次访问
        board[i][j] = '*';
        res = helper(board, word, i - 1, j, pos + 1)
                || helper(board, word, i + 1, j, pos + 1)
                || helper(board, word, i, j - 1, pos + 1)
                || helper(board, word, i, j + 1, pos + 1);
        //恢复未访问状态
        board[i][j] = temp;
        return res;
    }

    public static void main (String []args) {
        char [][]a= new char [][]{{'C','A','A'},
                                  {'A','A','A'},
                                  {'B','C','D'}};
        new leetcode79().exist(a,"AAB");
    }
}
