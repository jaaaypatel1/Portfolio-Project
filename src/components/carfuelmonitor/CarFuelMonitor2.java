package components.carfuelmonitor;

/**
 *
 * {@code CarFuelMonitor2} represented as a {@code double} with implementations
 * of primary methods.
 *
 * @convention
 *
 *             <pre>
 * this.fuelLevel >= 0
 *             </pre>
 *
 * @correspondence
 *
 *                 <pre>
 * this = [the current fuel level represented by this.fuelLevel]
 *             </pre>
 *
 * @author Jay Patel
 *
 **/
public final class CarFuelMonitor2 extends CarFuelMonitorSecondary {

    /**
     * Fuel level of the car, representation of {@code this}.
     */
    private double fuelLevel;

    /**
     * No-argument constructor. Initializes fuel level to 0.
     */
    public CarFuelMonitor2() {
        this.createNewRep();
    }

    /**
     * Create new rep.
     */

    private void createNewRep() {
        this.fuelLevel = 0.0;
    }

    /**
     * Constructor with initial fuel level.
     *
     * @param initialFuelLevel
     *            initial fuel level
     */
    public CarFuelMonitor2(double initialFuelLevel) {
        assert initialFuelLevel >= 0 : "Violation of: initialFuelLevel >= 0";
        this.fuelLevel = initialFuelLevel;
    }

    /**
     *
     */
    @Override
    public void addFuel(double amount) {
        this.fuelLevel += amount;
    }

    /**
     *
     */
    @Override
    public boolean isOutOfFuel() {
        return this.fuelLevel == 0;
    }

    /**
     *
     */
    @Override
    public double getFuelLevel() {
        return this.fuelLevel;
    }

    /**
     * Clears this, resetting its state to 0 fuel.
     */
    @Override
    public void clear() {
        this.fuelLevel = 0.0;
    }

    /**
     *
     */
    @Override
    public CarFuelMonitor2 newInstance() {
        return new CarFuelMonitor2();
    }

    /**
     *
     */
    @Override
    public void transferFrom(CarFuelMonitor source) {
        assert source != null : "Violation of: source is not null";
        this.fuelLevel = source.getFuelLevel();
    }

}
