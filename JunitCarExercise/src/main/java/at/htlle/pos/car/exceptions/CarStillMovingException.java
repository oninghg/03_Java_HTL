package at.htlle.pos.car.exceptions;

public class CarStillMovingException extends Exception {
    public CarStillMovingException() {
    }

    public CarStillMovingException(String message) {
        super(message);
    }

    public CarStillMovingException(String message, Throwable cause) {
        super(message, cause);
    }
}
