package sample;

public abstract class Consumable extends StockItem {

    private String expirationDate;
    private double calorieCount;

    public Consumable() {

    }

    public Consumable(String name, String expirationDate, double calorieCount) {
        this.setItemName(name);
        this.expirationDate = expirationDate;
        this.calorieCount = calorieCount;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getCalorieCount() {
        return calorieCount;
    }

    public void setCalorieCount(double calorieCount) {
        this.calorieCount = calorieCount;
    }
}
