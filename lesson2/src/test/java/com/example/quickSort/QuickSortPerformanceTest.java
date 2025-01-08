package com.example.quickSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortPerformanceTest {

    private final QuickSort quickSort = new QuickSort();

    @Test
    void testSortLargeNumberOfElements() {
        int numberOfElements = 1_000_000; // Один миллион элементов
        Integer[] array = new Integer[numberOfElements];

        // Заполняем массив случайными числами
        Random random = new Random();
        for (int i = 0; i < numberOfElements; i++) {
            array[i] = random.nextInt();
        }

        // Создаем копию массива для проверки
        Integer[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected); // Сортируем стандартным методом Java для проверки

        // Сортируем массив с использованием QuickSort
        quickSort.sort(array, Comparator.naturalOrder());

        // Проверяем, что массив отсортирован корректно
        assertArrayEquals(expected, array);
    }

    @Test
    void testSortLargeNumberOfElementsWithDuplicates() {
        int numberOfElements = 1_000_000; // Один миллион элементов
        Integer[] array = new Integer[numberOfElements];

        // Заполняем массив случайными числами с дубликатами
        Random random = new Random();
        for (int i = 0; i < numberOfElements; i++) {
            array[i] = random.nextInt(100); // Ограничиваем диапазон до 100 для появления дубликатов
        }

        // Создаем копию массива для проверки
        Integer[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected); // Сортируем стандартным методом Java для проверки

        // Сортируем массив с использованием QuickSort
        quickSort.sort(array, Comparator.naturalOrder());

        // Проверяем, что массив отсортирован корректно
        assertArrayEquals(expected, array);
    }
}
