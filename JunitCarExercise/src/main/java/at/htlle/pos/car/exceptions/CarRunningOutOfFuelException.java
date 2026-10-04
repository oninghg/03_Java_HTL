package at.htlle.pos.car.exceptions;

public class CarRunningOutOfFuelException extends Exception{
    public CarRunningOutOfFuelException() {
    }

    public CarRunningOutOfFuelException(String message) {
        super(message);
    }

    public CarRunningOutOfFuelException(String message, Throwable cause) {
        super(message, cause);
    }
}
