class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preMap = {}
        for i in range(numCourses):
            preMap[i] = []

        for a, b in prerequisites:
            preMap[a].append(b)

        visited = set()
        def dfs(crs):
            if crs in visited:
                return False
            if preMap[crs] == []:
                return True
            else:
                visited.add(crs)
                for pre in preMap[crs]:
                    if not dfs(pre):
                        return False
                visited.remove(crs)
                preMap[crs] = []
                return True
        

        for i in range(numCourses):
            if not dfs(i):
                return False
        return True