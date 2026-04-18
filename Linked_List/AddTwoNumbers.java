/*
* Time Complexity: O()
* Space Complexity: O()
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        // Reverse both lists
        reverseList(l1);
        reverseList(l2);

        return result;
    }

    private void reverseList(ListNode head) {
        ListNode curr = head;
        ListNode next = curr.next;
        ListNode prev = null;

        while (next != null) {
            prev = curr;
            curr = next;
            next = next.next;

            // Reverse link
            curr.next = prev;
        }
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