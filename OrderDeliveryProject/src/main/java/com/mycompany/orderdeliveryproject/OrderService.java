/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;

import java.util.Random;
/**
 *
 * Lamis Mohammed
 */
public class OrderService {
    // ------Attribute------ 
    private static int NumOfObj;
    private int OrderNumber;
    private Customer Coustmer;
    private ShoppingCart Cart;
    private String DATE;
    private String TIME;
    private DATETIME datetime;
    private Random Num;
    
    // ------Constractor------ 

    /**
     *
     */
    public OrderService() {
        Num = new Random();
        int random = Num.nextInt(9999);
        NumOfObj++;
        OrderNumber = random;
        datetime = new DATETIME();
    }

    /**
     *
     * @param Cart
     */
    public OrderService(ShoppingCart Cart) {
        this.Cart = Cart;
         Num = new Random();
        int random = Num.nextInt(9999);
        NumOfObj++;
        OrderNumber = random;
        datetime = new DATETIME();
    }

    // -------Methods------- 

    /**
     * Getter
     * @return int
     */
    public static int getNumOfObj() {
        return NumOfObj;
    }

    /**
     * Getter
     * @return int
     */
    public int getOrderNumber() {
        return OrderNumber;
    }

    /**
     * Setter
     * @param OrderNumber
     */
    public void setOrderNumber(int OrderNumber) {
        this.OrderNumber = OrderNumber;
    }

    /**
     * Getter
     * @return Customer
     */
    public Customer getCoustmer() {
        return Coustmer;
    }

    /**
     * setter
     * @param Coustmer
     */
    public void setCoustmer(Customer Coustmer) {
        this.Coustmer = Coustmer;
    }

    /**
     * Getter
     * @return ShoppingCart
     */
    public ShoppingCart getCart() {
        return Cart;
    }

    /**
     * Setter
     * @param Cart
     */
    public void setCart(ShoppingCart Cart) {
        this.Cart = Cart;
    }

    /**
     * 
     * @return String
     */
    public String setDATE() {
        DATE = datetime.getDate();
        return DATE;
    }

    /**
     *
     * @return String
     */
    public String setTIME() {
        TIME = datetime.getTime();
        return TIME;
    }

    /**
     * Getter
     * @return String
     */
    public String getDATE() {
        return DATE;
    }

    /**
     * Getter
     * @return String
     */
    public String getTIME() {
        return TIME;
    }

    /**
     * Override method
     * @return String
     */
    public String toString(){
        return ("order number: "+ getOrderNumber()+"\ncustomer name: "+Coustmer.getFirstName()+" "+Coustmer.getLastName());
    }
}
