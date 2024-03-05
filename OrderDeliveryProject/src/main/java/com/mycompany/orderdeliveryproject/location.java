
package com.mycompany.orderdeliveryproject;
/**
 *
 * @author Murooj
 */
public class location {

    //-------data feild---------- 
    private String DistrictName ;  //The name of the main District
    private String Storelocation ; //
    
    
    //-------constructors----------
   public location(int UserLocation ,ListOfInformation PersonalInformation,String []Storelocation){
       
       switch (UserLocation) {
           case 1:
               String[] District_1 = {"Al- Rasifah", "Al- khalidiya", "Al-Masfalah"};
               DistrictName = "Al-Masfalah";
               DeliveryRange(PersonalInformation, DistrictName,Check(District_1,Storelocation));
               
               break;
           case 2:
               String[] District_2 = {"An- Nuzha", "Al-Otaibi","Al-diyafih","Al-Shuhada"};
               DistrictName = "Al-Otaibi";
              DeliveryRange(PersonalInformation, DistrictName,Check(District_2,Storelocation));
               break;
           case 3:
               String[] District_3 = {"Al- Shawgiyah", "Batha Quraish","Al-Shamisi","King Fahd District"};
               DistrictName = "Al- Shawgiyah";
               DeliveryRange(PersonalInformation, DistrictName,Check(District_3,Storelocation));

               break;
           case 4:
               String[] District_4 = {"Al- Sharaie", "Al-Rashidiya","Al-salam","Al-Moghams","Al-Jaarana"};
               DistrictName = "Al- Sharaie";
               DeliveryRange(PersonalInformation, DistrictName,Check(District_4,Storelocation));

               break;
           case 5:
               String[] District_5 = {"Al- Azizia", "An- Naseem","Al- Awali","Abraj Al- Bait","Al-Abediyah","King Abdullah Road"};
               DistrictName = "Al- Azizia";
              DeliveryRange(PersonalInformation, DistrictName,Check(District_5,Storelocation));

               break;
           case 6:
               String[] District_6 = {"An- Nawwariyah", "Al-Tanaim","Al-Umrah","Al-Furqan"};
               DistrictName = "Al-Umrah";
               DeliveryRange(PersonalInformation, DistrictName,Check(District_6,Storelocation));

               break;

          
       }//end switch case 
   
   }
   
   
    //-------method ----------
   
   /**
     * Creates a Method Method to checks that the location of the user, the driver, 
     * and the store are compatible, and calls the method that changes the state of the 
     * driver according to the result of the condition.
     *
     * @param DistrictName  The name of the neighborhood in which the user is located
     * @param Storelocation The main District in which the store is located
     *
     */
   
   public void DeliveryRange( ListOfInformation PersonalInformation, String DistrictName,String Storelocation ){
     
     if (PersonalInformation.search(PersonalInformation ,DistrictName, 6, 0)!=null||Storelocation!=null) {
       PersonalInformation.DriverStatus(PersonalInformation ,DistrictName );
       PersonalInformation.DriverStatus(PersonalInformation ,Storelocation );
     }
   
    
      
      }
     /**
     *Method to verify that the store is located in one of the sub-districts of the main neighborhood
     * @param District
     * @param Storelocation
     * @return  name of the main District
       */
  
   public String Check (String []District ,String[]Storelocation ){
     for (int i = 0 ; i<District.length;i++){
                  for (int j = 0 ; j<Storelocation.length;j++){
                    if (District[i]==Storelocation[j])
                    {
                    this.Storelocation = DistrictName;
                        
                    }
                     
               }}  
        return DistrictName;
   }
       
       
       
       
       
   }
   
   
   
   
   
   
   
   

