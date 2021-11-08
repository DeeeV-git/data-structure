package com.novozhilova.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
    @Test
    public void testEnqueueAndDequeueAndChangeSizeAndClear(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        assertEquals(3,arrayQueue.size());
        assertEquals("A",arrayQueue.dequeue());
        assertEquals("B",arrayQueue.dequeue());
        assertEquals(1,arrayQueue.size());
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testEnqueueAndPeek(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        assertEquals("A",arrayQueue.peek());
        assertEquals("A",arrayQueue.dequeue());
        assertEquals("B",arrayQueue.peek());

    }
    @Test
    public void testIsEmptyReturnTrueOnNewQueue(){
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnQueueWithData(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testContainsReturnTrue(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        assertTrue(arrayQueue.contains("B"));
    }

    @Test
    public void testContainsReturnFalse(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        assertFalse(arrayQueue.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyQueue(){
        ArrayQueue arrayQueue = new ArrayQueue();
        assertFalse(arrayQueue.contains("A"));
    }

    @Test
    public void testThrowIllegalExeptionWhenDequeueOnEmptyQueue(){
        ArrayQueue arrayQueue=new ArrayQueue();
        Assertions.assertThrows(IllegalArgumentException.class,() ->{
            arrayQueue.dequeue();
        });
    }
    @Test
    public void testThrowIllegalExeptionWhenPeekOnEmptyQueue(){
        ArrayQueue arrayQueue=new ArrayQueue();
        Assertions.assertThrows(IllegalArgumentException.class,() ->{
            arrayQueue.peek();
        });
    }
}
