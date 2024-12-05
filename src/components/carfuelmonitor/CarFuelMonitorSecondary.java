package components.carfuelmonitor;

/**
 * Layered implementations of secondary methods for {@code CarFuelMonitor}.
 *
 * @author Jay Patel
 */
public abstract class CarFuelMonitorSecondary implements CarFuelMonitor {

    @Override
    public double drive(double fuelUsed, double efficiency) {
        assert fuelUsed >= 0 : "Violation of: fuelUsed >= 0";
        assert efficiency > 0 : "Violation of: efficiency > 0";

        double actualFuelUsed = Math.min(fuelUsed, this.getFuelLevel());
        this.addFuel(-actualFuelUsed);

        // Update formula to use efficiency as "distance per unit fuel"
        double distanceCovered = actualFuelUsed * efficiency;
        return distanceCovered;
    }

    @Override
    public double refuel(double amount, double maxCapacity) {
        assert amount >= 0 : "Violation of: amount >= 0";
        assert maxCapacity >= this
                .getFuelLevel() : "Violation of: maxCapacity >= current fuel level";

        // Calculate the fuel that can be added
        double fuelAdded = Math.min(amount, maxCapacity - this.getFuelLevel());

        // Correctly add fuel without applying a negative sign
        this.addFuel(fuelAdded);
        return fuelAdded;
    }

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

        if (!(obj instanceof CarFuelMonitorSecondary)) {
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

    /**
     * hashCode method implementation.
     */
    @Override
    public int hashCode() {
        return Double.hashCode(this.getFuelLevel());
    }
}
