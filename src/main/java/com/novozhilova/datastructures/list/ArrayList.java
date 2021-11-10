package com.novozhilova.datastructures.list;

public class ArrayList implements List{
    private Object[] array;
    private int size;

    ArrayList(){
        array=new Object[5];
    }

    private void ensureCapacity(){
        Object[] newArray= new Object[(int) (array.length*1.5)];
        for (int i = 0; i < array.length; i++) {
            newArray[i]=array[i];
        }
        array=newArray;
    }

    @Override
    public void add(Object value) {
        if(value==null){
            throw new IndexOutOfBoundsException();
        }
        if(size==array.length){
            ensureCapacity();
        }
        array[size]=value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if(value==null){
            throw new IndexOutOfBoundsException();
        }
        int count=0;
        Object[] newArray=new Object[array.length];
        if(size==array.length){
            ensureCapacity();
        }
        for (int i = 0; i < size+1; i++) {
            if(i!=index){
                newArray[count]=array[i];
                count++;
            }
            else {
                count++;
                newArray[count]=array[i];
                count++;
            }
        }
        newArray[index]=value;
        array=newArray;
        size++;
    }

    @Override
    public Object remove(int index) {//[1,2,null,4]
        if (index<0||index>=size||isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int count=0;
        Object temp=array[index];
        array[index]=null;
        for (int i = 0; i < array.length; i++) {
            if(array[i]!=null){
                array[count]=array[i];
                count++;
            }
            if (i==size-1){
                array[i]=null;
            }
        }
        size--;
        return temp;
    }

    @Override
    public Object get(int index) {
        if (index<0||index>=size||isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (index<0||index>=size||isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        Object temp = array[index];
        array[index]=value;
        return temp;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i]=null;
        }
        size=0;
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
        for (int i = 0; i < size; i++) {
            if(value.equals(array[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if(value.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size; i >0; i--) {
            if(value.equals(array[i])){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if(i==size-1){
                result.append(array[i]);
            }
            else {
                result.append(array[i] + ",");
            }
        }

        return "[" + result + "]";
    }
}
