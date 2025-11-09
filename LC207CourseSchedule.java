class LC207CourseSchedule {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /* DFS approach 
        for(int i = 0; i< numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] preq: prerequisites) {
            map.get(preq[0]).add(preq[1]);
        }
        for(int i = 0; i< numCourses; i++) {
            if(!dfs(i)) return false;
        }
        return true;
        */

        /* Topological Sort (kahn's algorithm) */
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i< numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] preq: prerequisites) {
            adj.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++;
        }
        for(int i = 0; i< numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int finished = 0;
        while(!queue.isEmpty()) {
            finished++;
            int course = queue.poll();
            for(int preq: adj.get(course)) {
                indegree[preq]--;
                if(indegree[preq] == 0) queue.add(preq);
            }
        }

        return finished == numCourses;

    }

    private boolean dfs(int course) {
        if(visited.contains(course)) return false;
        if(map.get(course).isEmpty()) return true;
        visited.add(course);
        for(int preq: map.get(course)) {
            if(!dfs( preq)) {
                return false;
            }
        }
        visited.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
