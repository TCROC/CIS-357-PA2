package sample;

public abstract class StockItem implements Comparable<StockItem>{
    public static int itemCount;
    private String name;
    private double price;
    private boolean isOnSale;
    private double itemId;
    protected String itemDescription;
    protected String itemCategory;

    public StockItem() {
        itemCount += 1;
    }

    public StockItem(String name) {
        this.name = name;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public double getItemId() {
        return itemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    @Override
    public String toString() {
        return getItemSummary();
    }

    @Override
    public int compareTo(StockItem o) {
        return (int) (o.getPrice() - price);
    }


    public abstract String getItemTypeDetails();
    public abstract String getItemSummary();
}
