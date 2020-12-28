import java.util.*;

class MinMaxStack {
    private Stack<int[]> stack = new Stack<>();

    public int peek() {
        return stack.peek()[0];
    }

    public int pop() {
        return stack.pop()[0];
    }

    public void push(Integer x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x, x});
            return;
        }

        int[] curt = stack.peek();
        stack.push(new int[]{x, Math.min(x, curt[1]), Math.max(x, curt[2])});
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public int getMax() {
        return stack.peek()[2];
    }
}
