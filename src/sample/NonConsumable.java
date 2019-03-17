package sample;

public abstract class NonConsumable extends StockItem {

    public NonConsumable(){}

    public NonConsumable(String name, double price, boolean isOnSale, String itemDescription, String itemCategory) {
        super(name, price, isOnSale, itemDescription, itemCategory);
    }

}
