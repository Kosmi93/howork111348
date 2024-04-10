package org.example.listString;

import java.util.Arrays;

public class StringListImp implements StringList {
    private String[] array;
    private int count = 0;

    public StringListImp(int size) {
        array = new String[size];
    }

    @Override
    public String add(String item) {
        if(item==null)
            throw new NullPointerException("В массиве запрещено хранить null значения");
        if (count < array.length) {
            array[count] = item;
            count++;
        }
        return array[count -1];
    }

    @Override
    public String add(int index, String item) {
        if(item==null)
            throw new NullPointerException("В массиве запрещено хранить null значения");
        if (index > this.count)
            throw new IndexOutOfBoundsException("Количество элементов в массиве меньше данного числа");
        if (index == array.length - 1)
            throw new RuntimeException("В массиве нет места");
        for (int i = this.count; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = item;
        this.count++;
        return array[index];
    }

    @Override
    public String set(int index, String item) {
        if(item==null)
            throw new NullPointerException("В массиве запрещено хранить null значения");
        if (index > this.count)
            throw new IndexOutOfBoundsException("Количество элементов в массиве меньше данного числа");
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int indexSearchElement = indexOf(item);
        if (indexSearchElement == -1)
            throw new RuntimeException("Такого элемента нет в списке");
        String removeElement = array[indexSearchElement];
        remove(count);
        return removeElement;
    }

    @Override
    public String remove(int index) {
        if (index > this.count)
            throw new IndexOutOfBoundsException("Количество элементов в массиве меньше данного числа");
        String returnElement = array[index];
        this.count--;
        for (int i = index; i < this.count; i++) {
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
        for (int i = 0; i < count; i++) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = this.count -1; i >= 0; i--) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > this.count)
            throw new IndexOutOfBoundsException("Количество элементов в массиве меньше данного числа");
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(otherList==null)
            throw new NullPointerException();
        if (otherList.size() != count)
            return false;
        for (int i = 0; i < count; i++) {
            if (!array[i].equals(otherList.get(i)))
                return false;
        }
        return true;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        array = new String[array.length];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, count);
    }
}
