package ua.goit.scollections;

import java.util.Arrays;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] array;

    private void checkIndex(int index) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException("Index out of LinkedList capacity");
        }
    }

    @SuppressWarnings("unchecked")
    public SimpleArrayList(int initLength) throws IllegalArgumentException {
        if (initLength >= 0) {
            this.array = (T[]) new Object[initLength];
        } else {
            throw new IllegalArgumentException("Capacity must be non-negative");
        }
    }

    public SimpleArrayList() {
        this(0);
    }

    public void add(T item) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = item;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array = Arrays.copyOf(array, array.length - 1);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        array = (T[]) new Object[]{};
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        return array[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
