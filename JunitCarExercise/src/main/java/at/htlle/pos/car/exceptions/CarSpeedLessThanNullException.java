package at.htlle.pos.car.exceptions;

public class CarSpeedLessThanNullException extends Exception{
    public CarSpeedLessThanNullException() {
    }

    public CarSpeedLessThanNullException(String message) {
        super(message);
    }

    public CarSpeedLessThanNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
