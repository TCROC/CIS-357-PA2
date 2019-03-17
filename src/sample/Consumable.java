package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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

    public Node drawInfoFillInNode(Main main, StockManager stockManager) {
        Pane pane = (Pane) super.drawInfoFillInNode(main, stockManager);

        Text expirationDateLabel = new Text("Expiration Date");
        TextField dateTextField = new TextField();
        Text calorieCountLabel = new Text("Calorie Count");
        TextField categoryTextArea = new TextField();

        Button addButton = (Button) pane.getChildren().get(pane.getChildren().size() - 1);

        EventHandler<ActionEvent> current = addButton.getOnAction();

        addButton.setOnAction(i ->
        {
            current.handle(i);
            setExpirationDate(dateTextField.getText());
            setCalorieCount(Double.parseDouble(categoryTextArea.getText()));
            stockManager.addItem(this);
            main.refreshItemsPane(stockManager);
        });

        // Do this to make sure the add button is always at the bottom.
        pane.getChildren().remove(addButton);

        pane.getChildren().addAll(expirationDateLabel, dateTextField, calorieCountLabel, categoryTextArea, addButton);

        return pane;
    }
}
