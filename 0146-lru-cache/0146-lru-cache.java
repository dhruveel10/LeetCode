class LRUCache {

    static class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
    
    static HashMap <Integer, Node> cache;
    static int capacity;
    
    //dummy nodes
    static Node head = new Node();     //insertion from here
    static Node tail = new Node();
    
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int ans = -1;
        Node node = cache.get(key);
        if(node != null){
            ans = node.val;
            remove(node);
            add(node);
        }
        
        return ans;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node != null){
            remove(node);
            node.val = value;
            add(node);
        }
        else{
            if(cache.size() == capacity){
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;
            
            cache.put(key, new_node);
            add(new_node); 
        }
    }
    
    public  void add(Node node){
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node;
    }
    
    //Deleting nodes to our doubly ll
    public  void remove(Node node){
        Node next_node = node.next;
        Node prev_node = node.prev;
        
        next_node.prev = prev_node;
        prev_node.next = next_node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */