class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int res = 0;
        int curr = 0;

        while (left < right) {
            curr = Math.min(heights[left], heights[right]) * (right - left);
            res = Math.max(res, curr);

            if (heights[left] <= heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return res;
    }
}
