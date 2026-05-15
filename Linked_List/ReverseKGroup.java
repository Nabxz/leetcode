/*
* Time Complexity: O()
* Space Complexity: O()
 */
class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode top = head;
        ListNode firstNodeInGroupToReverse = head;
        ListNode nodeFromLastGroupToLink = head;

        // First check if we have up to k nodes, if we do then store the next (kth + 1)
        // then reverese those k nodes
        // After reversing those k the tail will be null so point the tail to the
        // next then repeat

        boolean firstGroupToBeReversed = true;
        boolean doneReversingWholeList = false;

        int nodeCount;
        ListNode curr;

        while (!doneReversingWholeList) {

            nodeCount = 0;
            curr = firstNodeInGroupToReverse;

            // See if we have k nodes
            while (curr != null && nodeCount < k) {
                nodeCount++;
                curr = curr.next;
            }

            // Curr now hold the (kth + 1) node if it exist, it can be null
            ListNode nextNodeToLink = curr;

            // If we had up to k nodes we reverse the k nodes
            if (nodeCount == k) {

                nodeCount = 0;
                curr = firstNodeInGroupToReverse;

                if (curr.next != null) {
                    ListNode firstNode = curr;
                    ListNode prev;
                    ListNode next = curr.next;

                    // Reverse the nodes
                    while (next != null && nodeCount + 1 < k) {
                        prev = curr;
                        curr = next;
                        next = next.next;

                        curr.next = prev;
                        nodeCount++;
                    }

                    // If this was the first group we reversed we set the new top
                    if (firstGroupToBeReversed) {
                        top = curr;
                        firstGroupToBeReversed = false;

                        // If it's not then we connect the last node to its new next
                    } else {
                        nodeFromLastGroupToLink.next = curr;
                        nodeFromLastGroupToLink = firstNode;
                    }

                    // The first node will become the last node after reversing
                    firstNode.next = nextNodeToLink;

                    if (nextNodeToLink == null) {
                        doneReversingWholeList = true;
                    } else {
                        firstNodeInGroupToReverse = nextNodeToLink;
                    }
                }
            } else {
                doneReversingWholeList = true;
            }
        }

        return top;
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