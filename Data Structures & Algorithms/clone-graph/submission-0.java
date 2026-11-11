/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        /*
            1. go through each node add neighbours to a queue, pop and continue process.
            Connected graph eventually queue will be empty.
            In first pass We just have to create the node and keep a old node -> new node map
            Then we pass through each old node and create the correspinding neighbours list in new node.
            We will maintain a set in intial pass to avoid reprocessing already passed nodes.

            time complexity is n where n is the number of nodes, we process a node only once.
        */

        if (node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> que = new ArrayDeque<>();
        
        que.offer(node);
        map.put(node, new Node(node.val));

        while (!que.isEmpty()) {
            Node top = que.poll();
            for (Node n: top.neighbors) {
                if (map.containsKey(n)) continue;
                que.offer(n);
                map.put(n, new Node(n.val));
            }
        }

        map.forEach((on, nn) -> {
            nn.neighbors = on.neighbors.stream().map(
                n -> map.get(n)
            ).collect(Collectors.toCollection(ArrayList::new));
        });

        return map.get(node);

    }
}