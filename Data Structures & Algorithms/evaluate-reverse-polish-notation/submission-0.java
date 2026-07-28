class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int op1 = 0;
            int op2 = 0;
            int result = 0;
            switch (token)  {
                    case "+":
                        op2 = stack.pop();
                        op1 = stack.pop();
                        result = op1 + op2;
                        stack.push(result);
                        break;
                    case "-":
                        op2 = stack.pop();
                        op1 = stack.pop();
                        result = op1 - op2;
                        stack.push(result);
                        break;
                    case "*":
                        op2 = stack.pop();
                        op1 = stack.pop();
                        result = op1 * op2;
                        stack.push(result);
                        break;
                    case "/":
                        op2 = stack.pop();
                        op1 = stack.pop();
                        result = op1 / op2;
                        stack.push(result);
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                        break;
                }
        }
        return stack.pop();
    }
}
