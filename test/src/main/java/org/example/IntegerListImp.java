package org.example;

import org.example.exception.NullDataException;

import java.util.Arrays;

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

    private void swapElements( int indexA, int indexB) {
        int tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }

    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapElements( j, j + 1);
                }
            }
        }
    }

    public boolean binarySearch(int element) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == array[mid]) {
                return true;
            }

            if (element < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
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
        if (size == array.length)
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
        array[index] = item;
        return array[index];
    }

    @Override
    public int indexOf(Integer item) {
        isNullException(item);
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item))
                return array[i];
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        isNullException(item);
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item))
                return array[i];
        }
        return -1;
    }

    @Override
    public boolean contains(Integer item) {
        isNullException(item);
        sortBubble();
        return binarySearch(item);
    }

    @Override
    public Integer remove(int index) {
        isNullException(index);
        isIndexOfException(index);
        size--;
        int removeItem = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        return removeItem;
    }

    @Override
    public Integer remove(Integer item) {
        isNullException(item);
        return remove(indexOf(item));
    }

    @Override
    public Integer get(int index) {
        isIndexOfException(index);
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(array, otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        array = new Integer[10];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, size);
    }
}
