import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter Customer Name (or type 'exit' to quit): ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                System.out.println("Exiting application...");
                break;
            }

            System.out.print("Enter Previous Meter Reading: ");
            int prev = sc.nextInt();

            System.out.print("Enter Current Meter Reading: ");
            int curr = sc.nextInt();
            sc.nextLine(); // consume newline

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