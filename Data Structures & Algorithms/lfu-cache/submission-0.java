class Node {
    int key;
    int val;
    int freq;
    Node prev;
    Node next;

    public Node (int k, int v) {
        key = k;
        val = v;
        freq = 1;
        prev = null;
        next = null;
    }
}

class DoublyLinkedList {
    private Node first;
    private Node last;
    int size;

    public DoublyLinkedList() {
        this.first = new Node(0, 0);
        this.last = new Node(0, 0);
        first.next = last;
        last.prev = first;
    }

    public void add(Node node) {
        Node prev = last.prev;
        prev.next = node;
        node.next = last;
        last.prev = node;
        node.prev = prev;
        size++;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }
    
    public Node removeFirst() {
        if (size == 0) {
            return null;
        }
        Node toRemove = first.next;
        remove(toRemove);
        return toRemove;
    }

}

class LFUCache {

    private int capacity;
    private int minFreq;

    private Map<Integer, Node> keyMap;
    private Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            updateFreq(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            updateFreq(node);
            return;
        }

        else {
            if (keyMap.size() == capacity) {
                DoublyLinkedList minList = freqMap.get(minFreq);
                Node evicted = minList.removeFirst(); // LRU of minFreq
                keyMap.remove(evicted.key);
            }

            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);

            freqMap
                .computeIfAbsent(1, k -> new DoublyLinkedList())
                .add(newNode);   // MRU at tail

            minFreq = 1;
        }
    }

    public void updateFreq(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        if (freqMap.containsKey(node.freq)) {
            freqMap.get(node.freq).add(node);
        }

        else {
            freqMap.put(node.freq, new DoublyLinkedList());
            freqMap.get(node.freq).add(node);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */