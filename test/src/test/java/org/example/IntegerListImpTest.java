package org.example;

import org.example.exception.NullDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImpTest {
    IntegerListImp out = new IntegerListImp(2);
    @BeforeEach
    public void setup(){
        out.add(1);
        out.add(2);
    }

    @Test
    void addExceptionNull() {
        assertThrows(NullDataException.class
                , ()->out.add(null));
    }

    @Test
    void add() {
       assertEquals(out.add(3), 3);
    }

    @Test
    void testElementInPosition() {
        assertEquals(out.add(0,4), 4);
    }

    @Test
    void set() {
        assertEquals(out.set(0,4), 4);
    }

    @Test
    void setExceptionNull() {
        assertThrows(NullDataException.class
                ,()->out.set(0, null) );
    }

    @Test
    void setExceptionOfIndex() {
        assertThrows(IndexOutOfBoundsException.class
                ,()->out.set(10, 1) );
    }
    @Test
    void size() {
        assertEquals(out.size(), 2);
    }

    @Test
    void removeToIndex() {
        assertEquals(out.remove(0), 1);
        assertEquals(out.size(), 1);
    }

    @Test
    void removeToElement() {

    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void testEquals() {
    }


    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }
}