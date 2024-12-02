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

        if (car.isOutOfFuel()) {
            System.out.println("The car is out of fuel.");
        } else {
            System.out.println("The car has fuel.");
        }

        out.close();
    }

}
