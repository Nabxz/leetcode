/*
* Time Complexity: O(m + n), where m is the length of list l1 and n is the length of list l2
* Space Complexity: O(1)
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode resultHead = null;

        ListNode currValOne = l1;
        ListNode currValTwo = l2;

        int carryOver = 0;
        int operand1;
        int operand2;
        while (currValOne != null || currValTwo != null) {

            operand1 = 0;
            operand2 = 0;

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

        // If we finish with a carryover
        if (result != null && carryOver > 0) {
            result.next = new ListNode();
            result = result.next;
            result.val = carryOver;
        }

        return resultHead;
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