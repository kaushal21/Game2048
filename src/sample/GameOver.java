package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameOver {
    public static void gameOver(long score) {
        // This stores the boolean answer by the user.
        // Create a new Stage to Accept the Number of Players
        Stage newWindow = new Stage();

        // This makes the new Window a compulsory window
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.setTitle("Game Over");                                // Set the Title of the window
        newWindow.setMinWidth(250);                                     // Set the Minimum width of the Window

        Label gameOver = new Label("Game Over!!!");                  // Label Used to display the message
        Label yourScore = new Label("Your Score is "+score);         // Display the Score
        Button exit = new Button("Exit");                            // Create a Submit button
        exit.setOnAction(e -> newWindow.close());

        // Create a VBox to display this layout on the screen
        VBox layout = new VBox(10);
        layout.getChildren().addAll(gameOver, yourScore, exit);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(5, 10, 5, 10));

        Scene newScene = new Scene(layout, 250, 100);
        newWindow.setScene(newScene);
        newWindow.showAndWait();
    }
}


