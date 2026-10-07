class TimeMap:

    def __init__(self):
        self.pairs = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.pairs:
            self.pairs[key] = []
        self.pairs[key].append([value, timestamp]) 

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.pairs:
            return ""
        l = 0
        vals = self.pairs.get(key)
        r = len(vals) - 1
        res = ""

        while l <= r:
            mid = (l + r) // 2
            if vals[mid][1] <= timestamp:
                l = mid + 1
                res = vals[mid][0]

            else:
                r = mid - 1
        return res
        
