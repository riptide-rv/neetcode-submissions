/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;

        int num1 = 0;
        int num2 = 0;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                num1 = l1.val;
                System.out.println(num1);
                l1 = l1.next;
            }

            if (l2 != null) {
                num2 = l2.val;
                System.out.println(num2);
                l2 = l2.next;
            }

            int sum  = num1 + num2 + carry;
            if (sum >= 10) carry = 1; else carry = 0;
            ptr.next = new ListNode((int) sum % 10);
            ptr = ptr.next;
            num1 = 0;
            num2 = 0;
        }

        return dummy.next;
        
    }
}
