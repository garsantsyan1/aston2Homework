package com.example.quickSort;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private final QuickSort quickSort = new QuickSort();

    @Test
    void testSortNaturalOrderIntegers() {
        Integer[] array = {5, 2, 8, 3, 1};
        quickSort.sort(array, Comparator.naturalOrder());
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 8}, array);
    }

    @Test
    void testSortNaturalOrderStrings() {
        String[] array = {"banana", "apple", "cherry", "date"};
        quickSort.sort(array, Comparator.naturalOrder());
        assertArrayEquals(new String[]{"apple", "banana", "cherry", "date"}, array);
    }

    @Test
    void testSortCustomComparator() {
        Integer[] array = {5, 2, 8, 3, 1};
        quickSort.sort(array, Comparator.reverseOrder());
        assertArrayEquals(new Integer[]{8, 5, 3, 2, 1}, array);
    }

    @Test
    void testSortEmptyArray() {
        Integer[] array = {};
        quickSort.sort(array, Comparator.naturalOrder());
        assertArrayEquals(new Integer[]{}, array);
    }

    @Test
    void testSortSingleElement() {
        Integer[] array = {42};
        quickSort.sort(array, Comparator.naturalOrder());
        assertArrayEquals(new Integer[]{42}, array);
    }

    @Test
    void testSortWithNullComparator() {
        Integer[] array = {5, 2, 8, 3, 1};
        assertThrows(NullPointerException.class, () -> quickSort.sort(array, null));
    }

    @Test
    void testSortArrayWithNulls() {
        Integer[] array = {5, null, 8, 3, null};
        Comparator<Integer> safeComparator = Comparator.nullsFirst(Comparator.naturalOrder());
        quickSort.sort(array, safeComparator);
        assertArrayEquals(new Integer[]{null, null, 3, 5, 8}, array);
    }

    @Test
    void testSortUsingComparable() {
        Integer[] array = {5, 2, 8, 3, 1};
        quickSort.sort(array);
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 8}, array);
    }

    @Test
    void testSortUsingComparableWithStrings() {
        String[] array = {"banana", "apple", "cherry", "date"};
        quickSort.sort(array);
        assertArrayEquals(new String[]{"apple", "banana", "cherry", "date"}, array);
    }

    @Test
    void testSortArrayContainingDuplicates() {
        Integer[] array = {5, 2, 8, 3, 2, 8, 1};
        quickSort.sort(array, Comparator.naturalOrder());
        assertArrayEquals(new Integer[]{1, 2, 2, 3, 5, 8, 8}, array);
    }

    @Test
    void testSortLargeArray() {
        Integer[] array = new Integer[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        quickSort.sort(array, Comparator.naturalOrder());
        for (int i = 0; i < array.length; i++) {
            assertEquals(i + 1, array[i]);
        }
    }
}
