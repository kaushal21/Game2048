package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

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

        HBox hBox = new HBox();
        String m = "2048 is a very addictive game. After playing it for quite a while, I decided to code this game on my own. " +
                "After Cracking my own way of implementing this game, I made this with a little graphics using javaFX, which I have recently learned. " +
                "This is a my way of replicating the 2048.";
        Label motivation_heading = new Label("Motivation:");
        motivation_heading.setMinWidth(110);
        motivation_heading.getStyleClass().add("instructions");
        motivation_heading.setStyle("-fx-font-weight: bold;");
        Label motivation = new Label(m);
        motivation.getStyleClass().add("instructions");
        motivation.setTextAlignment(TextAlignment.JUSTIFY);
        hBox.getChildren().addAll(motivation_heading, motivation);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        vBoxHeading.getChildren().addAll(hBox);

        HBox hBox1 = new HBox();
        Label originalAuthorHeading = new Label("Original Author:");
        originalAuthorHeading.setMinWidth(130);
        originalAuthorHeading.getStyleClass().add("instructions");
        originalAuthorHeading.setStyle("-fx-font-weight: bold;");
        Label originalName = new Label("Gabriele Cirulli");
        originalName.getStyleClass().add("instructions");

        hBox1.getChildren().addAll(originalAuthorHeading, originalName);
        hBox1.setAlignment(Pos.CENTER_LEFT);
        hBox1.setSpacing(10);

        HBox hBox2 = new HBox();
        Label writtenBy = new Label("This code is by :");
        writtenBy.setMinWidth(130);
        writtenBy.getStyleClass().add("instructions");
        writtenBy.setStyle("-fx-font-weight: bold;");
        Label name = new Label("Kaushal Sharma");
        name.getStyleClass().add("instructions");

        hBox2.getChildren().addAll(writtenBy, name);
        hBox2.setAlignment(Pos.CENTER_LEFT);
        hBox2.setSpacing(10);

        vBoxHeading.getChildren().addAll(hBox1, hBox2);

        Label linkedin = new Label("LinkedIn ID");
        linkedin.getStyleClass().add("instructions");
        linkedin.setStyle("-fx-font-weight: bold;");
        vBoxHeading.getChildren().add(linkedin);

        Hyperlink hyperlink = new Hyperlink("https://www.linkedin.com/in/kaushal-sharma-92b548136/");
        hyperlink.setStyle("-fx-font-size: 17.5px; -fx-font-family: Corbel; -fx-text-fill: #202020; -fx-background-color: transparent; -fx-wrap-text: true;");
        vBoxHeading.getChildren().add(hyperlink);

        ImageView home_icon = new ImageView();
        Image image = new Image("sample/static/home.png");
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
