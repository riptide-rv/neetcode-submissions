class Solution {
    public int search(int[] nums, int target) {
        /*
        6 7 8 9 1 2 3 4 5

        [1 2 3]
        [3 1 2]
        [2 3 1]


        */
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            boolean rotated = true;
            if (nums[mid] >= nums[start]) {
                rotated = false;
            }

            if (!rotated) {
                if (target < nums[mid] && target >= nums[start] ) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[start] || target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
                
        }
        return -1;
    }
}
