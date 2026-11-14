class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        int[] result = new int[numCourses];
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
            result[count] = top;
            count++;
            
            for (int i : adj.getOrDefault(top, List.of())) {
                indeg[i]--;
                if (indeg[i] == 0)
                    que.offer(i);
            }
        }

        return count == numCourses ? result : new int[]{};
    }
}
