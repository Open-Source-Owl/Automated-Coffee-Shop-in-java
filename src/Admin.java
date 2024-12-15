import java.io.*;
import java.util.Scanner;

public class Admin extends Person {
    private String adminPassword;
    private Menu menu=new Menu();
    private final File orderReport =new File("order.txt");

    public Admin() {
        super("Admin");
        this.adminPassword = "1234";
    }

    public void addItem() {
        Scanner input = new Scanner(System.in);
        menu.displayStock();
        System.out.print("Enter item name: ");
        String name = input.nextLine();
        System.out.print("Enter item price: ");
        double price = input.nextDouble();
        System.out.print("Enter item stock: ");
        int stock = input.nextInt();
        menu.addMenuItemToFile( name, price, stock);
        System.out.println("Item added successfully.");
    }

    public void deleteItem() {
        Scanner input = new Scanner(System.in);
        menu.displayStock();
        System.out.print("Enter item name to delete: ");
        String name = input.nextLine();
        menu.deleteMenuItemFromFile(name);
        System.out.println("Successfully deleted");
    }

    public void updateItemPrice() {
        Scanner input = new Scanner(System.in);
        menu.displayStock();
        System.out.print("Enter item name to update price: ");
        String name = input.nextLine();
        System.out.print("Enter new price: ");
        double newPrice = input.nextDouble();
        menu.updateMenuItemPriceInFile(name, newPrice);
        System.out.println("SuccessFully Update price \n Updated menu:");
        menu.displayStock();
    }

    public void updateItemStock() {
        Scanner input = new Scanner(System.in);
        menu.displayStock();
        System.out.print("Enter item name to update stock: ");
        String name = input.nextLine();
        System.out.print("Enter new stock quantity: ");
        int newStock = input.nextInt();
        menu.updateMenuItemStockInFile(name, newStock);
        System.out.println("SuccessFully Update Stock \n Updated menu:");
        menu.displayStock();
    }

    public void viewSalesReport() {
        System.out.println("Sales Report: ");
        File salesReport = new File("order.txt");
        try (Scanner scanner=new Scanner(salesReport)) {
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void viewCustomerInfo(){
        System.out.println("Customer Information : ");
        File customerInfo = new File("customer.txt");
        try (Scanner scanner=new Scanner(customerInfo)) {
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearSalesReport(){
        try{
            FileWriter writer=new FileWriter(orderReport);
            writer.write("");
        }catch(IOException e){
            System.out.println("Error clearing sales report");
        }
    }

    public String getAdminPassword() {
        return adminPassword;
    }

}