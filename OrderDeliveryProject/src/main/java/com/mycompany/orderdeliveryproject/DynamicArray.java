/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;

/**
 *
 * @author Murooj
 */
public class DynamicArray {
//-------data feild----------
 /**
 *
 * @Deprecated Stores a non-fixed-size array
 */
    private String Array[];
  /**
 *
 * @Deprecated Stores the length of the array
 */
    private int count;
 
//-------constructors----------
    public DynamicArray(int size) {
        Array = new String[size]; }
 
 //--------- methods-----------
    /**
     * Creates Method to print the non-fixed size array
     */
    public  void printArray()
    {
     for (int i = 0; i < count; i++) {

            System.out.print("       "+Array[i] + "              ");
         ;}
        System.out.println("");
    }

    /**
     * Creates a Method to print the two non-fixed size arrays
     *
     * @param a The first  non-fixed-size array
     * @param b The second  non-fixed-size array
   
     */
    public void printArray2(DynamicArray a ,DynamicArray b) {

      for (int i = 0; i < a.count; i++) {
                   
       System.out.print((i+1)+"]"+a.Array[i] + "  | " +"Rating : "+b.Array[i]+"/5");
         System.out.println();             
      }   
            }  
    
    
     public  void printArray3(String a)
    {
        for (int i = 0; i < count; i++) {
            if (a == "AGE") {
                System.out.print(a + ":" + Array[i] + "                                        ");
            } else if (a == "EMAIL") {
                System.out.print(a + ":" + Array[i] + "               ");
            } else if (a == "RATING") {
                System.out.print(a + ":" + Array[i] + "                                   ");
            } else {
                System.out.print(a + ":" + Array[i] + "                      ");
            }
        }
        System.out.println("");
    }   
    
    
    
    
              
 /**
     * Creates a Method To add new elements to the array
     *
     * @param element new elements

     */
    
    public void insert(String element)
    {
 
        if (Array.length == count) {

            String newArr[] = new String[2 * count];

            for (int i = 0; i < count; i++) {
                newArr[i] = Array[i];
            }

            Array = newArr;
        }
 
        Array[count++] = element;
    }

    /**
     * Creates Method to return the length of the array
     * @return the length of the array
     */
    public int getCount() {
        return count;
    }

   
    
       
}
