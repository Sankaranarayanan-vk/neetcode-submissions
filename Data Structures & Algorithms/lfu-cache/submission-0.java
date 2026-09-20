class Node
{
    Node prev;
    Node next;
    int key;
    int val;
    int freq;

    public Node(int key, int val)
    {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DoublyLinkedList
{
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList()
    {
        size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node)
    {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
        size++;
    }

    public void remove(Node node)
    {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;
        size--;
    }

    public Node removeLast()
    {
        if(size == 0)
        {
            return null;
        }

        Node last = tail.prev;
        remove(last);
        return last;
    }
}

class LFUCache
{
    Map<Integer, Node> map = new HashMap<>();
    Map<Integer, DoublyLinkedList> freqMap = new HashMap<>();
    int capacity;
    int leastFreq;

    public LFUCache(int capacity)
    {
        this.capacity = capacity;
        this.leastFreq = 0;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key)
    {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            updateCache(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value)
    {
        if(capacity == 0)
        {
            return;
        }

        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.val = value;
            updateCache(node);
            return;
        }

        if(capacity == map.size())
        {
            DoublyLinkedList list = freqMap.get(leastFreq);
            Node last = list.removeLast();
            map.remove(last.key);
        }

        Node node = new Node(key, value);

        DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());
        list.addFirst(node);

        freqMap.put(1, list);
        map.put(key, node);

        this.leastFreq = 1;
    }

    public void updateCache(Node node)
    {
        int freq = node.freq;

        DoublyLinkedList oldList = freqMap.get(freq);
        oldList.remove(node);

        if(freq == leastFreq && oldList.size == 0)
        {
            leastFreq++;
        }

        freq = freq + 1;
        node.freq = freq;

        DoublyLinkedList newList = freqMap.getOrDefault(freq, new DoublyLinkedList());
        newList.addFirst(node);

        freqMap.put(freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */