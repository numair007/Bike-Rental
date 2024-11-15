package entity;


public class Scooter extends Product{
    ScooterType scooterType;

    Scooter(String id, ScooterType scooterType){
        super(id);
        this.scooterType = scooterType;
    }

    @Override
    int calculateRental() {
       return 10;
    }
}
