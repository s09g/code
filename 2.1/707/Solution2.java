class MyLinkedList {
    class Node {
        int val;
        Node prev, next;
        public Node(int val) {
            this.val = val;
        }
    }

    int size;
    Node head, tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;
    }

    private Node node(int index) {
        Node curt;
        if (index < (size >> 1)) {
            curt = head.next;
            for (int i = 0; i < index; i++)
                curt = curt.next;
        } else {
            curt = tail;
            for (int i = size; i > index; i--)
                curt = curt.prev;
        }
        return curt;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        return node(index).val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        Node curt = node(index);
        Node prev = curt.prev;
        Node node = new Node(val);

        node.prev = prev;
        node.next = curt;
        prev.next = node;
        curt.prev = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node curt = node(index);
        Node prev = curt.prev;
        Node next = curt.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }
}
