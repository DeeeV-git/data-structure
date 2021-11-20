package com.novozhilova.datastructures.list;


import java.sql.PreparedStatement;
import java.util.StringJoiner;

public class LindkedList implements List{
    Node head;
    Node tail;
    int size;

    @Override
    public void add(Object value) {
        if(value==null){
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if(value==null){
            throw new IndexOutOfBoundsException();
        }
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("Індекс виходить по за границі Ліста");
        }
        Node newNode= new Node(value);
        if (isEmpty()){
            head=tail=newNode;
        }else if(index==size-1){
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }else if(index==0){
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }else{
            Node current=head;
            for (int i = 0; i < size; i++) {
                if(i==index){
                    Node prevNode = current.prev;
                    prevNode.next=newNode;
                    current.prev=newNode;
                    newNode.prev=prevNode;
                    newNode.next=current;
                    break;
                }
                current=current.next;
            }
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index<0||index>=size||isEmpty()){
            throw new IndexOutOfBoundsException("Індекс виходить по за границі Ліста");
        }

        Node current=head;
        int count=0;
        while (current.next!=null){
            if(count==index){
                Node nextNode = current.next;
                Node prevNode = current.prev;
                nextNode.prev = prevNode;
                prevNode.next=nextNode;
                size--;
                break;

            }
            current=current.next;
            count++;
        }

        return current.value;
    }

    @Override
    public Object get(int index) {
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("Індекс виходить по за границі Ліста");
        }
        Node current=head;
        int count=0;
        while (current.next!=null) {
            if (count == index) {
                break;
            }
            current=current.next;
            count++;
        }
        return current.value;
    }

    @Override
    public Object set(Object value, int index) {
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("Індекс виходить по за границі Ліста");
        }
        Node newNode = new Node(value);
        Node current=head;
        int count=0;
        while (current.next!=null) {
            if (count == index) {
                Node nextNode = current.next;
                Node prevNode = current.prev;
                newNode.next=nextNode;
                newNode.prev=prevNode;
                nextNode.prev=newNode;
                prevNode.next=newNode;
                return current;
            }
            current=current.next;
            count++;
        }
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        head=tail=null;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object value) {
        Node current=head;
        while (current.next!=null) {
            if (current.value.equals(value)) {
                return true;
            }
            current=current.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if(isEmpty()){
            return -1;
        }
        Node current=head;
        int count=0;
        while (current.next!=null) {
            if (current.value.equals(value)) {
                return count;
            }
            current=current.next;
            count++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if(isEmpty()){
            return -1;
        }
        Node current = tail;
        for (int i = size-1; i>=0 ; i--) {
            if (current.value.equals(value)) {
                return i;
            }
            current=current.prev;
        }
        return -1;
    }
    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(",","[","]") ;
        Node current = head;
        for (int i = 0; i < size; i++) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }
        return   stringJoiner.toString();
    }
}
