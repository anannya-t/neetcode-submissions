class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<Integer>(Comparator.reverseOrder()); // max heap
        large = new PriorityQueue<Integer>(); // min heap
    }
    
    public void addNum(int num) {
        small.offer(num);

        if (small.size() - large.size() > 1 || !large.isEmpty() && small.peek() > large.peek()) {
            large.offer(small.poll());
        }

        if (large.size() - small.size() > 1) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() == large.size()) {
            return ((small.peek() + large.peek()) / 2.0);
        }

        else if (small.size() > large.size()) {
            return small.peek() / 1.0;
        }

        else {
            return large.peek() / 1.0;
        }


    }
}
