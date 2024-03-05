/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;


import java.text.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Calendar;  
import java.text.SimpleDateFormat;  
import java.text.DateFormatSymbols;

/**
 *
 * @author أروى
 */
public class discount {
  
    //--------------------ATTRIBUTES--------------------------
    
    private double discount;
    double Day_discount;
     Date discountDate;
    private double DeliveryPrice=15;
    SimpleDateFormat sdformat = new SimpleDateFormat("\"dd/MM/yy\"");
    String daysList[]={"Sunday", "Monday", "Tuesday", "Wednesday",
      "Thursday", "Friday", "Saturday"};
    
    String dayNames[] = new DateFormatSymbols().getWeekdays();  
    Calendar date = Calendar.getInstance(); //the current day and time 
  
     //-----------------------GETTERS AND SETTERS-----------------------------
     
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    
    public double getDeliveryPrice() {
        return DeliveryPrice;
    }

    public void setDeliveryPrice(double DeliveryPrice) {
        this.DeliveryPrice = DeliveryPrice;
    }

   
      public Date getDiscountDate() {
        return discountDate;
    }

    public String[] getDaysList() {
        return daysList;
    }
     public void setDay_discount(double Day_discount) {
        this.Day_discount = Day_discount;
    }
        

    public double getDay_discount() {
        return Day_discount;
    }
    
      public String[] getDayNames() {
        return dayNames;
    }
      
   //-----------------------------MTHODS--------------------------------

   
   /**
    * 
    * @param TotalPrice as double
    * @param daysList as String array
    * @return double Day_discount 
    */
         public double dayDiscount ( double TotalPrice, String daysList[]){
         String localDay=new String( dayNames[date.get(Calendar.DAY_OF_WEEK)]);  
        
          for (int i = 0; i < daysList.length; i++) {
            if (localDay.compareToIgnoreCase("friday")==0){
                if(daysList[i].compareTo(localDay)==0) {
                 Day_discount=(TotalPrice*0.10);
            }
            } else {
                Day_discount=0;
            }
        }
        return Day_discount;
      
  }

    /**
     * This method determines the delivery price based on the exact location of the store and the customer
     * @param store
     * @param userArea
     * @return double DeliveryPrice
     */
    
        public double deliveryPrice(Store store,String userArea){
        boolean location = store.searchExactLocation(userArea,store);
        if(location==true){
            setDeliveryPrice(15);
        }
            else{  
          setDeliveryPrice(25); 
                    }
        return this.DeliveryPrice;
    }

 
    /**
     * This method applies a a 23% discount to the total price only in the national day 
     * @param TotalPrice
     * @param store
     * @return double discount
     * @throws ParseException 
     */

        public double NationalDayDiscount(double TotalPrice,Store store) throws ParseException{
           
        Date NationalDayDiscount=sdformat.parse("23/09/23");
            if(NationalDayDiscount.compareTo(store.convertLocalDateTimeToDateUsingTimestamp(LocalDateTime.MIN)) == 0){
               discount=(TotalPrice)*0.23;
            }
            else{
                setDiscount(0);
            }
              return discount;
       }
       
     /**
      * This method chaecks if the order contains item with a quantitry larger than 2 , the customer gets a 20% discount
      * @param TotalPrice as double
      * @param Product as Item array
      * @return double discount
      */
     public double quantityDiscount(double TotalPrice,Item[] Product) {
        for (int i = 0; i < Product.length; i++) {
            if (Product[i].getQuantity() > 2) {
                discount=((TotalPrice*0.20));
                      
            } else {
                setDiscount(0);
            }
        }
        return discount;

    }
}
