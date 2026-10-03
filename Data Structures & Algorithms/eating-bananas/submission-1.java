class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // ik its binary search so its going sort. but lets analyze the question first

        /*
         there is a pile of banana [ 1, 4, 3, 2 ] and I have h = 9 to eat it.
         I need to find a min k.
         I can say that k = max pile size is the maximum hour limit.
         whereas k = 1 is the minimum.
         so solution should be between 1 and max(piles)

         so brute force solution is to check all the possible solutions. which is n square.

         or I can check mid solution. if mid solution takes too much time check greater sols else check lesser sols.
         so now solution is in log n.
         if equal still check for smaller solutions.

         I need to find a sol from a range of solutions -> binary search.

         Can I find a smaller solution using math is the question. I can reduce the solution space by finding a smaller max limit. i can take max(hours / pile length, 1) length and  if it > 1 means max sol limit is max / that value.
        */

        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length - 1];
        int sol = 0;
        while (start <= end) {
            int mid = ( start + end ) / 2;
            int nH = this.numberOfHours(piles, mid);
            // System.out.print(nH + " "+ mid);
            if (nH <= h) {
                sol = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return sol;

        
    }

    public int numberOfHours(int[] piles, int rate) {
        int res = 0;
        int i = piles.length - 1;
        while (i >= 0) {
            if (rate >= piles[i]) break;
            res += (int)((piles[i] + rate - 1) / rate);
            i--;
        }

        res += (i + 1);
        return res;

    }
}
