class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqMap = {}

        for num in nums:
            freqMap[num] = freqMap.get(num, 0) + 1

        freqList = []

        for num, count in freqMap.items():
            freqList.append([count, num])

        freqList.sort()

        res = []

        while len(res) < k:
            res.append(freqList.pop()[1])

        return res