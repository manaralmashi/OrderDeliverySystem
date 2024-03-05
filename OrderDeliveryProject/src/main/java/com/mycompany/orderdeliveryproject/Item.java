/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;

/**
 *
 * Lamis Mohammed
 */
public class Item {
// ------Attributes------ 
    private String Name;
    private int code;
    private double price;
    private int quantity;
// ------Constractors------ 

    /**
     *
     */
    public Item() {
    }

    /**
     *
     * @param code
     * @param quantity
     */
    public Item(int code, int quantity) {
        this.code = code;
        this.quantity = quantity;
    }

    /**
     *
     * @param Name
     * @param code
     * @param price
     */
    public Item(String Name, int code, double price) {
        this.Name = Name;
        this.code = code;
        this.price = price;
    }

    /**
     *
     * @param Name
     * @param code
     */
    public Item(String Name, int code) {
        this.Name = Name;
        this.code = code;
    }

    /**
     *
     * @param Name
     * @param price
     */
    public Item(String Name, double price) {
        this.Name = Name;
        this.price = price;
    }
     
    /**
     *
     * @param Name
     */
    public Item(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @param code
     */
    public Item(int code) {
        this.code = code;
    }
// -------Methods------- 

    /**
     *
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
