class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> h = new PriorityQueue<>((a, b) -> a[0]- b[0]);

        for (int num : count.keySet()) {
            h.offer(new int[]{count.get(num), num});
            if (h.size() > k) {
                h.poll();
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = h.poll()[1];
        }

        return res;

    }
}
