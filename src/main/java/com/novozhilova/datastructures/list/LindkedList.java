package com.novozhilova.datastructures.list;
import java.util.StringJoiner;

public class LindkedList implements List{
    Node head;
    Node tail;
    int size;

    @Override
    public void add(Object value) {
        add(value,size);
    }

    @Override
    public void add(Object value, int index) {
        if(value==null){
            throw new IndexOutOfBoundsException("Значення яке ви хочете помістити в ліст не має бути null.");
        }
        if (index<0||index>size){
            throw new IndexOutOfBoundsException("Індекс виходить по за границі Ліста");
        }
        Node newNode= new Node(value);
        if (isEmpty()){
            head=tail=newNode;
        }else if(index==size){
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
        Node current=head;
        if (index<0||index>=size||isEmpty()){
            throw new IndexOutOfBoundsException("Індекс виходить по за границі Ліста");
        }
        if (index==0){
            head = head. next;
            head.prev = null;

        }else if(index==size-1){
            current=tail;
            tail = tail.prev;
            tail.next = null;

        }else{
        int count=0;
        while (current.next!=null){
            if(count==index){
                Node nextNode = current.next;
                Node prevNode = current.prev;
                nextNode.prev = prevNode;
                prevNode.next=nextNode;
                break;
            }
            current=current.next;
            count++;
        }
        }
        size--;
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
        if(value==null){
            throw new IndexOutOfBoundsException("Значення яке ви хочете помістити в ліст не має бути null.");
        }
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
        return indexOf(value)!=-1;
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
