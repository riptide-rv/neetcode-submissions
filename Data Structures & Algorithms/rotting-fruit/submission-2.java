class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> que = new ArrayDeque<>();
        int time = 0;
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                    grid[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!que.isEmpty() && fresh != 0) {
            int size = que.size();
            time++;

            for (int x = 0; x < size; x++) {
                int[] item = que.poll();
                int i = item[0];
                int j = item[1];
                
                if (j - 1 >= 0 && grid[i][j-1] == 1) {
                    grid[i][j - 1] = 0;
                    fresh--;
                    que.offer(new int[] { i , j - 1});
                }

                 if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 0;
                    fresh--;
                   que.offer(new int[] { i , j + 1});
                }

                 if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 0;
                    fresh--;
                    que.offer(new int[] { i - 1, j });
                }

                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 0;
                    fresh--;
                    que.offer(new int[] { i + 1 , j });
                }
            }
        }

        return fresh > 0 ? -1 : time;
    }
}
