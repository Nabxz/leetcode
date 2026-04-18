import java.util.HashMap;

/*
* Time Complexity: O(n)
* Space Complexity: O(n)
 */
public class CopyLinkedListWithRandomPointer {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldToNewMapping = new HashMap<>();

        // Make a deep copy of each Node
        Node curr = head;
        while (curr != null) {
            Node newCurr = new Node(curr.val);
            oldToNewMapping.put(curr, newCurr);
            curr = curr.next;
        }

        // Connect the new nodes
        curr = head;
        while (curr != null) {
            Node newNode = oldToNewMapping.get(curr);

            // Connect the next
            if (curr.next != null) {
                Node newNext = oldToNewMapping.get(curr.next);
                newNode.next = newNext;
            } else {
                newNode.next = null;
            }

            // Connect the random
            if (curr.random != null) {
                Node newRandom = oldToNewMapping.get(curr.random);
                newNode.random = newRandom;
            } else {
                newNode.random = null;
            }
            curr = curr.next;
        }

        return oldToNewMapping.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}