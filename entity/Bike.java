package entity;

public class Bike extends Product{
    public BikeSize bikeSize;

    Bike(String id, BikeSize bikeSize){
        super(id);
        this.bikeSize = bikeSize;
    }

    @Override
    int calculateRental() {
       return 10;
    }
}