package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class Instructions {
    public Scene scene;
    public Button home_button;
    public Instructions() {
        StackPane stackPane = new StackPane();
        Group root = new Group();

        Label heading = new Label("Instructions");
        heading.setFont(Font.font(30));
        heading.setLayoutX(135);

        Label rule1 = new Label("- Use Arrow key to move tile");
        rule1.getStyleClass().add("instructions");
        rule1.setLayoutY(75);
        rule1.setLayoutX(0);

        Label rule2 = new Label("- Use ESC key to exit the game");
        rule2.getStyleClass().add("instructions");
        rule2.setLayoutY(125);
        rule2.setLayoutX(0);

        Label rule3 = new Label("- If no move is possible the an alert message will be shown");
        rule3.getStyleClass().add("instructions");
        rule3.setLayoutY(175);
        rule3.setLayoutX(0);

        Label rule4 = new Label("- Only tile with same numbers combined together");
        rule4.getStyleClass().add("instructions");
        rule4.setLayoutY(225);
        rule4.setLayoutX(0);


        ImageView home_icon = new ImageView();
        Image img = new Image("sample/static/home.png");
        home_icon.setImage(img);
        home_icon.setFitWidth(50);
        home_icon.setFitHeight(50);
        home_button = new Button("", home_icon);
        home_button.setLayoutX(185);
        home_button.setLayoutY(500);
        home_button.getStyleClass().add("home-button");

        root.getChildren().add(heading);
        root.getChildren().addAll(rule1, rule2, rule3, rule4);
        root.getChildren().add(home_button);

        stackPane.getChildren().add(root);
        stackPane.getStyleClass().add("background");
        scene = new Scene(stackPane, 500, 600);
        scene.getStylesheets().add("sample/static/A2048.css");
    }
}
