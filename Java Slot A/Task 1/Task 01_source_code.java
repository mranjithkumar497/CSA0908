
class Vehicle {
    String vehicleNo;
    String type;

    Vehicle(String vehicleNo, String type) {
        this.vehicleNo = vehicleNo;
        this.type = type;
    }
}

class ParkingSlot {
    int slotNo;
    Vehicle vehicle;

    ParkingSlot(int slotNo) {
        this.slotNo = slotNo;
        this.vehicle = null;
    }

    boolean isFree() {
        return vehicle == null;
    }

    void parkVehicle(Vehicle v) {
        if (isFree()) {
            vehicle = v;
            System.out.println("Vehicle parked in slot: " + slotNo);
        } else {
            System.out.println("Slot is already occupied");
        }
    }

    void display() {
        if (isFree()) {
            System.out.println("Slot " + slotNo + ": Free");
        } else {
            System.out.println("Slot " + slotNo + ": "
                    + vehicle.vehicleNo + " (" + vehicle.type + ")");
        }
    }
}

class ParkingFacility {
    ParkingSlot[] slots;

    ParkingFacility(int totalSlots) {
        slots = new ParkingSlot[totalSlots];

        for (int i = 0; i < totalSlots; i++) {
            slots[i] = new ParkingSlot(i + 1);
        }
    }

    void parkVehicle(Vehicle v) {
        for (ParkingSlot slot : slots) {
            if (slot.isFree()) {
                slot.parkVehicle(v);
                return;
            }
        }

        System.out.println("Parking facility is full");
    }

    void displaySlots() {
        for (ParkingSlot slot : slots) {
            slot.display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingFacility parking = new ParkingFacility(3);

        Vehicle v1 = new Vehicle("TN01AB1111", "Car");
        Vehicle v2 = new Vehicle("TN02CD2222", "Two-Wheeler");
        Vehicle v3 = new Vehicle("TN03EF3333", "Electric Car");
        Vehicle v4 = new Vehicle("TN04GH4444", "Car");

        parking.parkVehicle(v1);
        parking.parkVehicle(v2);
        parking.parkVehicle(v3);
        parking.parkVehicle(v4);

        System.out.println("\nParking Slot Details:");
        parking.displaySlots();
    }
}
