class TimeMap:

    def __init__(self):
        self.pairs = {} # key -> [value, timestamp]

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.pairs:
            self.pairs[key] = []
        self.pairs[key].append([value, timestamp])
        
    def get(self, key: str, timestamp: int) -> str:
        if key not in self.pairs:
            return ""
        
        res = ""
        values = self.pairs.get(key, [])
        l = 0
        r = len(values) - 1

        while l <= r:
            m = (l + r) // 2
            if values[m][1] <= timestamp:
                res = values[m][0]
                l = m + 1
            else:
                r = m - 1
        return res
        
