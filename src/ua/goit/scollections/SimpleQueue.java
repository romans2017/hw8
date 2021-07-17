package ua.goit.scollections;

public class SimpleQueue<T> extends SimpleLinkedList<T> {

    public T peek() {
        if (size() == 0) {
            return null;
        } else {
            return getFirst().getValue();
        }
    }

    public T poll() {
        T firstInQueue = peek();
        if (firstInQueue != null) {
            remove(0);
        }
        return firstInQueue;
    }
}
