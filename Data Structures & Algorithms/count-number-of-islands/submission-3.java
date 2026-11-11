class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        int numberOfIslands = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (visited[x][y] == 1 || grid[x][y] == '0') {
                    continue;
                }

                Deque<List<Integer>> queue = new ArrayDeque<>();
                queue.offer(List.of(x, y));
                visited[x][y] = 1;
                numberOfIslands += 1;
                while (!queue.isEmpty()) {
                    List<Integer> top = queue.poll();
                    int i = top.get(0);
                    int j = top.get(1);
                    

                    // left
                    if (j - 1 >= 0 && visited[i][j - 1] != 1 && grid[i][j - 1] != '0') {
                        queue.offer(List.of(i, j - 1));
                        visited[i][j - 1] = 1;
                    }

                    // right
                    if (j + 1 < grid[0].length && visited[i][j + 1] != 1 && grid[i][j + 1] != '0') {
                        queue.offer(List.of(i, j + 1));
                        visited[i][j + 1] = 1;
                    }

                    // top
                    if (i - 1 >= 0 && visited[i - 1][j] != 1 && grid[i - 1][j] != '0') {
                        queue.offer(List.of(i - 1, j));
                        visited[i - 1][j] = 1;
                    }

                    // bottom
                    if (i + 1 < grid.length && visited[i + 1][j] != 1 && grid[i + 1][j] != '0') {
                        queue.offer(List.of(i + 1, j));
                        visited[i + 1][j] = 1;
                    }
                }
            }
        }
        return numberOfIslands;
    }
}
