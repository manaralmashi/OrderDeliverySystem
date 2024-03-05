/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;

/**
 *
 * @author Murooj
 */
import java.util.Arrays;

public class ListOfInformation {

    //-------data feild----------
    /**
     *
     * @Deprecated header sentinel
     */
    private Node header;                         // header sentinel
    private Node trailer;                        // trailer sentinel
    private int size = 0;                       // number of node in the list  
    private double Rating;
    private int sizeOfarry;
    private double AveragRating;

    public void setAveragRating(double AveragRating) {
        this.AveragRating = AveragRating;
    }
    //-------constructor----------

    public ListOfInformation() {
        header = new Node(null, null, null);      // create header
        trailer = new Node(null, header, null);   // trailer is preceded by header
        header.setNext(trailer);                  // header is followed by trailer

    }

//---------------- nested Node class ----------------
    private static class Node<E> {

        private Node<E> head;  //reference to the previous node in the list
        private Node<E> next;  // reference to the subsequent node in the list
        private String[] data; // reference to the data stored at this node
        //-------constructor----------

        public Node(String[] data, Node<E> head, Node<E> next) {
            this.data = data;
            this.next = next;
            this.head = head;
        }
        //-------setters methods----------

        public void setData(String[] data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;

        }

        public void setHead(Node head) {
            this.head = head;
        }

        //-------Getters methods----------
        public String[] getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public Node getHead() {
            return head;
        }

    }//end of nested Node class

    //-------method ----------
    //1:
    /**
     * Adds Add a new driver to the first of the list.
     *
     * @param e the new driver to add
     */
    public void addFirst(ListOfInformation PersonalInformation, String[] DriverInformation) {

        Node newNode = new Node(DriverInformation, header, header.getNext());
        header.getNext().setHead(newNode);
        header.setNext(newNode);
        size++;
    }

    //2:
    /**
     * Adds Add a new driver to the end of the list.
     *
     * @param e the new driver to add
     */
    public void addLast(ListOfInformation PersonalInformation, String[] DriverInformation) {

        Node newNode = new Node(DriverInformation, trailer.getHead(), trailer);
        trailer.getHead().setNext(newNode);
        trailer.setHead(newNode);
        size++;
    }

    //3:
    /**
     * Creates a Method to change the status of the Driver according to the work
     * area.
     *
     * @param DistrictName The name of the neighborhood in which the user is
     * located
     *
     */
    public void DriverStatus(ListOfInformation PersonalInformation, String DistrictName) {
        Node pointer = header.getNext();

        while (pointer != trailer) {

            if (pointer.data[6] != DistrictName) {

                pointer.data[5] = "Unavailable";

            } else if (pointer.data[6] == DistrictName) {

                pointer.data[5] = "Available";
            }
            pointer = pointer.getNext();

        }

    }

    //4:
    /**
     * Creates a Method to search within the list of drivers information.
     *
     * @param text The text of the information to be searched for
     * @param i_Searched Index of the information to be searched for
     * @param i_display Index of the information to displayed
     * @return the Search result (or null if there is no result)
     */
    public DynamicArray search(ListOfInformation PersonalInformation, String text, int i_Searched, int i_display) {
        Node pointer = header.getNext();
        DynamicArray result = new DynamicArray(1);
        int i = 0;

        while (pointer != trailer) {
            if (pointer.data[i_Searched] == text) {

                result.insert(pointer.data[i_display]);

            }
            pointer = pointer.getNext();
        }

        sizeOfarry = result.getCount();
        return result;

    }

    //5:
    /**
     * Creates a Method to Sort linked list according to the best delegate
     * rating
     */
    public void sortList() {

        // Node current will point to head
        Node current = header.getNext();
        Node index = null;

        String[] temp;

        if (header.getNext() == null) {
            return;
        } else {
            while (current != trailer) {
                // Node index will point to node next to
                // current
                index = current.getNext();
                while (index != trailer) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.data[7].compareTo(index.data[7]) < 0) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }

    }

    public void AverageRating_Calculator(double Averag, int usernumber, double Rating) {

        setAveragRating((Averag * (usernumber - 1) + Rating) / usernumber);
        Node pointer = header.getNext();

        while (pointer != trailer) {

            if (pointer.data[5] == "Available" && pointer.data[7].compareTo(Averag + "") == 0) {
                pointer.data[7] = getAveragRating() + "";

            }
            pointer = pointer.getNext();
        }

    }
   
    public double getAveragRating() {
        return AveragRating;
    }

    public int getSizeOfarry() {
        return sizeOfarry;
    }

}
