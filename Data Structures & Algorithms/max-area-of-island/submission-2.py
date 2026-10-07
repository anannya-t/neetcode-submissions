class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        visit = set()

        def dfs(r, c):
            if (r >= len(grid) or c >= len(grid[0]) or c < 0 or r < 0 or grid[r][c] == 0 or (r, c) in visit):
                return 0
            visit.add((r, c))
            return 1 + dfs(r - 1, c) + dfs(r, c - 1) + dfs(r, c + 1) + dfs(r + 1, c)

        res = 0

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                res = max(res, dfs(r, c))

        return res