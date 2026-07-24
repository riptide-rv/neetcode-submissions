class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int start = 0;
        int end = 0;
        int longest = 0;

        HashSet<Character> set = new HashSet<>();
        while (end < s.length()) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            end++;

            longest = Math.max(longest, end - start);
        }
        return longest;
    }

    

}
