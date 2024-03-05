/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;


/**
 *
 * @author Fatimah
 */

public class ArrayStack <E> {
     public static final int CAPACITY = 10;   // default array capacity

  private int top = -1;
 
  /** Generic array used for storage of stack elements. */
  private E[] array;             // array used for storage
  private int t = -1;                      // index of the top element in stack

  /** Constructs an empty stack using the default array capacity. */
  public ArrayStack() { 
     array = (E[]) new Object [CAPACITY];  
  }  
  
  /**
   * Constructs an empty stack with the given array capacity.
   * @param capacity length of the underlying array
   */
 
  public ArrayStack(int capacity) {        // constructs stack with given capacity
    array = (E[]) new Object [capacity];    
  }

  
  
  public int size(){
      return top + 1;
  }
    
  public boolean isEmpty(){
      return size() == 0;
  }
    public E pop(){
        if (isEmpty())
            return null;
            
       E temp = array[top]; //creates a temp var to store the topmost element of the array
       //facilitate garbage collection
       array[top] = null;
       top--;
       return temp; 
    }
    
    public void push(E e){
        if (size() == array.length)
            throw new IllegalStateException("Stack is full");
        
        top++;
        array[top] = e;
        
    }
    
    public E top(){
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        return array[top];
    }
    
    
        public E[] toArray() {
        E[] result = (E[]) new Object[CAPACITY]; // create a new array with the same size as the stack
        System.arraycopy(array, 0, result, 0, size()); // copy the elements of the stack to the new array
        return result;
    }
        
    
    
  /**
   * Produces a string representation of the contents of the stack.
   * (ordered from top to bottom). This exists for debugging purposes only.
   *
   * @return textual representation of the stack
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (int j = 0; j <= top; j++) {
      sb.append(array[j]);
      if (j < top)
          sb.append(", ");
    }
    sb.append("]");
    return sb.toString();
  }
    
}
