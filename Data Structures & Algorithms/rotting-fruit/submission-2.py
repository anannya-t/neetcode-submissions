class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        time = 0
        q = collections.deque()
        fresh = 0
        # add rotten fruits to queue at each step

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 1:
                    fresh += 1
                if grid[r][c] == 2:
                    q.append((r, c))

        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while fresh > 0 and q:
            qLen = len(q)
            for i in range(qLen):
                r, c = q.popleft()

                for dr, dc in directions:
                    row, col = r + dr, c + dc
                    if (
                        row in range(len(grid)) and col in range(len(grid[0]))
                        and grid[row][col] == 1
                    ):
                        grid[row][col] = 2
                        q.append((row, col))
                        fresh -= 1
            time += 1
        return time if fresh == 0 else -1
