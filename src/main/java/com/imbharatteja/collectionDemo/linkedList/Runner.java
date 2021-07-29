package com.imbharatteja.collectionDemo.linkedList;

public class Runner {
    public static void main(String[] args) {

        LinkedList ls = new LinkedList();
        ls.insert(5);
        ls.insert(10);
        ls.insert(15);
        ls.insert(20);
        ls.insert(25);

        ls.insertAtStart(1);

        ls.insertAt(2, 555);
        ls.insertAt(7, 5555);

        ls.delete(5555);

        ls.show();
    }
}
