package org.chementsova.hashSet.implementation;

public class Element<T> {
    T element;

    Element<T> next;

    public Element(T element) {
        this.element = element;
    }

}
