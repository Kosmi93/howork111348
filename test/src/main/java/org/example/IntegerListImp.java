package org.example;

import org.example.exception.NullDataException;

public class IntegerListImp implements IntegerList {

    private int size;
    Integer[] array;

    public IntegerListImp(int size) {
        this.array = new Integer[size];
    }

    private void isNullException(Integer item) {
        if (item == null)
            throw new NullDataException("Массив не может содержать null");
    }

    private void newArraySize() {
        Integer[] newArray = new Integer[(int) (size * 1.5)];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    private void isIndexOfException(int index) {
        if (index > size)
            throw new IndexOutOfBoundsException("В массиве нет такого индекса");
    }

    @Override
    public Integer add(Integer item) {
        isNullException(item);
        if (size == array.length)
            newArraySize();
        array[size] = item;
        size++;
        return array[size - 1];
    }

    @Override
    public Integer add(int index, Integer item) {
        isNullException(item);
        isIndexOfException(index);
        if (size >= array.length)
            newArraySize();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        size++;
        array[index] = item;
        return array[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        isNullException(item);
        isIndexOfException(index);
        array[index]=item;
        return array[index];
    }

    @Override
    public Integer remove(Integer item) {
        return null;
    }

    @Override
    public Integer remove(int index) {
        isNullException(index);
        isIndexOfException(index);
        size--;
        int removeItem= array[index];
        for (int i = index; i < size; i++) {
            array[i]=array[i+1];
        }
        return removeItem;
    }

    @Override
    public boolean contains(Integer item) {
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        return 0;
    }

    @Override
    public int lastIndexOf(Integer item) {
        return 0;
    }

    @Override
    public Integer get(int index) {
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Integer[] toArray() {
        return new Integer[0];
    }
}
