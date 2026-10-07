class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int water;
        int res = 0;

        while (left < right) {
            water = Math.min(heights[left], heights[right]) * (right - left);
            if (heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }

            res = Math.max(water, res);

        }

        return res;
    }
}
