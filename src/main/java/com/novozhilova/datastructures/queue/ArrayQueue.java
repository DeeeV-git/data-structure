package com.novozhilova.datastructures.queue;

public class ArrayQueue implements Queue {
    private int size;
    private Object[] array;

    public ArrayQueue(){
        array=new Object[10];
    }

    @Override
    public void enqueue(Object value) {
        array[size]=value;
        size++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty!");
        }
        Object result = array[0];
        for (int i = 0; i < size; i++) {
            array[i]=array[i+1];
        }
        size--;
        return result;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty!");
        }
        return array[0];
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if(value.equals(array[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size=0;
    }
}
