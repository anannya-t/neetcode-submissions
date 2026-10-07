class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # find pivot then do a regular binary search on the correct half

        # find smallest element:

        left = 0
        right = len(nums) - 1
        pivot = 0

        while left < right:
            mid = (left + right) // 2

            if nums[mid] > nums[right]:
                # smallest in left side
                left = mid + 1
            else:
                right = mid
        pivot = left
        
        def binary_search(l, r):
            while l <= r:
                m = (l + r) // 2
                if nums[m] < target:
                    l = m + 1
                elif nums[m] > target:
                    r = m - 1
                else:
                    return m
            return -1

        # need to know what side is the correct half
        if pivot == 0:
            return binary_search(0, len(nums) - 1)
        if nums[0] <= target and target <= nums[pivot - 1]:
            return binary_search(0, pivot - 1)
        elif nums[pivot] <= target and target <= nums[len(nums) - 1]:
            return binary_search(pivot, len(nums) - 1)
        else:
            return -1
