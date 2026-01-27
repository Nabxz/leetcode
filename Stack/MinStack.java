// All functions except getMin() are O(1) time with a O(n) space complexity.
// getMin() is O(n)

public class MinStack {

    private class Node {

        int value;
        Node nextNode;
        Node prevNode;

        Node(int value, Node prevNode, Node nextNode) {
            this.value = value;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }

    Node tail = null;

    public MinStack() {
    }

    public void push(int val) {
        // If this is the first element
        if (tail == null) {
            tail = new Node(val, null, null);
        } else {
            tail.nextNode = new Node(val, tail, null);
            tail = tail.nextNode;
        }
    }

    public void pop() {
        if (tail != null) {
            Node nodeToBeDeleted = tail;
            tail = tail.prevNode;
            nodeToBeDeleted.prevNode = null;
        }
    }

    public int top() {
        if (tail != null) {
            return tail.value;
        }
        return -1;
    }

    public int getMin() {
        int minimumValue = -1;
        Node curr = tail;
        if (curr != null) {
            minimumValue = curr.value;
            while (curr != null) {
                if (curr.value < minimumValue) {
                    minimumValue = curr.value;
                }
                curr = curr.prevNode;
            }
        }
        return minimumValue;
    }
}
