package at.htlle.pos.car.exceptions;

public class CarNoSpeedSetException extends Exception{
    public CarNoSpeedSetException() {
    }

    public CarNoSpeedSetException(String message) {
        super(message);
    }

    public CarNoSpeedSetException(String message, Throwable cause) {
        super(message, cause);
    }
}
