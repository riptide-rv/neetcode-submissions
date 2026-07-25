class Solution {
    public String minWindow(String s, String t) {
        /*
        Okay, sliding window.
        Valid window condition freq of window = freq of t.
        Early return if length of t > s.
        We are concerned with minimum substring. so once one valid minimum is found window no longer expands.
        It should try to shrink only.

        So we can start by growing the window till a solution is found.
        Once a solution is found, shrink window, and for each shrink if sol is still valid, update min solution.
        when solution becomes invalid start moving end and start both by 1. If solution becomes valid reduce length again.

        */

        String validSol = "";
        int validSolLength = 0;
        int minSol = t.length();

        if (t.length() > s.length()) return validSol;

        int start = 0;
        int end = 0;

        int[] wfreq = new int[60];
        int[] tfreq = new int[60];

        for ( int i = 0; i < t.length(); i++ ) {
            wfreq[s.charAt(i) - 'A']++;
            tfreq[t.charAt(i) - 'A']++;
        }

        wfreq[s.charAt(minSol - 1) - 'A']--;
        start = 0;
        end = minSol - 1;

        while ( end < s.length()) {

            wfreq[s.charAt(end) - 'A']++;

            boolean flag = true;
            for(int i = 0; i < 60; i++ ) {
                if (tfreq[i] > 0 && wfreq[i] < tfreq[i])  {
                    flag = false;
                    break;
                }
            }
            
            if (flag == true) {
                validSol = s.substring(start, end + 1);
                validSolLength = validSol.length();
                if (validSolLength == minSol) return validSol;
                wfreq[s.charAt(start) - 'A']--;
                wfreq[s.charAt(end) - 'A']--;
                start++;
            } else {
                if (validSolLength > 0) {
                    wfreq[s.charAt(start) - 'A']--;
                    start++;
                }
                end++;
            }

        }

        /*
        x in xxxx
        */

        return validSol;

    }
}
