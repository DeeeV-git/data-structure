package com.novozhilova.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

//Reflection:
//        Метод принимает класс и возвращает созданный объект этого класса
//        Метод принимает object и вызывает у него все методы без параметров
//        Метод принимает object и выводит на экран все сигнатуры методов в который есть final
//Метод принимает Class и выводит все не публичные методы этого класса
//        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
//        Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
public class Reflection {
    public Object getObject(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return clazz.getDeclaredConstructor().newInstance();
    }

    public void invokeAllMethodsWithoutParameters(Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method : object.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getParameterCount()==0){
                method.invoke(object);
            }
        }
    }

    public void printFinalMethod(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (Modifier.isFinal(method.getModifiers())) {
                System.out.println(method.getName());
            }

        }
    }

    public void printNonPublic(Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method.getName());
            }

        }
    }
//        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
    public void  printParentAndInterfaceClass(Class clazz){
        clazz.getSuperclass().getCanonicalName();
        for (Class anInterface : clazz.getInterfaces()) {
            System.out.println(anInterface.getCanonicalName());
        }
    }
    //        Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
    public void setDefaults(Object object) throws IllegalAccessException {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
                if(field.getType().equals(int.class)||field.getType().equals(long.class)||field.getType().equals(short.class)){
                    field.set(object,0);
                }else if(field.getType().equals(float.class)){
                    field.setFloat(object,0.0f);
                }else if(field.getType().equals(double.class)){
                    field.setDouble(object,0.0d);
                }else if(field.getType().equals(String.class)) {
                    field.set(object, null);
                }else if(field.getType().equals(boolean.class)){
                    field.setBoolean(object,false);
                }else if(field.getType().equals(byte.class)){
                    field.setByte(object,(byte) 0);
                } else if(field.getType().equals(char.class)){
                    field.setChar(object, (char) 0);
                }

            }
        }
    }

}

