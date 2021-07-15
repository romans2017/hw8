package ua.goit.scollections;

import java.util.Arrays;

public class SimpleLinkedList<T> implements SimpleList <T> {

    private Node<T> last;

    public void add(T item) {
        if (last == null) {
            last = new Node<T>(item,null,null);
        } else {
            Node<T> newItem = new Node<>(item,last,null);
            last.setNext(newItem);

        }
    }

    public void remove(int index) {
        int length = array.length;
        if (index <= length - 1) {
            System.arraycopy(array,index+1, array, index,length-index-1);
            array[length-1] = null;
            capacity--;
        } else {
            throw new IndexOutOfBoundsException("Index out of length ArrayList");
        }

    }

    public void clear() {
        array = (T[]) new Object[]{};
        capacity = 0;
    }

    public int size() {
        return capacity;
    }

    public T get(int index) {
        if (index <= capacity-1) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of capacity ArrayList");
        }
    }

    public T[] toArray() {
        return array;
    }
}
