class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        I don't even realise this is a stack problem if I did not already
        know.
        obs 1: for always reducing array,
        It will be 0,0,0,0...
        okay let assume we go something like this,
        inp [30, 38, 30, 36, 35, 40, 28]
        intial res [0, 0, 0, 0, 0, 0 ,0]
        final res [1, 3, 1, 2, 1, 0 ,0]

        stack []
        stack [30]
        stack [38] pop 30 add 1 to 30 (i0)
        stack [38, 30]
        stack [38, 36] pop 30 add 1 to 30 i(i2)
        stack [38, 36, 35]
        stack [38, 36, 35] pop 35 add 1(i4), pop2 36 add 2(i3)
                           pop 38 add 3 (i1)
                           somewhere +1 is needed for 38, or I have to trace index.
                           so I can just calculate from index. so store int array in stack
                           or just store index in stack and use that to get temp
        */

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int topI = stack.pop();
                result[topI] = i - topI;
            }
            stack.push(i);
        }
        return result;
    }
}
