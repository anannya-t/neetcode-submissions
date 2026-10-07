class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        int[] res = new int[2];

        int sum = numbers[start] + numbers[end];

        while (sum != target) {
            if (sum > target) {
                end--;
            }
            else {
                start++;
            }

            sum = numbers[start] + numbers[end];

        }

        res[0] = start + 1;
        res[1] = end + 1;

        return res;
    }
}
