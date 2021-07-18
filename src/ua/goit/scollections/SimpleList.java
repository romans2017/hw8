package ua.goit.scollections;

public interface SimpleList<T> {

    void add(T item);

    void remove(int index);

    void clear();

    int size();

    T get(int index);

}
