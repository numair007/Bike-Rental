package entity;

import java.util.UUID;

public class Bike extends Product{
    public BikeSize bikeSize;

    public Bike(BikeSize bikeSize){
        super(UUID.randomUUID().toString());
        this.bikeSize = bikeSize;
    }

    @Override
        public
        int calculateRental() {
           return 10;
        }
}