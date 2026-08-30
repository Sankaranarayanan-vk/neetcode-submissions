class MinStack {
    private ArrayList<Integer> elementSet;
    private Stack<Integer> stack;
    public MinStack() {
        this.stack = new Stack<>();
        this.elementSet = new ArrayList<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        this.elementSet.add(val);
    }
    
    public void pop() {
        this.elementSet.remove(this.stack.peek());
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        Integer min = Integer.MAX_VALUE;
        for(Integer i : this.elementSet)
        {
            if(i < min)
            {
                min = i;
            }
        }
        return min;
    }
}
