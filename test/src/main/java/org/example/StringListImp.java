package org.example;

import java.util.Arrays;

public class StringListImp implements StringList {
    private String[] array;
    private int index = -1;

    public StringListImp(int size) {
        array = new String[size];
    }

    @Override
    public String add(String item) {
        if (index < array.length - 1) {
            index++;
            array[index] = item;
        }
        return array[index];
    }

    @Override
    public String add(int index, String item) {
        if (index > this.index)
            throw new IndexOutOfBoundsException("Количество элементов в массиве меньше данного числа");
        if (index == array.length - 1)
            throw new IndexOutOfBoundsException("В массиве нет места");
        for (int i = this.index; i > index; i--) {
            array[i + 1] = array[i];
        }
        this.index++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index > this.index)
            throw new IndexOutOfBoundsException("Количество элементов в массиве меньше данного числа");
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (index > this.index)
            throw new IndexOutOfBoundsException("Количество элементов в массиве меньше данного числа");
        int indexSearchElement = indexOf(item);
        if (indexSearchElement == -1)
            throw new RuntimeException("Такого элемента нет в списке");
        String removeElement = array[indexSearchElement];
        remove(index);
        return removeElement;
    }

    @Override
    public String remove(int index) {
        if (index > this.index)
            throw new IndexOutOfBoundsException("Количество элементов в массиве меньше данного числа");
        String returnElement = array[index];
        this.index--;
        for (int i = index; i < this.index; i++) {
            array[i] = array[i + 1];
        }
        return returnElement;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) > -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < index; i++) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > this.index)
            throw new IndexOutOfBoundsException("Количество элементов в массиве меньше данного числа");
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(otherList==null)
            throw new NullPointerException();
        if (otherList.size() != index)
            return false;
        for (int i = 0; i < index; i++) {
            if (!array[i].equals(otherList.get(i)))
                return false;
        }
        return true;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index > -1;
    }

    @Override
    public void clear() {
        array = new String[array.length];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, index);
    }
}
