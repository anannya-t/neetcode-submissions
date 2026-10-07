class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> states = new HashSet<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') { 
                    String row = board[i][j] + " in row " + i;
                    String col = board[i][j] + " in col " + j;
                    String box = board[i][j] + " in box " + i/3 + "," + j/3;

                    if (states.contains(row) || states.contains(col)
                    || states.contains(box)) {
                        return false;
                    }

                    states.add(row);
                    states.add(col);
                    states.add(box);
                }
            }
        }

        return true;
    }
}
