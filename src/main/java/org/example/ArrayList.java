package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ArrayList - producing a non-thread-safe list
 * supporting basic operations with a massive array
 *
 * @param <T> the type of elements in the list
 */
public class ArrayList<T> {
    private Object[] elements; // An array to store elements
    private int size; // Current list size

    /**
     * Constructor, initializes an array of a fixed size
     */
    public ArrayList() {
        elements = new Object[10]; // Initial array size
        size = 0;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param element element to be added
     */
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Adds an element at the specified index (does not replace the current element)
     *
     * @param index   index at which to add the element
     * @param element element to be added
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds " + index);
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Gets the element at the specified index
     *
     * @param index element index
     * @return element at the specified index
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds ");
        }
        return (T) elements[index];
    }

    /**
     * Removes the element at the specified index
     *
     * @param index index of the element to be deleted
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds ");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    /**
     * Clears the list by removing all elements
     */
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /**
     * Returns the current number of elements in the list
     *
     * @return current number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Sorts the elements of a list using the supplied comparator
     *
     * @param comparator a comparator that determines the sort order
     */
    public void sort(Comparator<? super T> comparator) {
        quicksort(0, size - 1, comparator);
    }

    /**
     * Quicksort algorithm for sorting an array
     *
     * @param low        starting index
     * @param high       end index
     * @param comparator a comparator that determines the sort order
     */
    private void quicksort(int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quicksort(low, pivotIndex - 1, comparator);
            quicksort(pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Splits an array and returns the index of the delimiter
     *
     * @param low        starting index
     * @param high       end index
     * @param comparator a comparator that determines the sort order
     * @return delimiter index
     */
    private int partition(int low, int high, Comparator<? super T> comparator) {
        T pivot = (T) elements[high]; // Take the last element as a reference
        int i = low - 1; // Index of the smaller element
        for (int j = low; j < high; j++) {
            if (comparator.compare((T) elements[j], pivot) <= 0) {
                i++;
                swap(i, j); // Swap places
            }
        }
        swap(i + 1, high); // Change the support element to the correct position
        return i + 1;
    }

    /**
     * Swaps an element
     */
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     * Increases array size if necessary.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
}

/*
Description of methods:
MyArrayList constructor – creates an array of fixed size 10
add(T element) – add an element to the end of the list
add(int index, T element) – add an element at a given index, replacing the rest
get(int index) – returns the element by index
Remove(int index) – save element by index
Clear() – clears the list
size() – returns the current number of elements in the list
sort(Comparator<? super T> comparator) – calls the quicksort method
quicksort(...) – the quick sort algorithm itself
partition(...) is a helper method for partitioning an array
*/
