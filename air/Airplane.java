public class Airplane extends FlyingVehicle {
    String airline;
    int numberOfCrew;
    String captain;

    public Airplane(String name, int price, 
                    int numberOfSeats, int maxSpeed, 
                    String fuel, int numberOfFins, 
                    int numberOfWheels, String steeringWheel,
                    String airline, int numberOfCrew, 
                    String captain) {
        super(name, price, numberOfSeats, maxSpeed, fuel, numberOfFins, numberOfWheels, steeringWheel);
        this.airline = airline;
        this.numberOfCrew = numberOfCrew;
        this.captain = captain;
    }
}
