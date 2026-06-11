import java.util.Scanner;

interface Billable {
    double calculateTotal();
}

class UtilityBill implements Billable {

    private String customerName;
    private int previousReading;
    private int currentReading;
    private int unitsConsumed;
    private double totalAmount;

    public UtilityBill(String customerName, int previousReading, int currentReading) {
        this.customerName = customerName;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
    }

    public boolean validateInput() {
        if (previousReading > currentReading) {
            System.out.println("Error: Previous reading cannot be greater than current reading.");
            return false;
        }
        return true;
    }

    public void calculateUnits() {
        unitsConsumed = currentReading - previousReading;
    }

    @Override
    public double calculateTotal() {
        calculateUnits();

        if (unitsConsumed <= 100) {
            totalAmount = unitsConsumed * 100;
        }
        else if (unitsConsumed <= 300) {
            totalAmount = (100 * 100) +
                          ((unitsConsumed - 100) * 200);
        }
        else {
            totalAmount = (100 * 100) +
                          (200 * 200) +
                          ((unitsConsumed - 300) * 500);
        }

        return totalAmount;
    }

    public void printReceipt() {
        System.out.println("\n------ DIGITAL RECEIPT ------");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Total Bill    : " + totalAmount);
        System.out.println("-----------------------------");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("\nEnter Customer Name (or type 'exit' to quit): ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                System.out.println("Exiting application...");
                break;
            }

            System.out.print("Enter Previous Meter Reading: ");
            int prev = sc.nextInt();

            System.out.print("Enter Current Meter Reading: ");
            int curr = sc.nextInt();
            sc.nextLine();

            UtilityBill bill = new UtilityBill(name, prev, curr);

            if (!bill.validateInput()) {
                continue;
            }

            bill.calculateTotal();
            bill.printReceipt();
        }

        sc.close();
    }
}
