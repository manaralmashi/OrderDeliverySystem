/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;



/**
 *
 * Lamis Mohammed
 */
public class ShoppingCart {
// ------Attribute------
    private LinkedList<Item> Cart = new LinkedList<>();
     private Item[] retriveCart;
// ------Constractor------ 

    /**
     * @Constractor
     */
    public ShoppingCart() {
        
    }
// -------Methods------- 

    /**
     * Getter
     * @return LinkedList<Item>
     */
    public LinkedList<Item> getCart() {
        return Cart;
    }

    /**
     * setter
     * @param Cart
     */
    public void setCart(LinkedList<Item> Cart) {
        this.Cart = Cart;
    }

    /**
     * getter
     * @return Item[]
     */
    public Item[] getRetriveCart() {
        return retriveCart;
    }

    /**
     * setter
     * @param retriveCart
     */
    public void setRetriveCart(Item[] retriveCart) {
        this.retriveCart = retriveCart;
    }

    /**
     * add a product to the list
     * @param product
     */
    public void AddToCart(Item product){
         Cart.Add(product);
    }

    /**
     * 
     * @param product
     * @param Quntity
     */
    public void AddToCart(Item product,int Quntity){
        if (!Cart.Search(product)){ // to add a new item in the cart
         product.setQuantity(Quntity);
         Cart.Add(product);}
        else {                     // if the item already exists, increase the quantity
            int index = Cart.indexOf(product);
            int updateQuntity = Cart.get(index).getQuantity()+ Quntity ;
            Cart.get(index).setQuantity(updateQuntity);
        }
    }

    /**
     * remove a product from the list
     * @param product
     * @return
     */
    public boolean RemoveFromCart(Item product){
       return Cart.remove(product);
    }

    /**
     *
     * @param product
     * @param Quntity
     */
    public void RemoveFromCart(Item product,int Quntity){
         if (product.getQuantity()>Quntity){ // If the user wants to reduce the quantity of a particular item
             int UpdateQuntity= product.getQuantity()-Quntity;
             product.setQuantity(UpdateQuntity);
         }
         else{    // if the user try to remove more than he/she puts in the cart, the item will be deleted from the cart
         Cart.remove(product);
         }
    }

    /**
     * Clear the list
     */
    public void clearCart(){ // if the user wants to remove all items
        Cart.clear();
       }

    /**
     * Getter
     * @return int
     */
    public int GetSize(){
        return Cart.getSize();
    }

   
        
  // --------------- Cart Services ---------------

    /**
     *
     */
        
   public void ShowList(){ // need it to represent the items if the user wants to remove one of them 
       for (int i=0;i<Cart.getSize();i++){
           System.out.println("\n                             ["+(i+1)+"]"+Cart.get(i).getName()+"  \t"+Cart.get(i).getPrice()+"\t"+Cart.get(i).getQuantity());
       }
   }

    /**
     *
     * @return Item[]
     */
    public Item[] ListToarray(){ // to make the retrival process faster, for the invoice, and represnt all the content of the cart before confirming
          retriveCart= new Item[Cart.getSize()]; 
          for(int i=0;i<retriveCart.length;i++){
             retriveCart[i]= Cart.get(i);
         }
          return retriveCart;
      }

    /**
     *
     * @param Code
     * @return boolean
     */
    public boolean ContainProduct(int Code){ // to cheack if a particular item is in the cart or not
       int Found =  search(retriveCart,  Code);
        if(Found>=0){
          return true;
        }
        else
          System.out.println("no, it is not there");
        return false;
    }  

    /**
     *
     * @param items
     * @param code
     * @return int
     */
    public int search(Item items[], int code) { // I modified it to search for a specific product in an array of products 
      int left = 0, right = items.length-1;
			
      while (left <= right) {
      int pivot = (left + right) / 2;
      if (items[pivot].getCode() == code) {
          return pivot;     		// found
      } else {
          if (items[pivot].getCode() < code)
              left = pivot + 1; 	// search right
          else 
	       right = pivot - 1; 	// search left
      }
   }
   return -1;
  }

    /**
     *
     * @param A
     * @param Temp
     * @param head
     * @param tail
     */
    public static void mergesort(Item[] A,Item[] Temp,int head,int tail){ // to sort the items in the array based on the item code
    if (head<tail){
        int Med = (head+tail)/2;
        mergesort(A,Temp,head,Med);
        mergesort(A,Temp,Med+1,tail);
        merge(A, Temp, head, Med + 1, tail);
    }
}

    /**
     *
     * @param a
     * @param tmpArray
     * @param leftPos
     * @param rightPos
     * @param rightEnd
     */
    public static void merge(Item[] a, Item[] tmpArray,
            int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].getCode() <= a[rightPos].getCode()) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }
        while (leftPos <= leftEnd) // Copy rest of first half
        {
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd) // Copy rest of right half
        {
            tmpArray[tmpPos++] = a[rightPos++];
        }
        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    /**
     *
     * @return String
     */
    public String toString(){ // to change the print format
       Item[] temp = new Item[retriveCart.length]; 
       mergesort(retriveCart,temp,0,(retriveCart.length-1));
       StringBuilder ListOfProduct= new StringBuilder();
       for(int i=0; i<retriveCart.length;i++){
           ListOfProduct.append("\n                              "+retriveCart[i].getName()+"  \t"+retriveCart[i].getPrice()+"\t"+retriveCart[i].getQuantity());
       }
       return ListOfProduct.toString();
      }    

    /**
     *
     */
    public void PrintTheCart(){
         System.out.println("                                                                ___");
         System.out.println("                                                               / ");
         System.out.println("                                                              / ");
         System.out.println("                                                             /");
         System.out.println("                    ***************************************");
         System.out.println("                    *                                      * ");
         System.out.println("                    *                                     *       ");
         System.out.println("                     *                                   *         ");
         System.out.println("                      *                                 *          ");
         System.out.println("                        *                              *     ");
         System.out.println("                         *****************************          ");
         System.out.println("                           * *                    * *        ");
         System.out.println("                           * *                    * *        ");


     }
}
