class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        numZeros = 0
        prod = 1
        res = [0] * len(nums)

        for num in nums:
            if num == 0:
                numZeros += 1
            else:
                prod *= num

        if numZeros >= 2:
            return res
        
        res = [0] * len(nums)

        if numZeros == 0:
            for i in range(0, len(nums)):
                res[i] = prod // nums[i]
            return res
        
        else:
            for i in range(0, len(nums)):
                if nums[i] == 0:
                    res[i] = prod
                else:
                    res[i] = 0
            return res

        return res