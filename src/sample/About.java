package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class About {
    public Scene scene;
    public Button home_button;
    public About() {
        StackPane stackPane = new StackPane();
        Group root = new Group();

        Label heading = new Label("About");
        heading.setFont(Font.font(30));
        heading.setLayoutX(205);

        Label point1 = new Label("- This Game is a replica of original 2048 Game");
        point1.getStyleClass().add("instructions");
        point1.setLayoutY(75);
        point1.setLayoutX(0);

        Label point2 = new Label("- Add two similar tile next to each other to make highest possible tile");
        point2.getStyleClass().add("instructions");
        point2.setLayoutY(125);
        point2.setLayoutX(0);

        Label point3 = new Label("- There are 4 possible moves: UP, DOWN, RIGHT, LEFT");
        point3.getStyleClass().add("instructions");
        point3.setLayoutY(175);
        point3.setLayoutX(0);

        Label point4 = new Label("- Make move to get the highest possible score");
        point4.getStyleClass().add("instructions");
        point4.setLayoutY(225);
        point4.setLayoutX(0);

        Label all_the_best = new Label("All The Best!!!");
        all_the_best.setFont(Font.font(25));
        all_the_best.setLayoutX(175);
        all_the_best.setLayoutY(300);

        ImageView home_icon = new ImageView();
        Image img = new Image("sample/static/home.png");
        home_icon.setImage(img);
        home_icon.setFitWidth(50);
        home_icon.setFitHeight(50);
        home_button = new Button("", home_icon);
        home_button.setLayoutX(224);
        home_button.setLayoutY(500);
        home_button.getStyleClass().add("home-button");

        root.getChildren().add(heading);
        root.getChildren().addAll(point1, point2, point3, point4, all_the_best);
        root.getChildren().add(home_button);

        stackPane.getChildren().add(root);
        stackPane.getStyleClass().add("background");
        scene = new Scene(stackPane, 500, 600);
        scene.getStylesheets().add("sample/static/A2048.css");
    }
}
