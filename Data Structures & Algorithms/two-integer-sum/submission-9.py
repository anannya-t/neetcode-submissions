class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        seen = {}

        for i in range(len(nums)):
            n = nums[i]
            comp = target - n
            if comp in seen:
                if i < seen[comp]:
                    return [i, seen[comp]]
                else:
                    return [seen[comp], i]
            else:
                seen[n] = i

        return []