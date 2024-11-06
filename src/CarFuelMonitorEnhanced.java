/**
 * CarFuelMonitorKernel provides an way to monitor and manage the fuel level of
 * a car. It allows adding fuel, checking whether the car is out of fuel, and
 * retrieving the current fuel level.
 *
 * <p>
 * The fuel level is represented as an integer, where the value 0 indicates that
 * the car is out of fuel. Any positive value indicates the amount of fuel
 * currently available. The interface assumes a non-negative fuel level at all
 * times, i.e., the fuel level cannot drop below zero.
 * </p>
 *
 * @initially <pre>
 *     this.getCurrentFuelLevel() = 0
 * </pre>
 */
public interface CarFuelMonitorEnhanced {

    /**
     * Adds the specified amount of fuel to the current fuel level.
     *
     * <p>
     * If the fuel added exceeds the car's fuel tank capacity, the fuel level
     * will be capped at the maximum capacity. It is assumed that the fuel level
     * is non-negative and cannot exceed the defined maximum capacity (this
     * constraint would typically be implemented in the concrete class that
     * implements this interface).
     * </p>
     *
     * @param x
     *            the amount of fuel to add; must be non-negative
     * @updates this
     * @requires x >= 0
     * @ensures this.getCurrentFuelLevel() = min(#this.getCurrentFuelLevel() +
     *          x, MAX_FUEL_CAPACITY)
     */
    void addFuel(int x);

    /**
     * Checks whether the fuel level is zero, indicating that the car is out of
     * fuel.
     *
     * <p>
     * This method returns {@code true} if the current fuel level is 0, and
     * {@code false} otherwise. The method does not alter the state of the fuel
     * monitor.
     * </p>
     *
     * @return true if the fuel level is 0 (empty tank), false otherwise
     * @ensures isOutOfFuel = (this.getCurrentFuelLevel() == 0)
     */
    boolean isOutOfFuel();

    /**
     * Retrieves the current fuel level of the car.
     *
     * <p>
     * The fuel level represents the amount of fuel currently in the tank. This
     * value is guaranteed to be non-negative and less than or equal to the
     * maximum fuel capacity of the car.
     * </p>
     *
     * @return the current fuel level (a non-negative integer)
     * @ensures getCurrentFuelLevel >= 0
     */
    int getCurrentFuelLevel();
}
