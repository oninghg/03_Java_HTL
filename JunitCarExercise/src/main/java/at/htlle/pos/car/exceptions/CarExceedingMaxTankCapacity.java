package at.htlle.pos.car.exceptions;

public class CarExceedingMaxTankCapacity extends Exception{             //Mehrere Konstruktoren weil man dann auswählen kann welchen man
    public CarExceedingMaxTankCapacity() {                              //verwendet wegen Parametern
    }

    public CarExceedingMaxTankCapacity(String message) {
        super(message);
    }

    public CarExceedingMaxTankCapacity(String message, Throwable cause) {
        super(message, cause);
    }
}
