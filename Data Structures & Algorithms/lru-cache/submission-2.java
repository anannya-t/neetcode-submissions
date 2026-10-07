class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {

    int capacity;
    HashMap<Integer, Node> cache;
    Node first;
    Node last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.first = new Node(0, 0);
        this.last = new Node(0, 0);
        this.first.next = this.last;
        this.last.prev = this.first;
    }

    public void add(Node node) {
        // insert at end (before last)
        Node prev = last.prev;
        prev.next = node;
        node.prev = prev;
        node.next = last;
        last.prev = node;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
        }
        Node newNode = new Node(key, value);
        add(newNode);
        cache.put(key, newNode);

        if (cache.size() > capacity) {
            Node lru = first.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}