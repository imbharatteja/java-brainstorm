package com.imbharatteja.collectionDemo.linkedList;

public class LinkedList {
    Node head;

    public void insert(int data){
        Node node = new Node();
        node.data = data;

        if(head == null){
            head = node;
        } else {
            Node n = head;
            while(n.next!=null){
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAtStart(int data){
        Node node = new Node();
        node.data = data;
        node.next = head;

        head = node;
    }

    public void insertAt(int index, int data){
        Node node = new Node();
        node.data = data;

        Node n = head;

        if(index==0){
            insertAtStart(data);
        } else {
            for(int i=0; i<index-1; i++){
                n = n.next;
            }
            node.next=n.next;
            n.next=node;
        }
    }

    public void delete(int data){
        Node previousNode = null;

        Node n = head;
        boolean deleted = false;
        if(head.data==data){
            head=head.next;
            deleted = true;
        } else{
            while(n.next!=null){

                if(n.data == data){
                    deleted = true;
                    previousNode.next = n.next;
                    n.next=null;
                    break;
                }
                previousNode = n;
                n = n.next;
            }
            if(n.next==null && deleted==false) {
                previousNode.next=null;
            }
        }

    }

    public void show() {
        Node node = head;
        while(node.next!= null){
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
}
