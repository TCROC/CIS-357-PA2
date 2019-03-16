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

        VBox itemsList = new VBox();
        itemsList.setSpacing(10);
        itemsList.setPadding(new Insets(10));
        ScrollPane sp = new ScrollPane();
        sp.setContent(itemsList);
        sp.setPannable(true);

        sp.setPrefWidth(500);

        for (var stockItem: stockManager.getAllItems()) {
            HBox box = new HBox(20);
            box.getChildren().add(new Text(stockItem.getItemName()));
            Button infoButton = new Button("Item Info");
            infoButton.setOnAction(i -> drawItemSummaryWindow(stockItem));
            box.getChildren().add(infoButton);
            box.getChildren().add(new Button("Remove Item"));
            itemsList.getChildren().add(box);
        }

        mainVerticalPanel.getChildren().add(sp);

        sp.prefHeightProperty().bind(rootPane.heightProperty());

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

        Computer computer = new Computer();

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
        addButton.setOnAction(i -> stockManager.addItem(computer));

        pane.getChildren().addAll(nameLabel, nameTextArea, categoryLabel, categoryTextArea, descriptionLabel, itemDescriptionTextArea, priceLabel, itemPriceTextField, addButton);

        secondaryWindow= new Stage();
        secondaryWindow.setTitle("Add Item");
        secondaryWindow.setScene(new Scene(pane, 450, 450));


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

}
