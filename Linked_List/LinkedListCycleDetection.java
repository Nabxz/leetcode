/*
* Time Complexity: O(n)
* Space Complexity: O(1)
 */
public class LinkedListCycleDetection {
    public boolean hasCycle(ListNode head) {
        boolean hasCycle = false;
        ListNode curr = head;
        ListNode fastCurr = head;

        if (fastCurr != null) {
            fastCurr = fastCurr.next;
        }

        while (curr != null && fastCurr != null && !hasCycle) {
            if (curr == fastCurr) {
                hasCycle = true;
            }

            curr = curr.next;
            fastCurr = fastCurr.next;
            if (fastCurr != null) {
                fastCurr = fastCurr.next;
            }
        }

        return hasCycle;
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
