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

public class About {
    public Scene scene;
    public Button home_button;
    public About() {
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

        Label heading = new Label("About");
        heading.setFont(Font.font(30));
        heading.setPadding(new Insets(10,0,10,0));
        vBoxHeading.getChildren().add(heading);

        Label point1 = new Label("- This Game is a replica of original 2048 Game");
        point1.getStyleClass().add("instructions");
        point1.setMinWidth(500);
        point1.setAlignment(Pos.CENTER_LEFT);

        Label point2 = new Label("- Add two similar tile next to each other to make highest possible tile");
        point2.getStyleClass().add("instructions");
        point2.setMinWidth(500);
        point2.setAlignment(Pos.CENTER_LEFT);

        Label point3 = new Label("- There are 4 possible moves: UP, DOWN, RIGHT, LEFT");
        point3.getStyleClass().add("instructions");
        point3.setMinWidth(500);
        point3.setAlignment(Pos.CENTER_LEFT);

        Label point4 = new Label("- Make move to get the highest possible score");
        point4.getStyleClass().add("instructions");
        point4.setMinWidth(500);
        point4.setAlignment(Pos.CENTER_LEFT);

        Label all_the_best = new Label("All The Best!!!");
        all_the_best.setFont(Font.font(25));
        all_the_best.setMinWidth(500);
        all_the_best.setAlignment(Pos.CENTER);
        all_the_best.setPadding(new Insets(50, 0, 0, 0));

        vBoxHeading.getChildren().addAll(point1, point2, point3, point4, all_the_best);

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
