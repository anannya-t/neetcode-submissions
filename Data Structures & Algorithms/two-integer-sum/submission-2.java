class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            if (map.containsKey(difference)) {
                result = new int[] { map.get(difference), i };          
            }

            map.put(nums[i], i);
        }
        return result;
    }
}
