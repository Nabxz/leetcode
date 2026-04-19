/*
* Time Complexity: O()
* Space Complexity: O()
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode resultHead = null;

        // Reverse both lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode currValOne = l1;
        ListNode currValTwo = l2;

        int carryOver = 0;
        int operand1 = 0;
        int operand2 = 0;
        while (currValOne != null || currValTwo != null) {

            // If we still have operand 1
            if (currValOne != null) {
                operand1 = currValOne.val;
                currValOne = currValOne.next;
            }

            // If we still have operand 2
            if (currValTwo != null) {
                operand2 = currValTwo.val;
                currValTwo = currValTwo.next;
            }

            // If this is the first solution node
            if (result == null) {
                result = new ListNode();
                resultHead = result;
            } else {
                result.next = new ListNode();
                result = result.next;
            }

            result.val = (operand1 + operand2 + carryOver) % 10;
            carryOver = (operand1 + operand2 + carryOver) / 10;
        }

        resultHead = reverseList(resultHead);
        return resultHead;
    }

    private ListNode reverseList(ListNode head) {
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

        head.next = null;
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