class Solution {

    private boolean isOp(String op) {
        switch(op) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
        }
        return false;
    }

    private int getResult(int l, int r, String op) {
        int res = 0;
        switch(op) {
                case "+": res = (l + r);
                    break;
                case "-": res = (l - r);
                    break;
                case "*": res = (l * r);
                    break;
                case "/": res = (l / r);
                    break;
            }
        return res;
    }

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> polish = new Stack<>();

        int l, r, res = 0;
        for(String token : tokens) {
            if(isOp(token)) {
                r = polish.pop();
                l = polish.pop();
                res = getResult(l, r, token);
            } else {
                res = new Integer(token);
            }
            polish.push(res);
        }
        return res;
    }
}
