class Solution {
    public int characterReplacement(String s, int k) {
        /*
        Okay, lets see.
        I need to find a substring of variable length. Im trying to maximize the length.
        So a sliding window.
        Need to find condition in which window grows, and condition in which window shrinks.

        What is a valid window.
        A window in which all characters are same once k replacements are done.
        This can be also said as a window in which.

        A window in which sum of non top frequent character = k.

        so we track top frequent character, easy enough since 26 capital letters are the domain.
        A size 26 frequency array.

        
        when we loop through set curr max freq = 0
        then when each character is checked, update freq if freq greater that curr max, set max = new freq.
        same time we need to keep track of non freq character it should be always <= k.

        if it goes above reduce window size.
        When window size is reduced there is a situation where max freq character is no longer max frequent 
        This can be ignored since we are concerned about maximum situation, when some other character becomes max
        it will naturally replace it. 
        Also notice that totalFreq if we process characters one at a time increases by 1 only.

        if length of string <= k + 1, it can be directly returned as result.
        */

        if (s.length() <= k) return s.length();

        int start = 0;
        int currMaxFreq = 0;
        int[] freq = new int[26];
        int result = 0;

        for(int end = 0; end < s.length(); end++) {
            char curr = s.charAt(end);
            freq[curr - 'A']++;
            currMaxFreq = Math.max(currMaxFreq, freq[curr - 'A']);

            while ((end - start + 1) - currMaxFreq > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result, end - start + 1);
        }

        return result;
        
    }
}