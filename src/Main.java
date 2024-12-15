import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        Admin admin = new Admin();
        TakeOrder takeOrder = new TakeOrder();

        boolean running = true;
        System.out.println("\nWelcome to CodeWithCoffee");
        while (running) {
            System.out.println("\nHomePage:");
            System.out.println("1. Admin");
            System.out.println("2. Customer Order");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = input.nextInt();
            input.nextLine();

            switch (mainChoice) {
                case 1:
                    adminMenu(input, admin, menu);
                    break;
                case 2:
                    System.out.println("Enter customer information ");
                    System.out.print("Enter name: ");
                    String customerName = input.nextLine();
                    System.out.print("Enter Number: ");
                    String customerNumber = input.nextLine();
                    Customer customer = new Customer(customerName, customerNumber);
                    menu.displayStock();
                    customer.createOrder(takeOrder);
                    customer.saveCustomerInfo();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static boolean login(String pass,Admin admin) {
        return pass.equals(admin.getAdminPassword());
    }

    public static void adminMenu(Scanner input, Admin admin, Menu menu) {
        boolean passwordVerified = false;

        while (!passwordVerified) {
            System.out.print("Enter password: ");
            String pass = input.nextLine();

            if (login(pass,admin)) {
                passwordVerified = true;

                boolean adminRunning = true;
                while (adminRunning) {
                    System.out.println("\nAdmin Menu:");
                    System.out.println("1. Display Stock");
                    System.out.println("2. Add Item");
                    System.out.println("3. Delete Item");
                    System.out.println("4. Update Item Price");
                    System.out.println("5. Update Item Stock");
                    System.out.println("6. View Sales Report");
                    System.out.println("7. View Customer Report");
                    System.out.println("8. Clear Sales Report");
                    System.out.println("9. Go Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    int adminChoice = input.nextInt();
                    input.nextLine();

                    switch (adminChoice) {
                        case 1:
                            menu.displayStock();
                            break;
                        case 2:
                            admin.addItem();
                            break;
                        case 3:
                            admin.deleteItem();
                            break;
                        case 4:
                            admin.updateItemPrice();
                            break;
                        case 5:
                            admin.updateItemStock();
                            break;
                        case 6:
                            admin.viewSalesReport();
                            break;
                        case 7:
                            admin.viewCustomerInfo();
                            break;
                        case 8:
                            admin.clearSalesReport();
                            break;
                        case 9:
                            adminRunning = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid password.");
                int retryChoice;
                do{
                System.out.println("1. Retry");
                System.out.println("2. Back to Main Menu");
                System.out.print("Enter your choice: ");
                 retryChoice = input.nextInt();
                input.nextLine();
            }while(retryChoice!=1 && retryChoice!=2);
                if (retryChoice == 2) {
                    return;
                }
            }
        }
    }
}