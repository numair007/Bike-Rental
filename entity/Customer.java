package entity;

import java.util.*;
import java.util.stream.Collectors;
public class Customer {
    String id;
    String name;
    Map<String, Rental> rentals;

    public Customer( String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        rentals = new HashMap<>();
    }

    public String getId(){
        return this.id;
    }

    public void addProductToRentals(Rental rental){
        rentals.put(rental.getId(), rental);
    }
    public void removeProductRental(Rental rental){
        rentals.remove(rental.getId());
    }
    public int calculateCharge(){
        int tot = 0;

        for(Rental rental : rentals.values()){
            tot += rental.ratePerDay;
        }

        return tot;
    }

    public List<Product> rentedProducts(){
        return rentals.values().stream().map(it -> it.product).collect(Collectors.toList());
    }
}
