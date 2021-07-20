package ua.goit.scollections;

public class SimpleHashMap<K, V> {

    private final static int DEFAULT_NUMBER_BUCKETS = 16;
    private final static float DEFAULT_LOAD_FACTOR = 0.75f;

    private int numberBuckets;
    private Node<K, V>[] map;
    private int capacity;
    private final float loadFactor;

    /**
     * The class Node is intended to represent data as Linked List in every bucket of Hash Map
     *
     * @param <K>
     * @param <V>
     */
    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public SimpleHashMap(int numberBuckets, float loadFactor) throws IllegalArgumentException {
        if (numberBuckets <= 0 || loadFactor <= 0) {
            throw new IllegalArgumentException("Number of buckets and load factor must be positive");
        }
        this.numberBuckets = numberBuckets;
        this.loadFactor = loadFactor;
        map = (Node<K, V>[]) new Node[numberBuckets];
        capacity = 0;
    }

    public SimpleHashMap(int numberBuckets) {
        this(numberBuckets, DEFAULT_LOAD_FACTOR);
    }

    public SimpleHashMap() {
        this(DEFAULT_NUMBER_BUCKETS, DEFAULT_LOAD_FACTOR);
    }

    public int getNumberBuckets() {
        return numberBuckets;
    }

    /**
     * Calculates hash of key
     *
     * @param key Key of Node
     * @return int
     */
    private int hashKey(K key) {
        return key == null ? 0 : key.hashCode();
    }

    /**
     * Returns the index of bucket of map array.
     *
     * @param hashKey hash of Key of Node
     * @return int
     */
    private int getIndexBucket(int hashKey, int numberBuckets) {
        return hashKey % numberBuckets;
    }

    @SuppressWarnings("unchecked")
    private void rebuildMap() {
        int newNumberBuckets = (-1 >>> Integer.numberOfLeadingZeros(map.length - 1)) + 1;
        if (newNumberBuckets == numberBuckets) {
            newNumberBuckets <<= 1;
        }
        Node<K, V>[] newMap = (Node<K, V>[]) new Node[newNumberBuckets];
        for (Node<K, V> kvNode : map) {
            Node<K, V> entry = kvNode;
            while (entry != null) {
                putEntry(entry.getKey(), entry.getValue(), newMap, newNumberBuckets);
                entry = entry.getNext();
            }
        }
        map = newMap;
        numberBuckets = newNumberBuckets;
    }

    private void putEntry(K key, V value, Node<K, V>[] entries, int numberBuckets) {
        int indexBucket = getIndexBucket(hashKey(key), numberBuckets);
        Node<K, V> newNode = new Node<>(key, value, null);

        if (entries[indexBucket] == null) {
            entries[indexBucket] = newNode;
        } else {
            Node<K, V> last = entries[indexBucket];
            boolean isCollision = false;
            for (Node<K, V> item = entries[indexBucket]; item != null; ) {
                if (item.getKey().equals(key)) {
                    item.setValue(value);
                    isCollision = true;
                    break;
                }
                last = item;
                item = item.getNext();
            }
            if (!isCollision) {
                last.setNext(newNode);
            }
        }
    }

    /**
     * Puts @value into Hash Map
     *
     * @param key   Key of Node
     * @param value Value of Node
     */
    public void put(K key, V value) {
        putEntry(key, value, map, numberBuckets);
        capacity++;
        if ((float) capacity > (float) map.length * loadFactor) {
            rebuildMap();
        }
    }

    /**
     * Gets Value by Key from Hash Map
     *
     * @param key Key of Node
     * @return Object V
     */
    public V get(K key) {
        int indexBucket = getIndexBucket(hashKey(key), numberBuckets);

        for (Node<K, V> item = map[indexBucket]; item != null; ) {
            if (item.getKey().equals(key)) {
                return item.getValue();
            }
            item = item.getNext();
        }
        return null;
    }

    /**
     * Remove Value by Key from Hash Map
     *
     * @param key Key of Node
     */
    public void remove(K key) {
        int indexBucket = getIndexBucket(hashKey(key), numberBuckets);

        Node<K, V> prev = map[indexBucket];
        for (Node<K, V> item = map[indexBucket]; item != null; ) {
            if (item.getKey().equals(key)) {
                if (map[indexBucket] == item) {
                    map[indexBucket] = item.getNext();
                } else {
                    prev.setNext(item.getNext());
                }
                item.setNext(null);
                item.setValue(null);
                capacity--;
                break;
            }
            prev = item;
            item = item.getNext();
        }
    }

    public void clear() {
        for (int i = 0; i < numberBuckets; i++) {
            map[i] = null;
        }
        capacity = 0;
    }

    public int size() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder mapToString = new StringBuilder();
        for (Node<K, V> linkedList : map) {
            mapToString.append("[");
            for (Node<K, V> item = linkedList; item != null; ) {
                mapToString.append("(");
                mapToString.append(item.getKey().toString());
                mapToString.append("=");
                mapToString.append(item.getValue().toString());
                mapToString.append(")");

                item = item.getNext();

                if (item != null) {
                    mapToString.append("->");
                }
            }
            mapToString.append("]");
            mapToString.append("\n");
        }
        return mapToString.toString();
    }
}
