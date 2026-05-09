/*
* Time Complexity: O(n * k)
* Space Complexity: O(1)
* where k is the total number of lists and n is the total number of nodes across all lists.
 */
public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode finalMergedList = null;

        if (lists.length > 0) {

            finalMergedList = lists[0];

            for (int indexOfLists = 1; indexOfLists < lists.length; indexOfLists++) {

                // Now we have broken this down into a two pointer problem
                // We insert into the first list from the second list in the correct order
                ListNode curr1 = finalMergedList;
                ListNode curr2 = lists[indexOfLists];
                boolean doneMergingList = false;

                while (curr1 != null && !doneMergingList) {

                    if (curr2.val <= curr1.val) {
                        // We have to swap the value of curr1 with curr2 then make a new node
                        // and put curr1 to point at it and the new node points at the next of the
                        // old curr1
                        ListNode newNode = new ListNode(curr1.val, curr1.next);
                        curr1.val = curr2.val;
                        curr1.next = newNode;
                        curr2 = curr2.next;
                    }

                    // If we reach the last node of curr1 we add all the remaining curr2 because we
                    // know it's in ascending order
                    if (curr1.next == null) {
                        curr1.next = curr2;
                        doneMergingList = true;
                    } else {
                        curr1 = curr1.next;
                    }
                }
            }
        }

        return finalMergedList;
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
