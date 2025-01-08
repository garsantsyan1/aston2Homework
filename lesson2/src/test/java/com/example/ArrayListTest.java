package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private ArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testAddElementAtIndex() {
        list.add(10);
        list.add(20);
        list.add(1, 15); // Вставка 15 на позицию 1
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(15, list.get(1));
        assertEquals(20, list.get(2));
    }

    @Test
    void testAddAll() {
        list.add(10);
        list.add(20);
        list.addAll(Arrays.asList(30, 40, 50));
        assertEquals(5, list.size());
        assertEquals(10, list.get(0));
        assertEquals(50, list.get(4));
    }

    @Test
    void testGetElement() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, list.get(1));
    }

    @Test
    void testSetElement() {
        list.add(10);
        list.add(20);
        list.set(25, 1); // Заменяем элемент на позиции 1
        assertEquals(25, list.get(1));
    }

    @Test
    void testClear() {
        list.add(10);
        list.add(20);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemoveByIndex() {
        list.add(10);
        list.add(20);
        list.add(30);
        int removed = list.remove(1); // Удаляем элемент на позиции 1
        assertEquals(20, removed);
        assertEquals(2, list.size());
        assertEquals(30, list.get(1));
    }

    @Test
    void testRemoveByObject() {
        list.add(10);
        list.add(20);
        list.add(30);
        boolean result = list.remove(Integer.valueOf(20)); // Удаляем 20
        assertTrue(result);
        assertEquals(2, list.size());
        assertEquals(30, list.get(1));
    }

    @Test
    void testContains() {
        list.add(10);
        list.add(20);
        assertTrue(list.contains(10));
        assertFalse(list.contains(30));
    }

    @Test
    void testSort() {
        list.add(30);
        list.add(10);
        list.add(20);
        list.sort(Comparator.naturalOrder()); // Сортировка в естественном порядке
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testToString() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    void testEnsureCapacity() {
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        list.add(11); // Увеличиваем емкость
        assertEquals(11, list.size());
        assertEquals(11, list.get(10));
    }
}
