
/*
* Time Complexity: O(n)
* Space Complexity: O(1)
 */
public class RemoveNodeFromEndOfLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head != null) {
            // Find the length of the list
            int size = 0;
            ListNode curr = head;

            while (curr != null) {
                size++;
                curr = curr.next;
            }

            // If we are removing a head
            if (n == size) {
                head = head.next;
            } else {
                // Remove the nth node by travelling to (size - n)
                curr = head;
                for (int i = 1; i < (size - n); i++) {
                    curr = curr.next;
                }
                if (n == 1) { // If we are removing the last element
                    curr.next = null;
                } else { // Removing a middle element
                    curr.next = curr.next.next;
                }
            }

        }

        return head;
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