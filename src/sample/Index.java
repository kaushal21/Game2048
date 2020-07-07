package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Index extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("2048");
        stage.getIcons().add(new Image("sample/static/2048_logo.png"));
        final Group root = new Group();

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
        Button play = new Button("Play");
        play.getStyleClass().add("index-button");
        play.setLayoutX(180);
        play.setLayoutY(440);
        Button instructions = new Button("Instructions");
        instructions.getStyleClass().add("index-button");
        instructions.setLayoutX(330);
        instructions.setLayoutY(440);
        Button high_score = new Button("High Score");
        high_score.getStyleClass().add("index-button");
        high_score.setLayoutX(105);
        high_score.setLayoutY(520);
        Button credits = new Button("Credits");
        credits.getStyleClass().add("index-button");
        credits.setLayoutX(255);
        credits.setLayoutY(520);

        root.getChildren().addAll(title_image);
        root.getChildren().addAll(about, play, instructions, high_score, credits);
        Scene scene = new Scene(root, 500, 600);
        scene.getStylesheets().add("sample/static/A2048.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
