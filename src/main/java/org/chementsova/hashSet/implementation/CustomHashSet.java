package org.chementsova.hashSet.implementation;

import org.chementsova.hashSet.CustomSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomHashSet<T> implements CustomSet<T>, Iterable<T> {
    private final int DEFAULT_CAPACITY = 10;

    private final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Element<T>[] elementsSet;

    private int size;

    private int capacity;

    public CustomHashSet() {
        capacity = DEFAULT_CAPACITY;
        elementsSet = new Element[capacity];
    }

    @Override
    public boolean put(T t) {
        int index = getIndex(t);
        Element<T> current = elementsSet[index];

        while (current != null) {
            if (current.element.equals(t)) {
                return false; // Element already exists
            }
            current = current.next;
        }

        Element<T> newSet = new Element<>(t);
        newSet.next = elementsSet[index];
        elementsSet[index] = newSet;
        size++;
        if (size >= (capacity * DEFAULT_LOAD_FACTOR)) {
            resize();
        }
        return true;
    }

    @Override
    public boolean remove(T t) {
        int index = getIndex(t);
        Element<T> current = elementsSet[index];
        Element<T> prev = null;

        while (current != null) {
            if (current.element.equals(t)) {
                if (prev == null) {
                    elementsSet[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(T t) {
        int index = getIndex(t);
        Element<T> current = elementsSet[index];

        while (current != null) {
            if (current.element.equals(t)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(T t) {
        return Math.abs(t.hashCode()) % capacity;

    }

    private void resize() {
        capacity *= 2;
        Element<T>[] newSet = new Element[capacity];

        for (Element<T> element : elementsSet) {
            while (element != null) {
                int newIndex = getIndex(element.element);
                Element<T> temp = element.next;
                element.next = newSet[newIndex];
                newSet[newIndex] = element;
                element = temp;
            }
        }
        elementsSet = newSet;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomHashSetIterator();
    }

    public class CustomHashSetIterator implements Iterator<T> {
        private int currentIndex;
        private Element<T> currentElement;

        public CustomHashSetIterator() {
            this.currentElement = elementsSet[0];
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            while ((currentElement == null)
                    && (currentIndex < capacity - 1)) {
                currentIndex++;
                currentElement = elementsSet[currentIndex];
            }
            return currentElement != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no next element");
            }
            T element = currentElement.element;
            currentElement = currentElement.next;
            return element;
        }
    }
}
