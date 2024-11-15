package entity;

import java.time.*;
import java.util.UUID;

public class Rental {
    public String rentalId;
    public Product product;
    public Customer customer;
    public LocalDate startDate;
    public LocalDate dueDate;
    public int ratePerDay;

    public Rental(Product product, Customer customer, LocalDate startDate, LocalDate dueDate, int rate){
        this.rentalId = UUID.randomUUID().toString();
        this.product = product;
        this.customer = customer;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.ratePerDay = rate;
    }
    public String getId(){
        return this.rentalId;
    }
    public boolean isOverdue(){
        LocalDate today = LocalDate.now();
        return today.isAfter(dueDate);
    }
}
