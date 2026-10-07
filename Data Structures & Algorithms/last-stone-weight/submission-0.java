class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> h = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            h.offer(stone);
        }

        while (h.size() > 1) {
            int first = h.poll();
            int second = h.poll();

            if (first > second) {
                h.offer(first - second);
            }
        }

        if (h.size() == 0) {
            return 0;
        }

        else {
            return h.peek();
        }
    }
}
