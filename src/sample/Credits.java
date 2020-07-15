package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Credits {
    public Scene scene;
    public Button home_button;
    public Credits() {
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

        Label heading = new Label("Credits");
        heading.setFont(Font.font(30));
        heading.setPadding(new Insets(10,0,10,0));
        vBoxHeading.getChildren().add(heading);

        ImageView creators_image = new ImageView();
        Image image = new Image("sample/static/kaushal.jpg");
        creators_image.setImage(image);
        creators_image.setFitHeight(320);
        creators_image.setFitWidth(213.28);
        vBoxHeading.getChildren().add(creators_image);

        Label name = new Label("Kaushal Sharma");
        name.setStyle("-fx-font-family: Corbel; -fx-text-fill: #202020; -fx-background-color: transparent; -fx-wrap-text: true;");
        name.setFont(Font.font(25));
        vBoxHeading.getChildren().add(name);

        Label linkedin = new Label("LinkedIn ID");
        linkedin.getStyleClass().add("instructions");
        vBoxHeading.getChildren().add(linkedin);

        Hyperlink hyperlink = new Hyperlink("https://www.linkedin.com/in/kaushal-sharma-92b548136/");
        hyperlink.setStyle("-fx-font-size: 17.5px; -fx-font-family: Corbel; -fx-text-fill: #202020; -fx-background-color: transparent; -fx-wrap-text: true;");
        vBoxHeading.getChildren().add(hyperlink);

        ImageView home_icon = new ImageView();
        image = new Image("sample/static/home.png");
        home_icon.setImage(image);
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
