package ua.goit.scollections;

public class SimpleStack<T> extends SimpleDeque<T> {

    public T peek() {
        if (size() == 0) {
            return null;
        } else {
            return getLast().getValue();
        }
    }

    public void push(T item) {
        super.add(item);
    }

    public T pop() {
        T firstInStack = peek();
        if (firstInStack != null) {
            remove(size() - 1);
        }
        return firstInStack;
    }
}
