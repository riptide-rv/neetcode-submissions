class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
            we are given a graph in form, of nodes and edges.
            If there a circular dependecency, then answer is false
            We can also represent the full graph in a n x n array where n is number of courses.
        */

        int[] indeg = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] req : prerequisites) {
            indeg[req[0]]++;
            adj.computeIfAbsent(req[1], k -> new ArrayList<>()).add(req[0]);
        }

        int count = 0;
        Deque<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0)
                que.offer(i);
        }

        while (!que.isEmpty()) {
            int top = que.poll();
            count++;
            for (int i : adj.getOrDefault(top, List.of())) {
                indeg[i]--;
                if (indeg[i] == 0)
                    que.offer(i);
            }
        }

        return count == numCourses;
    }
}
