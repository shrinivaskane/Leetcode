class LC210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        int[] ans = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i< numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] preq : prerequisites){
            adj.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++;
        }
        for(int i = 0; i< numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            ans[index++] = course;
            for(int preq: adj.get(course)) {
                indegree[preq]--;
                if(indegree[preq] == 0) {
                    queue.add(preq);
                }
            }
        }

        return (index == numCourses) ? ans: new int[0];
    }
}
