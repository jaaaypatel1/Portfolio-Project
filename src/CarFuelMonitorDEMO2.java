import components.carfuelmonitor.CarFuelMonitor2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

/**
 * More complex demo for the CarFuelMonitorComponent.
 *
 * @author Jay Patel
 */
public class CarFuelMonitorDEMO2 {
    public static void main(String[] args) {
        SimpleReader reader = new SimpleReader1L();

        CarFuelMonitor2 car1 = new CarFuelMonitor2(100.0);
        CarFuelMonitor2 car2 = new CarFuelMonitor2();

        System.out.println("Initial fuel levels:");
        System.out.println("Car 1 Fuel Level: " + car1.getFuelLevel());
        System.out.println("Car 2 Fuel Level: " + car2.getFuelLevel());

        System.out
                .print("\nStep 2: How much fuel do you want to add to car1? ");
        double fuelToAddToCar1 = reader.nextDouble();
        car1.addFuel(fuelToAddToCar1);
        System.out.println("Car 1 Fuel Level after adding " + fuelToAddToCar1
                + " units: " + car1.getFuelLevel());

        System.out.print(
                "\nStep 3: Do you want to transfer fuel from car1 to car2? (yes/no) ");
        String transferResponse = reader.nextLine();
        if (transferResponse.equalsIgnoreCase("yes")) {
            car2.transferFrom(car1);
            System.out.println(
                    "Car 2 Fuel Level after transfer: " + car2.getFuelLevel());
            System.out.println(
                    "Car 1 Fuel Level after transfer: " + car1.getFuelLevel());
        } else {
            System.out.println("No fuel transferred.");
        }

        System.out.print(
                "\nStep 4: How many units of fuel do you want car2 to use for driving? ");
        double fuelUsed = reader.nextDouble();
        System.out
                .print("Enter the fuel efficiency (miles per unit of fuel): ");
        double efficiency = reader.nextDouble();
        double distanceCovered = car2.drive(fuelUsed, efficiency);
        System.out.println("Car 2 drove " + distanceCovered + " miles.");
        System.out.println("Car 2 Fuel Level after driving " + fuelUsed
                + " units: " + car2.getFuelLevel());

        System.out.println("\nStep 5: Checking if car2 is out of fuel...");
        if (car2.isOutOfFuel()) {
            System.out.println("Car 2 is out of fuel!");
        } else {
            System.out.println("Car 2 still has fuel.");
        }

        System.out
                .print("\nStep 6: How much fuel do you want to add to car2? ");
        double fuelToAddToCar2 = reader.nextDouble();
        car2.addFuel(fuelToAddToCar2);
        System.out.println("Car 2 Fuel Level after adding " + fuelToAddToCar2
                + " units: " + car2.getFuelLevel());

        System.out.print(
                "\nStep 7: Enter the distance for the trip (in miles): ");
        double tripDistance = reader.nextDouble();
        System.out.print(
                "Enter the fuel efficiency for the trip (miles per unit of fuel): ");
        double fuelEfficiencyForTrip = reader.nextDouble();
        if (car2.isLowFuel(tripDistance, fuelEfficiencyForTrip)) {
            System.out.println("Car 2 does not have enough fuel for the trip.");
        } else {
            System.out.println("Car 2 has enough fuel for the trip.");
        }

        System.out.print(
                "\nStep 8: Do you want to refuel car2 for the trip? (yes/no) ");
        String refuelResponse = reader.nextLine();
        if (refuelResponse.equalsIgnoreCase("yes")) {
            double requiredFuelForTrip = tripDistance * fuelEfficiencyForTrip;
            double fuelAdded = car2.refuel(requiredFuelForTrip, 200.0);
            System.out.println("Car 2 added " + fuelAdded + " units of fuel.");
            System.out.println("Car 2 Fuel Level after refueling for trip: "
                    + car2.getFuelLevel());
        } else {
            System.out.println("No fuel added for the trip.");
        }

        System.out.println(
                "\nStep 9: Verifying if car2 is ready for the trip...");
        if (car2.isLowFuel(tripDistance, fuelEfficiencyForTrip)) {
            System.out.println(
                    "Car 2 still does not have enough fuel for the trip!");
        } else {
            System.out.println(
                    "Car 2 is ready for the trip with sufficient fuel.");
        }

        System.out.print(
                "\nStep 10: Do you want to clear all fuel from car2? (yes/no) ");
        String clearFuelResponse = reader.nextLine();
        if (clearFuelResponse.equalsIgnoreCase("yes")) {
            car2.clear();
            System.out.println(
                    "Car 2 Fuel Level after clearing: " + car2.getFuelLevel());
        } else {
            System.out.println("Fuel not cleared from car2.");
        }

        System.out.println(
                "\nFinal Step: Checking fuel status after clearing...");
        System.out.println("Car 1 Fuel Level: " + car1.getFuelLevel());
        System.out.println("Car 2 Fuel Level: " + car2.getFuelLevel());
    }
}
