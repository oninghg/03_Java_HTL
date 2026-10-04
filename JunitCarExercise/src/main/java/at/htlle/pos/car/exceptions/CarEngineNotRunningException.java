package at.htlle.pos.car.exceptions;

public class CarEngineNotRunningException extends Exception{
    public CarEngineNotRunningException() {
    }

    public CarEngineNotRunningException(String message) {
        super(message);
    }

    public CarEngineNotRunningException(String message, Throwable cause) {
        super(message, cause);
    }
}
