public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

// node class with key, val, next, prev
// hashmap of value -> node
// dummy nodes at left and right, store most recently used at the end
// helper methods: insert (inserts at end) and remove
// get: look in hashmap, if exists then remove and add at the end
// put: if already in hashmap, remove Node. add at end/hashmap
// also check capacity -> lru is the first node

class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> cache; // key to node
    private Node left;
    private Node right;

    // doubly linked list of key value pairs

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);

        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}

