package com.company;

import java.util.Iterator;  // Iterator Import

public class MyArrayList<T> implements Iterable<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    public MyArrayList() {
    }

    public MyArrayList(T[] elements) {
        for (T element : elements) {
            add(element);
        }
    }

    /**
     * add element
     *
     * @param item
     */
    public void add(T item) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = item;
    }

    /**
     * add element
     *
     * @param item
     */
    public void set(int index, T item) {
        while(index > array.length) {
            resize(array.length * 2);
        }

        array[index] = item;
        pointer = index + 1;
    }

    /**
     * @param index
     * @return element
     */
    public T get(int index) {
        return (T) array[index];
    }

    /**
     * remove element
     *
     * @param index
     */
    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);
    }

    /**
     * get size
     *
     * @return array size
     */
    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    /**
     *
     * @return
     */
    public Object[] toArray() {
        return array;
    }

    /**
     *
     * @param element
     * @return
     */
    public int indexOf(T element) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if(array[i] == element) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     *
     * @param element
     * @return
     */
    public int lastIndexOf(T element) {
        int index = -1;

        for (int i = array.length-1; i >= 0; i--) {
            if(array[i] == element) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     *
     * @param element
     * @return
     */
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public void clean(T element) {
        array = new Object[INIT_SIZE];
         pointer = 0;
    }

    /**
     * array resize function
     *
     * @param newLength
     */
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        // OverRiding Default List Iterator //
        Iterator<T> it = new Iterator<T>()
        {
            private int currentIndex = 0;
            @Override
            public boolean hasNext()
            {
                // OverRiding Default hasNext  Method//
                return currentIndex < array.length && array[currentIndex] != null;
            }
            @Override
            public T next()
            {
                // OverRiding Default next  Method//
                return (T) array[currentIndex++];
            }
            @Override
            public void remove()
            {
                // OverRiding Default Remove  Method.
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
