
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of floors: ");
        int floors = sc.nextInt();

        String[][] slots = new String[floors][];

        for (int i = 0; i < floors; i++) {
            System.out.print("Enter slots on floor " + (i + 1) + ": ");
            int count = sc.nextInt();
            slots[i] = new String[count];
        }

        System.out.print("Enter floor number: ");
        int floor = sc.nextInt();

        System.out.print("Enter slot number: ");
        int slot = sc.nextInt();

        if (floor >= 1 && floor <= floors
                && slot >= 1 && slot <= slots[floor - 1].length) {
            System.out.print("Enter vehicle number: ");
            String vehicleNo = sc.next();

            slots[floor - 1][slot - 1] = vehicleNo;

            System.out.println("Vehicle parked successfully");
            System.out.println("Vehicle Number: "
                    + slots[floor - 1][slot - 1]);
        } else {
            System.out.println("Invalid floor or slot number");
        }

        System.out.print("Enter parking duration in minutes: ");
        int minutes = sc.nextInt();

        System.out.print("Enter hourly fee: ");
        double rate = sc.nextDouble();

        if (minutes < 0 || rate < 0) {
            System.out.println("Invalid duration or fee");
        } else {
            int hours = (minutes + 59) / 60;
            double fee = hours * rate;

            System.out.println("Billable hours: " + hours);
            System.out.println("Parking Fee: Rs " + fee);
        }

        sc.close();
    }
}
