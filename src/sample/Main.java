package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StockManager stockManager = new StockManager();

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

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        ScrollPane sp = new ScrollPane();
        sp.setContent(root);
        sp.setPannable(true);

        sp.setPrefWidth(500);

        for (var stockItem: stockManager.getAllItems()) {
            HBox box = new HBox(20);
            box.getChildren().add(new Text(stockItem.getItemName()));
            box.getChildren().add(new Button("Item Info"));
            box.getChildren().add(new Button("Remove Item"));
            root.getChildren().add(box);
        }

        Pane pane = new Pane();
        pane.getChildren().add(sp);

        sp.prefHeightProperty().bind(pane.heightProperty());

        Scene scene = new Scene(pane, 1000, 600);
        primaryStage.setTitle("Stock Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
