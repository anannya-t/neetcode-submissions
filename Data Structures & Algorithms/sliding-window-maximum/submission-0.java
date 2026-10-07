class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            ArrayList<Integer> window = new ArrayList<Integer>();
            
            for (int j = i; j < i + k; j++) {
                window.add(nums[j]);
            }

            res[i] = Collections.max(window);
        }

        return res;
    }
}
