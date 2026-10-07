class MedianFinder {

    ArrayList<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        nums.add(num);
    }
    
    public double findMedian() {

        Collections.sort(nums);

        if (nums.size() % 2 == 1) {
            return nums.get(nums.size() / 2);
        }

        else {
           return (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) / 2.0;
        }
    }
}
