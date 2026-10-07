class Twitter {

    private int count;
    private HashMap<Integer,List<int[]>> tweetMap;
    private HashMap<Integer,Set<Integer>> followMap;

    public Twitter() {
        count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!(tweetMap.containsKey(userId))) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<int[]> tweets = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        if (!(followMap.containsKey(userId))) {
            followMap.put(userId, new HashSet<>());
        }
        followMap.get(userId).add(userId);

        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                for (int[] tweet: tweetMap.get(followeeId)) {
                    tweets.add(tweet);
                }
            }
        }

        for (int[] tweet : tweets) {
            minHeap.offer(tweet);

            if (minHeap.size() > 10) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll()[1]);
        }

        Collections.reverse(res);

        return res;


    }
    
    public void follow(int followerId, int followeeId) {
        if (!(followMap.containsKey(followerId))) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!(followMap.containsKey(followerId))) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).remove(followeeId);
    }
}
