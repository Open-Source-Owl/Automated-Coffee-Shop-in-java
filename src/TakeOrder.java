import java.io.*;
import java.util.Scanner;
public class TakeOrder {
   private final File orderFile=new File("order.txt");
   private final File menuFile= new File("menu.txt");
   private final ShopDetails shopDetails =new ShopDetails();
    public TakeOrder() {
    }
    public void createOrder(String itemName,int quantity, String customerName){
            MenuItem menuItem=findMenuItem(itemName);
        if(menuItem!=null){
            while(menuItem.getItemStock()<quantity){
                Scanner input=new Scanner(System.in);
                System.out.print("Insufficient stock. Enter again quantity:" );
                quantity=input.nextInt();
            }
            StringBuilder orderDetails=new StringBuilder();
            double bill=  quantity * menuItem.getItemPrice();
            orderDetails.append("Customer name: ").append(customerName).append("  ").append("\nItem name: ").append(itemName).append("\nQuantity: ").append(quantity).append("\nTotalBill : ").append(bill).append("\n").append("-------=======-------\n");
            System.out.println("Order Details \n"+ orderDetails.toString());

            try(FileWriter writer = new FileWriter(orderFile,true)){
                writer.write(orderDetails.toString());
            }catch(IOException e){
                System.out.println("Failed to write order file");
            }
            int finalStock= menuItem.getItemStock()-quantity;
            updateMenu(menuItem,itemName,finalStock);
            paymentOption(bill);
        }
    }

    public void paymentOption(double bill){
        System.out.print("Enter your payment option (1.Card or 2.Cash) : ");
        Scanner input =new Scanner(System.in);
        int c= input.nextInt();
        while(c!=1 && c!=2){
            System.out.println("Error! Please enter 1 or 2 : ");
            c= input.nextInt();
        }

        if(c==1){
            System.out.println("Thanks for  your payment.\n ");
            System.out.println(shopDetails.ending());
        }
        else {
            double receive;
           do{
               System.out.print("Enter your payment :");
               receive= input.nextDouble();
           }while(receive<bill);
            double exchange= receive-bill;
            System.out.printf("Here is your exchange money %.2f .Thanks for your payment.\n",exchange);
            System.out.println(shopDetails.ending());
        }
    }

    public void updateMenu(MenuItem menuItem,String itemName, int finalStock){
        try(Scanner scanner =new Scanner(menuFile)){
            StringBuilder updatedMenu=new StringBuilder();
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] parts =line.split(",");
                if(parts[0].equalsIgnoreCase(itemName)){
                    updatedMenu.append(itemName).append(",").append(menuItem.getItemPrice()).append(",").append(finalStock).append("\n");
                }
                else {
                    updatedMenu.append(line).append("\n");
                }
            }
            try(FileWriter writer = new FileWriter(menuFile,false)){
                writer.write(updatedMenu.toString());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private MenuItem findMenuItem(String itemName){
        try(Scanner scanner =new Scanner(menuFile)){
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] parts =line.split(",");
                if(parts[0].equalsIgnoreCase(itemName)){
                    double price=Double.parseDouble(parts[1]);
                    int stock =Integer.parseInt(parts[2]);
                    return new MenuItem(price,stock);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
