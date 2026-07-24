class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        Ok lets see.
        I need to check for substring. Sliding window prob. fixed length.

        What is a valid window.
        A window where freq array of s2 is equal to freq array of curr window.

        I can easily use start and end to update freq array of current window, and then compare 26
        size array. time complexity o(26n) which is basically n.

        Is there a way to avoid 26 comparison always.
        There is even though its not needed.

        Suppose at some point freq of one character is having a mismatch. Then till it is corrected
        I can move the window. Once it is corrected, I will have to check if window is correct.

        so instead of
        move window -> check all loop.
        move window -> last added & removed character freq should match till then keep moving check
        all loop.
        */

        int[] wfreq = new int[26];
        int[] s1freq = new int[26];
        int windowSize = s1.length();

                             if (s1.length() > s2.length()) return false;

        for (int i = 0; i < windowSize - 1; i++) {
            s1freq[s1.charAt(i) - 'a']++;
            wfreq[s2.charAt(i) - 'a']++;
        }

        s1freq[s1.charAt(windowSize - 1) - 'a']++;

        int start = 0;
        int end = windowSize - 1;

        while (end < s2.length()) {
            wfreq[s2.charAt(end) - 'a']++;

            boolean check = true;
            for(int i = 0; i < 26; i++) {
                if ( s1freq[i] != wfreq[i] ) {
                    check = false;
                    break;
                }
            }
            if(check) return check;
            end++;
            wfreq[s2.charAt(start) - 'a']--;
            start++;
           
        }

        return false;
    }
}
