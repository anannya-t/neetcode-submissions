class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> second = new PriorityQueue<>();
        PriorityQueue<Integer> first = new PriorityQueue<>((a,b) -> b - a);

        for (int num : nums1) {
            if (!second.isEmpty() && num > second.peek()) {
                second.offer(num);
            }

            else {
                first.offer(num);
            }

            if (first.size() - second.size() > 1) {
                second.offer(first.poll());
            }

            else if (second.size() - first.size() > 1) {
                first.offer(second.poll());
            }
        }

        for (int num : nums2) {
            if (!second.isEmpty() && num > second.peek()) {
                second.offer(num);
            }

            else {
                first.offer(num);
            }

            if (first.size() - second.size() > 1) {
                second.offer(first.poll());
            }

            else if (second.size() - first.size() > 1) {
                first.offer(second.poll());
            }
        }

        if (first.size() == second.size()) {
            return (first.peek() + second.peek()) / 2.0;
        }
        else if (first.size() > second.size()) {
            return first.peek();
        }
        else {
            return second.peek();
        }
    }
}
