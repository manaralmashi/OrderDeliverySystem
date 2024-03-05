/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;


/**
 *
 * @author لميس
 */
public class Report {
    int numOfOrders;
    ArrayStack orderHistory= new ArrayStack<>();
    BinaryTree ORDERS = new BinaryTree();
    DriverInformation DeliveryWorker = new DriverInformation();
    ListOfInformation ListOfInformation;
    /**
     *
     */
    public Report() {
        
    }
    public Report(ListOfInformation listOfInformation) {
      ListOfInformation =listOfInformation;  
    }
    
    /**
     *
     * @return
     */
    public int getNumOfOrders() {
        return numOfOrders;
    }

    /**
     *
     * @param numOfOrders
     */
    public void setNumOfOrders(int numOfOrders) {
        this.numOfOrders = numOfOrders;
    }

    /**
     *
     * @return
     */
    public ArrayStack getOrderHistory() {
        return orderHistory;
    }

    /**
     *
     * @param orderHistory
     */
    public void setOrderHistory(ArrayStack orderHistory) {
        this.orderHistory = orderHistory;
    }

    /**
     *
     * @return
     */
    public BinaryTree getORDERS() {
        return ORDERS;
    }

    /**
     *
     * @param ORDERS
     */
    public void setORDERS(BinaryTree ORDERS) {
        this.ORDERS = ORDERS;
    }

    /**
     *
     * @return
     */
    public DriverInformation getDeliveryWorker() {
        return DeliveryWorker;
    }

    /**
     *
     * @param DeliveryWorker
     */
    public void setDeliveryWorker(DriverInformation DeliveryWorker) {
        this.DeliveryWorker = DeliveryWorker;
    }
    
    /**
     *
     * @param order
     */
    public void pushOrder(OrderService order){
        orderHistory.push(order);  
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

    /**
     *
     * @param store
     */
    public void TheMostRequested(Store[] store) {
        int star = store[0].getIncrementStore();
        int pand = store[1].getIncrementStore();
        int mac = store[2].getIncrementStore();
        int nah = store[3].getIncrementStore();
        int neam = store[4].getIncrementStore();
        int[] Temp = {star, mac, nah, pand, neam};
        System.out.println(store[0].getName() + "                 number of orders = " + star);

        System.out.println(store[1].getName() + "                     number of orders = " + pand);

        System.out.println(store[2].getName() + "                  number of orders = " + nah);

        System.out.println(store[3].getName() + "                    number of orders = " + neam);

        System.out.println(store[4].getName() + "            number of orders = " + mac);

    }

    /**
     *
     * @param i
     */
    public void NewestAndOldest(int i){
        
        if (!(orderHistory.isEmpty())){
        System.out.println("["+i+"] "+orderHistory.pop());
        NewestAndOldest(i+1);
        }
        
    }
    
    /**
     *
     * @param store
     */
    public void CreatReport(Store[] store){
        System.out.println(" ____________________________________________________________________________________________");
        System.out.println("|                                    R  E  P  O  R  T                                        |");
        System.out.println("|____________________________________________________________________________________________|");
        System.out.println("\n\n NUMBER OF ORDERES IN THE SYSTEM : "+(ORDERS.getSize()));
        System.out.println("\n\n ARRANGE ORDERS FROM NEWEST TO OLDEST : ");
        NewestAndOldest(1);
        System.out.println("\n\n Orders Per Store : ");
        TheMostRequested(store);
        DeliveryWorker.Driversٌeport(ListOfInformation);


    }

  

}

