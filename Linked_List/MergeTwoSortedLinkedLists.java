/*
* Time Complexity: O(n + m)
* Space Complexity: O(n + m)
* where n is the length of list1 and m is the length of list2
 */
public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = null;
        ListNode top = null;
        ListNode listIteratorOne = list1;
        ListNode listIteratorTwo = list2;
        boolean isTransferComplete = false;

        if (listIteratorOne != null || listIteratorTwo != null) {
            mergedList = new ListNode();
            top = mergedList;

            while ((listIteratorOne != null || listIteratorTwo != null) && !isTransferComplete) {
                // If we still have both list populated
                if (listIteratorOne != null && listIteratorTwo != null) {
                    if (listIteratorOne.val <= listIteratorTwo.val) {
                        mergedList.val = listIteratorOne.val;
                        mergedList.next = new ListNode();
                        mergedList = mergedList.next;
                        listIteratorOne = listIteratorOne.next;
                    } else {
                        mergedList.val = listIteratorTwo.val;
                        mergedList.next = new ListNode();
                        mergedList = mergedList.next;
                        listIteratorTwo = listIteratorTwo.next;
                    }
                }
                // If only list1 is remaining
                else if (listIteratorOne != null) {
                    mergedList.val = listIteratorOne.val;
                    mergedList.next = listIteratorOne.next;
                    isTransferComplete = true;
                }
                // If only list2 is remaining
                else if (listIteratorTwo != null) {
                    mergedList.val = listIteratorTwo.val;
                    mergedList.next = listIteratorTwo.next;
                    isTransferComplete = true;
                }
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
