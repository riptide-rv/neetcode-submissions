class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        /*
        basically find islands with a size calculation for each queue.
        */

        int maxSize = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 0)
                    continue;

                Deque<int[]> que = new ArrayDeque<>();
                que.offer(new int[] {x, y});
                grid[x][y] = 0;
                int currentSize = 0;
                while (!que.isEmpty()) {
                    int[] top = que.poll();
                    int i = top[0];
                    int j = top[1];
                    currentSize++;

                    if (i - 1 >= 0 && grid[i - 1][j] != 0) {
                        que.offer(new int[] {i - 1, j});
                        grid[i - 1][j] = 0;
                    }

                    if (i + 1 < grid.length && grid[i + 1][j] != 0) {
                        que.offer(new int[] {i + 1, j});
                        grid[i + 1][j] = 0;
                    }

                    if (j - 1 >= 0 && grid[i][j-1] != 0) {
                        que.offer(new int[]{i, j - 1});
                        grid[i][j-1] = 0;
                    }

                    if (j + 1 < grid[0].length && grid[i][j+1] != 0) {
                        que.offer(new int[]{i, j + 1});
                        grid[i][j+1] = 0;
                    }
                }
                maxSize = Math.max(maxSize, currentSize);
            }
        }

        return maxSize;
    }
}
