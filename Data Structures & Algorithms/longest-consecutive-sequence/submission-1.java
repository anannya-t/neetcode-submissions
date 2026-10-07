class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 0;

        for (int val : set) {
            if (!set.contains(val - 1)) {
                int curr = val;
                int streak = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }

                res = Math.max(res, streak);
            }
        }

        return res;
    }
}
