class MinStack {

    Stack<Integer> vals;
    Stack<Integer> min;

    public MinStack() {
        vals = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        vals.push(val);
        if (min.isEmpty()) {
            min.push(val);
        }
        else if (val <= min.peek()) {
            min.push(val);
        }
    }
    
    public void pop() {
        if (vals.peek().equals(min.peek())) {
            min.pop();
        }
        vals.pop();
    }
    
    public int top() {
        return vals.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
