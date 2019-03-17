package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Computer extends NonConsumable {

    protected String processor;
    protected String memory;
    protected String graphicsCard;

    public Computer() {}

    public Computer(String processor, String memory, String graphicsCard, String name, double price, boolean isOnSale, String itemDescription, String itemCategory) {
        super(name, price, isOnSale, itemDescription, itemCategory);
        this.processor = processor;
        this.memory = memory;
        this.graphicsCard = graphicsCard;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public String getItemTypeDetails() {
        String details = "\nDetails:\n";
        details += "Processor: " + getProcessor() + "\n";
        details += "Memory: " + getMemory() + "\n";
        details += "Graphics Card: " + getGraphicsCard() + "\n";
        return details;
    }

    @Override
    public String getItemSummary() {
        String summary = "";
        summary += "Name: " + getItemName() + "\n";
        summary += "Category: " + getItemCategory() + "\n";
        summary += "Description: " + getItemDescription() + "\n";
        summary += "Price: " + getPrice() + "\n";

        return summary;
    }

    @Override
    public int compareTo(StockItem o) {
        return (int) (o.getPrice() - getPrice());
    }

    @Override
    public Node drawInfoFillInNode(Main main, StockManager stockManager, boolean isAddWindow) {
        VBox pane = (VBox) super.drawInfoFillInNode(main, stockManager, false);

        Text processorLabel = new Text("Processor");
        TextField processorTextField = new TextField();
        Text memoryLabel = new Text("Memory");
        TextField memoryTextField = new TextField();
        Text graphicsCardLabel = new Text("Graphics Card");
        TextField graphicsCardTextField = new TextField();

        Button addButton = (Button) pane.getChildren().get(pane.getChildren().size() - 1);
        EventHandler<ActionEvent> current = addButton.getOnAction();

        addButton.setOnAction(i ->
        {
            current.handle(i);
            processor = processorTextField.getText();
            memory = memoryTextField.getText();
            graphicsCard = graphicsCardTextField.getText();

            if (isAddWindow) {
                stockManager.addItem(this);
                main.refreshItemsPane(stockManager);
            }
        });

        // Do this to make sure the add button is always at the bottom.
        pane.getChildren().remove(addButton);

        pane.getChildren().addAll(processorLabel, processorTextField, memoryLabel, memoryTextField, graphicsCardLabel, graphicsCardTextField, addButton);

        return pane;
    }
}
