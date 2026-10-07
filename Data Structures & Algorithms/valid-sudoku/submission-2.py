class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        seen = set()

        for i in range(9):
            for j in range(9):
                if board[i][j] != ".":
                    row = str(board[i][j]) + " in row " + str(i)
                    col = str(board[i][j]) + " in col " + str(j)
                    box = str(board[i][j]) + " in box " + str(i // 3) + "," + str(j // 3)

                    if row in seen or col in seen or box in seen:
                        return False
                    else:
                        seen.add(row)
                        seen.add(col)
                        seen.add(box)

        return True