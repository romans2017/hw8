package ua.goit.scollections;

public class SimpleHashMap<K, V> {

    private final static int DEFAULT_NUMBER_BUCKETS = 16;

    private final int numberBuckets;
    private final Node<K, V>[] map;
    private int capacity;

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

    public SimpleHashMap(int numberBuckets) {
        this.numberBuckets = numberBuckets;
        map = (Node<K, V>[]) new Node[numberBuckets];
        capacity = 0;
    }

    public SimpleHashMap() {
        this(DEFAULT_NUMBER_BUCKETS);
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
    private int getIndexBucket(int hashKey) {
        return hashKey % numberBuckets;
    }

    /**
     * Puts @value into Hash Map
     *
     * @param key   Key of Node
     * @param value Value of Node
     */

    public void put(K key, V value) {
        int indexBucket = getIndexBucket(hashKey(key));
        Node<K, V> newNode = new Node<>(key, value, null);

        if (map[indexBucket] == null) {
            map[indexBucket] = newNode;
        } else {
            Node<K, V> last = map[indexBucket];
            boolean isCollision = false;
            for (Node<K, V> item = map[indexBucket]; item != null; ) {
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
        capacity++;
    }

    /**
     * Gets Value by Key from Hash Map
     *
     * @param key Key of Node
     * @return Object V
     */
    public V get(K key) {
        int indexBucket = getIndexBucket(hashKey(key));

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
        int indexBucket = getIndexBucket(hashKey(key));

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
