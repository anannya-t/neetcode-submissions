class Solution {
    public boolean exist(char[][] board, String word) {
        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return found;
    }

    public boolean search(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
            board[i][j] != word.charAt(index)) {
                return false;
            }

        else if (word.charAt(index) == board[i][j]) {

            char temp = board[i][j];
            board[i][j] = '#';

            boolean res = search(board, i + 1, j, word, index + 1) ||
            search(board, i - 1, j, word, index + 1) ||
            search(board, i, j + 1, word, index + 1) ||
            search(board, i, j - 1, word, index + 1);

            board[i][j] = temp;
            return res;
        }

        return false;
    }
}
