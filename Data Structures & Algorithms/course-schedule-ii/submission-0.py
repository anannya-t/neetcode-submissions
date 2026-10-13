class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        preMap = {}

        for i in range(numCourses):
            preMap[i] = []

        for crs, pre in prerequisites:
            preMap[crs].append(pre)
        
        res = []
        visited = set()
        cycle = set()

        def dfs(crs):
            if crs in cycle:
                return False
            if crs in visited:
                return True
            cycle.add(crs)
            for pre in preMap[crs]:
                if dfs(pre) == False:
                    return False
            visited.add(crs)
            cycle.remove(crs)
            res.append(crs)
            return True

        for i in range(numCourses):
            if dfs(i) == False:
                return []
        return res