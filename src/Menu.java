import java.io.*;
import java.util.Scanner;

public class Menu {
    private final File menuFile = new File("menu.txt");

    public Menu() {
    }

    public void displayStock() {
        System.out.println("Menu:");
        try (Scanner scanner=new Scanner(menuFile)) {
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error opening menu file");
        }
    }

    public void addMenuItemToFile( String name, double price, int stock) {
        try (FileWriter writer = new FileWriter(menuFile, true)) {
            writer.write(  name + "," + price + "," + stock + "\n");
        } catch (IOException e) {
            System.out.println("Error write add menu in  file");;
        }
    }

    public void deleteMenuItemFromFile(String itemName) {
       try(Scanner scanner=new Scanner(menuFile)){
           StringBuilder updateMenu=new StringBuilder();
           while(scanner.hasNextLine()){
               String line= scanner.nextLine();
               String[] parts=line.split(",");
               if(!parts[0].equalsIgnoreCase(itemName)){
                   updateMenu.append(line).append("\n");
               }
           }
           try(FileWriter writer = new FileWriter(menuFile,false)){
               writer.write(updateMenu.toString());
           }
       } catch(IOException e){
           System.out.println("Error reading menu file");
       }

    }

    public void updateMenuItemPriceInFile(String itemName, double newPrice) {
        try(Scanner scanner =new Scanner(menuFile)){
            StringBuilder updatedMenu=new StringBuilder();
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] parts =line.split(",");
                if(parts[0].equalsIgnoreCase(itemName)){
                    int stock =Integer.parseInt(parts[2]);
                    updatedMenu.append(itemName).append(",").append(newPrice).append(",").append(stock).append("\n");
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

    public void updateMenuItemStockInFile(String itemName, int newStock) {
        try(Scanner scanner =new Scanner(menuFile)){
            StringBuilder updatedMenu=new StringBuilder();
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] parts =line.split(",");
                if(parts[0].equalsIgnoreCase(itemName)){
                    double price=Double.parseDouble(parts[1]);
                    updatedMenu.append(itemName).append(",").append(price).append(",").append(newStock).append("\n");
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
}