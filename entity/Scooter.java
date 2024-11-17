package entity;

import java.util.UUID;

public class Scooter extends Product{
    ScooterType scooterType;

    public Scooter(ScooterType scooterType){
        super(UUID.randomUUID().toString());
        this.scooterType = scooterType;
    }

    @Override
        public int calculateRental() {
           return 10;
        }
}
