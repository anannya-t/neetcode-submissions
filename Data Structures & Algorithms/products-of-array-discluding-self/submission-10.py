class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [0] * len(nums)
        numZeros = 0
        for num in nums:
            if num == 0:
                numZeros += 1
        
        if numZeros >= 2:
            return res

        prod = 1
        for i in range(len(nums)):
            if nums[i] != 0:
                prod *= nums[i]
            
        if numZeros == 1:
            for i in range(len(nums)):
                if nums[i] != 0:
                    res[i] = 0
                else:
                    res[i] = prod
        
        else:
            for i in range(len(res)):
                res[i] = prod // nums[i]
        
        return res


            
