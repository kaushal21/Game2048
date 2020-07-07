package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void alertBox(String message) {
        // This stores the boolean answer by the user.
        // Create a new Stage to Accept the Number of Players
        Stage newWindow = new Stage();

        // This makes the new Window a compulsory window
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.setTitle("Invalid Move");                                // Set the Title of the window
        newWindow.setMinWidth(250);                                     // Set the Minimum width of the Window

        Label name = new Label(message);                                // Label Used to display the message
        Button ok = new Button("OK!!!");                            // Create a Submit button
        ok.setOnAction(e -> newWindow.close());

        // Create a VBox to display this layout on the screen
        VBox layout = new VBox(10);
        layout.getChildren().addAll(name, ok);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(5, 10, 5, 10));

        Scene newScene = new Scene(layout, 250, 100);
        newScene.getStylesheets().add("sample/static/A2048.css");

        newWindow.setScene(newScene);
        newWindow.showAndWait();
    }
}

