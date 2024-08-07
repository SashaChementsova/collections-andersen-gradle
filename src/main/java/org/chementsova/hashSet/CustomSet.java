package org.chementsova.hashSet;

public interface CustomSet<T> {
    boolean put(T t);

    boolean remove(T t);

    boolean contains(T t);

    int size();
}
