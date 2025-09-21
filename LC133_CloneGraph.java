/*
// Definition for a Node.
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

class LC133_CloneGraph {
    public Node cloneGraph(Node node) {
        /* using dfs 
        HashMap<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
        */
        /* using bfs */
        if(node == null) return null;
        HashMap<Node, Node> oldToNew = new HashMap<>();
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node nei: cur.neighbors) {
                if(!oldToNew.containsKey(nei)) {
                    Node newNode = new Node(nei.val);
                    oldToNew.put(nei, newNode);
                    queue.offer(nei);
                }
            oldToNew.get(cur).neighbors.add(oldToNew.get(nei));
        }
        }
        return oldToNew.get(node);
    }

    private Node dfs(Node node, HashMap<Node, Node> oldToNew) {
        if(node == null) return null;
        if(oldToNew.containsKey(node)) return oldToNew.get(node);
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);
        for(Node nei: node.neighbors) {
            copy.neighbors.add(dfs(nei, oldToNew));
        }
        return copy;
    }
}
