class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            combined[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            combined[i + nums1.length] = nums2[i];
        }

        Arrays.sort(combined);

        if (combined.length % 2 == 1) {
            return combined[combined.length / 2];
        }

        else {
            return (combined[combined.length / 2] + combined[combined.length / 2 - 1])/2.0;
        }
    }
}
