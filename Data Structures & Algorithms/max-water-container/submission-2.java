class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        
        int max =0;
        while (start < end) {
        
            int currStart = heights[start];
            int currEnd = heights[end];
            max = Math.max(max, (end - start) * Math.min(heights[start], heights[end]));
            if (currStart <= currEnd ) {
                while (start < end && heights[start] <= currStart) {
                    start++;
                }
            } else {
                while ( start < end && heights[end] <= currEnd ) {
                    end--;
                }
            }
            
        } 
        return max;
    }
}
