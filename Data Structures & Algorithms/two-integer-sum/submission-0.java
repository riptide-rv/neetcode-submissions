class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for ( int x = 0; x < nums.length ; x++ ) {
            int num = nums[x];
            if (map.containsKey(num)) {
                return new int[] {map.get(num), x};
            }
            map.put(target - num, x);
        }
        return new int[] {};
    }
}
