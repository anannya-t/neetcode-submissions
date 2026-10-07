class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int prev_2 = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = prev;
            prev = prev + prev_2;
            prev_2 = temp;
        }

        return prev;
    }
}
