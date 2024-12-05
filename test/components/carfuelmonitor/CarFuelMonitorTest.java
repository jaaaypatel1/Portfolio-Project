package components.carfuelmonitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test fixture for {@code CarFuelMonitors}'s secondary methods.
 *
 * @author Jay Patel
 *
 */
public abstract class CarFuelMonitorTest {
    /**
     *
     * @return the new CarFuelMonitor
     */
    protected abstract CarFuelMonitor constructorTest();

    @Test
    public final void testConstructor() {
        CarFuelMonitor car = this.constructorTest();
        CarFuelMonitor car2 = new CarFuelMonitor2(2);
    }

    @Test
    public final void testDrive_Valid() {
        CarFuelMonitor car = this.constructorTest();

        car.refuel(20, 50);

        double distance = car.drive(10, 5);

        assertEquals(50.0, distance, 0.001);
        assertEquals(10.0, car.getFuelLevel(), 0.001);
    }

    @Test
    public final void testAddFuel_WithinCapacity() {
        CarFuelMonitorKernel car = this.constructorTest();

        car.addFuel(10);
        assertEquals(10, car.getFuelLevel(), 0.001);
    }

    /**
     * test the addFuel method with input exceeding capacity.
     */
    @Test
    public final void testAddFuel_ExceedsCapacity() {
        CarFuelMonitorKernel car = this.constructorTest();

        car.addFuel(50);
        assertEquals(50, car.getFuelLevel(), 0.001);
    }

    /**
     * test the addFuel method with zero fuel.
     */
    @Test
    public final void testAddFuel_ZeroFuel() {
        CarFuelMonitorKernel car = this.constructorTest();

        car.addFuel(0);
        assertEquals(0, car.getFuelLevel(), 0.001);
    }

    /**
     * Test the isOutOfFuel method when fuel level is zero.
     */
    @Test
    public final void testIsOutOfFuel_True() {
        CarFuelMonitorKernel car = this.constructorTest();

        assertTrue(car.isOutOfFuel());
    }

    /**
     * Test the isOutOfFuel method when fuel level is non-zero.
     */
    @Test
    public final void testIsOutOfFuel_False() {
        CarFuelMonitorKernel car = this.constructorTest();

        car.addFuel(10);
        assertFalse(car.isOutOfFuel());
    }

    /**
     * Test the getFuelLevel method initially.
     */
    @Test
    public final void testGetFuelLevel_Initial() {
        CarFuelMonitorKernel car = this.constructorTest();

        assertEquals(0, car.getFuelLevel(), 0.001);
    }

    /**
     * Test the getFuelLevel method after adding fuel.
     */
    @Test
    public final void testGetFuelLevel_AfterAddingFuel() {
        CarFuelMonitorKernel car = this.constructorTest();

        car.addFuel(20);
        assertEquals(20, car.getFuelLevel(), 0.001);
    }

    @Test
    public final void testClear() {
        CarFuelMonitor car = this.constructorTest();
        car.addFuel(10);
        car.clear();
        assertEquals(0.0, car.getFuelLevel(), 0.001);
    }

    @Test
    public final void testNewInstance() {
        CarFuelMonitor newCar = this.constructorTest().newInstance();
        assertEquals(0.0, newCar.getFuelLevel(), 0.001);
    }

    @Test
    public final void testTransferFrom() {

        CarFuelMonitor car1 = this.constructorTest();
        car1.addFuel(20);

        CarFuelMonitor car2 = this.constructorTest();
        car2.transferFrom(car1);

        assertEquals(20.0, car2.getFuelLevel(), 0.001);

        assertEquals(20.0, car1.getFuelLevel(), 0.001);
    }

    @Test
    public final void testDrive_NoFuel() {
        CarFuelMonitor car = this.constructorTest();
        double distance = car.drive(10, 5);
        assertEquals(0.0, distance, 0.001);
    }

    @Test
    public final void testRefuel() {
        CarFuelMonitor car = this.constructorTest();
        double added = car.refuel(30, 50);
        assertEquals(30.0, added, 0.001);
        assertEquals(30.0, car.getFuelLevel(), 0.001);
    }

    @Test
    public final void testIsLowFuel() {
        CarFuelMonitor car = this.constructorTest();
        car.addFuel(10);

        assertTrue(car.isLowFuel(50, 1));
        assertFalse(car.isLowFuel(5, 1));
    }

    @Test
    public final void testEquals() {
        CarFuelMonitor car1 = this.constructorTest();
        CarFuelMonitor car2 = this.constructorTest();

        assertTrue(car1.equals(car2));

        car1.addFuel(10);
        assertFalse(car1.equals(car2));
    }

    @Test
    public final void testEquals2() {
        CarFuelMonitor car1 = new CarFuelMonitor2(2);
        CarFuelMonitor car2 = new CarFuelMonitor2(2);

        assertTrue(car1.equals(car2));

    }

    @Test
    public final void testToString() {
        CarFuelMonitor car = this.constructorTest();
        car.addFuel(10);
        assertEquals("CarFuelMonitorSecondary{fuelLevel=10.0}", car.toString());
    }

    @Test
    public final void testHashCode() {
        CarFuelMonitor car1 = this.constructorTest();
        CarFuelMonitor car2 = this.constructorTest();

        assertEquals(car1.hashCode(), car2.hashCode());

        car1.addFuel(10);
        assertNotEquals(car1.hashCode(), car2.hashCode());
    }

}
