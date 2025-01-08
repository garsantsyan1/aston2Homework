package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListPerformanceTest {

    @Test
    void testAddLargeNumberOfElements() {
        ArrayList<Integer> list = new ArrayList<>();
        int numberOfElements = 1_000_000; // Один миллион элементов

        // Добавляем элементы
        for (int i = 0; i < numberOfElements; i++) {
            list.add(i);
        }

        // Проверяем размер
        assertEquals(numberOfElements, list.size());

        // Проверяем доступ к элементам
        assertEquals(0, list.get(0)); // Первый элемент
        assertEquals(numberOfElements - 1, list.get(numberOfElements - 1)); // Последний элемент
    }

    @Test
    void testRemoveLargeNumberOfElements() {
        ArrayList<Integer> list = new ArrayList<>();
        int numberOfElements = 1_000_000; // Один миллион элементов

        // Добавляем элементы
        for (int i = 0; i < numberOfElements; i++) {
            list.add(i);
        }

        // Удаляем элементы с конца
        for (int i = numberOfElements - 1; i >= 0; i--) {
            assertEquals(i, list.remove(i));
        }

        // Проверяем, что список пуст
        assertTrue(list.isEmpty());
    }

    @Test
    void testSortLargeNumberOfElements() {
        ArrayList<Integer> list = new ArrayList<>();
        int numberOfElements = 1_000_000; // Один миллион элементов

        // Добавляем элементы в обратном порядке
        for (int i = numberOfElements - 1; i >= 0; i--) {
            list.add(i);
        }

        // Сортируем список
        list.sort(Integer::compareTo);

        // Проверяем, что элементы отсортированы
        for (int i = 0; i < numberOfElements; i++) {
            assertEquals(i, list.get(i));
        }
    }
}
