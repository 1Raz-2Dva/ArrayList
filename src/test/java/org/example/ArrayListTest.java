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

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(list.size()+2);
        });
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

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(list.size()+2);
        });
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

        // Call the clear method
        list.clear();

        // Checking that the list size has become 0
        assertEquals(0, list.size());
    }

    @Test
    public void SortComparator() {
        ArrayList<String> list = new ArrayList<>();
        list.add("second element");
        list.add("first element");
        list.add("third element");
        list.sort(Comparator.reverseOrder());
        assertEquals("third element", list.get(0));
        assertEquals("second element", list.get(1));
        assertEquals("first element", list.get(2));
    }

    @Test
    void sort() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        list.sort(Comparator.naturalOrder());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
    }

    @Test
    void swap() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.swap(0, 2);
        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(2));
    }

    @Test
    public void index() {
        ArrayList<Object> list = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.addIndex(-1, 5);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.addIndex(5, 5);
        });
    }

    @Test
    public void addIndex() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("first element");
        list.add("second element");
        list.add("third element");

        // Add element "three" at index 2
        list.addIndex(1, "fourth element");

        // We expect the list to become ["first element", "second element", "third element", "fourth element"]
        assertEquals(4, list.size());

        // Verifying that items are ordered correctly after increasing capacity
        assertEquals("first element", list.get(0));
        assertEquals("fourth element", list.get(1));
        assertEquals("second element", list.get(2));
        assertEquals("third element", list.get(3));
    }
}