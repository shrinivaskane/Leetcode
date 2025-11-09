class LC207CourseSchedule {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
