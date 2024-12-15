public class ShopDetails {
    private String shopName= "ProgBuddy Coffee Shop";
    private String shopAddress = "infornt of EWU,Afternagar,Rampura";
    private String phoneNumber= "+01254785245";

    public ShopDetails() {
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String ending(){
        return "*****************************\n" +
                "*                           *\n" +
                "*     ╔═╗   ╔═╗   ╔═╗   ╔═╗  *\n" +
                "*    ║ C ║─║ O ║─║ D ║─║ E ║ *\n" +
                "*     ╚═╝   ╚═╝   ╚═╝   ╚═╝  *\n" +
                "*          with Coffee       *\n" +
                "*                           *\n" +
                "*   Sip, Code, Repeat!       *\n" +
                "*                           *\n" +
                "*****************************";
    }

    @Override
    public String toString() {
        return " CodeWithCoffee\n" +"Address:  "+shopAddress+"\n Phone:"+phoneNumber;
    }
}