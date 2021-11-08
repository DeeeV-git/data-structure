package com.novozhilova.datastructures.queue;

public interface Queue {
    void enqueue(Object value);

    Object dequeue();

    Object peek();

    boolean contains(Object value);

    boolean isEmpty();

    int size();

    void clear();

    String toString();
}
