public class UtilityBill implements Billable {

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
        } else if (unitsConsumed <= 300) {
            totalAmount = (100 * 1.0) + ((unitsConsumed - 100) * 200);
        } else {
            totalAmount = (100 * 1.0) + (200 * 2.0) + ((unitsConsumed - 300) * 500);
        }

        return totalAmount;
    }

    public void printReceipt() {
        System.out.println("\n------ DIGITAL RECEIPT ------");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Total Bill    : $" + totalAmount);
        System.out.println("-----------------------------");
    }
}
