package com.novozhilova.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

interface Data{
    public void printName();

}

class Human{
    private int age=32;
    public void printAge(){
        System.out.println("Age" + age);
    }
}

class Person extends Human implements Data  {
    private String name="Roma";
    private int age = 37;
    private boolean isWorking = true;
    private void rename(String name){
        this.name=name;
    }
    private void nonWork(){
        System.out.println("No Work");
        isWorking=false;
    }
    @Override
    public void printName() {
        System.out.println(name);
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public boolean isWorking() {
        return isWorking;
    }
}



public class ReflectionTest {
    Reflection reflection = new Reflection();
    Person person = new Person();

    @Test
    public void testGetObject() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        assertEquals(person.getClass(), reflection.getObject(Person.class).getClass());
        assertTrue(reflection.getObject(Person.class)!=null);
    }

    @Test
    public void testSetDefaults() throws IllegalAccessException {
        reflection.setDefaults(person);
        assertEquals(null,person.getName());
        assertEquals(0,person.getAge());
        assertFalse(person.isWorking());
    }

}
class Testing{
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Reflection reflection=new Reflection();
        Person person=new Person();
        reflection.printFinalMethod(person);
        reflection.printNonPublic(person);
        reflection.printParentAndInterfaceClass(Person.class);
        reflection.invokeAllMethodsWithoutParameters(person);
    }
}
