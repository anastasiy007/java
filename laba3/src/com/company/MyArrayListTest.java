package com.company;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    @org.junit.jupiter.api.Test
    void add() {
        MyArrayList<Integer> array = new MyArrayList<Integer>();
        array.add(1);
        array.add(20);
        assertEquals(2, array.size());
    }

    @org.junit.jupiter.api.Test
    void set() {
        MyArrayList<Integer> array = new MyArrayList<Integer>();
        array.set(4, 20);
        array.add(300);
        assertEquals(array.get(4), 20);
        assertEquals(array.get(5), 300);
    }

    @org.junit.jupiter.api.Test
    void get() {
        MyArrayList<Integer> array = new MyArrayList<Integer>();
        array.add(1);
        array.add(20);
        array.add(300);
        assertEquals(20, array.get(1));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        Integer[] vars = {
                100, 23, 42, 123
        };
        MyArrayList<Integer> array = new MyArrayList<Integer>(vars);
        array.remove(1);
        array.remove(1);
        assertEquals(123, array.get(1));
        assertEquals(2, array.size());
    }

    @org.junit.jupiter.api.Test
    void size() {
        Integer[] vars = {
                100, 23, 42, 123
        };
        MyArrayList<Integer> array = new MyArrayList<Integer>(vars);
        assertEquals(4, array.size());
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        Integer[] vars = {
                100, 23, 42, 123
        };
        MyArrayList<Integer> array = new MyArrayList<Integer>(vars);
        Object[] vars2 = array.toArray();

        assertEquals(123, vars2[3]);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Integer[] vars = {
                100, 23
        };
        MyArrayList<Integer> array = new MyArrayList<Integer>(vars);

        assertFalse(array.isEmpty());

        array.remove(0);
        array.remove(0);

        assertTrue(array.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        Integer[] vars = {
                100, 23, 15, 20, 15
        };
        MyArrayList<Integer> array = new MyArrayList<Integer>(vars);


        assertEquals(2, array.indexOf(15));
        assertEquals(-1, array.indexOf(16));
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
        Integer[] vars = {
                100, 23, 15, 20, 15
        };
        MyArrayList<Integer> array = new MyArrayList<Integer>(vars);


        assertEquals(2, array.indexOf(15));
        assertEquals(-1, array.indexOf(16));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        Integer[] vars = {
                100, 23, 15, 20
        };
        MyArrayList<Integer> array = new MyArrayList<Integer>(vars);


        assertTrue(array.contains(15));
        assertFalse(array.contains(16));
    }
}