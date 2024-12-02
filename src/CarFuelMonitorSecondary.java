/**
 * Layered implementations of secondary methods for {@code CarFuelMonitor}.
 *
 * @author Jay Patel
 */
public abstract class CarFuelMonitorSecondary
        implements CarFuelMonitorEnhanced {
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
    @Override
    public double drive(double fuelUsed, double efficiency) {
        assert fuelUsed >= 0 : "Violation of: fuelUsed >= 0";
        assert efficiency > 0 : "Violation of: efficiency > 0";

        double actualFuelUsed = Math.min(fuelUsed, this.getFuelLevel());
        this.addFuel(-actualFuelUsed);

        double distanceCovered = actualFuelUsed / efficiency;
        return distanceCovered;
    }

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
    @Override
    public double refuel(double amount, double maxCapacity) {
        assert amount >= 0 : "Violation of: amount >= 0";
        assert maxCapacity >= this
                .getFuelLevel() : "Violation of: maxCapacity >= current fuel level";

        double fuelAdded = Math.min(amount, maxCapacity - this.getFuelLevel());
        this.addFuel(-fuelAdded);
        return fuelAdded;
    }

    /**
     * Checks if the car has enough fuel to reach the destination.
     *
     * @param distanceToDestination
     *            the distance to the destination
     * @param fuelEfficiency
     *            the car's fuel efficiency (e.g., gallons per mile)
     * @return true if there is not enough fuel, false otherwise
     */
    @Override
    public boolean isLowFuel(double distanceToDestination,
            double fuelEfficiency) {
        assert distanceToDestination >= 0 : "Violation of: distanceToDestination >= 0";
        assert fuelEfficiency > 0 : "Violation of: fuelEfficiency > 0";

        double requiredFuel = distanceToDestination * fuelEfficiency;
        return this.getFuelLevel() < requiredFuel;
    }

    /**
     * Equals method implementation.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        CarFuelMonitorSecondary other = (CarFuelMonitorSecondary) obj;
        return Double.compare(this.getFuelLevel(), other.getFuelLevel()) == 0;
    }

    /**
     * toString method implementation.
     */

    @Override
    public String toString() {
        return "CarFuelMonitorSecondary{" + "fuelLevel=" + this.getFuelLevel()
                + '}';
    }
}
