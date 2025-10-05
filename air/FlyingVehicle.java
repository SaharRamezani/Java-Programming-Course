public class FlyingVehicle extends Vehicle {
    String fuel;
    int numberOfFins;
    int numberOfWheels;
    String steeringWheel;
    
    public FlyingVehicle(String name, int price, 
                        int numberOfSeats, int maxSpeed, 
                        String fuel, int numberOfFins, 
                        int numberOfWheels, String steeringWheel) {
        super(name, price, numberOfSeats, maxSpeed);
        this.fuel = fuel;
        this.numberOfFins = numberOfFins;
        this.numberOfWheels = numberOfWheels;
        this.steeringWheel = steeringWheel;
    }
}
