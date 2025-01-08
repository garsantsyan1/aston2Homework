package com.example;

import java.util.Arrays;

public class Homework {


    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        System.out.println(new StringBuilder(string).reverse());
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        Arrays.stream(ints)
                .distinct()
                .forEach(num -> System.out.print(num + " "));
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        int max = Arrays.stream(arr)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Array is empty"));

        return Arrays.stream(arr)
                .filter(x -> x < max)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Array does not contain a second maximum element"));
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        string = string.trim();
        int lastSpaceIndex = string.lastIndexOf(' ');
        if (lastSpaceIndex == -1) {
            return string.length();
        }
        return string.length() - lastSpaceIndex - 1;
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        int length = string.length();

        for (int i = 0; i < length / 2; i++) {
            if (string.charAt(i) != string.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
