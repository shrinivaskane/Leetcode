class LC706_DesignHashMap {
    LinkedList<int[]>[] list;
    public MyHashMap() {
        list = new LinkedList[769];
        for(int i = 0; i< 769; i++) {
            list[i] = new LinkedList<>();
        }
    }

    int hash(int i) {
        return i%769;
    }


    public void put(int key, int value) {
        int[] node = getNode(key);
        if(node != null) {
            node[1] = value;
        } else {
            list[hash(key)].add(new int[] {key, value});
        }
    }
    
    public int get(int key) {
        int[] node = getNode(key);
        return node != null? node[1]: -1;
    }
    
    public void remove(int key) {
        int[] node = getNode(key);
        if(node != null) list[hash(key)].remove(node);
    }

    private int[] getNode(int key) {
        int bucket = hash(key);
        for(int[] node: list[bucket]) {
            if(node[0] == key) {
                return node;
            }
        }
        return null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
