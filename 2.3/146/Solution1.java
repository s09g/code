import java.util.HashMap;

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    List list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new List();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        list.remove(node);
        list.add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(map.get(key));
            map.remove(key);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        list.add(node);

        if (map.size() > capacity) {
            Node last = list.tail.prev;
            list.remove(last);
            map.remove(last.key);
        }
    }

    class Node {
        int key, val;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    class List {
        Node head, tail;

        List() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node) {
            Node next = head.next;
            node.prev = head;
            node.next = next;
            head.next = node;
            next.prev = node;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
    }
}
