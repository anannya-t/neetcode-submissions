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
        res = binary_search(0, pivot - 1)

        if res != -1:
            return res
        else:
            return binary_search(pivot, len(nums) - 1)
