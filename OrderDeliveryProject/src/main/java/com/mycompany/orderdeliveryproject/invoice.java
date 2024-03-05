/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;



/**
 *
 * @author Lamis Mohammed
 */
public class invoice {
   private OrderService Order;
    Item[] Products;
    private double TotalPrice;
    private static int NumOfObj;
    private int InvoiceNum;
    private discount discount = new discount();
    /**
     * 
     */
    public invoice(){
      Order = new OrderService();
      NumOfObj=NumOfObj+1;
      InvoiceNum=NumOfObj;
   }

    /**
     *
     * @param Order
     */
    public invoice(OrderService Order) {
        NumOfObj=NumOfObj+1;
        InvoiceNum=NumOfObj;
        this.Order = Order;
    }

    /**
     * Getter
     * @return OrderService
     */
    public OrderService getOrder() {
        return Order;
    }

    /**
     * Setter
     * @param Order
     */
    public void setOrder(OrderService Order) {
        this.Order = Order;
    }

    /**
     * Getter
     * @return Item[]
     */
    public Item[] getProducts() {
        return Products;
    }

    /**
     * setter
     * @param Products
     */
    public void setProducts(Item[] Products) {
        this.Products = Products;
    }

    public discount getDiscount() {
        return discount;
    }

    public void setDiscount(discount discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }
  
    /**
     * To make calling method easier
     */
    public void creatInvoice(){
      Order.setDATE();
      Order.setTIME();
      calculateTotal();
     // PrintInvoice();
   }

    /**
     * calculate Total price for each product in the list,whit their quantities 
     * @return double
     */
    public double calculateTotal(){
       Products = Order.getCart().getRetriveCart();
       for(int i=0;i<Order.getCart().ListToarray().length;i++){
          TotalPrice += Products[i].getPrice()*Products[i].getQuantity();
       }
       return TotalPrice;
   }

    /**
     * print the invoice
     */
    public void PrintInvoice(){
      
     System.out.println("\n                            ---         invoice         ---  ");
     System.out.println("                              invoice number: "+InvoiceNum);
     System.out.println("                              Date and time:\n                              "+Order.getTIME()+" "+Order.getDATE()); 
     System.out.println("\n                            ---   Personal Information  ---  ");
     System.out.println("\n                              name: "+Order.getCoustmer().getFirstName()+" "+Order.getCoustmer().getLastName());
     System.out.println("                              Mobile number: "+Order.getCoustmer().getPhoneNo());
     System.out.println("\n                            ---         Products         ---  ");
     System.out.println(Order.getCart().toString());
     System.out.println("                              the price of your cart is: "+TotalPrice);
   if(discount.getDiscount()>0){
     System.out.println("                              price after discount is: "+(TotalPrice-discount.getDiscount()));
  }
   if(discount.getDay_discount()>0){
   
     System.out.println("                              price after today's discount: "+(TotalPrice-discount.getDay_discount()));
   }
     System.out.println("                              Delivery Price is: "+discount.getDeliveryPrice());
     System.out.println("                              Total price\n                              and Delivery Price is: "+((TotalPrice-discount.getDiscount())+discount.getDeliveryPrice()));
      
   } 
}

