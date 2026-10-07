package at.htlle.pos.car;

import at.htlle.pos.car.exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.CharArrayReader;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    //    1. Setup:
//    Erstellen Sie ein neues JUnit-Testprojekt in Ihrer IDE.
//    Fügen Sie die Klasse Car zu Ihrem Projekt hinzu.
//    Erstellen Sie eine neue Testklasse namens CarTest.
//
    private final double maxSpeed = 200.0;
    private final double maxFuel = 65.0;

    private final double consumption = 5.5;
    private Car car;

    @BeforeEach
    void setup() {
        car = new Car(maxSpeed, maxFuel, consumption);
    }

    @Test
    void testCarConstructor() {
        assertNotNull(car);
        assertEquals(maxFuel, car.getMaxFuelLevel());
        assertEquals(maxSpeed, car.getMaxSpeed());

        // must have been initialized by the constructor
        assertFalse(car.isEngineRunning());
        assertEquals(car.getMaxFuelLevel(), car.getCurrentFuelLevel());
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void testStartEngine() throws CarEmptyFuelTankException, CarExceedingMaxTankCapacity {
        assertFalse(car.isEngineRunning());
        car.startEngine();
        assertTrue(car.isEngineRunning());

        //  the startEngine must be idempotent,
        //  i.e., the result must be unchanged: engineRunning=true;
        car.startEngine();
        assertTrue(car.isEngineRunning());
    }

    @Test
    void testStartEngineWithEmptyTank() throws CarEmptyFuelTankException, CarRunningOutOfFuelException, CarExceedingMaxSpeedException, CarEngineNotRunningException {
        // prepare car so it has an empty tank and therefore engine is NOT running.
        car.startEngine();
        car.accelerate(car.getMaxSpeed()/4.0);
        assertThrows(CarRunningOutOfFuelException.class,
                () -> car.drive(car.getCurrentFuelLevel() / car.getConsumptionPerKm()));
        // so the tank is empty now
        assertEquals(0, Double.compare(0, car.getCurrentFuelLevel()));
        // and the car's engine is NOT running
        assertFalse(car.isEngineRunning());

        // now try to start with empty tank and expect an exception
        assertThrows(CarEmptyFuelTankException.class, () -> car.startEngine());
    }

    @Test
    void testStopHappyPath() throws CarEmptyFuelTankException, CarStillMovingException, CarExceedingMaxTankCapacity {
        // setup for test case 'testStop() happy-path'
        car.startEngine();
        assertTrue(car.isEngineRunning());

        // test stopEngine must be idempotent as long as the car NOT moving
        car.stopEngine();
        assertFalse(car.isEngineRunning());
        car.stopEngine();
        assertFalse(car.isEngineRunning());
    }

    @Test
    void testStopWhileEngineNotRunning() throws CarStillMovingException {
        // test stopEngine must be idempotent as long as the car NOT moving
        assertFalse(car.isEngineRunning());
        car.stopEngine();
        assertFalse(car.isEngineRunning());
        car.stopEngine();
        assertFalse(car.isEngineRunning());
    }

    @Test
    void testStopWhileCarMoving() throws Exception {
        // prepare for test case testStop while car is moving
        car.startEngine();
        car.accelerate(maxSpeed / 2.0);
        assertTrue(Double.compare(car.getCurrentSpeed(), 0.0) > 0);

        // now the car is moving - test the stop()-method
        // which is expected to throw an exception
        assertThrows(Exception.class, () -> car.stopEngine());

        // after the car stands still switching off the engine works
        car.brake(maxSpeed / 2.0);
        assertEquals(0, Double.compare(0, car.getCurrentSpeed()));
        assertTrue(car.isEngineRunning());
        car.stopEngine();
        assertFalse(car.isEngineRunning());
    }

    // Tests für die Methode accelerate:
    // Testen Sie, was passiert, wenn das Auto nicht gestartet wurde.
    // Testen Sie, was passiert, wenn das Auto beschleunigt wird und die Höchstgeschwindigkeit
    // überschreitet.
    //Testen Sie normales Beschleunigen.
    @Test
    void testAccelerateHappyPath() throws Exception {
        car.startEngine();
        car.accelerate(maxSpeed);
        assertEquals(maxSpeed, car.getCurrentSpeed());
    }

    @Test
    void testAccelerateWhileNotStarted() {
        assertThrows(CarEngineNotRunningException.class, () -> car.accelerate(maxSpeed / 2.0));
    }


    @Test
    void testAccelerateExceedingMaxSpeed() throws Exception {
        car.startEngine();
        car.accelerate(maxSpeed);
        assertThrows(CarExceedingMaxSpeedException.class, () -> car.accelerate(1.0), "Exception expected: must be thrown since maxSpeed is exceeded!");
    }

    @Test
    void testBrakingHappyPath() throws Exception {
        // prepare for moving with max.-speed
        car.startEngine();
        car.accelerate(maxSpeed);
        assertEquals(maxSpeed, car.getCurrentSpeed());

        car.brake(maxSpeed);
        assertEquals(0, car.getCurrentSpeed());

        // other than max. brake

        car.accelerate(maxSpeed / 2.0);
        car.brake(maxSpeed / 4.0);
        car.brake(maxSpeed / 4.0);
        assertEquals(0, car.getCurrentSpeed());

    }

    // tests for driving:
    // driving while car engine not running, i.e, not started
    @Test
    void testDriveWhileEngineOff(){
        // initial engine state off
        assertFalse(car.isEngineRunning());

        // exercise (method call) & verify (assert)
        assertThrows(CarEngineNotRunningException.class, ()-> car.drive(car.getCurrentFuelLevel()/car.getConsumptionPerKm()/2));

    }

    // driving while car engine on but speed 0
    // driving happy path - engine on, speed > 0
    // driving until out of fuel



    // tests for braking:
    // braking with value greater than current Speed
    @Test
    void testBrakingWithValueGreaterThanCurrentSpeed() throws Exception {
        car.startEngine();
        car.accelerate(maxSpeed / 2.0);

        assertThrows(CarSpeedLessThanNullException.class, () -> car.brake(maxSpeed));

    }

    @Test
    void testDriveWithEngineNotRunning() throws Exception {
        assertThrows(CarEngineNotRunningException.class, () -> car.drive(10));
    }

    @Test
    void testDriveWithSpeedSetAtZero() throws Exception {
        car.startEngine();

        assertThrows(CarNoSpeedSetException.class, () -> car.drive(10));
    }

    @Test
    void testDriveHappyPath() throws Exception {
        car.startEngine();
        car.accelerate(50);
        car.drive(100);

        assertEquals(59.5, car.getCurrentFuelLevel());
    }

    @Test
    void testAccelerateWithNegativeSpeed() throws Exception {
         car.startEngine();
         assertThrows(IllegalArgumentException.class, () -> car.accelerate(-10));
    }

    @Test
    void testBrakingWithNegativeSpeed() throws Exception {
        car.startEngine();
        car.accelerate(maxSpeed);
        assertThrows(IllegalArgumentException.class, () -> car.brake(-10));
    }

    @Test
    void testRefuelHappy() throws Exception {
        //setup
        car.startEngine();
        car.accelerate(10);
        car.drive(100);
        car.brake(10);
        car.stopEngine();

        //excercise
        car.refuel(4.5);
        assertEquals(64, car.getCurrentFuelLevel());

    }

    @Test
    void testFuelWithEngineStillRunning() throws Exception {
        car.startEngine();
        assertThrows(CarEngineRunningException.class, () -> car.refuel(10));
    }

    @Test
    void testFuelWithOverfillingTank() throws Exception {
        assertThrows(CarExceedingMaxTankCapacity.class, () -> car.refuel(100));
    }
}