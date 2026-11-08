class KthLargest {
    PriorityQueue<Integer> minHeap = null;
    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();

        if (nums.length < k) {
            this.minHeap.offer(Integer.MIN_VALUE);
        }
        for (int i = 0; i < Math.min(k, nums.length); i++) {
            this.minHeap.offer(nums[i]);
        }
        

        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                this.minHeap.poll();
                this.minHeap.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (this.minHeap.peek() < val) {
            this.minHeap.poll();
            this.minHeap.offer(val);
        }

        return this.minHeap.peek();
    }
}
