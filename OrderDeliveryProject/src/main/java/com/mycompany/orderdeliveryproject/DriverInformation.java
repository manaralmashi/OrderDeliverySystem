
package com.mycompany.orderdeliveryproject;

/**
 *9
 * @author Murooj
 */
public class DriverInformation {
    
    //-------data feild----------
    
    private static final String SystemID = "0987";       // The unified identification number of the system
    private static int serialID = 10;                    //Drivers serial identification number                
    private String DefaultStatus = "Available";        //The default state of the driver
        private double  AveragRating ;
  
    
   //-------constructors----------
    
    public DriverInformation() {
    }

    public DriverInformation(ListOfInformation PersonalInformation, String name, String age, String number, String email, String adrees) {
        
        String DriverID = SystemID + serialID;
        /*
        index 0 --> Driver ID
        index 1 --> Driver Name
        index 2 --> Driver age
        index 3 --> Driver's number
        index 4 --> Driver's email
        index 5 --> DefaultStatus
        index 6 --> driver address
        index 7 --> Rating 
        
        
        */
        String[] Delivery_1 = {DriverID, name, age, number, email, DefaultStatus, adrees ,Rating( PersonalInformation,DriverID)};
        PersonalInformation.addLast(PersonalInformation, Delivery_1);
        serialID++;

    }
   //-------Getters methods----------
    public static String getSystemID() {
        return SystemID;
    }

    public static int getSerialID() {
        return serialID;
    }

    public String getDefaultStatus() {
        return DefaultStatus;
    }
     public String getAveragRating() {
        String s = AveragRating+"";
        return s;
    }
      public double getAveragRating2() {
    
        return AveragRating;
    
    }
    //-------setters methods----------
    public static void setSerialID(int serialID) {
        DriverInformation.serialID = serialID;
    }

    public void setDefaultStatus(String DefaultStatus) {
        this.DefaultStatus = DefaultStatus;
    }
    
      public void setAveragRating(double AveragRating) {
     
    this.AveragRating=AveragRating ;
    }

  public String Rating (ListOfInformation PersonalInformation,String DriverID) {

    switch (DriverID) {
        case "098710":
        case "098713":
           setAveragRating(4.5);
            
            break;
        case "098711":
        case "098715":
             setAveragRating(4.8);
            break;
        case "098714":
        case "098716":
        case "098725":
             setAveragRating(4.8);
            break;
        case "098717":
        case "098718":
             setAveragRating(3.8);
            break;
        case "098719":
        case "098720":
             setAveragRating(4.0);
            break;
        case "098722":
        case "098723":
             setAveragRating(3.5);
            break;
        case "098721":
        case "098724":
             setAveragRating(3.0);

            break;
        default:
            break;
    }
    return getAveragRating();
    
}
  
  
 
  
  
  
  
  
  
  
  
  
  
  
  

   public  static void  Driversٌeport (ListOfInformation PersonalInformation) {
    System.out.println("                   Information of all deceased drivers in the system according to their regions                            ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------- ");
        System.out.println("                                   { THE  FIRST AREA : Al-Masfalah }                                               ");
        System.out.println("-----------[1]----------------------------------------[2]-------------------------------------------------------------------");
        AREA("Al-Masfalah", PersonalInformation);
        System.out.println("____________________________________________________________________________________________________________________________");
        
        System.out.println("                                   { THE SECOND AREA : Al-Otaibi  }                               ");
        System.out.println("-----------[1]----------------------------------------[2]-------------------------------------------------------------------");
        AREA("Al-Otaibi", PersonalInformation);
        System.out.println("____________________________________________________________________________________________________________________________");

        System.out.println("                                   {  THE THIRD AREA : Al- Shawgiyah  }                               ");
        System.out.println("-----------[1]----------------------------------------[2]-------------------------------------------------------------------");
        
        AREA("Al- Shawgiyah", PersonalInformation);
        System.out.println("____________________________________________________________________________________________________________________________");

        System.out.println("                                   { THE FOURTH AREA : Al- Sharaie  }                               ");
        System.out.println("-----------[1]----------------------------------------[2]---------------------------------------------[3]-------------------");
        
        AREA("Al- Sharaie", PersonalInformation);
        System.out.println("____________________________________________________________________________________________________________________________");
        System.out.println("                                   { THE FIFTH AREA : Al- Azizia  }                               ");
        System.out.println("-----------[1]----------------------------------------[2]---------------------------------------------[3]-------------------");
        
        AREA("Al- Azizia", PersonalInformation);
        System.out.println("____________________________________________________________________________________________________________________________");

        System.out.println("                                    { THE SIXTH AREA : Al-Umrah  }                               ");
        System.out.println("-----------[1]----------------------------------------[2]-------------------------------------------------------------------");
        
        AREA("Al-Umrah", PersonalInformation);
        System.out.println("____________________________________________________________________________________________________________________________");

  
 
      
  }
 public  static void AREA (String AREA,ListOfInformation PersonalInformation)   {
     
      DynamicArray a = PersonalInformation.search(PersonalInformation, AREA, 6, 1);

        DynamicArray b = PersonalInformation.search(PersonalInformation, AREA, 6, 2);

        DynamicArray c = PersonalInformation.search(PersonalInformation, AREA, 6, 3);

        DynamicArray d = PersonalInformation.search(PersonalInformation, AREA, 6, 4);

        DynamicArray e = PersonalInformation.search(PersonalInformation, AREA, 6, 7);
        a.printArray3("NAME");
        b.printArray3("AGE");
        c.printArray3("MOBILE NUMBER");
        d.printArray3("EMAIL");
        e.printArray3("RATING");
     
     
     
     
     
     
     
     
 }
    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
