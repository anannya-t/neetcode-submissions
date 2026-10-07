class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int res = 0;

        while (start < end) {
            int water = (end - start) * Math.min(heights[start], heights[end]);
            res = Math.max(res, water);

            if (heights[start] <= heights[end]) {
                start++;
            }

            else {
                end--;
            }
        }

        return res;
        
    }
}
