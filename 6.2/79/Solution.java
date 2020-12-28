class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, i, j, word, 0, visited))
                        return true;
                }
        return false;
    }

    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};
    private boolean dfs(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        if (k == word.length()) return true;
        if (invalid(board, i, j, word, k, visited))  return false;

        visited[i][j] = true;
        for (int c = 0; c < 4; c++)
            if (dfs(board, i + dx[c], j + dy[c], word, k + 1, visited))
                return true;

        visited[i][j] = false;
        return false;
    }

    private boolean invalid(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        return i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || visited[i][j] || word.charAt(k) != board[i][j];
    }
}