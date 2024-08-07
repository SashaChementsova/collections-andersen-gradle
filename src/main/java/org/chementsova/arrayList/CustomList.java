package org.chementsova.arrayList;

public interface CustomList<T> {
    boolean add(T t);

    void remove(int index);

    T get(int index);

    int getSize();
}
