package service;


import entity.*;
import java.util.*;
public class InventoryService {
    static InventoryService inventoryService;
    Map<String, Product> products;
    private InventoryService(){
        products = new HashMap<>();
    }

    public static InventoryService getInventoryServiceInstance(){
            if(inventoryService == null) inventoryService = new InventoryService();
            return inventoryService;
    }

    public void addProduct(Product product){
        products.put(product.getId(), product);
        System.out.println("Product "+product.getId()+" added in inventory");
    }

    public Product findProduct(String productId){
        if(!products.containsKey(productId)){

            System.out.println("Product not found");
            return null;
        }
        return products.get(productId);
    }

    public void removeProduct(String productId){
        if(!products.containsKey(productId)){

            System.out.println("Product to be removed not found");
            
        }
        products.get(productId).setProductDamaged();
    }

    public List<Product> renetedOutProducts(){
        Collection<Product> allProducts = products.values();
        List<Product> rentedOut = new ArrayList<>();
        for(Product product: allProducts){
            if(product.isRented()){
                rentedOut.add(product);
            }
        }

        return rentedOut;
    }
    public List<Product> availableProducts(){
        Collection<Product> allProducts = products.values();
        List<Product> rentedOut = new ArrayList<>();
        for(Product product: allProducts){
            if(!product.isRented() && !product.isDamaged()){
                rentedOut.add(product);
            }
        }

        return rentedOut;
    }
    public int findAllSmallBikes(){
        Collection<Product> allProducts = products.values();
        int count = 0;
        for(Product product: allProducts){

            if(product instanceof Bike){
                Bike bike = (Bike)product;
                if(bike.bikeSize == BikeSize.SMALL){
                   count++;
                }
                
            }
        }

        return count;
    }


}
