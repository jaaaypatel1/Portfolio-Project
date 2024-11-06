import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * {@code CarFuelMontor} represented as a {@code double} with implementations of
 * primary methods.
 *
 * @convention
 *
 *             <pre>
 * [all characters of $this.rep are '0' through '9']  and
 * [$this.rep does not start with '0']
 *             </pre>
 *
 * @correspondence
 *
 *                 <pre>
 * this = [if $this.rep = "" then 0
 *         else the decimal number whose ordinary depiction is $this.rep]
 *                 </pre>
 *
 * @author Jay Patel
 *
 **/
public class CarFuelMonitor {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Fuel level of the car, representation of {@code this}.
     */
    private double fuelLevel;

    /**
     * No-argument constructor. Initializes fuel level to 0.
     */
    public CarFuelMonitor() {
        this.fuelLevel = 0.0;
    }

    /**
     * Constructor with initial fuel level.
     *
     * @param initialFuelLevel
     *            initial fuel level
     */
    public CarFuelMonitor(double initialFuelLevel) {
        assert initialFuelLevel >= 0 : "Violation of: initialFuelLevel >= 0";
        this.fuelLevel = initialFuelLevel;
    }

    /*
     * Standard methods -------------------------------------------------------
     */

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
    public double refuel(double amount, double maxCapacity) {
        assert amount >= 0 : "Violation of: amount >= 0";
        assert maxCapacity >= this
                .getFuelLevel() : "Violation of: maxCapacity >= current fuel level";

        double fuelAdded = Math.min(amount, maxCapacity - this.getFuelLevel());
        this.addFuel(fuelAdded);
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
    public boolean isLowFuel(double distanceToDestination,
            double fuelEfficiency) {
        assert distanceToDestination >= 0 : "Violation of: distanceToDestination >= 0";
        assert fuelEfficiency > 0 : "Violation of: fuelEfficiency > 0";

        double requiredFuel = distanceToDestination * fuelEfficiency;
        return this.fuelLevel < requiredFuel;
    }

    /*
     * Kernel methods
     * -----------------------------------------------------------
     */

    /**
     * Adds fuel to the car.
     *
     * @param amount
     *            the amount of fuel to add
     */
    public void addFuel(double amount) {
        assert amount >= 0 : "Violation of: amount >= 0";

        this.fuelLevel += amount;
    }

    /**
     * Checks if the car is out of fuel.
     *
     * @return true if fuel level is 0, false otherwise
     */
    public boolean isOutOfFuel() {
        return this.fuelLevel == 0;
    }

    /**
     * Gets the current fuel level.
     *
     * @return the current fuel level
     */
    public double getFuelLevel() {
        return this.fuelLevel;
    }

    /*
     * Standard methods --------------------------------------------------------
     */

    /**
     * Main method.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        CarFuelMonitor car = new CarFuelMonitor();

        SimpleWriter out = new SimpleWriter1L();
        car.addFuel(10.5);
        out.println("Fuel added. Current fuel level: " + car.getFuelLevel()
                + " liters");

        if (car.isOutOfFuel()) {
            out.println("The car is out of fuel.");
        } else {
            out.println("The car has fuel.");
        }

        car.addFuel(5.0);
        out.println("More fuel added. Current fuel level: " + car.getFuelLevel()
                + " liters");

        car.addFuel(car.getFuelLevel());
        out.println("All fuel consumed. Current fuel level: "
                + car.getFuelLevel() + " liters");

        if (car.isOutOfFuel()) {
            out.println("The car is out of fuel.");
        }
        car.addFuel(10.0);
        System.out.println(
                "Current fuel level: " + car.getFuelLevel() + " liters");

        double distanceToDestination = 100.0;
        double fuelEfficiency = 0.1; // Car uses 0.1 gallons per mile

        if (car.isLowFuel(distanceToDestination, fuelEfficiency)) {
            out.println("Not enough fuel to reach the destination.");
        } else {
            out.println("Sufficient fuel to reach the destination.");
        }

        if (car.isOutOfFuel()) {
            System.out.println("The car is out of fuel.");
        } else {
            System.out.println("The car has fuel.");
        }

        out.close();
    }

}
