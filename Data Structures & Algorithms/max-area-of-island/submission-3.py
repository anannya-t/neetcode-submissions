class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:

        rows = len(grid)
        cols = len(grid[0])

        visited = set()

        def dfs(r, c):
            if (r < 0 or c < 0 or r >= rows or c >= cols or (r, c) in visited or grid[r][c] == 0):
                return 0
            else:
                visited.add((r, c))
                return 1 + dfs(r - 1, c) + dfs(r + 1, c) + dfs(r, c - 1) + dfs(r, c + 1)

        res = 0
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                area = dfs(r, c)
                res = max(res, area)
        
        return res