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
    public void reorderList(ListNode head) {
        /*
            0 1 2 3  4 5 6
            0   1   2   3

           */
        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.val);

        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;

        slow.next = null;
        // I have two linked list now, first half and secondHalf, need to reverse second half.

        secondHalf = this.reverseLinkedList(secondHalf);

        ListNode start = firstHalf;

        while (secondHalf != null) {
            ListNode fn = firstHalf.next;
            ListNode sn = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = fn;

            firstHalf = fn;
            secondHalf = sn;
        }
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode rem = this.reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return rem;
    }
}
