package org.chementsova.arrayList.implementation;

import org.chementsova.arrayList.CustomList;

public class CustomArrayList<T> implements CustomList<T> {

    private final int DEFAULT_CAPACITY = 10;

    private T[] list;

    private int size;

    public CustomArrayList(T[] list, int size) {
        if(size <= 0) {
            throw new IllegalArgumentException("The size isn't valid");
        } else {
            this.list = (T[]) new Object[size];
        }
    }

    public CustomArrayList() {
        this.list = (T[]) new Object[this.DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(T t) {
        resize(this.size+1);
        list[size++] = t;
        return true;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("The index isn't valid");
        } else {
            int num = this.size - index - 1;
            if(num > 0) {
                System.arraycopy(list, index + 1, list, index, num);
            }
            list[--size] = null;
        }
    }

    @Override
    public T get(int index) {
        if((index < 0) || (index >= size)) {
            throw new IllegalArgumentException("The index isn't valid");
        } else {
            return list[index];
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    private void resize(int needSize) {
        if(needSize > list.length) {
            T[] oldList = this.list;
            int newSize = oldList.length * 2;
            this.list = (T[]) new Object[newSize];
            System.arraycopy(oldList, 0, this.list, 0, oldList.length);
        }
    }
}
