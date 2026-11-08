class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b)
                -> Double.compare(Math.pow(Math.pow(a[0], 2) + Math.pow(a[1], 2), 0.5),
                    Math.pow(Math.pow(b[0], 2) + Math.pow(b[1], 2), 0.5)));

        for(int[] point: points) {
            minHeap.offer(point);
        }

      int[][] sol = new int[k][2];
      for(int i = 0; i < k ; i++) {
        sol[i] = minHeap.poll();
      }
      return sol;

    }
}
