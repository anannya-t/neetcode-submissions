class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqMap = {}

        for num in nums:
            if num not in freqMap:
                freqMap[num] = 1
            else:
                freqMap[num] += 1
        

        # num -> freq pairs
        # turn into (freq, num) pairs

        pairs = []

        for num, freq in freqMap.items():
            pairs.append([freq, num])
        
        pairs.sort()

        res = []
        while len(res) < k:
            res.append(pairs.pop()[1])
        
        return res