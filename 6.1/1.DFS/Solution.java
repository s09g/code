import java.util.*;

class Node {
    String name;
    List<Node> neighbors = new ArrayList<Node>();

    public Node(String name) {
        this.name = name;
    }

    public List<Node> depthFirstSearch(List<Node> array, Node src) {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        stack.add(src);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (visited.contains(current)) {
                continue;
            }
            array.add(current);
            for (Node next : current.neighbors) {
                stack.push(next);
            }
        }
        return array;
    }

    public Node addChild(String name) {
        Node child = new Node(name);
        neighbors.add(child);
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", neighbors=" + neighbors +
                '}';
    }
}

class Solution {
    public static void main(String[] args) {
        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.neighbors.get(0).addChild("E").addChild("F");
        graph.neighbors.get(2).addChild("G").addChild("H");
        graph.neighbors.get(0).neighbors.get(1).addChild("I").addChild("J");
        graph.neighbors.get(2).neighbors.get(0).addChild("K");
        List<Node> inputArray = new ArrayList<>();
        System.out.println(graph.depthFirstSearch(inputArray, graph));
    }
}