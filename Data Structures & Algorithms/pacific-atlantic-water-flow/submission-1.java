class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*
            do two bfs search first one, to find the ones connected to
            pacific. In second pass we can find ones connected to atlantic and
            at the same time add it to result.

            Technically I dont need to do a bfs , I can do a dfs from each level.
        */

        List<List<Integer>> result = new ArrayList<>();

        // pass one

        Deque<int[]> que = new ArrayDeque<>();
        int[][] visited = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights[0].length; i++) {
            visited[0][i] = 1;
            que.offer(new int[] {0, i});
        }

        for (int i = 0; i < heights.length; i++) {
            visited[i][0] = 1;
            que.offer(new int[] {i, 0});
        }

        while (!que.isEmpty()) {
            int[] land = que.poll();
            int x = land[0];
            int y = land[1];

            if (x - 1 >= 0 && visited[x - 1][y] == 0 && heights[x - 1][y] >= heights[x][y]) {
                visited[x - 1][y] = 1;
                que.offer(new int[] {x - 1, y});
            }
            if (y - 1 >= 0 && visited[x][y - 1] == 0 && heights[x][y - 1] >= heights[x][y]) {
                visited[x][y - 1] = 1;
                que.offer(new int[] {x, y - 1});
            }

            if (x + 1 < heights.length && visited[x + 1][y] == 0
                && heights[x + 1][y] >= heights[x][y]) {
                visited[x + 1][y] = 1;
                que.offer(new int[] {x + 1, y});
            }

            if (y + 1 < heights[0].length && visited[x][y + 1] == 0
                && heights[x][y + 1] >= heights[x][y]) {
                visited[x][y + 1] = 1;
                que.offer(new int[] {x, y + 1});
            }
        }

        // second pass
        for (int i = 0; i < heights[0].length; i++) {
            this.updateResultAndQue(que, visited, result, heights.length - 1, i);
        }

        for (int i = 0; i < heights.length; i++) {
            this.updateResultAndQue(que, visited, result, i, heights[0].length - 1);
        }

        while (!que.isEmpty()) {
            int[] land = que.poll();
            int x = land[0];
            int y = land[1];

            if (x - 1 >= 0 && visited[x - 1][y] < 2 && heights[x - 1][y] >= heights[x][y]) {
                this.updateResultAndQue(que, visited, result, x - 1, y);
            }
            if (y - 1 >= 0 && visited[x][y - 1] < 2 && heights[x][y - 1] >= heights[x][y]) {
                this.updateResultAndQue(que, visited, result, x, y - 1);
            }

            if (x + 1 < heights.length && visited[x + 1][y] < 2
                && heights[x + 1][y] >= heights[x][y]) {
                this.updateResultAndQue(que, visited, result, x + 1, y);
            }

            if (y + 1 < heights[0].length && visited[x][y + 1] < 2
                && heights[x][y + 1] >= heights[x][y]) {
                this.updateResultAndQue(que, visited, result, x, y + 1);
            }
        }
        return result;
    }

    private void updateResultAndQue(
        Deque<int[]> que, int[][] visited, List<List<Integer>> result, int x, int y) {
        visited[x][y] += 2;
        if (visited[x][y] == 3) {
            result.add(new ArrayList<>(List.of(x, y)));
        };
        que.offer(new int[] {x, y});
    }
}
