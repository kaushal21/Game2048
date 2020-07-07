package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationBox {
    static boolean answer;
    public static boolean confirmationBox(String message) {
        // This stores the boolean answer by the user.
        // Create a new Stage to Accept the Number of Players
        Stage newWindow = new Stage();

        // This makes the new Window a compulsory window
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.setTitle("Confirmation box");                         // Set the Title of the window
        newWindow.setMinWidth(250);                                     // Set the Minimum width of the Window

        Label name = new Label(message);                                // Label Used to display the message
        Button yes = new Button("Yes");                              // Create a Yes button
        Button no = new Button("No");                                // Create a No button
        yes.setOnAction(e -> {
            answer = true;
            newWindow.close();
        });
        no.setOnAction(e -> {
            answer = false;
            newWindow.close();
        });

        // Create a VBox to display this layout on the screen
        VBox layout = new VBox(10);
        layout.getChildren().addAll(name, yes, no);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(5, 10, 5, 10));

        Scene newScene = new Scene(layout, 300, 250);
        newWindow.setScene(newScene);
        newWindow.showAndWait();

        // return the entered value
        return answer;
    }
}
