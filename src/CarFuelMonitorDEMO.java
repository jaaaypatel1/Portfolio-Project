import components.carfuelmonitor.CarFuelMonitor2;

/**
 * Simple demo for the CarFuelMonitorComponent.
 *
 * @author Jay Patel
 */
public class CarFuelMonitorDEMO {
    public static void main(String[] args) {
        // Create two CarFuelMonitor2 objects
        CarFuelMonitor2 car1 = new CarFuelMonitor2();
        CarFuelMonitor2 car2 = new CarFuelMonitor2();

        // Refuel car1 with 50 units of fuel
        car1.addFuel(50.0);
        System.out.println(
                "Car 1 Fuel Level after refueling: " + car1.getFuelLevel());

        // Transfer fuel from car1 to car2
        car2.transferFrom(car1);
        System.out.println(
                "Car 2 Fuel Level after transfer: " + car2.getFuelLevel());

        // Verify that car1's fuel level remains the same
        System.out.println(
                "Car 1 Fuel Level after transfer: " + car1.getFuelLevel());

        // Simulate driving car2 with some fuel usage
        double distance = car2.drive(10, 5);
        System.out.println("Car 2 drove " + distance + " miles.");
        System.out.println(
                "Car 2 Fuel Level after driving: " + car2.getFuelLevel());

        // Check if car2 is out of fuel
        if (car2.isOutOfFuel()) {
            System.out.println("Car 2 is out of fuel.");
        } else {
            System.out.println("Car 2 still has fuel.");
        }
    }
}
