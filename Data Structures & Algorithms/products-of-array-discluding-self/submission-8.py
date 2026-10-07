class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prod = 1
        zero_freq = 0
        for num in nums:
            if num == 0:
                zero_freq += 1
            else:
                prod *= num
        

        if zero_freq > 1:
            return [0] * len(nums)
        
        else:
            res = [0] * len(nums)
            for i in range(len(nums)):
                if zero_freq == 1:
                    if nums[i] == 0:
                        res[i] = prod
                else:
                    res[i] = prod // nums[i]

        return res
