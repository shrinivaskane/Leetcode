class LCEvaluatepolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int temp = switch(s) {
                    case "+" -> num2+num1;
                    case "-" -> num2-num1;
                    case "*" -> num1 * num2;
                    case "/" -> num2 / num1;
                    default -> 0;
                };
                stack.push(temp);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
