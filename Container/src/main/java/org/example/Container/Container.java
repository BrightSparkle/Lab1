package org.example.Container;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Динамический контейнер для хранения целочисленных значений.
 * Реализует механизм автоматического расширения внутреннего массива при заполнении.
 * Поддерживает итерацию по элементам с помощью интерфейса {@link Iterable}.
 *
 * <p>Элементы хранятся в порядке добавления. При удалении элемента происходит сдвиг
 * последующих элементов влево для заполнения пустого пространства.</p>
 */

public class Container implements Iterable<Integer> {

    private Integer[] elements;
    private int size;

    /**
     * Создает новый пустой контейнер с начальной емкостью 10 элементов.
     */
    public Container() {
        elements = new Integer[10];
        size = 0;
    }

    /**
     * Добавляет значение в контейнер.
     *
     * @param value добавляемое значение (не может быть null)
     * @throws IllegalArgumentException если передано значение null
     */
    public void add(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("Null values are not allowed");
        }
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = value;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index позиция элемента (отсчет с 0)
     * @return элемент на указанной позиции
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона [0, size-1]
     */
    public Integer get(int index) {
        checkIndex(index);
        return elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу. Сдвигает последующие элементы влево.
     *
     * @param index позиция элемента для удаления
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона
     */
    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    /**
     * Возвращает текущее количество элементов в контейнере.
     *
     * @return количество элементов
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет валидность индекса.
     *
     * @param index проверяемый индекс
     * @throws IndexOutOfBoundsException если индекс невалиден
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Увеличивает емкость внутреннего массива вдвое.
     * Используется автоматически при заполнении текущего массива.
     */
    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Integer[] newArray = new Integer[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    /**
     * Возвращает итератор для последовательного обхода элементов контейнера.
     *
     * @return итератор элементов в порядке их добавления
     */
    @Override
    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    /**
     * Внутренний класс-итератор для обхода элементов контейнера.
     * Поддерживает базовые операции итерации.
     */
    private class IntIterator implements Iterator<Integer> {

        private int cursor = 0;

        /**
         * Проверяет наличие следующего элемента для итерации.
         *
         * @return true если есть следующий элемент, иначе false
         */
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        /**
         * Возвращает следующий элемент в итерации.
         *
         * @return следующий элемент
         * @throws NoSuchElementException если достигнут конец контейнера
         */
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[cursor++];
        }
    }
}
