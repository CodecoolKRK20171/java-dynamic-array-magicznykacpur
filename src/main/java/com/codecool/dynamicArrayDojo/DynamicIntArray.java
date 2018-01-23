package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {

    Integer[] array;
    int pointer;
    int size;

    public DynamicIntArray(int size) {
        this.pointer = 0;
        this.size = size;
        this.array = new Integer[size];
    }

    public DynamicIntArray() {
        this.pointer = 0;
        this.size = 1;
        this.array = new Integer[size];
    }

    public void add(int value) {
        Integer[] newArray = new Integer[++size];

        if (array[0] == null) {
            newArray[pointer++] = value;
            array = newArray;
        }

        else {
            for (int i = 0; i < size - 1; i++) {
                newArray[i] = array[i];
                pointer++;
            }

            newArray[size - 1] = value;
            pointer++;

            array = newArray;
        }
    }

    public void remove(int index) {
//        for (int i = 0; i < size - 1; i++) {
//            if (i == index)

//        }
    }

    public void insert(int index, int value) {}

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Integer i : array)
            if (i != null)
                sb.append(" " + i);

        return sb.toString();
    }

    public static void main(String[] args) {
        DynamicIntArray a = new DynamicIntArray();
        System.out.println(a.toString());
    }
}