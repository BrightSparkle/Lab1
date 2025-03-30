package org.example.Container;

public class Container {

    private int[] elements;
    private int size;

    public Container() {
        elements = new int[10];
        size = 0;
    }

    public void add(int value) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = value;
    }

    public int get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        size--;
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
        int[] newArray = new int[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }
}
