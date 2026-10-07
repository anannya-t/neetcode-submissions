class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        seen = {}

        for num in nums:
            if num in seen:
                seen[num] += 1
            else: 
                seen[num] = 1

        # now at (num, freq) pairs

        freqs = []

        for (num, freq) in seen.items():
            freqs.append([freq, num])

        freqs.sort()

        res = []

        while len(res) < k:
            res.append(freqs.pop()[1])

        return res
        