package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StockManager {

    private ArrayList<StockItem> stockItems = new ArrayList<>();

    public void addItem(StockItem item) {
        stockItems.add(item);
    }

    public void removeItem(StockItem item) {
        stockItems.remove(item);
    }

    public ArrayList<StockItem> getAllItems(){
        return stockItems;
    }

    public StockItem getItem(double itemId){
        for (var item:stockItems) {
            if (item.getItemId() == itemId){
                return item;
            }
        }

        return null;
    }

    public ArrayList<StockItem> getItemsByName(String itemName) {
        ArrayList<StockItem> items = new ArrayList<>();
        for (var item: stockItems) {
            if (item.getItemName().equals(itemName))
                items.add(item);
        }

        return items;
    }

    public ArrayList<StockItem> getItemsByCategory(String itemCategory) {
        ArrayList<StockItem> items = new ArrayList<>();
        for (var item: stockItems) {
            if (item.getItemName().equals(itemCategory))
                items.add(item);
        }

        return items;
    }

    public ArrayList<StockItem> getMostExpensiveItems() {
        ArrayList<StockItem> items = new ArrayList<>(stockItems);
        Collections.sort(items);
        return items;
    }

    public ArrayList<StockItem> getCheapestItems() {
        ArrayList<StockItem> items = new ArrayList<>(stockItems);
        Collections.sort(items);
        return items;
    }

    public ArrayList<StockItem> getMostExpensiveItemsByName(String itemName){
        ArrayList<StockItem> items = new ArrayList<>();

        for(var item: stockItems) {
            if (item.getItemName().equals(itemName))
                items.add(item);
        }
        Collections.sort(items);
        return items;
    }

    public ArrayList<StockItem> getCheapestItemsByName() {
        return null;
    }

    public ArrayList<StockItem> getMostExpensiveItemsByCategory(String itemCategory){
        ArrayList<StockItem> items = new ArrayList<>();

        for(var item: stockItems) {
            if (item.getItemCategory().equals(itemCategory))
                items.add(item);
        }
        Collections.sort(items);
        return items;
    }

    public ArrayList<StockItem> getCheapestItemsByCategory(String itemCategory){
        return null;
    }

    public <T>ArrayList<T> getItemsByType(Class<T> type) {
        ArrayList<T> items = new ArrayList<>();

        for(var item: stockItems) {
            if (type.isInstance(item))
                items.add((T)item);
        }

        return items;
    }

    public String generateReport() {
        String report = "Stock Item Report\n";

        for (var item: stockItems) {
            report += item.toString() + "\n";
        }

        return report;
    }
}
