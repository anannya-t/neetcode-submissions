class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxendingati = nums[0]
        res = nums[0]

        for i in range(1, len(nums)):
            maxendingati = max(nums[i], maxendingati + nums[i])
            res = max(res, maxendingati)

        return res