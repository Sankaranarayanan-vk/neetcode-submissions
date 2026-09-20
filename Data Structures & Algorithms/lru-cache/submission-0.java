// ["LRUCache", [2], "put", [1, 10],  "get", [1], "put", [2, 20], "put", [3, 30], "get", [2], "get", [1]]

// 2,20 3-30

// duplylinked list next prev
// head - 1 - 2 - tail
// hashmap to store the required to get in O(1)

class Node
{
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val)
    {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache
{
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key)
    {
        if(this.map.containsKey(key))
        {
            Node node = this.map.get(key);
            deleteNode(node);
            placeFirst(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value)
    {
        if(this.map.containsKey(key))
        {
            Node node = this.map.get(key);
            deleteNode(node);
            placeFirst(node);
            node.val = value;
        }
        else
        {
            Node node = new Node(key, value);
            placeFirst(node);
            this.map.put(key, node);
        }

        if(map.size() > capacity)
        {
            Node newTail = this.tail.prev;
            deleteNode(newTail);
            map.remove(newTail.key);
        }
    }

    public void placeFirst(Node node)
    {
        Node first = this.head.next;
        this.head.next = node;
        first.prev = node;
        node.prev = head;
        node.next = first;
    }

    public void deleteNode(Node node)
    {
        Node prev = node.prev;
        Node next = node.next;
        node.prev = null;
        node.next = null;
        prev.next = next;
        next.prev = prev;
    }
}
