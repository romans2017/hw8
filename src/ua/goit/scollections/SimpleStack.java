package ua.goit.scollections;

public class SimpleStack<T> extends SimpleLinkedList<T> {

    public T peek() {
        if (size() == 0) {
            return null;
        } else {
            return getLast().getValue();
        }
    }

    public void push(T item) {
        add(item);
    }

    public T pop() {
        T firstInStack = peek();
        if (firstInStack != null) {
            remove(size() - 1);
        }
        return firstInStack;
    }
}
