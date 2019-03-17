package sample;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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

    public StockItem(String name, double price, boolean isOnSale, String itemDescription, String itemCategory) {
        this.name = name;
        this.price = price;
        this.isOnSale = isOnSale;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
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
        return getItemSummary() + getItemTypeDetails();
    }

    @Override
    public int compareTo(StockItem o) {
        return Double.compare(o.getPrice(), price);
    }


    public abstract String getItemTypeDetails();
    public abstract String getItemSummary();

    public Pane drawInfoFillInNode(Main main, StockManager stockManager, boolean isAddWindow) {
        VBox pane = new VBox();

        Text nameLabel = new Text("Name");
        TextField nameTextArea = new TextField();
        Text categoryLabel = new Text("Category");
        TextField categoryTextArea = new TextField();
        Text descriptionLabel = new Text("Description");
        TextArea itemDescriptionTextArea = new TextArea();
        Text priceLabel = new Text("Price");
        TextField itemPriceTextField = new TextField();

        Button addButton = new Button("Add");

        addButton.setOnAction(j ->
        {
            name = nameTextArea.getText();
            itemCategory = categoryTextArea.getText();
            itemDescription = itemDescriptionTextArea.getText();
            price = Double.parseDouble(itemPriceTextField.getText());

            if (isAddWindow) {
                stockManager.addItem(this);
                main.drawUnsortedItemsPane(stockManager);
            }
        });

        pane.getChildren().addAll(nameLabel, nameTextArea, categoryLabel, categoryTextArea, descriptionLabel, itemDescriptionTextArea, priceLabel, itemPriceTextField, addButton);

        return pane;
    }
}
