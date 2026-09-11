class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
            suppose we take two points, i and j in the histogram
            The max area is min of height between i and j * (i - j).

            so if consider every combination of i and j, and then calculate min for each region
            I will have the brute force solution.

            can I minimize the calculation of min between i and j?

            I know that area will be maximized if square, not sure if that is usefull though,
            since here we can have a 1 width very tall histogram with max area

            Is checking from bottom up a possibility?

            i.e for each level find the largest non breaking section that * level is basically the
           max height, this is a n square solution.

            ok if use a stack approach
            I can check if for a single rectangle how much I can extend left and right,
            in reality if i process linearly for each rectangle I just need to process if it can
           extend to left and store that info alone right, if at one point it cant top become 1.
        */

        Deque<List<Integer>> stack = new ArrayDeque<>();

        // pre initialize first record
        Integer maxArea = heights[0] * 1;
        stack.push(new ArrayList<>(List.of(heights[0], 1)));

        for (int i = 1; i < heights.length; i++) {
            int cheight = heights[i];

            int clength = 1;

            int topPos = 0;

            while (!stack.isEmpty() && stack.peek().get(0) >= cheight) {
                topPos += stack.peek().get(1);
                int carea = (topPos) * stack.peek().get(0);
                maxArea = Math.max(maxArea, carea);
                stack.pop();

            }
                
                stack.push(List.of(cheight, topPos + 1 ));
            

           //System.out.println(stack + "---");
            
        }
         int tlen = 0;
        //System.out.println(stack);
            while (!stack.isEmpty()) {
                tlen += stack.peek().get(1);
                maxArea = Math.max(maxArea, stack.peek().get(0) * tlen);
                stack.pop();
            }
        return maxArea;
        /*
         dry run [2, 1, 5, 6, 2, 3]
         stack [ (2, 1)]
         -i1 - (1, 1) , checks stack top, 2 is greater so pops it , top pos is 1
               now stack is empty, area becomes, 1 * 2 = 2
               stack push (1, 2)
         stack [(1, 2)]
         -i2 height is 5,
         left cant extend, topPos = 0, area = 7.
         stack [(1, 1), (7, 1)]
         -i3 height 2
         pop top, top pos = 1
         area = 2 * 2 = 4, push (2, 2)
         stack [(1, 1), (2, 2)]
         -i4 2, pop pos = 2
         area = 2 * 3 = 6
         stack [(1,1), (2,3)]
         i5 4 , no pop area = 4
         stack [(1,1), (2,3), (4,1)]

         now lastly I have to process the stack till empty

         area = 4 * 1
         area = 2 * (3 + 1)
         area = 1 * (1 + 1 + 1)
        */
    }
}
