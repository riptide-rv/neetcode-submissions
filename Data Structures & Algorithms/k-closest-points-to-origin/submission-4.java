class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((b, a)
                                    -> Double.compare(this.getSquaredDistanceFromOrigin(a),
                                        this.getSquaredDistanceFromOrigin(b)));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] sol = new int[k][2];
        for (int i = 0; i < k; i++) {
            sol[i] = maxHeap.poll();
        }
        return sol;
    }

    // public void add(int[] point, PriorityQueue<int[]> maxHeap, int k) {
    //     if (maxHeap.size() < k) {
    //         maxHeap.offer(point);
    //         return;
    //     }
    //     if (this.getSquaredDistanceFromOrigin(maxHeap.peek())
    //         > this.getSquaredDistanceFromOrigin(point)) {
    //         maxHeap.poll();
    //         maxHeap.offer(point);
    //     }
    // }

    private double getSquaredDistanceFromOrigin(int[] point) {
        return Math.pow(point[0], 2) + Math.pow(point[1], 2);
    }
}
