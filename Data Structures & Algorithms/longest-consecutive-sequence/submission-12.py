class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        res = 0

        numSet = set()

        for num in nums:
            numSet.add(num)
        
        for num in numSet:
            if (num - 1) not in numSet:
                length = 1
                while (num + length) in numSet:
                    length += 1
                res = max(res, length)
        return res


        
