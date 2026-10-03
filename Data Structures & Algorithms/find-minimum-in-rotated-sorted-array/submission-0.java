class Solution {
    public int findMin(int[] nums) {
     /*
     can have two state
     original state if it is rotated back to orginal order
     1 2 3 4 5 6
     or 
     5 6 1 2 3 4

     6 1 2 3 4 5 6

     for state 1. check is easy if 0th pos < last pos
     immediate 0th pos is answer.

     else we need to find pos i, j such that ith > jth

     now how suppse im checking the kth pos, 
     i can identify which half im in by a simple check
     if kth pos < last pos means right half else we in left half.
     I know solution will be only in right half starting.
     if im in right half I seach left, if im in left half I     
     search  right
     */   

     int start = 0;
     int end = nums.length - 1;
     if (nums[start] <= nums[end]) return nums[start];
     
     while (start <= end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }
        if ( nums[mid] < nums[end] ) {
            end = mid;
        } else {
            start = mid + 1;
        }
     }
     return -1;
    }
}
