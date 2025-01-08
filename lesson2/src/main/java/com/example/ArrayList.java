package com.example;

import com.example.quickSort.QuickSort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;


/**
 * Класс ArrayList — реализация динамического массива.
 * <p>
 * Поддерживает операции добавления, удаления, сортировки, поиска и получения элементов.
 * Автоматически увеличивает емкость при необходимости, позволяет работать с любыми типами данных через дженерики.
 * </p>
 *
 * @param <E> Тип элементов, хранимых в списке.
 */
public class ArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    /**
     * Конструктор по умолчанию. Создает список с начальной емкостью 10.
     */
    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Конструктор с заданной начальной емкостью.
     *
     * @param initialCapacity начальная емкость списка.
     * @throws IllegalArgumentException если начальная емкость меньше 0.
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elementData = new Object[initialCapacity];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент, который нужно добавить.
     */
    public void add(E element) {
        ensureCapacity(size + 1);
        elementData[size++] = element;
    }


    /**
     * Добавляет элемент в указанную позицию.
     *
     * @param index   индекс, куда нужно вставить элемент.
     * @param element элемент, который нужно вставить.
     * @throws IndexOutOfBoundsException если индекс вне диапазона [0, size].
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }


    /**
     * Добавляет все элементы из коллекции в конец списка.
     *
     * @param c коллекция, элементы которой нужно добавить.
     * @return true, если элементы были добавлены, иначе false.
     */
    public boolean addAll(Collection<? extends E> c) {
        Object[] newElementsData = c.toArray();
        int numNewElements = newElementsData.length;
        ensureCapacity(size + numNewElements);
        System.arraycopy(newElementsData, 0, elementData, size, numNewElements);
        size += numNewElements;
        return numNewElements != 0;
    }

    /**
     * Возвращает элемент по индексу.
     *
     * @param index индекс элемента.
     * @return элемент по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс вне диапазона [0, size - 1].
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (E) elementData[index];
    }

    /**
     * Заменяет элемент по указанному индексу.
     *
     * @param element новый элемент.
     * @param index   индекс, где заменить элемент.
     * @throws IndexOutOfBoundsException если индекс вне диапазона [0, size - 1].
     */
    public void set(E element, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        elementData[index] = element;
    }

    /**
     * Очищает список, удаляя все элементы.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * Удаляет элемент по индексу.
     *
     * @param index индекс элемента для удаления.
     * @return удаленный элемент.
     * @throws IndexOutOfBoundsException если индекс вне диапазона [0, size - 1].
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E oldValue = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        size--;
        elementData[size] = null;
        return oldValue;
    }

    /**
     * Удаляет первый найденный элемент, равный переданному объекту.
     *
     * @param o объект для удаления.
     * @return true, если элемент был удален, иначе false.
     */
    public boolean remove(Object o) {
        for (int index = 0; index < size; index++) {
            if (o.equals(elementData[index])) {
                remove(index);
                return true;
            }
        }
        return false;
    }

    /**
     * Сортирует список с использованием переданного компаратора.
     *
     * @param c компаратор, определяющий порядок сортировки.
     */
    public void sort(Comparator<? super E> c) {
        QuickSort quickSort = new QuickSort();
        Object[] filledArray = Arrays.copyOfRange(elementData, 0, size);
        quickSort.sort(filledArray, c);
        System.arraycopy(filledArray, 0, elementData, 0, size);
    }

    /**
     * Проверяет, является ли список пустым.
     *
     * @return true, если список пуст, иначе false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Проверяет, содержит ли список указанный элемент.
     *
     * @param value элемент для проверки.
     * @return true, если элемент содержится в списке, иначе false.
     */
    public boolean contains(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(elementData[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает текущее количество элементов в списке.
     *
     * @return размер списка.
     */
    public int size() {
        return size;
    }

    /**
     * Возвращает строковое представление списка.
     *
     * @return строка в формате "[элемент1, элемент2, ...]".
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Увеличивает емкость массива до указанного размера.
     *
     * @param minCapacity минимально необходимая емкость.
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            int newCapacity = Math.max(elementData.length + (elementData.length >> 1), minCapacity);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elementData, 0, newArray, 0, size);
            elementData = newArray;
        }
    }

}