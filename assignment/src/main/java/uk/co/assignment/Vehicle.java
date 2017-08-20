package uk.co.assignment;

public class Vehicle {
    private String registrationNumber;
    private String make;
    private String colour;

    public Vehicle(String registrationNumber, String make, String colour) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.colour = colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public String getMake() {
        return make;
    }

    @Override
    public String toString() {
        return String.format("Reg no:%s, Make:%s, Colour:%s \n", this.registrationNumber, this.make, this.colour);
    }
}
