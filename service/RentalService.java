package service;

import entity.*;
import java.util.*;
public class RentalService {
    BillingService billingService;
    InventoryService inventoryService;

    public RentalService(){
        billingService = BillingService.getBillingServiceInstance();
        inventoryService = InventoryService.getInventoryServiceInstance();
    }

    public void addCustomer(Customer customer){
        billingService.addCustomer(customer);
    }
    public void addProduct(Product product){
        inventoryService.addProduct(product);
    }
    public void removeProduct(Product product){
        inventoryService.removeProduct(product.getId());
    }
    public List<Product> getAvaialbleProducts(){
        return inventoryService.availableProducts();
    }
    public List<Product> getRentedOutProducts(){
        return inventoryService.renetedOutProducts();
    }
    public int getBalanceForCustomer(Customer customer){
        return billingService.calculateCharge(customer);
    }
    public int getSmallBikes(){
        return inventoryService.findAllSmallBikes();
    }
    public List<Customer> getCustomerWithOverdue(){
       return billingService.overdueRentCustomers();
    }
    public void rentOutProduct(Product product, Customer customer){
        billingService.rentProductToCustomer(product, customer);
    }
    public List<Product> getRentedOutProductsToCustomer(Customer customer){
        return billingService.rentedProductsToCustomer(customer);
    }

}
