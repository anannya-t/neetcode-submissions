class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}

        for i in range(len(nums)):
            comp = target - nums[i]

            if comp in seen:
                if seen[comp] < i:
                    return [seen[comp], i]
                else:
                    return [i, seen[comp]]
            seen[nums[i]] = i
        return []