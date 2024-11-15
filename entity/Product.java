package entity;

public abstract class Product {
   String id;
   boolean  isAvailable;
   boolean isDamaged;
   int rentalPrice;
    Product(String id){
        this.id = id;
        isAvailable = true;
        isDamaged = false;
    }

   public abstract int calculateRental();
   public String getId(){
    return this.id;
   }
   public boolean isDamaged(){
    return isDamaged;
   }
   public void setProductDamaged(){
    isDamaged = true;
   }

   public boolean isRented(){
    return !isAvailable;
   }
   public void rentOutProduct(){
    isAvailable = false;
   }
   public void returnProduct(){
    isAvailable = true;
   }
    
}

