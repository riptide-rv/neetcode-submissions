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

        if length of string <= k + 1, it can be directly returned as result.
        */

        if (s.length() <= k + 1) return s.length();

        int start = 0;
        int totalNonFreq = 0;
        int currMaxFreq = 0;
        int[] freq = new int[26];
        int result = 0;

        for(int end = 0; end < s.length(); end++) {
            Character curr = s.charAt(end);
            freq[curr - 'A']++;
            if(freq[curr - 'A'] > currMaxFreq) currMaxFreq += 1;
            else totalNonFreq += 1;

            if (totalNonFreq <= k) result = end - start + 1;
            else {
                freq[s.charAt(start) - 'A']--;
                start += 1;
                totalNonFreq -= 1;
            }
        }

        return result;
        
    }
}
