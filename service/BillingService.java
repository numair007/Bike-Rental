package service;



import entity.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BillingService {
    Map<String, Customer> customers;
    Map<String, Rental> rentals;
    static BillingService billingService;
    int duration  = 15;

    BillingService(){
        customers = new HashMap<>();
        rentals = new HashMap<>();
    }

    public static BillingService getBillingServiceInstance(){
        if(billingService == null) billingService = new BillingService();
        return billingService;
    }

    public void addCustomer(Customer customer){
        customers.put(customer.getId(), customer);
    }

    public void rentProductToCustomer(Product product, Customer customer){
        product.rentOutProduct();
        LocalDate startDate = LocalDate.now();
        LocalDate dueDate = startDate.plusDays(duration);
        Rental rental  = new Rental(product, customer, startDate, dueDate, product.calculateRental());
        rentals.put(rental.getId(), rental);
        customer.addProductToRentals(rental);

    }

    public int calculateCharge(Customer customer){
       return customer.calculateCharge();
    }

    public List<Product> rentedProductsToCustomer(Customer customer){
        return customer.rentedProducts();
     }

     public List<Customer> overdueRentCustomers(){
        int v = 5;
        return rentals.values().stream().filter(it -> 
            it.isOverdue()
        ).map(it -> it.customer).collect(Collectors.toList());
     }



}
