package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<Integer>();
        array.add(1);
        array.add(20);
        array.add(300);
        array.add(4000);

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

        array.remove(2);

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

        //getting Custom iterator from List.
        for (Integer integer : array) {   //custom hasNext() Method
            String value = integer.toString();   // Custom Method Return The Current Index
            System.out.print(value + ", ");
        }
        System.out.println();
    }
}
