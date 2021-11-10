package com.novozhilova.datastructures.list;

import com.novozhilova.datastructures.queue.ArrayQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void testAddObjectAndSize(){
        ArrayList arrayList = new ArrayList();

        arrayList.add("A");
        arrayList.add("B");
        assertEquals("[A,B]",arrayList.toString());
        assertEquals(2,arrayList.size());
    }

    @Test
    public void testIndexOutOfBoundsExceptionWhenAddNull(){
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->{
            arrayList.add(null);
        });
    }

    @Test
    public void testAddByIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        arrayList.add("C",1);

        assertEquals(3,arrayList.size());
        assertEquals("[A,C,B]",arrayList.toString());
    }

    @Test
    public void testIndexOutOfBoundsExceptionWhenAddNullBeIndex(){
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->{
            arrayList.add(null);
        });
    }

    @Test
    public void testCorrectWorkAddObjectWhenSizeMoreLenghtArrayList(){
        ArrayList arrayList = new ArrayList();

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("B");

        assertEquals(6,arrayList.size());

    }

    @Test
    public void testRemoveObject(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals("B",arrayList.remove(1));
        assertEquals(2,arrayList.size());
        assertEquals("[A,C]",arrayList.toString());
    }

    @Test
    public void testIndexOutOfBoundsExceptionRemoveObjectsWhenIndexNotPresent(){
        ArrayList arrayList=new ArrayList();

        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->{
            arrayList.remove(0);
        });
    }

    @Test
    public void testGetObject(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals("B",arrayList.get(1));
        assertEquals(3,arrayList.size());
    }

    @Test
    public void testIndexOutOfBoundsExceptionGetObjectsWhenIndexNotPresent(){
        ArrayList arrayList=new ArrayList();

        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->{
            arrayList.get(1);
        });
    }

    @Test
    public void testSetObject(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        arrayList.set("D",1);

        assertEquals("[A,D,C]",arrayList.toString());
        assertEquals(3,arrayList.size());
    }

    @Test
    public void testIndexOutOfBoundsExceptionSetObjectsWhenIndexNotPresent(){
        ArrayList arrayList=new ArrayList();

        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->{
            arrayList.set("D",1);
        });
    }

    @Test
    public void testIsEmptyReturnTrueOnNewArrayList(){
        ArrayList arrayList=new ArrayList();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnArrayListWithData(){
        ArrayList arrayList=new ArrayList();
        arrayList.add("A");
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnArrayListAfterClear(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertTrue(arrayList.contains("B"));
    }

    @Test
    public void testContainsReturnFalse(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertFalse(arrayList.contains("C"));
    }

    @Test
    public void testIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(1,arrayList.indexOf("B"));
    }

    @Test
    public void testIndexOfObjectNotPresent() {
        ArrayList arrayList = new ArrayList();

        assertEquals(-1,arrayList.indexOf("B"));
    }

    @Test
    public void testLastIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");

        assertEquals(2,arrayList.lastIndexOf("A"));
    }

    @Test
    public void testLastIndexOfObjectNotPresent() {
        ArrayList arrayList = new ArrayList();

        assertEquals(-1,arrayList.lastIndexOf("B"));
    }

    @Test
    public void testToString() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertEquals("[A,B]",arrayList.toString());
    }
}
