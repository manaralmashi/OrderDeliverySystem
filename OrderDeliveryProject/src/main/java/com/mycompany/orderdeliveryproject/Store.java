/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;



/**
 *
 * @author manaralmashi
 */
import java.text.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

public class Store {

//------------------------------ATTREBUTS---------------------------------------
    private String name;
    private String classification;
    private int presentStoreNumber;
    private int StoreNumber;
    private String brunch;
    private String website;
    private String[] location;

    private Item[] specificProduct;
    private Item[] product1;
    private Item[] product2;
    private Item[] product3;
    private Item[] product4;
    private Item[] product5;

    private LocalDateTime now_in_LocalDateTime;
    private Date now_inDate;
    private LocalTime now_inLocalTime;
    private LocalTime workHour_Start;
    private LocalTime workHour_End;

    private boolean status_boolean;     //---> true/false
    private String status_String;       //---> Open/Close


    private double averageRating_D;
    private String rating_Stars;
    private int rating_reviews = 100;

    private int incrementStore;

//----------------------------CONSTRUCTORS--------------------------------------
    public Store() {
    }

    public Store(int indexOfStoreArray) throws ParseException {

        switch (indexOfStoreArray) {
            case 0:
                //Informations
                name = "Starbucks";
                classification = "Cafè";
                brunch = "Brunch :\n"
                        + "1- Abraj Al Bait\n"
                        + "2- Al Diyafa Mall\n"
                        + "3- Al Hijaz Plaza\n"
                        + "4- Hokair Time \n"
                        + "5- Jabel Omar\n"
                        + "6- Jarir Book Store\n"
                        + "7- Makkah Mall\n"
                        + "8- Othaim Mall\n"
                        + "9- Saud Plaza\n"
                        + "10- Prince Abdullah Ibn Saud";
                location = new String[]{"Abraj Al- Bait", "Al- Awali", "Al- Azizia", "Al- Rasifah", "King Abdullah Road"};
                website = "www.starbucks.com";

                //Rating
                averageRating_D = 4.9;
                rating_Stars = RatingStars(averageRating_D);

                //Work hours
                workHour_Start = LocalTime.parse("23:00:00");
                workHour_End = LocalTime.parse("23:59:59");

                //Products
                product1 = new Item[]{
                    new Item("Iced Caffe Latte(S)             ", 14.0),
                    new Item("Iced Caffe Latte(B)             ", 18.0),
                    new Item("Iced Caramel Macchiato(S)       ", 16.0),
                    new Item("Iced Caramel Macchiato(B)       ", 20.0),
                    new Item("Signature Hot Chocolate(S)      ", 16.0),
                    new Item("Signature Hot Chocolate(B)      ", 20.0),
                    new Item("Green Tea Latte(S)              ", 16.0),
                    new Item("Green Tea Latte(B)              ", 20.0),
                    new Item("Doubleshot Iced Shaken Espresso ", 14.0),
                    new Item("Blubbery Cheescake              ", 21.0),
                    new Item("Strawberry Cheescake            ", 20.0),
                    new Item("Deep Carrot Cake                ", 17.0),
                    new Item("German Cake                     ", 18.0),
                    new Item("Chocolate Fudge Brownie         ", 12.0)
                };

                break;

            case 1:
                name = "Panda";
                classification = "Supermarket";
                brunch = "Brunch :\n"
                        + "1.	AL Awali\n"
                        + "2.	Makkah Mall\n"
                        + "3.	Ash Sharaie Mall\n"
                        + "4.	Batha Quraish\n"
                        + "5.	Al Lith Road\n"
                        + "6.	An Nawwariyah";
                location = new String[]{"An- Nawwariyah", "Al- Sharaie", "Batha Quraish", "Al- Azizia"};
                website = "panda.com.sa";

                //Rating
                averageRating_D = 4.3;
                rating_Stars = RatingStars(averageRating_D);

                //Work hours
                workHour_Start = LocalTime.parse("07:00:00");
                workHour_End = LocalTime.parse("23:59:59");

                //Products
                product2 = new Item[]{
                    new Item("Khalas Qassim Dates 1kg                 ", 25.95),
                    new Item("Afia Extra Virgin Olive Oil 500ml       ", 20.95),
                    new Item("Quaker White Oat Quick Cooking 500g     ", 11.95),
                    new Item("Al Osra White Sugar 2kg                 ", 8.75),
                    new Item("Abu Kass Classic White Basmati Rice 5kg ", 63.25),
                    new Item("Alkhair Light Meat Tuna  95g            ", 4.50),
                    new Item("Goody Creamy Peanut Butter 510g         ", 18.0),
                    new Item("Green Tea Latte(B)                      ", 20.0),
                    new Item("Brown Eggs Medium ×30                   ", 21.25),
                    new Item("Almarai Full Fat Milk 1L                ", 5.95),
                    new Item("Sadia Tender Chicken Breast 1kg         ", 28.45)
                };

                break;

            case 2:
                name = "Al Nahdi";
                classification = "Pharmacy";
                brunch = "Brunch :\n"
                        + "1.	Al Masjid Al Haram Road\n"
                        + "2.	King Abdullah Road\n"
                        + "3.	An Naseem\n"
                        + "4.	Ad Diyafa \n"
                        + "5.	Ray Zakhir\n"
                        + "6.	Ash Shawgiyah\n"
                        + "7.	An Nuzha\n"
                        + "8.	Batha Quraish\n"
                        + "9.	Az Zahir\n"
                        + "10.	An Nawwariyah";
                location = new String[]{"An- Nawwariyah", "Al- Sharaie", "Batha Quraish", "Abraj Al- Bait", "Al- Shawgiyah", "An- Naseem", "An- Nuzha", "King Abdullah Road"};
                website = "www.nahdionline.com";

                //Rating
                averageRating_D = 4.2;
                rating_Stars = RatingStars(averageRating_D);

                //Work hours
                workHour_Start = LocalTime.parse("00:00:00");
                workHour_End = LocalTime.parse("23:59:59");

                //Products
                product3 = new Item[]{
                    new Item("Redoxon-Vitamin C 1000mg            ", 14.95),
                    new Item("Folic Acid 5mg                      ", 4.95),
                    new Item("Jamieson-Zinc 10mg                  ", 55.0),
                    new Item("Vichy-Sunscreen SPF50 50ml          ", 125.75),
                    new Item("QV-Hand Cream 50gm                  ", 63.25),
                    new Item("Lifebuoy- Body wash 500ml           ", 45.50),
                    new Item("Dettol- Shower gel 250ml            ", 34.50),
                    new Item("Panadol Extra 25pcs                 ", 8.0),
                    new Item("Refresh Plus- eyes drop 30pcs/0.4ml ", 18.25),
                    new Item("Elica Cream 30gm                    ", 19.95)
                };

                break;

            case 3:
                name = "Neamah";
                classification = "Bakery & Sweet";
                brunch = "Brunch :\n"
                        + "1- Sharaie branch\n"
                        + "2- Khalidiya branch\n"
                        + "3- Azizia branch\n"
                        + "4- Al-nawwariyah branch";
                location = new String[]{"An- Nawwariyah", "Al- Sharaie", "Al- Azizia", "Al- khalidiya"};
                website = "neamah.my.taker.io";

                //Rating
                averageRating_D = 2.9;
                rating_Stars = RatingStars(averageRating_D);

                //Work hours
                workHour_Start = LocalTime.parse("11:30:00");
                workHour_End = LocalTime.parse("22:59:59");

                //Products
                product4 = new Item[]{
                    new Item("Pizza Vegetables ", 14.95),
                    new Item("Muhamara with Cheese and Thyme    ", 10.95),
                    new Item("Meat pizza                        ", 17.0),
                    new Item("Premium zaatar croissant          ", 5.75),
                    new Item("Remium cheese croissant           ", 6.25),
                    new Item("Fresh maamoul (one piece)         ", 0.87),
                    new Item("Chocolate plate (size : large)    ", 3346.50),
                    new Item("Mixed pastry Box                  ", 73.83),
                    new Item("Corissant sandwich Box            ", 31.25),
                    new Item("Box Vine leaves Stuffed with Rice ", 68.95)
                };

                break;

            case 4:
                name = "McDonald's KSA";
                classification = "Fast Food";
                brunch = "Brunch :\n"
                        + "1.	Sharaie Mall\n"
                        + "2.	King Faisal Rd\n"
                        + "3.	Makkah Mall\n"
                        + "4.	Al Hukair Time\n"
                        + "5.	Diyafa Mall\n"
                        + "6.	Al Rasifah St\n"
                        + "7.	The Clock Towers\n"
                        + "8.	Ibrahim Al Khaled\n"
                        + "9.	Darb Station";
                location = new String[]{"Abraj Al- Bait", "Al- Sharaie", "Al- Azizia", "Al- Rasifah"};
                website = "www.mcdonalds.com";

                //Rating
                averageRating_D = 4.4;
                rating_Stars = RatingStars(averageRating_D);

                //Work hours
                workHour_Start = LocalTime.parse("16:30:00");
                workHour_End = LocalTime.parse("23:59:59");

                //Products
                product5 = new Item[]{
                    new Item("Big Mac meal              ", 25.95),
                    new Item("Chicken happy meal        ", 16.95),
                    new Item("Grand Chicken Deluxe Meal ", 32.0),
                    new Item("Grand Chicken Spicy Meal  ", 32.75),
                    new Item("Caesar Salad              ", 24.25),
                    new Item("Fries                     ", 8.87),
                    new Item("Mc Flurry Oreo            ", 10.50),
                    new Item("Jalapeno Cheese           ", 9.83),
                    new Item("Orange Juice              ", 5.25),
                    new Item("Coke-Cola                 ", 6.95)
                };
                break;

            default:
        }
        switch (indexOfStoreArray) {
            case 0:
                specificProduct = product1;
                StoreNumber = 1;
                break;
            case 1:
                specificProduct = product2;
                StoreNumber = 2;
                break;
            case 2:
                specificProduct = product3;
                StoreNumber = 3;
                break;
            case 3:
                specificProduct = product4;
                StoreNumber = 4;
                break;
            case 4:
                specificProduct = product5;
                StoreNumber = 5;
                break;
        }
        IsOpenOrClose();
    }
    //----------------------------METHODS---------------------------------------

    public Date convertLocalDateTimeToDateUsingTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }

    public void IsOpenOrClose() {
//        now_inDate = convertLocalDateTimeToDateUsingTimestamp(now_in_LocalDateTime);
        now_in_LocalDateTime = LocalDateTime.now();
        now_inLocalTime = LocalTime.parse((now_in_LocalDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME)));

        if (now_inLocalTime.isAfter(workHour_Start) && now_inLocalTime.isBefore(workHour_End)) {
            status_String = "Open Now";
            status_boolean = true;
        } else {
            status_String = "Close Now";
            status_boolean = false;
        }
    }

    public void sortStores(Store[] store, String userArea) {

        SinglyLinkedList<Store> stores_After_storing = new SinglyLinkedList<>();

        int x = 0;
        int w = 0;
        for (; stores_After_storing.size() <= 5; w++) {

            if (searchExactLocation(userArea, store[x])) {
                stores_After_storing.addFirst(store[x]);
                x++;
            } else {
                stores_After_storing.addLast(store[x]);
                x++;
            }
            if (x == 5) {
                break;
            }
        }
        System.out.println("-------[Sort Stores According To The Nearest]-------");
        stores_After_storing.display();

    }

    public String presentStore() {

        String presentStore
                = " _______________________________________________ " + "\n"
                + "|                " + name + "                    " + "\n"
                + "|_______________________________________________ " + "\n"
                + "| Classification : " + classification + "\n"
                + "|                                                " + "\n"
                + "| Work Hours     : (from) " + workHour_Start + "\n"
                + "|                : ( to ) " + workHour_End + "\n"
                + "|                                                " + "\n"
                + "| Status         : " + status_String + "\n"
                + "|                                                " + "\n"
                + "| Rating         : " + averageRating_D + " / 5.0 \n"
                + "|                 " + rating_Stars + "\n"
                + "|_______________________________________________ \n\n" + "\n";
        return presentStore;
    }

    public void sortProduct(Store[] store) {
        //Creation new list
        SinglyLinkedList<Double> listOfPriceProduct = new SinglyLinkedList<>();

        for (int j = 0; j < specificProduct.length; j++) {
            listOfPriceProduct.addNode(store[StoreNumber - 1].getSpecificProduct()[j].getPrice());
        }
        for (int j = 0; j < specificProduct.length - 1; j++) {
            System.out.println("[" + (j + 1) + "] " + store[StoreNumber - 1].getSpecificProduct()[j].getName() + " : " + store[StoreNumber - 1].getSpecificProduct()[j].getPrice() + " RS");
        }
        System.out.println();

//        // sort in ascending order
//        Collections.sort(listOfPriceProduct);
//        
//        
//        // Print the Sorted LinkedList
//        System.out.println("Sorted List");
//        for (int j = 0; j < specificProduct.length - 1; j++) {
//            System.out.println(store[StoreNumber - 1].getSpecificProduct()[j].getName() + " : " + store[StoreNumber - 1].getSpecificProduct()[j].getPrice());
//        }
//        System.out.println();
    }

    //method that return the exact Location which user is choosen.
    public boolean searchExactLocation(String userArea, Store store) {
        for (int i = 0; i < store.location.length; i++) {
            if (userArea == store.location[i]) {
                return true;
            }
        }
        return false;
    }

    public double averageRating(double rating_D) {
        
        averageRating_D = (( ((averageRating_D) * rating_reviews) + rating_D)  / (rating_reviews + 1));
        rating_reviews++;
        
        rating_Stars = RatingStars(averageRating_D);
        return averageRating_D;
    }

    public String RatingStars(double averageRating) {
        switch ((int) Math.round(averageRating)) {
            case 0:
                rating_Stars = "[  -------  ]";
                break;
            case 1:
                rating_Stars = "[     *     ]";
                break;
            case 2:
                rating_Stars = "[    * *    ]";
                break;
            case 3:
                rating_Stars = "[   * * *   ]";
                break;
            case 4:
                rating_Stars = "[  * * * *  ]";
                break;
            case 5:
                rating_Stars = "[ * * * * * ]";
                break;
        }
        return rating_Stars;
    }

    //--------------------------SETTERS & GETTERS-------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getPresentStoreNumber() {
        return presentStoreNumber;
    }

    public void setPresentStoreNumber(int presentStoreNumber) {
        this.presentStoreNumber = presentStoreNumber;
    }

    public int getStoreNumber() {
        return StoreNumber;
    }

    public void setStoreNumber(int StoreNumber) {
        this.StoreNumber = StoreNumber;
    }

    public String getBrunch() {
        return brunch;
    }

    public void setBrunch(String brunch) {
        this.brunch = brunch;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String[] getLocation() {
        return location;
    }

    public void setLocation(String[] location) {
        this.location = location;
    }

    public Item[] getSpecificProduct() {
        return specificProduct;
    }

    public void setSpecificProduct(Item[] specificProduct) {
        this.specificProduct = specificProduct;
    }

    public Item[] getProduct1() {
        return product1;
    }

    public void setProduct1(Item[] product1) {
        this.product1 = product1;
    }

    public Item[] getProduct2() {
        return product2;
    }

    public void setProduct2(Item[] product2) {
        this.product2 = product2;
    }

    public Item[] getProduct3() {
        return product3;
    }

    public void setProduct3(Item[] product3) {
        this.product3 = product3;
    }

    public Item[] getProduct4() {
        return product4;
    }

    public void setProduct4(Item[] product4) {
        this.product4 = product4;
    }

    public Item[] getProduct5() {
        return product5;
    }

    public void setProduct5(Item[] product5) {
        this.product5 = product5;
    }

    public LocalDateTime getNow_in_LocalDateTime() {
        return now_in_LocalDateTime;
    }

    public void setNow_in_LocalDateTime(LocalDateTime now_in_LocalDateTime) {
        this.now_in_LocalDateTime = now_in_LocalDateTime;
    }

    public Date getNow_inDate() {
        return now_inDate;
    }

    public void setNow_inDate(Date now_inDate) {
        this.now_inDate = now_inDate;
    }

    public LocalTime getNow_inLocalTime() {
        return now_inLocalTime;
    }

    public void setNow_inLocalTime(LocalTime now_inLocalTime) {
        this.now_inLocalTime = now_inLocalTime;
    }

    public LocalTime getWorkHour_Start() {
        return workHour_Start;
    }

    public void setWorkHour_Start(LocalTime workHour_Start) {
        this.workHour_Start = workHour_Start;
    }

    public LocalTime getWorkHour_End() {
        return workHour_End;
    }

    public void setWorkHour_End(LocalTime workHour_End) {
        this.workHour_End = workHour_End;
    }

    public boolean isStatus_boolean() {
        return status_boolean;
    }

    public void setStatus_boolean(boolean status_boolean) {
        this.status_boolean = status_boolean;
    }

    public String getStatus_String() {
        return status_String;
    }

    public void setStatus_String(String status_String) {
        this.status_String = status_String;
    }

    public double getAverageRating_D() {
        return averageRating_D;
    }

    public void setAverageRating_D(double averageRating_D) {
        this.averageRating_D = averageRating_D;
    }

    public int getIncrementStore() {
        return incrementStore;
    }

    public void setIncrementStore(int incrementStore) {
        this.incrementStore = incrementStore;
    }

    public String getRating_Stars() {
        return rating_Stars;
    }

    public void setRating_Stars(String rating_Stars) {
        this.rating_Stars = rating_Stars;
    }

    public int getRating_reviews() {
        return rating_reviews;
    }

    public void setRating_reviews(int rating_reviews) {
        this.rating_reviews = rating_reviews;
    }
    
    
    

}
