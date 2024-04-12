package org.example;

import org.example.exception.NullDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImpTest {
    IntegerListImp out = new IntegerListImp(2);

    @BeforeEach
    public void setup() {
        out.add(1);
        out.add(2);
    }

    @Test
    void addExceptionNull() {
        assertThrows(NullDataException.class
                , () -> out.add(null));
    }

    @Test
    void add() {
        assertEquals(out.add(3), 3);
    }

    @Test
    void testElementInPosition() {
        assertEquals(out.add(0, 4), 4);
    }

    @Test
    void set() {
        assertEquals(out.set(0, 4), 4);
    }

    @Test
    void setExceptionNull() {
        assertThrows(NullDataException.class
                , () -> out.set(0, null));
    }

    @Test
    void setExceptionOfIndex() {
        assertThrows(IndexOutOfBoundsException.class
                , () -> out.set(10, 1));
    }

    @Test
    void size() {
        assertEquals(out.size(), 2);
    }

    @Test
    void removeToIndexElement() {
        assertEquals(out.remove(0), 1);
        assertEquals(out.size(), 1);
    }

    @Test
    void removeToElement() {
        assertEquals(out.remove(new Integer(1)), 2);
        assertEquals(out.size(), 1);
    }

    @Test
    void contains() {
        assertEquals(out.contains(1), true);
    }

    @Test
    void indexOf() {
        assertEquals(out.indexOf(1), 1);
    }

    @Test
    void lastIndexOf() {
        assertEquals(out.lastIndexOf(1), 1);
    }

    @Test
    void get() {
        assertEquals(out.get(1), 2);
    }

    @Test
    void testEquals() {
        IntegerList list = new IntegerListImp(10);
        list.add(1);
        list.add(2);
        assertEquals(out.equals(list), true);
    }


    @Test
    void isEmpty() {
        assertEquals(out.isEmpty(),false);
    }

    @Test
    void clear() {
        out.clear();
        assertEquals(out.size(), 0);
    }

    @Test
    void toArray() {
        assertArrayEquals(out.toArray(), new Integer[]{1,2});
    }
}