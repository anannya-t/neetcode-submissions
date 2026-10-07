class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqMap = {}

        for num in nums:
            freqMap[num] = 1 + freqMap.get(num, 0)
        
        revMap = []

        for num, freq in freqMap.items():
            revMap.append([freq, num])

        revMap.sort()

        res = []

        while len(res) < k:
            res.append(revMap.pop()[1])
        
        return res

        