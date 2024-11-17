import entity.*;
import service.*;

public class Driver {
    
    public static void main(String[] args){
        RentalService rentalService = new RentalService();
        Product bikeProductSmall = new Bike(BikeSize.SMALL);
        Product bikeProductMedium = new Bike(BikeSize.MEDIUM);
        Product bikeProductLarge = new Bike(BikeSize.LARGE);

        Product scooterElectric = new Scooter(ScooterType.ELECTRIC);
        Product scooterGas = new Scooter(ScooterType.GAS);

        rentalService.addProduct(bikeProductSmall);
        rentalService.addProduct(bikeProductMedium);
        rentalService.addProduct(bikeProductLarge);
        rentalService.addProduct(scooterElectric);
        rentalService.addProduct(scooterGas);


        Customer c1 = new Customer("c1");
        Customer c2 = new Customer("c2");
        Customer c3 = new Customer("c3");

        rentalService.addCustomer(c1);
        rentalService.addCustomer(c2);
        rentalService.addCustomer(c3);

        System.out.println(rentalService.getAvaialbleProducts());
        System.out.println(rentalService.getSmallBikes());




        rentalService.rentOutProduct(bikeProductLarge, c3);
        rentalService.rentOutProduct(scooterElectric, c3);


        


    }
}
