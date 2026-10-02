class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // I can reduce the size of the matrix till a single cell is remaining by comparing mid
        // value of x axis and y axis

        int xstart = 0;
        int xend = matrix[0].length - 1;
        int ystart = 0;
        int yend = matrix.length - 1;
        int[] row = matrix[ystart];
        // now plain binary search

        // first identify row
        while (ystart <= yend) {
            int ymid = (ystart + yend) / 2;
            if (target >= matrix[ymid][0] && target <= matrix[ymid][xend]) {
                row = matrix[ymid];
                System.out.print("a");
                break;
            }  
            if ( target > matrix[ymid][xend]) {
                ystart = ymid + 1;
            } else {
                yend = ymid - 1;
            }

        }


        while (xstart <= xend) {
            int xmid = (xstart + xend) / 2;
            if (target == row[xmid])
                return true;
            if (target > row[xmid])
                xstart = xmid + 1;
            else
                xend = xmid - 1;
        }
        return false;
    }
}
