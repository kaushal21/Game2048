package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Game {
    public Scene scene;
    GridPane gridPane;
    int number, block;
    Group root = new Group();
    Button home_button, highScoreNumber, yourScoreNumber;
    public Game(Movement movement) {
        root.getStyleClass().add("background");

        VBox vBox = new VBox();
        vBox.setMinHeight(100);
        vBox.setMaxHeight(100);
        vBox.setMinWidth(500);

        Label heading = new Label("2048");
        heading.setFont(Font.font(30));
        heading.setStyle("-fx-font-family: 'Britannic Bold';");
        heading.setPadding(new Insets(10,0,0,0));

        Label highScore = new Label("High Score");
        highScore.setFont(Font.font(20));
        highScore.setStyle("-fx-font-family: 'Comic Sans MS';");
        highScore.setPadding(new Insets(10,0,0,0));
        highScore.setLayoutX(250);
        highScore.setLayoutY(0);

        Label currentScore = new Label("Your Score");
        currentScore.setFont(Font.font(20));
        currentScore.setStyle("-fx-font-family: 'Comic Sans MS';");
        currentScore.setPadding(new Insets(10,0,0,0));
        currentScore.setLayoutX(366);
        currentScore.setLayoutY(0);

        root.getChildren().addAll(heading, highScore, currentScore);

        ImageView home_icon = new ImageView();
        Image img = new Image("sample/static/home.png");
        home_icon.setImage(img);
        home_icon.setFitWidth(40);
        home_icon.setFitHeight(40);
        home_button = new Button("", home_icon);
        home_button.getStyleClass().add("home-button");
        home_button.setLayoutX(0);
        home_button.setLayoutY(50);

        highScoreNumber = new Button(Long.toString(movement.getHighScore()));
        highScoreNumber.getStyleClass().add("score");
        highScoreNumber.setLayoutX(250);
        highScoreNumber.setLayoutY(50);

        yourScoreNumber = new Button(Long.toString(movement.getScore()));
        yourScoreNumber.getStyleClass().add("score");
        yourScoreNumber.setLayoutX(366);
        yourScoreNumber.setLayoutY(50);

        root.getChildren().addAll(home_button, highScoreNumber, yourScoreNumber);

        number = movement.numberGeneration();
        block = movement.blockGeneration();
        movement.setA(block, number);
        movement.setGrid(block);
        gridPane = board(movement);
        root.getChildren().add(gridPane);

        scene = new Scene(root, 500, 600);
        scene.getStylesheets().add("sample/static/A2048.css");
    }

    public GridPane board(Movement movement) {
        GridPane gridPane = new GridPane();
        gridPane.getStyleClass().add("game-board");
        gridPane.setPadding(new Insets(12, 12, 12, 12));
        gridPane.setVgap(12);
        gridPane.setHgap(12);
        gridPane.setLayoutY(100);
        int k = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                Label label1 = new Label();
                label1.getStyleClass().add("game-block");
                label1.setFont(Font.font(25));
                if ( movement.getA(k) != 0 ) {
                    label1.setText(String.valueOf(movement.getA(k)));
                    label1.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    String colorCode = "-fx-background-color: "+blockColor(movement.getA(k))+";";
                    label1.setStyle(colorCode);
                }
                GridPane.setConstraints(label1, j, i);
                gridPane.getChildren().add(label1);
                k++;
            }
        }
        return gridPane;
    }

    public String blockColor(int tile) {
        if ( tile == 2 )
            return "#FAFAD2";
        if ( tile == 4 )
            return "#FFE4B5";
        if ( tile == 8 )
            return "#EEE8AA";
        if ( tile == 16 )
            return "#FFA07A";
        if ( tile == 32 )
            return "#FF7F50";
        if ( tile == 64 )
            return "#FF6347";
        if ( tile == 128 )
            return "#FF4500";
        if ( tile == 256 )
            return "#FF8C00";
        if ( tile == 512 )
            return "#FFA500";
        if ( tile == 1024 )
            return "#FFD700";
        if ( tile == 2048 )
            return "#FFFF00";
        if ( tile == 4096 )
            return "#66CDAA";
        if ( tile == 8192 )
            return "#20B2AA";
        if ( tile == 16384 )
            return "#008B8B";
        if ( tile == 32768)
            return "#008080";
        if ( tile == 65536 )
            return "#0000CD";
        if ( tile == 131072 )
            return "#00008B";
        if ( tile == 262144 )
            return "#191970";
        return "";
    }
}
