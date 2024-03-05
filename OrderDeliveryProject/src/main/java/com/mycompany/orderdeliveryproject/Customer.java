/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;

import java.util.LinkedList;
import java.util.ArrayList;


/**
 *
 * @author Fatimah
 */

public class Customer extends ArrayStack {
    
    /**
     *  ------- Attributes --------
     * 
     */
    
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String paymentMethod;
    private String creditCardNo;
    private int wallet;
    private String district;
    private String[] preferences = new String[5]; 
    private static int numOfOrders;
    private OrderService order;
    private static ArrayStack orderHistory = new ArrayStack();
 
    /**
     * Constructors: 
     * 
     */ 
    
    public Customer(){}
    
    public Customer(String f, String l, String phone, String district, String paymentMethod){
        this.firstName = f;
        this.lastName = l;
        this.phoneNo = phone;
        this.district = district;
        this.paymentMethod = paymentMethod;
    }
    
    
     // --------- Setters & Getters ----------

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDistrict() {
        return district;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
    
    
    public void setDistrict(String district) {
        this.district = district;
    }

    public String[] getPreferences() {
        return preferences;
    }

    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public static int getNumOfOrders() {
        return numOfOrders;
    }

    public static void setNumOfOrders(int numOfOrders) {
        Customer.numOfOrders = numOfOrders;
    }

     
     // --------- Other Methods ---------
  
/**
 * this method allows the customer to have his favorite stores stored in a list
 * @param preference 
 */
    public void addPreference(String preference) {
        int i = 0;
        
        if (i < preferences.length)
        preferences[i] = preference;
        
        
        i++;
        
        }
    
    
     /** 
     * this method pushes the order's invoice into the stack
     * @param cart 
     */
    public void pushOrder(invoice invoice){
        orderHistory.push(invoice);  
        numOfOrders++; 
      
    }  
    
    
    /**
     * this method allows the user to view his orders history via orders' invoices
     * 
     */
    
    public void getOrdersHistory(){
        if (numOfOrders >= 1){
          System.out.println("Order History: "); 
          System.out.println (orderHistory.toString());
    }
    }
        
        
      public int search(ArrayStack arrayStack, int orderNo) {
       invoice[] array = (invoice[]) arrayStack.toArray(); 
      int bottom = arrayStack.size() , top = 0; //last element added to the stack will be the first in the array (top)
      // while first element added to the stack will be the last element in the array(bottom)
			
      while (bottom >= top) {
      int pivot = (bottom + top) / 2;
      if (array[pivot].getOrder().getOrderNumber() == orderNo) {
          return pivot;     		
      } else {
          if (array[pivot].getOrder().getOrderNumber() < orderNo)
              bottom = pivot - 1; 	
          else 
	       top = pivot + 1; 	
      }
   } 
   return -1;
  } 

   

    }
    
    
    
    
    
