class Solution {
    public boolean isAnagram(String s, String t) {
        Integer total = 0;
        if ( s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for(char sc: s.toCharArray())  {
            int si = sc;
            total += 1;
            arr[si - 97] += 1;
        }

        for (char tc: t.toCharArray()) {
            int ti = tc;
            if (arr[ti - 97] <= 0) {
                return false;
            }
            arr[ti - 97] -= 1;
            total -= 1;

        }
        return total == 0;
    }
}
