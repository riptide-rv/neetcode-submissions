/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        /*
        I think map with two pass is easiest way
        */

        Node currItr = head;
        Map<Node, Node> map = new HashMap<>();

        while (currItr != null) {
            Node newNode = new Node(currItr.val); 
            map.put(currItr, newNode);
            currItr = currItr.next;
        }

        currItr = head;
        Node newItr;

        while (currItr != null) {
            newItr = map.get(currItr);
            newItr.next = map.getOrDefault(currItr.next, null);
            newItr.random = map.getOrDefault(currItr.random, null);

            currItr = currItr.next;
        }

        return map.get(head);
    }
}
