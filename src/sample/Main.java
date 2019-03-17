package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    Stage secondaryWindow = null;
    StockManager stockManager = new StockManager();
    ScrollPane itemsPane = new ScrollPane();

    @Override
    public void start(Stage primaryStage) throws Exception{
        stockManager = new StockManager();
        Pane rootPane = new Pane();

        Random r = new Random();

        for (int i=0; i<500; i++) {
            int randomR = r.nextInt();
            StockItem stockItem = null;

            if (randomR > 0) {
                Computer c = new Computer();
                stockItem = c;
                c.setItemName("Computer");
            } else {
                Apple a = new Apple();
                stockItem = a;
                a.setItemName("Apple");
            }

            stockManager.addItem(stockItem);
        }

        VBox mainVerticalPanel = new VBox();

        ToolBar toolBar = new ToolBar();
        Button addButton = new Button("Add Item");
        addButton.setOnAction(i -> drawAddItemWindow(stockManager));
        toolBar.getItems().add(addButton);

        toolBar.prefWidthProperty().bind(mainVerticalPanel.widthProperty());

        mainVerticalPanel.getChildren().add(toolBar);
        mainVerticalPanel.prefHeightProperty().bind(rootPane.heightProperty());
        mainVerticalPanel.prefWidthProperty().bind(rootPane.widthProperty());

        rootPane.getChildren().add(mainVerticalPanel);

        refreshItemsPane(stockManager);

        mainVerticalPanel.getChildren().add(itemsPane);

        itemsPane.prefHeightProperty().bind(rootPane.heightProperty());

        Scene scene = new Scene(rootPane, 1000, 600);
        primaryStage.setTitle("Stock Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void drawAddItemWindow(StockManager stockManager){
        if (secondaryWindow != null)
            secondaryWindow.close();

        ComboBox<String> comboBox = new ComboBox<>();

        VBox mainPane = new VBox();

        mainPane.getChildren().add(comboBox);

        VBox fieldFillOutPane = new VBox();

        comboBox.getItems().addAll(
                "Apple",
                "Computer"
        );

        comboBox.valueProperty().addListener(i -> {
            fieldFillOutPane.getChildren().clear();
            switch (comboBox.getValue()){
                case "Apple":
                    fieldFillOutPane.getChildren().add(new Apple().drawInfoFillInNode(this, stockManager));
                    break;
                case "Computer":
                    fieldFillOutPane.getChildren().add(new Computer().drawInfoFillInNode(this, stockManager));
                    break;
            }
        });

        mainPane.getChildren().add(fieldFillOutPane);

        secondaryWindow= new Stage();
        secondaryWindow.setTitle("Add Item");
        secondaryWindow.setScene(new Scene(mainPane, 450, 450));
        secondaryWindow.show();
    }

    public void drawItemSummaryWindow(StockItem stockItem) {

        if (secondaryWindow != null)
            secondaryWindow.close();

        Pane pane = new Pane();
        Text info = new Text(stockItem.getItemSummary());

        pane.getChildren().add(info);

        secondaryWindow = new Stage();
        secondaryWindow.setTitle("Item Summary: " + stockItem.getItemName());
        secondaryWindow.setScene(new Scene(pane, 450, 450));
        secondaryWindow.show();
    }

    public void refreshItemsPane(StockManager stockManager) {
        VBox itemsListPanel = new VBox();

        itemsListPanel.setSpacing(10);
        itemsListPanel.setPadding(new Insets(10));
        itemsPane.setContent(itemsListPanel);
        itemsPane.setPannable(true);

        itemsPane.setPrefWidth(500);

        for (var stockItem: stockManager.getAllItems()) {
            HBox box = new HBox(20);
            box.getChildren().add(new Text(stockItem.getItemName()));
            Button infoButton = new Button("Item Info");
            infoButton.setOnAction(i -> drawItemSummaryWindow(stockItem));
            box.getChildren().add(infoButton);
            box.getChildren().add(new Button("Remove Item"));
            itemsListPanel.getChildren().add(box);
        }
    }
}
