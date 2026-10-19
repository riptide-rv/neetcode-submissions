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

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.val);

        if(head == null || head.next == null) return;

        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;

        slow.next = null;
        // I have two linked list now, first half and secondHalf, need to reverse second half.

        secondHalf = this.reverseLinkedList(secondHalf);


        ListNode start = new ListNode(); 


        while (secondHalf != null && firstHalf != null) {
            ListNode fn = firstHalf.next;
            ListNode sn = secondHalf.next;

            

            start.next = firstHalf;
            start.next.next = secondHalf;
            start = start.next.next;

            firstHalf = fn;
            secondHalf = sn;
        }

        if (firstHalf != null ) start.next = firstHalf;
        
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode rem = this.reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return rem;
    }
}
