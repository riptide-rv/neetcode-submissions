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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        removing nth node -> keep two pointers seperated such that when second pointer 
        reaches end, first pointer is in nth pos from end.

        1 2 3 4 (n=2)
            pf pl

        given constraints:
        atleast one node.
        n max equals no of node.

        lets check edge case 1 node , and n

        1
        pf pl

        so first point n pf and pl to first node, then for n time pl = pl.next

        while pl.next not null forward pf and pl

        exits 

        Ok here I need prev node also since I'm removing node, 
        removing first node case is also there.
        initially set prev = null,
        then along with forward increment prev also.

        if first node removal case, prev == null so return head.next
        else 
         prev.next = pf.next

        any other way
        first node removal condition means after first loop pf == null

        1 2 3
        pl   pf (n=3)

        1 2 3
        pl  pf 

        then we can loop till pl.next = null and set pl.next = pl.next.next return head
        */

        ListNode pl = head;
        ListNode pf = head;

        for (int i = 0; i < n; i++) {
            pf = pf.next;
        }

        if (pf == null) {
            return pl.next;
        } 

        while (pf.next != null) {
            pl = pl.next;
            pf = pf.next;
        }

        pl.next = pl.next.next;

        return head;
    }
}
