package com.novozhilova.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    LindkedList lindkedList;
    @BeforeEach
    public void newLinkedList(){
        lindkedList = new LindkedList();
    }

    @Test
    public void testAddObjectAndSize(){
        lindkedList.add("A");
        lindkedList.add("B");
        assertEquals("[A,B]",lindkedList.toString());
        assertEquals(2,lindkedList.size());
    }

    @Test
    public void testIndexOutOfBoundsExceptionWhenAddNull(){
        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->{
            lindkedList.add(null);
        });
    }

    @Test
    public void testAddByIndex() {
        lindkedList.add("A");
        lindkedList.add("B");

        lindkedList.add("C",1);

        assertEquals(3,lindkedList.size());
        //assertEquals("[A,C,B]",lindkedList.toString());
    }

    @Test
    public void testIndexOutOfBoundsExceptionWhenAddNullBeIndex(){;
        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->{
            lindkedList.add(null);
        });
    }

    @Test
    public void testCorrectWorkAddObjectWhenSizeMoreLenghtArrayList(){
        lindkedList.add("A");
        lindkedList.add("B");
        lindkedList.add("A");
        lindkedList.add("B");
        lindkedList.add("A");
        lindkedList.add("B");

        assertEquals(6,lindkedList.size());

    }

    @Test
    public void testRemoveObject(){
        lindkedList.add("A");
        lindkedList.add("B");
        lindkedList.add("C");

        assertEquals("B",lindkedList.remove(1));
        assertEquals(2,lindkedList.size());
        assertEquals("[A,C]",lindkedList.toString());
    }

    @Test
    public void testIndexOutOfBoundsExceptionRemoveObjectsWhenIndexNotPresent(){

        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->{
            lindkedList.remove(0);
        });
    }

    @Test
    public void testGetObject(){
        lindkedList.add("A");
        lindkedList.add("B");
        lindkedList.add("C");

        assertEquals("B",lindkedList.get(1));
        assertEquals(3,lindkedList.size());
    }

    @Test
    public void testIndexOutOfBoundsExceptionGetObjectsWhenIndexNotPresent(){

        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->{
            lindkedList.get(1);
        });
    }

    @Test
    public void testSetObject(){
        lindkedList.add("A");
        lindkedList.add("B");
        lindkedList.add("C");

        lindkedList.set("D",1);

        assertEquals("[A,D,C]",lindkedList.toString());
        assertEquals(3,lindkedList.size());
    }

    @Test
    public void testIndexOutOfBoundsExceptionSetObjectsWhenIndexNotPresent(){
        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->{
            lindkedList.set("D",1);
        });
    }

    @Test
    public void testIsEmptyReturnTrueOnNewArrayList(){
        assertTrue(lindkedList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnArrayListAfterClear(){
        lindkedList.add("A");
        lindkedList.add("B");

        lindkedList.clear();
        assertTrue(lindkedList.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        lindkedList.add("A");
        lindkedList.add("B");
        lindkedList.add("C");

        assertTrue(lindkedList.contains("B"));
    }

    @Test
    public void testContainsReturnFalse(){
        lindkedList.add("A");
        lindkedList.add("B");
        assertFalse(lindkedList.contains("C"));
    }

    @Test
    public void testIndexOf() {
        lindkedList.add("A");
        lindkedList.add("B");
        lindkedList.add("C");

        assertEquals(1,lindkedList.indexOf("B"));
    }

    @Test
    public void testIndexOfObjectNotPresent() {
        assertEquals(-1,lindkedList.indexOf("B"));
    }

    @Test
    public void testLastIndexOf() {
        lindkedList.add("A");
        lindkedList.add("B");
        lindkedList.add("A");
        lindkedList.add("C");

        assertEquals(2,lindkedList.lastIndexOf("A"));
    }

    @Test
    public void testLastIndexOfObjectNotPresent() {

        assertEquals(-1,lindkedList.lastIndexOf("B"));
    }

    @Test
    public void testToString() {
        lindkedList.add("A");
        lindkedList.add("B");

        assertEquals("[A,B]",lindkedList.toString());
    }
}

