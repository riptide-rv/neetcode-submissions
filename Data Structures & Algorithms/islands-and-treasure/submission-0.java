class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int x = 0; x < grid.length; x++) {
            for ( int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] != 0) continue;
                Deque<int[]> que = new ArrayDeque<>();
                int currentDistance = 0;
                
                que.offer(new int[]{x, y});
                while (!que.isEmpty()) {
                    currentDistance++;
                    
                    int size = que.size();
                    for (int n = 0; n < size; n++) {
                        int[] item = que.pop();
                        int i = item[0];
                        int j = item[1];
                        // left 
                        if ( j - 1 >= 0 && grid[i][j-1] > currentDistance) {
                            grid[i][j-1] = currentDistance;
                            que.offer(new int[]{i, j - 1});
                        }

                        if (i - 1 >= 0 && grid[i - 1][j] > currentDistance ) {
                            grid[i - 1][j] = currentDistance;
                            que.offer(new int[]{i - 1, j});
                        }

                        if (j + 1 < grid[0].length && grid[i][j + 1] > currentDistance) {
                            grid[i][j + 1] = currentDistance;
                            que.offer(new int[]{i, j + 1});
                        }

                        if ( i + 1 < grid.length && grid[i + 1][j] > currentDistance) {
                            grid[i + 1][j] = currentDistance;
                            que.offer(new int[]{i + 1, j});
                        }
                    }
                }
            }
        }
    }
}
