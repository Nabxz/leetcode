
/*
* Time Complexity: O(n)
* Space Complexity: O(1)
 */
public class ReorderLinkedList {
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Reverse half the list
        if (fast != null) {
            fast = fast.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Slow pointer is now at the middle so we start reversing the list
            // First we disconnect the 2 lists
            ListNode temp = slow;
            slow = slow.next;
            temp.next = null;

            // Now we reverse the list
            ListNode next;
            if (slow != null) {
                ListNode newTail = slow;
                next = slow.next;
                while (next != null) {
                    temp = slow;
                    slow = next;
                    next = slow.next;
                    slow.next = temp;
                }
                newTail.next = null;
            }

            // Halft the list has been reversed, now build the new one
            // Slow is at the start of the reversed half
            ListNode curr = head;
            ListNode currNext;
            ListNode slowNext;
            while (curr != null && slow != null) {
                currNext = curr.next;
                slowNext = slow.next;
                curr.next = slow;
                slow.next = currNext;
                curr = currNext;
                slow = slowNext;
            }
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
