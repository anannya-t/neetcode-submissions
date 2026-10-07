class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        res = nums[0]

        while left < right:
            mid = (left + right) // 2

            if nums[mid] < nums[right]:
                # min is in left half, move right pointer
                right = mid
            elif nums[mid] > nums[right]:
                # min is in right half, move left pointer
                left = mid + 1

        return nums[left]
