package sample;

public class Apple extends Consumable {

    protected String color;

    public Apple() {

    }

    public Apple(String color, String expirationDate, double calorieCount, String name, double price, boolean isOnSale, String itemDescription, String itemCategory) {
        super(expirationDate, calorieCount, name, price, isOnSale, itemDescription, itemCategory);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getItemTypeDetails() {
        return null;
    }

    @Override
    public String getItemSummary() {
        return null;
    }

    @Override
    public int compareTo(StockItem o) {
        return 0;
    }
}
