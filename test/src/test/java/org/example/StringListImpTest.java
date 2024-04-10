package org.example;

import org.example.listString.StringListImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImpTest {
    private StringListImp list;

    @BeforeEach
    public void setup(){
        list= new StringListImp(2);
        list.add("new data one");
    }

    @Test
    void add() {
        assertEquals(list.add("new data two"), "new data two");
    }


    @Test
    void addElementInPosition() {
        assertEquals(list.add(0,"new data two"), "new data two");
    }
    @Test
    void addMissingElementInPositionException() {
        list.add("new data two");
        assertThrows(IndexOutOfBoundsException.class,()->list.add(3, "new"));
    }

    @Test
    void addNotSpaceInArrayException() {
        list.add("new data two");
        assertThrows(RuntimeException.class,()->list.add(0, "new"));
    }

    @Test
    void set() {
        assertEquals(list.set(0,"new data two"), "new data two");
    }

    @Test
    void remove() {
        assertEquals(list.remove("new data one"), "new data one");
    }

    @Test
    void removeByIndex() {
        assertEquals(list.remove(0), "new data one");
    }

    @Test
    void contains() {
        assertEquals(list.contains("new data one"), true);
    }

    @Test
    void indexOf() {
        assertEquals(list.indexOf("new data one"), 0);
    }

    @Test
    void lastIndexOf() {
        assertEquals(list.lastIndexOf("new data one"), 0);
    }

    @Test
    void get() {
        assertEquals(list.get(0), "new data one");
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
        assertEquals(list.size(),1);
    }

    @Test
    void isEmpty() {
        assertEquals(list.isEmpty(),false);
    }

}