package com.novozhilova.datastructures.list;

public class Node {
    Node prev;
    Node next;
    Object value;

    public Node(Object value){
        this.value=value;
    }
}
