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
    ListNode last;
    public ListNode reverseList(ListNode head) {
        /*
         a -> b -> c -> d

         
        */
        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode rem = this.reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rem;
        
    }

    
}
