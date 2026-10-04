package at.htlle.pos.car.exceptions;

public class CarExceedingMaxSpeedException extends Exception{
    public CarExceedingMaxSpeedException() {
    }

    public CarExceedingMaxSpeedException(String message) {
        super(message);
    }

    public CarExceedingMaxSpeedException(String message, Throwable cause) {
        super(message, cause);
    }
}
