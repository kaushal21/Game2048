package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Index extends Application {
    Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("2048");
        stage.getIcons().add(new Image("sample/static/2048_logo.png"));
        StackPane stackPane = new StackPane();
        Group root = new Group();

        ImageView title_image = new ImageView();
        Image img = new Image("sample/static/2048_animation2.gif");
        title_image.setImage(img);
        title_image.setFitHeight(430);
        title_image.setFitWidth(430);
        title_image.setX(35);

        Button about = new Button("About");
        about.getStyleClass().add("index-button");
        about.setLayoutX(30);
        about.setLayoutY(440);
        about.setOnMouseClicked(mouseEvent -> {
            About ins = new About();
            stage.setScene(ins.scene);
            ins.home_button.setOnMouseClicked(mouseEvent1 -> {
                stage.setScene(scene);
            });
        });

        Button play = new Button("Play");
        play.getStyleClass().add("index-button");
        play.setLayoutX(180);
        play.setLayoutY(440);

        Button instructions = new Button("Instructions");
        instructions.getStyleClass().add("index-button");
        instructions.setLayoutX(330);
        instructions.setLayoutY(440);
        instructions.setOnMouseClicked(mouseEvent -> {
            Instructions ins = new Instructions();
            stage.setScene(ins.scene);
            ins.home_button.setOnMouseClicked(mouseEvent1 -> {
                stage.setScene(scene);
            });
        });

        Button high_score = new Button("High Score");
        high_score.getStyleClass().add("index-button");
        high_score.setLayoutX(105);
        high_score.setLayoutY(520);
        high_score.setOnMouseClicked(mouseEvent -> {
            List<List<String>> temp = new ArrayList<>();
            List<List<String>> temp1 = new ArrayList<>();
            List<String> t = new ArrayList<>();
            t.add("1");
            t.add("Harsh");
            t.add("1289670");
            temp.add(t);
            List<String> t1 = new ArrayList<>();
            t1.add("2");
            t1.add("Kaushal");
            t1.add("128967");
            temp.add(t1);
            System.out.println(temp);
            HighScore highScore = new HighScore();
            stage.setScene(highScore.scene);
            try {
                highScore.WriteScores(temp);
                temp1 = highScore.ReadScore();
                System.out.println(temp1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            highScore.home_button.setOnMouseClicked(mouseEvent1 -> {
                stage.setScene(scene);
            });
        });

        Button credits = new Button("Credits");
        credits.getStyleClass().add("index-button");
        credits.setLayoutX(255);
        credits.setLayoutY(520);
        credits.setOnMouseClicked(mouseEvent -> {
            Credits ins = new Credits();
            stage.setScene(ins.scene);
            ins.home_button.setOnMouseClicked(mouseEvent1 -> {
                stage.setScene(scene);
            });
        });

        root.getChildren().addAll(title_image);
        root.getChildren().addAll(about, play, instructions, high_score, credits);
        stackPane.getChildren().add(root);
        stackPane.getStyleClass().add("background");
        scene = new Scene(stackPane, 500, 600);
        scene.getStylesheets().add("sample/static/A2048.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
