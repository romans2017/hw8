package ua.goit.scollections;

import java.util.Arrays;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] array;
    private int capacity; //number of not-null Objects in array

    public SimpleArrayList(int initLength) {
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
        if (capacity == array.length) {
            array = Arrays.copyOf(array, capacity+1);
        }
        array[capacity] = item;
        capacity++;
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
