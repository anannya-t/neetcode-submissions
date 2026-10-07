class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        pairs = {}

        for num in nums:
            pairs[num] = pairs.get(num, 0) + 1
        
        freqs = []

        for num, freq in pairs.items():
            freqs.append([freq, num])
        freqs.sort()

        res = []

        while len(res) < k:
            res.append(freqs.pop()[1])
        return res