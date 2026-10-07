class Solution {
    public int maxSubArray(int[] nums) {
        int maxendingati = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxendingati = Math.max(maxendingati + nums[i], nums[i]);
            res = Math.max(res, maxendingati);
        }

        return res;
    }
}
