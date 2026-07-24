class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int start = 0;
        int end = 0;
        int longest = 0;

        HashSet<Character> set = new HashSet<>();
        while (end < s.length()) {
            
            if (set.contains(s.charAt(end))) {
                while (s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
                end++;
            } else {
                set.add(s.charAt(end));
                end++;
                longest = Math.max(longest, end - start);
            }
        }



        return longest;

    }
}
