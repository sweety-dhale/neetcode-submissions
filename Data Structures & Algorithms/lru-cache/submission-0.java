class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node mru, lru;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        mru = new Node(-1, -1);
        lru = new Node(-1, -1);

        mru.next = lru;
        lru.prev = mru;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            moveFront(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
        } else {
            if(map.size() == capacity) {
                int k = removeLRU();
                map.remove(k);
            }
            node = new Node(key, value);
        }
        map.put(key, node);
        moveFront(node);
    }

    private void remove(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    private void moveFront(Node node) {
        remove(node);
        node.prev = mru;
        node.next = mru.next;
        mru.next = node;
        node.next.prev = node;
    }

    private int removeLRU() {
        Node node = lru.prev;
        remove(node);
        return node.key;
    }

    private class Node {
        int key;
        int value;
        Node prev, next;

        public Node(int k, int v) {
            key = k;
            value = v;
            prev = null;
            next = null;
        }
    }
}
