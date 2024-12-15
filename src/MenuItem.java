public class MenuItem {

    private String itemName;
    private double itemPrice;
    private int itemStock;

    public MenuItem() {
    }

    public MenuItem( double itemPrice, int itemStock) {
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getItemStock() {
        return itemStock;
    }

    @Override
    public String toString() {
        return " Item: " + itemName + ", Price: $" + itemPrice + ", Stock: " + itemStock;
    }
}