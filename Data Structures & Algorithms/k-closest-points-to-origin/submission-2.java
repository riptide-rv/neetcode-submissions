class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((b, a)
                                    -> Double.compare(this.getSquaredDistanceFromOrigin(a),
                                        this.getSquaredDistanceFromOrigin(b)));

        for (int[] point : points) {
            this.add(point, minHeap, k);
        }

        int[][] sol = new int[k][2];
        for (int i = 0; i < k; i++) {
            sol[i] = minHeap.poll();
        }
        return sol;
    }

    public void add(int[] point, PriorityQueue<int[]> minHeap, int k) {
        if (minHeap.size() < k) {
            minHeap.offer(point);
            return;
        }
        if (this.getSquaredDistanceFromOrigin(minHeap.peek())
            > this.getSquaredDistanceFromOrigin(point)) {
            minHeap.poll();
            minHeap.offer(point);
        }
    }

    private double getSquaredDistanceFromOrigin(int[] point) {
        return Math.pow(point[0], 2) + Math.pow(point[1], 2);
    }
}
