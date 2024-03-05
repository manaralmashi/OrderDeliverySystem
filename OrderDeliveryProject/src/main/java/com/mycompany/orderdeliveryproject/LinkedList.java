/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;


/**
 *
 * Lamis Mohammed
 */
public class LinkedList<E>{
    /**
   * Node of a doubly linked list, which stores a reference to its
   * element and to both the previous and next node in the list.
   */
 private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    
    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param p  reference to a node that should precede the new node
     * @param n  reference to a node that should follow the new node
     */
    public Node(){
        
    }
    public Node(E e, Node<E> p, Node<E> n) {
      item = e;
      prev = p;
      next = n;
    }

    // public accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return item; }

    /**
     * Returns the node that precedes this one (or null if no such node).
     * @return the preceding node
     */
    public Node<E> getPrev() { return prev; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Update methods
    /**
     * Sets the node's previous reference to point to Node n.
     * @param p    the node that should precede this one
     */
    public void setPrev(Node<E> p) { prev = p; }

    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------

// instance variables of the DoublyLinkedList
  /** Sentinel node at the beginning of the list */
  private LinkedList.Node<E> header;                    // header sentinel

  /** Sentinel node at the end of the list */
  private LinkedList.Node<E> trailer;                   // trailer sentinel

  /** Number of elements in the list (not including sentinels) */
  private int size = 0;                      // number of elements in the list

  /** Constructs a new empty list. */
  public LinkedList() {
  }

    /**
     *
     * @return
     */
    public int getSize() { // return the size of the list
        return size;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty(){ // to check if the list is empty or not
        if (header == null)
            return true;
        return false;
    }
   
    /**
     *
     * @param e
     * @return
     */
    public boolean Search(E e){  // to search for whether a specific element is present in the list or not
        if(!isEmpty()){
          if(indexOf(e)==-1) 
              return false;
          else 
              return true;
        }
        return false;
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOf(Object o) { // Returns the index in which the element is stored, If it does not find the element, will return -1
        int index = 0;
        if (o == null) {
            for (Node<E> x = header; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = header; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    /**
     *
     * @return
     */
    public E getHeader() { // get the first element in the list
        return header.getElement();
    }
  /** Add method, take an element to add it in the list. */
  public void Add(E e){
      final Node<E> F = header;
      final Node<E> NewNode = new Node<>(null,e,F);
      header = NewNode;
      if(F==null)
          trailer = NewNode;
      else
          F.prev= NewNode;
      size++;
  }
  
    /**
     *
     * @param e
     */
    public void AddLast(E e){
        final Node<E> last = trailer;
        final Node<E> newNode = new Node<>(last, e, null);
        trailer = newNode;
        if (last == null)
            header = newNode;
        else
            last.next = newNode;
        size++;
  }

    /**
     *
     * @return
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = header.getElement();
        header = header.getNext();
        size--;
        if (size == 0) {
            trailer = null; // special case as list is now empty 
        }
        return answer;
    }
    
    E unlink(Node<E> x) { // remove a non-null node
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            header = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            trailer = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = header; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = header; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     */
    public void clear(){
         for (Node<E> x = header; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        header = trailer = null;
        size = 0;
    }
   // ---------------------------------------------------------------------------------- 

    /**
     *
     * @param index
     * @return
     */
 public E get(int index){
      checkIndex(index);
      return node(index).item;
  }
  private void checkIndex(int index){
    if(!isElementIndex(index))  
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
  }
   private String outOfBoundsMsg(int index) {
        throw new UnsupportedOperationException("This index does not Exist"); 
    }
  private boolean isElementIndex(int index) {
        return index >= 0 && index <= size;
    }
   Node<E> node (int index){
      if(index < (size>>1)){
          Node<E> e = header;
          for(int i= 0;i<index;i++)
              e=e.next;
          
          return e;
      }
      else{
          Node<E> e = trailer;
          for(int i=size -1;i>index;i--)
              e=e.prev;
          return e;
      }
  }
    
}
