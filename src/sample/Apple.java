package sample;

public class Apple extends Consumable {

    protected String color;

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
