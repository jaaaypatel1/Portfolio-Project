/**
 * CarFuelMonitorKernel provides an way to monitor and manage the fuel level of
 * a car. It allows adding fuel, checking whether the car is out of fuel, and
 * retrieving the current fuel level.
 *
 * <p>
 * The fuel level is represented as an double, where the value 0 indicates that
 * the car is out of fuel. Any positive value indicates the amount of fuel
 * currently available. The interface assumes a non-negative fuel level at all
 * times, i.e., the fuel level cannot drop below zero.
 * </p>
 *
 * @initially <pre>
 *     this.getCurrentFuelLevel() = 0
 * </pre>
 */
public interface CarFuelMonitorEnhanced extends CarFuelMonitorKernel {

    /**
     * Simulates driving by decreasing the fuel level based on fuel efficiency.
     * Calculates and returns the distance covered.
     *
     * @param fuelUsed
     *            the amount of fuel intended to be used
     * @param efficiency
     *            the fuel efficiency (fuel consumed per unit distance)
     * @return the actual distance covered based on fuel used
     * @requires fuelUsed >= 0 and efficiency > 0
     * @ensures this.fuelLevel = #this.fuelLevel - [actual fuel used]
     */
    double drive(double fuelUsed, double efficiency);

    /**
     * Refuels the car with the specified amount of fuel, but does not exceed
     * max capacity.
     *
     * @param amount
     *            the amount of fuel to add
     * @param maxCapacity
     *            the max fuel capacity of the car
     * @return the actual amount of fuel added
     * @requires amount >= 0 and maxCapacity >= this.fuelLevel
     * @ensures this.fuelLevel = min(#this.fuelLevel + amount, maxCapacity)
     */
    double refuel(double amount, double maxCapacity);

    /**
     * Checks if the car has enough fuel to reach the destination.
     *
     * @param distanceToDestination
     *            the distance to the destination
     * @param fuelEfficiency
     *            the car's fuel efficiency (e.g., gallons per mile)
     * @return true if there is not enough fuel, false otherwise
     */
    boolean isLowFuel(double distanceToDestination, double fuelEfficiency);

}
