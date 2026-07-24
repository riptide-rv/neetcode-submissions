class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        I need to find distinct triplets that sum to 0.
        ex: [-1,0,1,2,-1,-4]
        sol: [[-1,0,1], [-1,2,-1]]
        
        Some thing I noticed.
        if I consider array
        [-1,-1,0,1,3,-2,2]
        since [-1,0,1] is a solution, for -1 (0 and 1 will no longer be part of any solution in which -1 is present)
        So I can start finding solution which has -1 in it.
        that means finding two sum with target 1. from [0,1,3,-2,2,-1]
        Since ik its two sum I can sort that is one approach.
        [-2,-1,-1,0,1,2,3]

        */

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while ( i < nums.length) {
            List<List<Integer>> interRes = twoSum(nums, 0 - nums[i], i + 1, nums.length);
            if(interRes.size() > 0) {
                result.addAll(interRes);
            }
            i++;
            while (i < nums.length && nums[i] == nums[i-1]) i++;
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int s, int e) {
        List<List<Integer>> result = new ArrayList<>();

        int start = s;
        int end = e - 1;
        while (start < end) {
            if ( nums[start] + nums[end] == target) {
                result.add(new ArrayList<Integer>(Arrays.asList(0 - target, nums[start], nums[end])));
                start++;
                end--;
                while (start < end && nums[start] == nums[start-1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end+1]) {
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        

        }
        return result;

    }
}
