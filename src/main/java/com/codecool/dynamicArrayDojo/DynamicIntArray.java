package com.codecool.dynamicArrayDojo;

import java.lang.reflect.Array;

public class DynamicIntArray {

    private static Integer[] staticArray;

    public DynamicIntArray(Integer size) {
        this.staticArray = new Integer[size];
    }

    public DynamicIntArray() {
        this.staticArray = new Integer[0];
    }

    public void add(int number) {
        Integer[] oldArray = staticArray;
        Integer[] newArray = new Integer[oldArray.length + 1];

        Array.set(newArray, newArray.length - 1, number);
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);

        staticArray = newArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Object o : this.staticArray)
            sb.append(" " + o);

        return sb.toString();
    }

    public void remove(int index) {
        Integer[] oldArray = staticArray;
        Integer[] newArray = new Integer[oldArray.length - 1];

        if (index < 0 || index >= oldArray.length)
            throw new ArrayIndexOutOfBoundsException("Invalid index.");

        else if (index == 0) {
            System.arraycopy(oldArray, 1, newArray, 0, oldArray.length - 1);
            staticArray = newArray;
        }

        else if (index == oldArray.length - 1) {
            System.arraycopy(oldArray, 0, newArray, 0, oldArray.length - 1);
            staticArray = newArray;
        }

        else {
            System.arraycopy(oldArray, 0, newArray, 0, index);
            System.arraycopy(oldArray, index + 1, newArray, index, index);
            staticArray = newArray;
        }
    }

    public void insert(int index, int number) {
        Integer[] oldArray = staticArray;
        Integer[] newArray = new Integer[oldArray.length + 1];

        if (index >= newArray.length)
            index = newArray.length - 1;

        System.arraycopy(oldArray, 0, newArray, 0, index);
        Array.set(newArray, index, number);
        System.arraycopy(oldArray, index, newArray, index + 1, oldArray.length - index);

        staticArray = newArray;
    }
}
