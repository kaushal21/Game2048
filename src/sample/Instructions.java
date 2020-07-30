package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Instructions {
    public Scene scene;                                 // Contains the Main Scene for this page
    public Button home_button;                          // Home Button which take this page back to index
    public Instructions() {
        // Main root Vertical Box, that Contains every element in this page
        VBox root = new VBox();
        root.getStyleClass().add("background");
        root.setMinWidth(500);
        root.setMinHeight(600);

        // Vertical Box that stores the heading of the Page and the body of the page
        VBox vBoxHeading = new VBox();
        vBoxHeading.setMinWidth(500);
        vBoxHeading.setMinHeight(525);
        vBoxHeading.setAlignment(Pos.TOP_CENTER);

        // Vertical Box that stores the Home Button
        VBox vBoxButton = new VBox();
        vBoxButton.setMinWidth(500);
        vBoxButton.setAlignment(Pos.TOP_CENTER);

        // Label for the Heading
        Label heading = new Label("Instructions");
        heading.setFont(Font.font(30));
        heading.setPadding(new Insets(10,0,10,0));
        vBoxHeading.getChildren().add(heading);

        // Rules for playing the Game
        String[] rules = {
                "> \tUse Arrow key to move tile in UP, DOWN, RIGHT and LEFT direction.",
                "> \tUse ESC key to exit the game.",
                "> \tIf the made move is not possible then a alert message will be shown.",
                "> \tIf there is no possible left then the game is over and the game over message will be shown.",
                "> \tTile's with only same numbers combined together."
        };

        // Using for loop to Create label for each point in this page
        for(int i = 0; i < rules.length; i++) {
            Label rule = new Label(rules[i]);
            rule.setMaxWidth(500);
            rule.setAlignment(Pos.TOP_LEFT);
            rule.setTextAlignment(TextAlignment.LEFT);
            rule.setPadding(new Insets(2.5, 0, 2.5, 10));
            rule.setStyle("    -fx-font-size: 17.5px;\n" +
                    "    -fx-font-family: Corbel;\n" +
                    "    -fx-min-width: inherit;\n" +
                    "    -fx-text-fill: #202020;\n" +
                    "    -fx-wrap-text: true;\n");
            vBoxHeading.getChildren().add(rule);
        }

        // Creating the Home Button with an Image
        ImageView home_icon = new ImageView();
        Image img = new Image("sample/static/home.png");
        home_icon.setImage(img);
        home_icon.setFitWidth(50);
        home_icon.setFitHeight(50);
        home_button = new Button("", home_icon);
        home_button.getStyleClass().add("home-button");
        vBoxButton.getChildren().add(home_button);

        // Adding the Heading and Button to the root
        root.getChildren().addAll(vBoxHeading, vBoxButton);
        scene = new Scene(root, 500, 600);
        scene.getStylesheets().add("sample/static/A2048.css");
    }
}
