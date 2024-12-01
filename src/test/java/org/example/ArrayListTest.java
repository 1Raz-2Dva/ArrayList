package org.example;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;


class ArrayListTest {

    @Test
    void add() {
        ArrayList<String> list = new ArrayList<>();

        // Populating a list with 1000 elements
        for (int i = 0; i < 1000; i++) {
            list.add("Element " + i);
        }

        // Checking that list size is 1000
        assertEquals(1000, list.size(), "List size should be 1000");
    }

    @Test
    void addIndex() {
    }

    @Test
    void get() {

        // Create and fill ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("first element");
        list.add("second element");
        list.add("third element");
        list.add("fourth element");
        list.add("fifth element");

        // Getting an element by index
        String element = list.get(2); // We get "third element"

        // We check that the received element matches the expected one
        assertEquals("third element", element);
    }

    @Test
    void remove() {
        ArrayList<String> list = new ArrayList<>();

        // Populating a list with 1000 elements
        for (int i = 0; i < 1000; i++) {
            list.add("Element " + i);
        }

        // Removing all items
        for (int i = 999; i >= 0; i--) {
            list.remove(i);
        }

        // Checking list size
        assertEquals(0, list.size(), "The list size should be 0 after removing all elements");
    }

    @Test
    void clear() {

        // Create and fill ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("first element");
        list.add("second element");
        list.add("third element");
        list.add("fourth element");
        list.add("fifth element");

        // Checking that the list is not empty before clearing
        assertEquals(5, list.size());

        // Вызываем метод clear
        list.clear();

        // Проверяем, что размер списка стал 0
        assertEquals(0, list.size());
    }

    @Test
    void swap() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.swap(0, 2); // Let's say the swap method is implemented
        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(2));
    }
}