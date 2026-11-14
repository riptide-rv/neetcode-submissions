class Solution {
    public void solve(char[][] board) {
        List<int[]> result = new ArrayList<>();

        Deque<int[]> que = new ArrayDeque<>();

        for (int i = 0; i < board[0].length - 1; i++) {
            this.update(que, result, 0, i, board);
        }

        for (int i = 0; i < board.length - 1; i++) {
            this.update(que, result,  i, board[0].length - 1, board);
        }

        for (int i = board[0].length - 1; i > 0; i--) {
            this.update(que, result, board.length - 1, i, board);
        }

        for (int i = board.length - 1; i > 0; i--) {
            this.update(que, result, i, 0, board);
        }



        while (!que.isEmpty()) {
            int[] top = que.poll();

            int x = top[0];
            int y = top[1];
 

            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                this.update(que, result, x - 1, y, board);
            }

            if (x + 1 < board.length && board[x + 1][y] == 'O') {
                this.update(que, result, x + 1, y, board);
            }

            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                this.update(que, result, x, y - 1, board);
            }

            if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
                this.update(que, result, x, y + 1, board);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) board[i][j] = 'X';
        }

        for (int[] res : result) {
            board[res[0]][res[1]] = 'O';
        }
    }

    private void update(Deque<int[]> que, List<int[]> result, int x, int y, char[][] board) {
        if (board[x][y] == 'O') {
            que.offer(new int[] {x, y});
            board[x][y] = 'X';
            result.add(new int[] {x, y});
        }
    }
}
