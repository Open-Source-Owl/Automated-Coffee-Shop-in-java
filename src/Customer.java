import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Customer extends Person {
    private String phoneNumber;
    ArrayList<String> customerList=new ArrayList<>();

    public Customer(String name, String phoneNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void createOrder(TakeOrder takeOrder) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String itemName = input.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        takeOrder.createOrder(itemName,quantity,this.getName());
    }

    public void saveCustomerInfo(){
        String information="Name: "+ this.getName()+", "+"PhoneNumber: "+this.getPhoneNumber();
        customerList.add(information);
        addCustomerInfoToFile(customerList);
    }

    public void addCustomerInfoToFile(ArrayList<String>customerInfo) {
        try (FileWriter writer = new FileWriter("customer.txt", true)) {
            writer.write(customerInfo+ "\n");
        } catch (IOException e) {
            System.out.println("Error added customer information in file");;
        }
    }
}
