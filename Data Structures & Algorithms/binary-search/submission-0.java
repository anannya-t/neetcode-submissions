class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int curr = (high + low) / 2;

            if (nums[curr] == target) {
                return curr;
            }

            else if (nums[curr] < target) {
                low = curr + 1;
            }

            else {
                high = curr - 1;
            }
        }

        return -1;
    }
}
