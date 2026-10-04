package at.htlle.pos.car.exceptions;

public class CarEmptyFuelTankException extends Exception {
    //usage:
    //CarEmptyFuelTankException myException = new CarEmptyFuelTankException();
    public CarEmptyFuelTankException() {
    }

    public CarEmptyFuelTankException(String message) {
        super(message);
    }

    //usage:
    //try{
    //     car.brake();
    //} catch (CarBrakesFailedException ex) {
    // throw new CarFuelTankException("In addition to the failed brakes - your tank is empty", ex):
    public CarEmptyFuelTankException(String message, Throwable cause) {
        super(message, cause);
    }
}

