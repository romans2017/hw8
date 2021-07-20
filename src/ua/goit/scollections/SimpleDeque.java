package ua.goit.scollections;

abstract public class SimpleDeque<T> implements SimpleList<T> {

    protected static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    protected Node<T> last;
    protected Node<T> first;
    protected int capacity;

    protected Node<T> getLast() {
        return last;
    }

    protected Node<T> getFirst() {
        return first;
    }

    private Node<T> getNode(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        if (index <= capacity / 2) {
            Node<T> item = first;
            for (int i = 0; i <= capacity / 2; i++) {
                if (i == index) {
                    return item;
                }
                item = item.getNext();
            }
        } else {
            Node<T> item = last;
            for (int i = capacity - 1; i > capacity / 2; i--) {
                if (i == index) {
                    return item;
                }
                item = item.getPrev();
            }
        }
        return null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > capacity - 1) {
            throw new IndexOutOfBoundsException("Index out of LinkedList capacity");
        }
    }

    protected void add(T item) {
        if (first == null) {
            first = new Node<>(item, null, null);
            last = first;
        } else {
            Node<T> newItem = new Node<>(item, last, null);
            last.setNext(newItem);
            last = newItem;
        }
        capacity++;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);

        Node<T> item = getNode(index);
        Node<T> prevItem = item.getPrev();
        Node<T> nextItem = item.getNext();
        if (prevItem != null) {
            prevItem.setNext(nextItem);
        }
        if (nextItem != null) {
            nextItem.setPrev(prevItem);
        }
        if (item == first) {
            first = nextItem;
        }
        if (item == last) {
            last = prevItem;
        }
        capacity--;
    }

    @Override
    public void clear() {
        for (Node<T> item = first; item != null; ) {
            Node<T> temp = item.getNext();
            item.setValue(null);
            item.setPrev(null);
            item.setNext(null);
            item = temp;
        }
        first = last = null;
        capacity = 0;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public T get(int index) {
        return getNode(index).getValue();
    }

    @Override
    public String toString() {
        StringBuilder listToString = new StringBuilder();
        for (Node<T> item = first; item != null; ) {
            listToString.append(item.getValue().toString());
            if (item != last) {
                listToString.append("<->");
            }
            item = item.getNext();
        }
        return listToString.toString();
    }

}
