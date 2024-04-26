package day2.leetcode.medium;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    solve(board, word, 0, i, j, new boolean[board.length][board[0].length]);
                    if (finalRes) {
                        return finalRes;
                    }
                }
            }
        }
        return false;
    }

    private boolean finalRes = false;

    private boolean solve(char[][] board, String word, int currIdx, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j]
                || word.charAt(currIdx) != board[i][j]) {
            return false;
        }

        if (currIdx == (word.length() - 1) && word.charAt(currIdx) == board[i][j]) {
            finalRes = true;
            return true;
        }

        visited[i][j] = true;
        boolean res = solve(board, word, currIdx + 1, i + 1, j, visited);
        if (!res) {
            res = solve(board, word, currIdx + 1, i, j + 1, visited);
        }
        if (!res) {
            res = solve(board, word, currIdx + 1, i - 1, j, visited);
        }
        if (!res) {
            res = solve(board, word, currIdx + 1, i, j - 1, visited);
        }
        visited[i][j] = false;
        return res;
    }
}
