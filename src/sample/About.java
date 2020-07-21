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
import javafx.scene.text.TextAlignment;

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

        String[] points = {
                "> \t2048 is played on a gray 4×4 grid, with numbered tiles that " +
                        "\nslide when a player moves them using the four arrow keys.",
                "> \tEvery turn, a new tile will randomly appear in an empty spot" +
                        "\non the board with a value of either 2 or 4.",
                "> \tTiles slide as far as possible in the chosen direction until" +
                        "\nthey are stopped by either another tile or the edge of the grid.",
                "> \tIf two tiles of the same number collide while moving, they " +
                        "\nwill merge into a tile with the total value of the two " +
                        "\ntiles that collided.",
                "> \tIf all four spaces in a row or column are filled with tiles " +
                        "\nof the same value, a move parallel to that row/column will " +
                        "\ncombine the first two and last two.",
                "> \tA scoreboard on the upper-right keeps track of the user's score.",
                "> \tThe user's score starts at zero, and is increased whenever two " +
                        "\ntiles combine, by the value of the new tile.",
                "> \tAs with many arcade games, the user's high score is shown " +
                        "\nalongside the current score."
        };

        for(int i = 0; i < points.length; i++) {
            Label point = new Label(points[i]);
            point.setMaxWidth(500);
            point.setPadding(new Insets(2.5, 0, 2.5, 10));
            point.setWrapText(true);
            point.setStyle("    -fx-font-size: 17.5px;\n" +
                    "    -fx-font-family: Corbel;\n" +
                    "    -fx-min-width: inherit;\n" +
                    "    -fx-text-fill: #202020;\n");
            vBoxHeading.getChildren().add(point);
        }

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
