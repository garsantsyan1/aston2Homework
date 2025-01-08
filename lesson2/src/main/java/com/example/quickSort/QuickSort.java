package com.example.quickSort;

import java.util.Comparator;

/**
 * Реализация алгоритма быстрой сортировки (QuickSort).
 * <p>
 * Этот класс предоставляет методы для сортировки массивов объектов
 * с использованием пользовательских компараторов (Comparator)
 * или естественного порядка (Comparable).
 * </p>
 */
public class QuickSort {

    /**
     * Сортирует массив с использованием указанного Comparator.
     * <p>
     * Если массив содержит менее двух элементов, метод завершает выполнение,
     * так как он уже отсортирован. Если переданный компаратор равен {@code null},
     * выбрасывается {@link NullPointerException}.
     * </p>
     *
     * @param arr Массив, который нужно отсортировать.
     * @param c   Comparator, определяющий порядок сортировки элементов.
     * @param <E> Тип элементов массива.
     * @throws NullPointerException Если массив равен {@code null}.
     */
    public <E> void sort(Object[] arr, Comparator<? super E> c) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be null");
        }
        if (arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1, c);
    }

    /**
     * Сортирует массив с использованием естественного порядка элементов (Comparable).
     *
     * @param arr Массив, который нужно отсортировать.
     * @param <E> Тип элементов массива, реализующих Comparable.
     * @throws NullPointerException Если массив равен {@code null}.
     */
    @SuppressWarnings("unchecked")
    public <E extends Comparable<? super E>> void sort(Object[] arr) {
        sort(arr, (a, b) -> ((Comparable<E>) a).compareTo((E) b));
    }

    /**
     * Реализация алгоритма быстрой сортировки.
     *
     * @param arr  Массив для сортировки.
     * @param low  Начальный индекс.
     * @param high Конечный индекс.
     * @param c    Компаратор для сравнения элементов.
     * @param <E>  Тип элементов массива.
     */
    private <E> void quickSort(Object[] arr, int low, int high, Comparator<? super E> c) {
        while (low < high) {
            int pivotIndex = partition(arr, low, high, c);


            if (pivotIndex - low < high - pivotIndex) {
                quickSort(arr, low, pivotIndex - 1, c);
                low = pivotIndex + 1; // Продолжаем с правой частью
            } else {
                quickSort(arr, pivotIndex + 1, high, c);
                high = pivotIndex - 1; // Продолжаем с левой частью
            }
        }
    }

    /**
     * Выполняет разбиение массива на две части относительно опорного элемента.
     *
     * @param arr  Массив для разбиения.
     * @param low  Начальный индекс.
     * @param high Конечный индекс.
     * @param c    Компаратор для сравнения элементов.
     * @param <E>  Тип элементов массива.
     * @return Индекс опорного элемента после разбиения.
     */
    @SuppressWarnings("unchecked")
    private <E> int partition(Object[] arr, int low, int high, Comparator<? super E> c) {
        int randomIndex = low + (int) (Math.random() * (high - low + 1));
        swap(arr, randomIndex, high);

        E pivot = (E) arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (c.compare((E) arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Меняет местами два элемента в массиве.
     *
     * @param arr Массив.
     * @param i   Индекс первого элемента.
     * @param j   Индекс второго элемента.
     */
    private void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
