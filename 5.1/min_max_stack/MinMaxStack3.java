import java.util.*;

class MinMaxStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    private Stack<Integer> max = new Stack<>();
    public int peek() {
        return stack.peek();
    }

    public int pop() {
        int x = stack.pop();
        min.pop();
        max.pop();
        return x;
    }

    public void push(Integer x) {
        min.push(stack.isEmpty() ? x : Math.min(x, min.peek()));
        max.push(stack.isEmpty() ? x : Math.max(x, max.peek()));
        stack.push(x);
    }

    public int getMin() {
        return min.peek();
    }

    public int getMax() {
        return max.peek();
    }
}