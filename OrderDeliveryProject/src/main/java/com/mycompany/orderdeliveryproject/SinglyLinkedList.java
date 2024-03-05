/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;
/**
 *
 * @author manaralmashi
 */

import java.text.ParseException;

public class SinglyLinkedList<E> {

    //Represent a node of the singly linked list    
    class Node<E> {

        private E element;
        private Store store;
        private double data;
        private Node<E> next;
        public Node<E> prev;

        public Store getStore() {
            return store;
        }

        public void setStore(Store store) {
            this.store = store;
        }

        public Node() {
        }

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element, int data, Node<E> next) {
            this.element = element;
            this.data = data;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public double getData() {
            return data;
        }

        public void setData(double data) {
            this.data = data;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

    }

    //Represent the head and tail of the singly linked list    
    public Node<E> head = null;
    public Node<E> tail = null;
    private int size = 0;
    private int count = 1;

    public SinglyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addNode(double data) {
        //Create a new node  
        Node newNode = new Node(data);

        //If list is empty  
        if (head == null) {
            //Both head and tail will point to newNode  
            head = tail = newNode;
            //head's previous will point to null  
            head.prev = null;
            //tail's next will point to null, as it is the last node of the list  
            tail.next = null;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode  
            tail.next = newNode;
            //newNode's previous will point to tail  
            newNode.prev = tail;
            //newNode will become new tail  
            tail = newNode;
            //As it is last node, tail's next will point to null  
            tail.next = null;
        }
    }

    public void addNode(E e) {
        //Create a new node  
        Node newNode = new Node(e);

        //If list is empty  
        if (head == null) {
            //Both head and tail will point to newNode  
            head = tail = newNode;
            //head's previous will point to null  
            head.prev = null;
            //tail's next will point to null, as it is the last node of the list  
            tail.next = null;

            size++;
            head.setStore((Store) e);
        } else {
            //newNode will be added after tail such that tail's next will point to newNode  
            tail.next = newNode;
            //newNode's previous will point to tail  
            newNode.prev = tail;
            //newNode will become new tail  
            tail = newNode;
            //As it is last node, tail's next will point to null  
            tail.next = null;

            size++;
            head.setStore((Store) e);
        }
    }

    public void addFirst(E e) {
        //Create a new node    
        head = new Node<>(e, head);

        //Checks if the list is empty    
        if (size == 0) {
            tail = head;
            size++;
        }
        head.setStore((Store) e);
    }

    public void addLast(E e) {
        //Create a new node    
        Node<E> newest = new Node<>(e);

        if (head == null) {
            head = newest;
            size++;
            head.setStore((Store) e);
        } else {
            if (tail == null) {
                tail = newest;
                head.setNext(tail);
            } else {
                tail.setNext(newest);
                tail = newest;
            }
            size++;
            tail.setStore((Store) e);
        }

    }

    public void sortList() {

        // Node current will point to head
        Node current = head, index = null;

        double temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    //display() will display all the nodes present in the list    
    public void display() {
        //Node current will point to head    
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
//        System.out.println("Nodes of singly linked list: ");
        while (current != null) {

            System.out.println("                    [ " + count + " ]");
            //Prints each node by incrementing pointer    
            System.out.print(current.getStore().presentStore());
            current = current.next;
            System.out.println(" ");
            count++;
        }

    }

} //----------- end of SinglyLinkedList class -----------
