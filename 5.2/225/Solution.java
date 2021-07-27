import java.util.*;

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        Queue<Integer> temp = queue;
        queue = new LinkedList<>();
        queue.offer(x);
        while (!temp.isEmpty()) {
            queue.offer(temp.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
