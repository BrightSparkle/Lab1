package org.example.Container;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container implements Iterable<Integer> {

    private Integer[] elements;
    private int size;

    public Container() {
        elements = new Integer[10];
        size = 0;
    }

    public void add(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("Null values are not allowed");
        }
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = value;
    }

    public Integer get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Integer[] newArray = new Integer[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[cursor++];
        }
    }
}
