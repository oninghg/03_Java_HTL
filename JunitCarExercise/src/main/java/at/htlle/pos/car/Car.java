package at.htlle.pos.car;


import at.htlle.pos.car.exceptions.*;

public class Car {
    // initialized via constructor parameters
    private final double maxSpeed;
    private final double maxFuelLevel;
    private final double consumptionPerKm;

    // implicitly initialized with during instantiation 0;
    private double currentSpeed;
    private double currentFuelLevel;
    private boolean isEngineRunning;
    private double mileageInKm;

    /**
     * The constructor initializing the new instance of Car.
     *
     * @param maxSpeed            ... the maximum speed the car can go.
     * @param maxFuel             ... the maximum amount of fuel the car can hold in its tank
     * @param consumptionPer100km ... fuel consumption per 100km according the specification
     */
    public Car(double maxSpeed, double maxFuel, double consumptionPer100km) {
        this.maxSpeed = maxSpeed;
        this.maxFuelLevel = maxFuel;
        // a new car with a full tank ;-) not to bother with initial refuelling
        this.currentFuelLevel = maxFuelLevel;
        this.consumptionPerKm = consumptionPer100km / 100.0;
    }

    /**
     * starts the engine if there is any fuel in the tank.
     *
     * @throws CarEmptyFuelTankException ... when the car's tank is empty,
     *                                   the engine cannot be started
     */
    public void startEngine() throws CarEmptyFuelTankException {
        if (Double.compare(0.0, currentFuelLevel) == 0)
            throw new CarEmptyFuelTankException();
        if (!isEngineRunning) {
            isEngineRunning = true;
            System.out.println("Car engine started!");
        }
    }

    /**
     * stops the car's engine if the car's speed is zero.
     *
     * @throws CarStillMovingException ... when the car is stil moving it's too dangerous to stop teh engine.
     */
    public void stopEngine() throws CarStillMovingException {
        if (Double.compare(0.0, currentSpeed) < 0) {
            throw new CarStillMovingException("Car is still moving! Please brake first.");
        }
        isEngineRunning = false;

    }

    /**
     * accelerates the car by increasing its speed  about the passed speedIncrement.
     *
     * @param speedIncrement ... the increment the car's speed is to be increased by
     * @throws CarEngineNotRunningException ... when the engine is not up and running,
     *                                      no acceleration can be fulfilled
     * @throws IllegalArgumentException     ... then the passed argument is negative
     * @throws CarExceedingMaxSpeedException   ... when the passed speedIncrement would exceed
     *                                       the car's maxSpeed if used for acceleration.
     */
    public void accelerate(double speedIncrement) throws CarExceedingMaxSpeedException, CarEngineNotRunningException {
        if (!isEngineRunning)
            throw new CarEngineNotRunningException("The car's engine is not up and running! isEngineRunning='false'");
        if (Double.compare(0.0, speedIncrement) > 0)
            throw new IllegalArgumentException("Passed parameter 'speedIncrement' must not be "
                    + "negative! speedIncrement='" + speedIncrement + "'");
        if (currentSpeed + speedIncrement > 200){
            throw new CarExceedingMaxSpeedException("The car can not exceed the maxSpeed of 200");
        }

        currentSpeed =+ speedIncrement;   //Adds the speedIncrement to the currentSpeed of the car
    }



    /**
     * slows the car down about the passed amount.
     *
     * @param speedDecrement ... the amount (must be positive) to decrease the current speed.
     * @throws IllegalArgumentException ... if a negative value is passed
     * @throws CarSpeedLessThanNullException ... if 'speedDecrement' maked the 'currentSpeed' negative
     */
    public void brake(double speedDecrement) throws IllegalArgumentException, CarSpeedLessThanNullException {
        if (Double.compare(0, speedDecrement) > 0)
            throw new IllegalArgumentException("Passed parameter 'speedDecrement' must not be negative!");
        if(currentSpeed - speedDecrement < 0){
            throw new CarSpeedLessThanNullException("'currentSpeed' cannot be less than null");
        }
        currentSpeed = currentSpeed - speedDecrement;     //Removes the speedDecrement to the currentSpeed of the car
    }

    /**
     * refills the tank with the passed fuelVolume
     *
     * @param fuelVolume ... which is added to the current fuel Level in the tank
     * @throws CarExceedingMaxTankCapacity ... is thrown when the currentFuelLevel
     *                                     plus the passed fuelVolume to be refilled would exceed the tank.
     */
    public void refuel(double fuelVolume) throws CarExceedingMaxTankCapacity, CarEngineRunningException {
        if (isEngineRunning)
            throw new CarEngineRunningException("Refueling with a running engine is prohibited!");
        if (Double.compare(currentFuelLevel + fuelVolume, maxFuelLevel) > 0)
            throw new CarExceedingMaxTankCapacity("Cannot exceed max fuel capacity!");
        currentFuelLevel += fuelVolume;
    }

    /**
     * moves the car and adjusts the mileage (increase) as well as
     * the fuelLevel (decrease) accordingly
     *
     * @param distanceInKm ... the distance the car should move; the value is added to its mileage
     * @throws CarRunningOutOfFuelException when the distance exceeds
     *                                      the max. distance which is possible with the available fuel.
     */
    public void drive(double distanceInKm) throws CarRunningOutOfFuelException, CarEngineNotRunningException, CarNoSpeedSetException {
        if (!isEngineRunning) throw new CarEngineNotRunningException("Car engine must have been started!");
        if(Double.compare(0.0, currentSpeed)==0) throw new CarNoSpeedSetException("Car must have set a speed above 0!");
        if (Double.compare(consumptionPerKm * distanceInKm, currentFuelLevel) >= 0) {
            mileageInKm += currentFuelLevel / consumptionPerKm;
            currentFuelLevel = 0.0;
            currentSpeed = 0.0;
            isEngineRunning = false;
            throw new CarRunningOutOfFuelException("Car runs out of fuel!");
        } else {
            mileageInKm += distanceInKm;
            currentFuelLevel -= distanceInKm * consumptionPerKm;
        }
    }

    public double getConsumptionPerKm() {
        return consumptionPerKm;
    }

    public double getMileageInKm() {
        return mileageInKm;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public boolean isEngineRunning() {
        return isEngineRunning;
    }

    public double getMaxFuelLevel() {
        return maxFuelLevel;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
}