class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set()

        for num in nums:
            numSet.add(num)

        res = 0
        
        for num in nums:
            if num - 1 not in numSet:
                streak = 0
                curr = num

                while curr in numSet:
                    streak += 1
                    curr += 1
                    res = max(res, streak)
        return res
