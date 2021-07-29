package com.imbharatteja.collectionDemo.generics;

class GenericClass<T extends Number> {

    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void show(){
        System.out.println(value.getClass().getName());
    }

    /*public void demo(){
        System.out.println(ArrayList);
    }*/

}


public class GenericDemoClass {
    public static void main(String args[]) throws Exception{

        GenericClass<Integer> value =  new GenericClass<>();
        value.value=9;
        value.show();
    }
}
