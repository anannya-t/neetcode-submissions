class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        combined = []

        for num in nums1:
            combined.append(num)

        for num in nums2:
            combined.append(num)

        combined.sort()

        if len(combined) % 2 == 1:
            return combined[len(combined) // 2]
        else:
            return (combined[len(combined) // 2] + combined[len(combined) // 2 - 1]) / 2.0