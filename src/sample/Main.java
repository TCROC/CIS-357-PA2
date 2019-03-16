package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
            } else {
                Apple a = new Apple();
                stockItem = a;
            }

            stockManager.addItem(stockItem);
        }

        BorderPane borderPane = new BorderPane();

        Text input1Label = new Text(" Number 1: ");
        Text input2Label = new Text(" Number 2: ");
        Text resultLabel = new Text(" Result: ");

        HBox hInputs = new HBox();

        Button btnAdd = new Button("Add");
        Button btnSubtract = new Button("Subtract");
        Button btnMultiply = new Button("Multiply");
        Button btnDivide = new Button("Divide");

        HBox hButtons = new HBox(20);
        hButtons.getChildren().addAll(btnAdd, btnSubtract, btnMultiply, btnDivide);

        borderPane.setBottom(hButtons);
        borderPane.setPrefSize(400, 400);
        BorderPane.setAlignment(hInputs, Pos.CENTER);
        BorderPane.setAlignment(hButtons, Pos.CENTER);

        borderPane.setCenter(hInputs);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Rectangle Rotator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
