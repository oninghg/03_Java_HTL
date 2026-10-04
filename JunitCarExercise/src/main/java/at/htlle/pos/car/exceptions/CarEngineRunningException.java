package at.htlle.pos.car.exceptions;

public class CarEngineRunningException extends Exception{
    public CarEngineRunningException() {
    }

    public CarEngineRunningException(String message) {
        super(message);
    }

    public CarEngineRunningException(String message, Throwable cause) {
        super(message, cause);
    }
}
