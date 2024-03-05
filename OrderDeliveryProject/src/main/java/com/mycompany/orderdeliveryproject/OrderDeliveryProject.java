/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.orderdeliveryproject;

import java.text.ParseException;
import java.text.*;
import java.util.*;  
/**
 *
 * @author manaralmashi
 */

public class OrderDeliveryProject {
 static boolean DriversInsert = false;
    public static void main(String[] args) throws ParseException {
        ListOfInformation PersonalInformation = new ListOfInformation();
        Report R = new Report(PersonalInformation);
        
        for(int O = 0; O!=-1;O++){
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Customer customer = new Customer();
        ShoppingCart Cart = new ShoppingCart();
        OrderService Order = new OrderService();
        Store[] store = new Store[5];
   
        int i = 0;
        for (; i <= store.length - 1; i++) {
            store[i] = new Store(i);
        }
        //------------------------------------------------------------------
        
    
        System.out.println("       __________________                     ");
        System.out.println("     /              |     \\                  ");
        System.out.println("    /               |      \\                 ");
        System.out.println("   /                |       \\                ");
        System.out.println("  /                 |        \\               ");
        System.out.println(" /__________________|_________\\              ");
        System.out.println("|                              *              ");
        System.out.println("|                                  *          ");
        System.out.println("|           W E L L C O M E           *       ");
        System.out.println("|     To The Order Delivery System     *      ");
        System.out.println("|                                      *      ");
        System.out.println("|                                     *       ");
        System.out.println("|                                    *        ");
        System.out.println(" ------*-------* *** *-------*-----*          ");
        System.out.println("       *       *     *       *                ");
        System.out.println("         * * *         * * *                  ");
       
        
        //------------------------------------------------------------------------------
        //PERSONAL INFORMATION :
        System.out.println(" ___________________________________________________");
        System.out.println("|                 User information                  |  ");
        System.out.println("| __________________________________________________|");
        
        System.out.println("\n Please Enter the following PERSONAL INFORMATION :");
        System.out.println("[1]:");
        String fname = CheckName("First name ");
        customer.setFirstName(fname);
        System.out.println("[2]:");
        String lname = CheckName("Last name ");
        customer.setLastName(lname);

        System.out.println("*Mobile number");
        String num;

        System.out.println(" Please enter you'r PHONE NUMBER ( Start with 05********) : ");
        num = input.nextLine();
        boolean indexnum = (num.matches("[0]{1}[5]{1}[0-9]{8}"));

        if (indexnum == true) {
            System.out.println(" Number is valid");
        }
        while (indexnum == false) {
            System.out.println("************************** *");
            System.out.println("                             *");
            System.out.println("                               *");
            System.out.println("*******     Sorry               *");
            System.out.println("****                             *      O");
            System.out.println("      Number is invalid,          *");
            System.out.println(" enter your mobile number again   *");
            System.out.println("*******                           *     O");
            System.out.println("****                             *");
            System.out.println("                                *");
            System.out.println("     * * *         * * *      *");
            System.out.println("** *       * *** *       * **");
            System.out.println("   *       *     *       *   ");
            System.out.println("     * * *         * * *     \n");

            System.out.println("Enter the PHONE NUMBER ( Start with 05********):");
            num = input.nextLine();
            indexnum = (num.matches("[0]{1}[5]{1}[0-9]{8}"));
        }
        customer.setPhoneNo(num);
        
        
         //Payment method
         String cc ="";
        System.out.println("\n Choose Your Preferred Payment Method: \n"+
                "1] Credit Card     2] Pay From App Wallet    3] Cash on Delivery");
        int choicee = input.nextInt();
       do{
        switch (choicee){
            case 1: 
                do{
                System.out.println("Enter Your Credit Card Number [BE 16  DIGITS LONG ]: ");
                 cc = input.next(); 
                if (cc.length()!= 16){ //16 is the standard number of digits for credit cards
                    System.out.println("************************** *");
                    System.out.println("                             *");
                    System.out.println("                               *");
                    System.out.println("******      Sorry               *");
                    System.out.println("****    The number must be       *      O");
                    System.out.println("        16 digits long,           *");
                    System.out.println("                                  *");
                    System.out.println("*****   Please enter again        *     O");
                    System.out.println("****                             *");
                    System.out.println("                                *");
                    System.out.println("     * * *         * * *      *");
                    System.out.println("** *       * *** *       * **");
                    System.out.println("   *       *     *       *   ");
                    System.out.println("     * * *         * * *    \n ");
                    continue; }
                }
                while (cc.length() != 16); 
                System.out.println("/n Credit card has been saved succefully!");
                customer.setPaymentMethod("Credit Card");
                customer.setCreditCardNo(cc);
                break; 
            case 2:
                System.out.println("Enter The Amount You Want to Add: ");
                int wallet = input.nextInt();
                System.out.println("Added!");
                customer.setPaymentMethod("Wallet");
                customer.setWallet(wallet);
                break;
            case 3:
                System.out.println("Payment method saved!");
                customer.setPaymentMethod("Cash on Delivery");
                break;
            default:
                System.out.println("Invalid Option!");
                 ErrorMessage();
        }}
        while(choicee<1||choicee>3);
        
        
        
        
        
        
        
        
        
        //------------------------------------------------------------------------------
        //USER LOCATION INFORMATION 
        System.out.println(" ___________________________________________________");
        System.out.println("|                 LOCATION INFORMATION              |  ");
        System.out.println("| __________________________________________________|");
        
       int userArea_int;
        S:
        do {
            System.out.println("\n Please Enter The Delivery Address Area :\n\n"
                    + "[01] Al-Masfalah\n"
                    + "[02] Al-Otaibi\n"
                    + "[03] Al- Shawgiyah\n"
                    + "[04] Al- Sharaie\n"
                    + "[05] Al- Azizia\n"
                    + "[06] Al-Umrah\n");

            userArea_int = input.nextInt();
            if (userArea_int < 1 || userArea_int > 6) {
                ErrorMessage();
                continue S;
            }
        } while (userArea_int < 1 || userArea_int > 6);

        int Userneighborhood = 0;
         
         switch (userArea_int) {
            case 1:
                s:
                do {
                    System.out.println("\n Please Enter The exact neighborhood of your location : ");
                    System.out.println("1] Al- Rasifah");
                    System.out.println("2] Al- khalidiya");
                    System.out.println("3] Al-Masfalah");
                    Userneighborhood = input.nextInt();
                    if (Userneighborhood < 1 || Userneighborhood > 3) {
                        ErrorMessage();
                        continue s;
                    }
                } while (Userneighborhood < 1 || Userneighborhood > 3);

                break;
            case 2:
                s:
                do {
                    System.out.println("1] An- Nuzha");
                    System.out.println("2] Al-Otaibi");
                    System.out.println("3] Al-diyafih");
                    System.out.println("4] Al-Shuhada");
                    Userneighborhood = input.nextInt();
                    if (Userneighborhood < 1 || Userneighborhood > 4) {
                        ErrorMessage();
                        continue s;}}                  
                   while (Userneighborhood < 1 || Userneighborhood > 4);
                break;
            case 3:
                s:
                do {
                    System.out.println("1] Al- Shawgiyah");
                    System.out.println("2] Batha Quraish");
                    System.out.println("3] Al-Shamisi");
                    System.out.println("4] King Fahd District");
                    Userneighborhood = input.nextInt();
                    if (Userneighborhood < 1 || Userneighborhood > 4) {
                        ErrorMessage();
                        continue s;}}                    
                    while (Userneighborhood < 1 || Userneighborhood > 4);
                break;
            case 4:
                s:
                do {
                    System.out.println("1] Al- Sharaie");
                    System.out.println("2] Al-Rashidiya");
                    System.out.println("3] Al-salam");
                    System.out.println("4] Al-Moghams");
                    System.out.println("5] Al-Jaarana");
                    Userneighborhood = input.nextInt();
                    if (Userneighborhood < 1 || Userneighborhood > 5) {
                        ErrorMessage();
                        continue s;}}                    
                    while (Userneighborhood < 1 || Userneighborhood > 5);
                break;
            case 5:
                s:
                do {
                    System.out.println("1] Al- Azizia");
                    System.out.println("2] An- Naseem");
                    System.out.println("3] Al- Awali");
                    System.out.println("4] Abraj Al- Bait");
                    System.out.println("5] Al-Abediyah");
                    System.out.println("6]  King Abdullah Road");
                    Userneighborhood = input.nextInt();
                    if (Userneighborhood < 1 || Userneighborhood > 6) {
                        ErrorMessage();
                        continue s;}}
                    while (Userneighborhood < 1 || Userneighborhood > 6);
                break;
            case 6:
                s:
                do {
                    System.out.println("1] An- Nawwariyah");
                    System.out.println("2] Al-Tanaim");
                    System.out.println("3] Al-Umrah");
                    System.out.println("4] Al-Furqan");
                    Userneighborhood = input.nextInt();
                    if (Userneighborhood < 1 || Userneighborhood > 4) {
                        ErrorMessage();
                        continue s;}}
                    
                     while (Userneighborhood < 1 || Userneighborhood > 4);

                break;
            default:

        }
        
       String userArea_String = null;

        switch (userArea_int) {
            case 1:
                if (Userneighborhood == 2) {
                    userArea_String = "Al- khalidiya";
                } else if (Userneighborhood == 1) {
                    userArea_String = "Al- Rasifah";
                } else if (Userneighborhood == 3) {
                    userArea_String = "Al-Masfalah";
                } else {
                    userArea_String = " ";
                }
                break;
            case 2:
                if (Userneighborhood == 1) {
                    userArea_String = "An- Nuzha";
                } else if (Userneighborhood == 2) {
                    userArea_String = "Al-Otaibi";
                } else if (Userneighborhood == 3) {
                    userArea_String = "Al-diyafih";
                } else if (Userneighborhood == 4) {
                    userArea_String = "Al-Shuhada";
                } else {
                    userArea_String = " ";
                }

                break;
            case 3:
                if (Userneighborhood == 1) {
                    userArea_String = "Al- Shawgiyah";
                } else if (Userneighborhood == 2) {
                    userArea_String = "Batha Quraish";
                } else if (Userneighborhood == 3) {
                    userArea_String = "Al-Shamisi";
                } else if (Userneighborhood == 4) {
                    userArea_String = "King Fahd District";
                } else {
                    userArea_String = " ";
                }

                break;
            case 4:

                if (Userneighborhood == 1) {
                    userArea_String = "Al- Sharaie";
                } else if (Userneighborhood == 2) {
                    userArea_String = "Al-Rashidiya";
                } else if (Userneighborhood == 3) {
                    userArea_String = "Al-salam";
                } else if (Userneighborhood == 4) {
                    userArea_String = "Al-Moghams";
                } else if (Userneighborhood == 5) {
                    userArea_String = "Al-Jaarana";
                } else {
                    userArea_String = " ";
                }

                break;
            case 5:
                switch (Userneighborhood) {
                    case 1:
                        userArea_String = "Al- Azizia";
                        break;
                    case 2:
                        userArea_String = "An- Naseem";
                        break;
                    case 3:
                        userArea_String = "Al- Awali";
                        break;
                    case 4:
                        userArea_String = "Abraj Al- Bait";
                        break;
                    case 5:
                        userArea_String = "Al-Abediyah";
                        break;
                    case 6:
                        userArea_String = "King Abdullah Road";
                        break;

                }

                break;
            case 6:
                if (Userneighborhood == 1) {
                    userArea_String = "An- Nawwariyah";
                } else if (Userneighborhood == 2) {
                    userArea_String = "Al-Tanaim";
                } else if (Userneighborhood == 3) {
                    userArea_String = "Al-Umrah";
                } else if (Userneighborhood == 4) {
                    userArea_String = "Al-Furqan";
                } else {
                    userArea_String = " ";
                }

                break;

        }
        //__________________________________________________________________________

       
        //STORE
        //presentAllStore (with SORTING)
        store[0].sortStores(store, userArea_String);

        //presentAllStore (without SORTING)
//        presentAllStore(store);
        System.out.println("\n-------------------------------------------------");
//        System.out.println("Please Enter The Store (( NUMBER )) : ");
//        int userStore = input.nextInt();

        Store specificStore = null;
        String userStore = null;
        boolean isNotValidStoreName = true;

        while (isNotValidStoreName) {
            System.out.println("Please Enter The Store (( N A M E )) : ");
            userStore = input2.next();

            if (userStore.matches("[a-zA-Z]+")) {

                if (!(userStore.charAt(0) == 'S' || userStore.charAt(0) == 'A' || userStore.charAt(0) == 'N' || userStore.charAt(0) == 'P' || userStore.charAt(0) == 'M'
                        || userStore.charAt(0) == 's' || userStore.charAt(0) == 'a' || userStore.charAt(0) == 'n' || userStore.charAt(0) == 'p' || userStore.charAt(0) == 'm')) {

                    System.out.println("************************** *");
                    System.out.println("                             *");
                    System.out.println("                               *");
                    System.out.println("******      Sorry               *");
                    System.out.println("****    It Must be one of        *      O");
                    System.out.println("        these stores name,        *");
                    System.out.println("                                  *");
                    System.out.println("*****   Please enter again        *     O");
                    System.out.println("****                             *");
                    System.out.println("                                *");
                    System.out.println("     * * *         * * *      *");
                    System.out.println("** *       * *** *       * **");
                    System.out.println("   *       *     *       *   ");
                    System.out.println("     * * *         * * *    \n ");
                } else {
                    switch (userStore.charAt(0)) {
                        case 'S','s':
                            specificStore = store[0];
                            break;
                        case 'P','p':
                            specificStore = store[1];
                            break;
                        case 'A','a':
                            specificStore = store[2];
                            break;
                        case 'N','n':
                            specificStore = store[3];
                            break;
                        case 'M','m':
                            specificStore = store[4];
                            break;
                    }
                    if (specificStore.getName().charAt(0) == userStore.charAt(0) || specificStore.getName().charAt(0) == userStore.toUpperCase().charAt(0)) {
                        //Is it close or open
                        if (!specificStore.isStatus_boolean()) {
                            System.out.println("Sorry! THE STORE IS CLOSE !");
                        } else {
                            //see the product
                            specificStore.sortProduct(store);
                            //Valid store
                            isNotValidStoreName = false;
                        }
                    }

                }

            } else {
                System.out.println("************************** *");
                System.out.println("                             *");
                System.out.println("                               *");
                System.out.println("******      Sorry               *");
                System.out.println("****    You Have to enter        *      O");
                System.out.println("           Only letters,          *");
                System.out.println("                                  *");
                System.out.println("*****   Please enter again        *     O");
                System.out.println("****                             *");
                System.out.println("                                *");
                System.out.println("     * * *         * * *      *");
                System.out.println("** *       * *** *       * **");
                System.out.println("   *       *     *       *   ");
                System.out.println("     * * *         * * *    \n ");
            }
        }

        
        //----------------------------------------------------------------------------------
      //ORDER  
        invoice invoice;
        discount discount =new discount();
//        Store s = new Store(); // Hena Manar
        Item[] item = specificStore.getSpecificProduct(); 
        boolean test = true;
        while (test) {
            System.out.println("please enter the number of product you want, -1 to See the content of your cart ");
            int choice;
            do {
                choice = input.nextInt();
                if (choice == -1) {
                    test = false;
                    break;
                }
            } while (choice < 1 || choice > item.length);
            if (choice != -1) {
                System.out.println("please enter the Quntity you want ");
                int Quntity = 1;
                do {
                    if (Quntity < 1) {
                       ErrorMessage();
                    }
                    Quntity = input.nextInt();
                } while (Quntity < 1);
                Cart.AddToCart(item[choice - 1], Quntity);
            }
        }
        Cart.ListToarray();
        System.out.println(Cart.toString());
        Cart.PrintTheCart();
        System.out.println("\n Please choose the modification you want, 3 to confirm the order and print the invoice ");
        boolean test2 = true;
        while (test2) {
            System.out.println("         [1] Add more items    [2] remove some item   [3] Print the invoice ");
            int Update;
            do {
                Update = input.nextInt();
                if (Update < 1 || Update > 3) {
                       ErrorMessage();
                }
            } while (Update < 1 || Update > 3);
            switch (Update) {
                case 1:
                    specificStore.sortProduct(store);
                    System.out.println("please enter the number of product you want ");
                    int choice;
                    do {
                        choice = input.nextInt();
                    } while (choice < 1 || choice > item.length);

                    System.out.println("please enter the Quntity you want ");
                    int Quntity = 1;
                    do {
                        if (Quntity < 1) {
                       ErrorMessage();
                        }
                        Quntity = input.nextInt();
                    } while (Quntity < 1);
                    Cart.AddToCart(item[choice - 1], Quntity);
                    break;
                case 2:
                    if (Cart.getCart().isEmpty()) {
                        System.out.println("Sorry you can not remove more items because the cart is Empty ");
                    } else {

                        Cart.ShowList();
                        System.out.println("lease enter the number of product you want to remove");
                        int choice1 = 1;
                        do {
                            choice1 = input.nextInt();
                            if (choice1 > Cart.GetSize() || choice1 < 1) {
                             ErrorMessage();
                            }
                        } while (choice1 > Cart.GetSize() || choice1 < 1);

                        System.out.println("please enter the Quntity you want ");
                        int Q = input.nextInt();
                        Cart.RemoveFromCart(Cart.getCart().get(choice1), Q);
                    }

                    break;
                case 3:
                    if (Cart.getCart().isEmpty()) {
                        System.out.println("Sorry you can not print the invoice because the cart is Empty ");
                    } else {
                       
                     Cart.ListToarray();
                   Order.setCart(Cart);
                   Order.setCoustmer(customer);
                   invoice = new invoice(Order);
                   invoice.creatInvoice();
                   // ------
                   discount.quantityDiscount(invoice.getTotalPrice(),invoice.getProducts());
                   discount.dayDiscount(invoice.getTotalPrice(),discount.getDaysList());
                   // ------
                   invoice.setDiscount(discount);
                   invoice.PrintInvoice();
                   test2=false;
                    }

                    break;
            }
        }
         
   
   
  //-----------------------------------------------------------------------------------
  // Drivers: 
  
               //  Drivers currently enrolled in the system : 
         if(DriversInsert==false) {    
        DriversEnrolled(PersonalInformation);
         DriversInsert=true;}
        PersonalInformation.sortList();
        location location = new location(userArea_int, PersonalInformation, store[0].getLocation());
        System.out.println(" ___________________________________________________");
        System.out.println("|                 Available drivers                 |  ");
        System.out.println("| __________________________________________________|");

        if (PersonalInformation.getSizeOfarry() == 0) {
            System.out.println("Sorry ):, there are no drivers available at the moment, try again later");
            System.exit(0);
        } else {
            int driver;
            h:
            do {

                System.out.println("  Please Choose a driver to deliver your order : ");
                DynamicArray driverName = PersonalInformation.search(PersonalInformation, "Available", 5, 1);
                DynamicArray driverRating = PersonalInformation.search(PersonalInformation, "Available", 5, 7);
                System.out.println("---------------------------------------------");
                driverName.printArray2(driverName, driverRating);
                System.out.println("---------------------------------------------");
                driver = input.nextInt();
                if (driver > PersonalInformation.getSizeOfarry() || driver < 1) {
                    ErrorMessage();
                    continue h;
                }

            } while (driver > PersonalInformation.getSizeOfarry() || driver < 1);
        }
            System.out.println("-------------------------------------------------------------------");
            System.out.println("        *");
            System.out.println("       *");
            System.out.println("      *      YOUR ORDER HAS BEEN APPROVED , DELIVERY IS COMING  ");
            System.out.println(" *   *");
            System.out.println("   *");
            System.out.println("-------------------------------------------------------------------");
           
        
            System.out.println(" ___________________________________________________");
            System.out.println("|                       Rating                      |  ");
            System.out.println("| __________________________________________________|");
            int rating;
            do {
                System.out.println("[1] :");
                System.out.println("How was the driver service?");
                System.out.println("5] * * * * *\n4] * * * *\n3] * * * \n2] * * \n1] *");
                System.out.println("Enter the rating number - FROM ZERO TO FIVE-");
                rating = input.nextInt();

                if (rating < 0.0 || rating > 5.0) {
                    ErrorMessage();
                }

            } while (rating < 1.0 || rating > 5.0);

            
  
          //----------------------------------------------------------------
          //User Rating 
        Boolean isNotValidRate = true;
        double userRateingD;
        String comment;

        while (isNotValidRate) {
            System.out.println("[2] :");
            System.out.println("\nPlease (RATE) the quality of service for ( " + specificStore.getName().toUpperCase() + " ) products, by entering number from 0 to 5 :\n");

            userRateingD = input.nextDouble();

            //The user will only enter (if-else) if he enter less or equal 5
            if (userRateingD >= 0 && userRateingD <= 5) {
                System.out.print("\nThanks for rating! we\'ll work to improve our service to your good satisfaction,\n"
                        + "Please can you give us a COMMENT about the reason for your rating :");
                comment = input.nextLine();
                specificStore.averageRating(userRateingD);
                isNotValidRate = false;
            } else {
                System.out.println("************************** *");
                System.out.println("                             *");
                System.out.println("                               *");
                System.out.println("******      Sorry               *");
                System.out.println("****    It Must be a number      *      O");
                System.out.println("          between 0 to 5!         *");
                System.out.println("                                  *");
                System.out.println("*****   Please enter again        *     O");
                System.out.println("****                             *");
                System.out.println("                                *");
                System.out.println("     * * *         * * *      *");
                System.out.println("** *       * *** *       * **");
                System.out.println("   *       *     *       *   ");
                System.out.println("     * * *         * * *    \n ");
            }
        }

          //-----------------------------------------------------------------
        
        
        System.out.println(" - THANK YOU FOR USING OUR PROGRAM -");
        System.out.println("       __________________                     ");
        System.out.println("     /              |     \\                  ");
        System.out.println("    /               |      \\                 ");
        System.out.println("   /                |       \\                ");
        System.out.println("  /                 |        \\               ");
        System.out.println(" /__________________|_________\\              ");
        System.out.println("|                              *              ");
        System.out.println("|                                  *          ");
        System.out.println("|           W E L L C O M E           *       ");
        System.out.println("|     To The Order Delivery System     *      ");
        System.out.println("|                                      *      ");
        System.out.println("|                                     *       ");
        System.out.println("|                                    *        ");
        System.out.println(" ------*-------* *** *-------*-----*          ");
        System.out.println("       *       *     *       *                ");
        System.out.println("         * * *         * * *                  ");
                    
            boolean homepage = true;
            while (homepage)//while loop if the user enters an unacceptable value, the question will be asked again
            {//to open the loop while block
                System.out.println("\n- DO YOU WANT TO ORDER? \n"
                    + "[1] Yes\n"
                    + "[2] EXIT");
                int home = input.nextInt();//allows the user to enter the answer
                switch (home) {
                    case 1:
                         R.getORDERS().addNode(Order);
                         R.getOrderHistory().push(Order);
                        homepage = false;
                        break;
                    case 2:
                        R.getORDERS().addNode(Order);
                        R.getOrderHistory().push(Order);
                        R.CreatReport(store);
                        homepage = false;
                        O=-2;
                        break;
                    default:
                       ErrorMessage();

                }

            }
  
        
    }
    }
    public static String CheckName(String p) {
        Scanner input = new Scanner(System.in);
        boolean CheckName = true;
        String name;
        CheckName:
        do {
            System.out.println("   Please enter you'r " + p + " \n (write the name without writing numbers) ");
            name = input.next();
            CheckName = name.matches("[a-zA-Z]+");
            if (CheckName == false) {

                System.out.println("************************** *");
                System.out.println("                             *");
                System.out.println("                               *");
                System.out.println("******      Sorry               *");
                System.out.println("**** The entered " + p + "     *      O");
                System.out.println("           is incorrect           *");
                System.out.println("                                  *");
                System.out.println("*****   Please enter again        *     O");
                System.out.println("****                             *");
                System.out.println("                                *");
                System.out.println("     * * *         * * *      *");
                System.out.println("** *       * *** *       * **");
                System.out.println("   *       *     *       *   ");
                System.out.println("     * * *         * * *    \n ");
                
                continue CheckName;
            }
        } while (CheckName == false);

        return name;

    } 
  public static void ErrorMessage (){
                System.out.println("************************** *");
                System.out.println("                             *");
                System.out.println("                               *");
                System.out.println("******      Sorry               *");
                System.out.println("**** You must choose a number    *      O");
                System.out.println("from the displayed numbers only   *");
                System.out.println("                                  *");
                System.out.println("******Please enter a valid number *     O");
                System.out.println("****                             *");
                System.out.println("                                *");
                System.out.println("     * * *         * * *      *");
                System.out.println("** *       * *** *       * **");
                System.out.println("   *       *     *       *   ");
                System.out.println("     * * *         * * *    \n ");

  }
    
    

     public static void presentAllStore(Store[] store) {
        int y = 1;
//        Rating rating = new Rating();
        for (int i = 0; i < 5; i++, y++) {
            System.out.println("                    [ " + y + " ]");
            System.out.println(" _______________________________________________ ");
            System.out.println("|                  " + store[i].getName() + "                   ");
            System.out.println("|_______________________________________________");
            System.out.println("| Classification : " + store[i].getClassification());
            System.out.println("|                                            ");
            System.out.println("| Work Hours     : (from) " + store[i].getWorkHour_Start());
            System.out.println("|                : ( to ) " + store[i].getWorkHour_End());
            System.out.println("|                                            ");
            System.out.println("| Status         : " + store[i].getStatus_String());
            System.out.println("|                                            ");
            System.out.println("| Rating         : " + store[i].getAverageRating_D() + " / 5.0");
            System.out.println("|                 " + store[i].getRating_Stars());
            System.out.println("|_______________________________________________\n\n");
        }

    }

    
   

    
    public static void DriversEnrolled(ListOfInformation PersonalInformation) {
        //1:
        DriverInformation driver_1 = new DriverInformation(PersonalInformation, "Ahmed Mohsen       ", "30", "0598124477", "AhmedMohsen@gmil.com     ", "Al-Masfalah");
        //2:
        DriverInformation driver_2 = new DriverInformation(PersonalInformation, "Khaled Al-Ghamdi   ", "22", "0512768854", "KhaledAl_Ghamdi@gmil.com ", "Al- Sharaie");
        //3:
        DriverInformation driver_3 = new DriverInformation(PersonalInformation, "Muhammad Al-Rifai  ", "25", "0574322004", "MuhammadAl_Rifai@gmil.com", "Al-Otaibi ");
        //4:
        DriverInformation driver_4 = new DriverInformation(PersonalInformation, "Salem Al-Tuwaijri  ", "31", "0520321966", "SalemAl_Tuwaijri@gmil.com", "Al- Shawgiyah");
        //5:
        DriverInformation driver_5 = new DriverInformation(PersonalInformation, "Hamad Al-Maliki    ", "27", "0548954443", "HamadAl_Maliki@gmil.com  ", "Al- Azizia");
        //6:
        DriverInformation driver_6 = new DriverInformation(PersonalInformation, "Saleh Hosny        ", "36", "0509185011", "SalehHosny@gmil.com      ", "Al-Umrah");

        //7:
        DriverInformation driver_7 = new DriverInformation(PersonalInformation, "Nawaf Al-Salmi     ", "21", "0512768854", "NawafAl-Salmi@gmil.com   ", "Al- Sharaie");
        //8:
        DriverInformation driver_8 = new DriverInformation(PersonalInformation, "Majid Al-Dosari    ", "41", "0528653421", "MajidAl-Dosari@gmil.com  ", "Al-Masfalah");
        //9:
        DriverInformation driver_9 = new DriverInformation(PersonalInformation, "Rami Al-Ahmadi     ", "33", "0533187654", "Rami Al-Ahmadi@gmil.com  ", "Al- Azizia");
        //10:
        DriverInformation driver_10 = new DriverInformation(PersonalInformation, "Muhammad Al-Maliki", "44", "0554219876", "MuhammadAl-Maliki@gmil.com", "Al- Shawgiyah");
        //11:
        DriverInformation driver_11 = new DriverInformation(PersonalInformation, "Anas Al-Omari     ", "31", "0544331985", "AnasAl-Omari@gmil.com    ", "Al-Otaibi");
        //12:
        DriverInformation driver_12 = new DriverInformation(PersonalInformation, "Majid Al-Maliki   ", "33", "0555438712", "MajidAl-Maliki@gmil.com  ", "Al- Azizia");
        //13:
        DriverInformation driver_13 = new DriverInformation(PersonalInformation, "Hamad Hosny       ", "44", "0567941390", "Hamad Hosny@gmil.com      ", "Al-Umrah");

        //14:
        DriverInformation driver_14 = new DriverInformation(PersonalInformation, "Mustafa Al-Rubaie ", "45", "050086112", "MustafaAl-Rubaie@gmil.com ", "Al- Sharaie");
      // 15:
        DriverInformation driver_15 = new DriverInformation(PersonalInformation, "Omari Hosny   ", "22", "0587351985", "OmariHosny@gmil.com    ", "Al-Otaibi");


    
}
    
 
    
}
