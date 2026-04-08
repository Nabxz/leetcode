/*
* Time Complexity: O(n)
* Space Complexity: O(1)
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode lastNode = head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextNode = null;

        if (curr != null) {
            nextNode = curr.next;
        }

        while (curr != null) {
            prev = curr;
            curr = nextNode;

            if (nextNode != null) {
                nextNode = nextNode.next;
            }

            // Swap the next reference to point backward
            if (curr != null) {
                curr.next = prev;
            }
        }

        if (lastNode != null) {
            lastNode.next = null;
        }

        if (prev != null) {
            curr = prev;
        }

        return curr;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}