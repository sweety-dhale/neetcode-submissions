class MinStack {

    private class StackNode {
        private int val, currMin;
        
        StackNode(int val, int currMin) {
            this.val = val;
            this.currMin = currMin;
        }

        public int getMin() {
            return currMin;
        }

        public  int getVal() {
            return val;
        }
    }

    private Stack<StackNode> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        int currMin = Integer.MAX_VALUE;
        if(!minStack.isEmpty()) {
            StackNode top = minStack.peek();
            currMin = top.getMin();
        }
        currMin = Math.min(currMin, val);
        StackNode node = new StackNode(val, currMin);
        minStack.push(node);
    }
    
    public void pop() {
        if(!minStack.isEmpty()) {
            minStack.pop();
        }
    }
    
    public int top() {
        if(!minStack.isEmpty()) {
            return minStack.peek().getVal();
        }
        return -1;
    }
    
    public int getMin() {
        if(!minStack.isEmpty()) {
            return minStack.peek().getMin();
        }
        return -1;
    }
}
