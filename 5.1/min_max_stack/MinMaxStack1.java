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
        if (x == min.peek()) min.pop();
        if (x == max.peek()) max.pop();
        return x;
    }

    public void push(Integer x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()) min.push(x);
        if (max.isEmpty() || x >= max.peek()) max.push(x);
    }

    public int getMin() {
        return min.peek();
    }

    public int getMax() {
        return max.peek();
    }
}