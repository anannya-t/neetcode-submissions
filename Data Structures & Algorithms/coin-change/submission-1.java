class Solution {
    public int coinChange(int[] coins, int amount) {
 
        int[] combo = new int[amount + 1];

        for (int i = 1; i < combo.length; i++) {
            combo[i] = Integer.MAX_VALUE;
        }

        combo[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && combo[i - coin] != Integer.MAX_VALUE) {
                    combo[i] = Math.min(combo[i], combo[i - coin] + 1);
                }
            }
        }

        if (combo[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        else {
            return combo[amount];
        }


    }
}
