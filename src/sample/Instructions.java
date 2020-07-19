package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Instructions {
    public Scene scene;
    public Button home_button;
    public Instructions() {
        VBox root = new VBox();
        root.getStyleClass().add("background");
        root.setMinWidth(500);
        root.setMinHeight(600);

        VBox vBoxHeading = new VBox();
        vBoxHeading.setMinWidth(500);
        vBoxHeading.setMinHeight(525);
        vBoxHeading.setAlignment(Pos.TOP_CENTER);

        VBox vBoxButton = new VBox();
        vBoxButton.setMinWidth(500);
        vBoxButton.setAlignment(Pos.TOP_CENTER);

        Label heading = new Label("Instructions");
        heading.setFont(Font.font(30));
        heading.setPadding(new Insets(10,0,10,0));
        vBoxHeading.getChildren().add(heading);

        Label rule1 = new Label("- Use Arrow key to move tile");
        rule1.getStyleClass().add("instructions");
        rule1.setMinWidth(500);
        rule1.setAlignment(Pos.TOP_LEFT);

        Label rule2 = new Label("- Use ESC key to exit the game");
        rule2.getStyleClass().add("instructions");
        rule2.setMinWidth(500);
        rule2.setAlignment(Pos.TOP_LEFT);

        Label rule3 = new Label("- If no move is possible the an alert message will be shown");
        rule3.getStyleClass().add("instructions");
        rule3.setMinWidth(500);
        rule3.setAlignment(Pos.TOP_LEFT);

        Label rule4 = new Label("- Only tile with same numbers combined together");
        rule4.getStyleClass().add("instructions");
        rule4.setMinWidth(500);
        rule4.setAlignment(Pos.TOP_LEFT);

        vBoxHeading.getChildren().addAll(rule1, rule2, rule3, rule4);

        ImageView home_icon = new ImageView();
        Image img = new Image("sample/static/home.png");
        home_icon.setImage(img);
        home_icon.setFitWidth(50);
        home_icon.setFitHeight(50);
        home_button = new Button("", home_icon);
        home_button.getStyleClass().add("home-button");
        vBoxButton.getChildren().add(home_button);

        root.getChildren().addAll(vBoxHeading, vBoxButton);
        scene = new Scene(root, 500, 600);
        scene.getStylesheets().add("sample/static/A2048.css");
    }
}
