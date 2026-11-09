class Twitter {
    int tweetNo = 0;
    Map<Integer, Set<Integer>> userFollowerMap = new HashMap<>();
    PriorityQueue<Tweet> recentTweets = new PriorityQueue<>();


    public class Tweet implements Comparable<Tweet> {
        int userId;
        int tweetId;
        int tweetNo;

        public Tweet(int userId, int tweetId, int tweetNo) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.tweetNo = tweetNo;
        }

        @Override
        public int compareTo(Tweet other) {
            return Integer.compare(other.tweetNo, this.tweetNo);
        }

    }

    public Twitter() {
    }
    
    public void postTweet(int userId, int tweetId) {
        recentTweets.offer(new Tweet(userId, tweetId, this.tweetNo++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> processed = new ArrayList<>();
        List<Tweet> ans = new ArrayList<>();

        while (!this.recentTweets.isEmpty()) {
            Tweet top = this.recentTweets.poll();
            processed.add(top);
            if (top.userId == userId || this.userFollowerMap.getOrDefault(userId, new HashSet<>()).contains(top.userId)) {
                ans.add(top);
                if ( ans.size() == 10 ) break;
            }
        }
        recentTweets.addAll(processed);
        return ans.stream().map(i -> i.tweetId).collect(Collectors.toList());
    }
    
    public void follow(int followerId, int followeeId) {
        if (this.userFollowerMap.get(followerId) == null) {
            this.userFollowerMap.put(followerId,new HashSet<>());
        }
        this.userFollowerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (this.userFollowerMap.get(followerId) != null) {
            this.userFollowerMap.get(followerId).remove(followeeId);
        }
    }
}
