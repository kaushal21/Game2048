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
    boolean enterValidMove, invalidEntry;
    int number, block;
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
        play.setOnMouseClicked(mouseEvent -> {
            Movement movement = new Movement();
            Game game = new Game(movement);

            game.scene.setOnKeyReleased(event -> {
                enterValidMove = false;
                invalidEntry = false;
                while (!enterValidMove) {
                    switch (event.getCode()) {
                        case ESCAPE:
                            if (ConfirmationBox.confirmationBox("Are You Sure You Want To Quit?"))
                                stage.close();
                            invalidEntry = true;
                            enterValidMove = true;
                            break;
                        case UP:
                            String moveCheck = movement.up();
                            if (moveCheck.equals("u")) {
                                System.out.println("Enter A Valid Move");
                                AlertBox.alertBox("Enter A Valid Move");
                                invalidEntry = true;
                            }
                            enterValidMove = true;
                            break;
                        case DOWN:
                            moveCheck = movement.down();
                            if (moveCheck.equals("d")) {
                                System.out.println("Enter A Valid Move");
                                AlertBox.alertBox("Enter A Valid Move");
                                invalidEntry = true;
                            }
                            enterValidMove = true;
                            break;
                        case LEFT:
                            moveCheck = movement.left();
                            if (moveCheck.equals("l")) {
                                System.out.println("Enter A Valid Move");
                                AlertBox.alertBox("Enter A Valid Move");
                                invalidEntry = true;
                            }
                            enterValidMove = true;
                            break;
                        case RIGHT:
                            moveCheck = movement.right();
                            if (moveCheck.equals("r")) {
                                System.out.println("Enter A Valid Move");
                                AlertBox.alertBox("Enter A Valid Move");
                                invalidEntry = true;
                            }
                            enterValidMove = true;
                            break;
                        default:
                            System.out.println("Enter A Valid Move");
                            AlertBox.alertBox("Enter A Valid Move");
                            invalidEntry = true;
                            enterValidMove = true;
                            break;
                    }
                }
                if (!invalidEntry) {
                    game.root.getChildren().remove(game.gridPane);
                    number = movement.numberGeneration();
                    block = movement.blockGeneration();
                    movement.setA(block, number);
                    movement.setGrid(block);
                    game.gridPane = game.board(movement);
                    game.root.getChildren().add(game.gridPane);
                    game.yourScoreNumber.setText(Long.toString(movement.getScore()));
                    if ( movement.getScore() > movement.getHighScore() ) {
                        game.highScoreNumber.setText(Long.toString(movement.getScore()));
                    }

                    if (movement.gameOver()) {
                        System.out.println("Final Score: " + movement.getScore());
                        GameOver gameOver = new GameOver();
                        gameOver.gameOver(movement.getScore());
                        HighScore hs = new HighScore();
                        List<List<String>> list = hs.ReadScore();
                        System.out.println(list);
                        List<List<String>> finalList = new ArrayList<>();
                        if ( list.size() - 1 == 0 ) {
                            List<String> temp = new ArrayList<>();
                            temp.add("1");
                            if (gameOver.givenName.equals(""))
                                temp.add("Anonymous");
                            else
                                temp.add(gameOver.givenName);
                            temp.add(Long.toString(movement.getScore()));
                            finalList.add(temp);
                            try {
                                hs.WriteScores(finalList);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            int i1 = 0;
                            long[] score = new long[list.size() - 1];
                            String[] name = new String[list.size() - 1];
                            for (List<String> temp : list) {
                                if (i1 != 0) {
                                    score[i1 - 1] = Long.valueOf(temp.get(2));
                                    name[i1 - 1] = temp.get(1);
                                }
                                i1++;
                            }
                            for (int i = 0; i < list.size() - 1; i++) {
                                System.out.println(i + 1 + ". " + name[i] + " " + score[i]);
                            }
                            int k = 0, i;
                            boolean added = false;
                            for (i = 0; i < list.size() - 1 && i < 9; i++) {
                                List<String> listRow = new ArrayList<>();
                                listRow.add(String.valueOf(i + 1));
                                if (movement.score > score[k] && !added ) {
                                    if (gameOver.givenName.equals(""))
                                        listRow.add("Anonymous");
                                    else
                                        listRow.add(gameOver.givenName);
                                    listRow.add(String.valueOf(movement.score));
                                    System.out.println(listRow);
                                    finalList.add(listRow);
                                    added = true;
                                } else {
                                    listRow.add(name[k]);
                                    listRow.add(Long.toString(score[k]));
                                    System.out.println(listRow);
                                    finalList.add(listRow);
                                    k++;
                                }
                            }
                            if ( i < 9 && !added ) {
                                List<String> listRow = new ArrayList<>();
                                listRow.add(String.valueOf(i + 1));
                                if (gameOver.givenName.equals(""))
                                    listRow.add("Anonymous");
                                else
                                    listRow.add(gameOver.givenName);
                                listRow.add(String.valueOf(movement.score));
                                System.out.println(listRow);
                                finalList.add(listRow);
                            }
                            if ( i < list.size() - 1 ) {
                                for (;i < list.size() - 1 && i < 9; i++) {
                                    List<String> listRow = new ArrayList<>();
                                    listRow.add(String.valueOf(i + 1));
                                    listRow.add(name[k]);
                                    listRow.add(Long.toString(score[k]));
                                    System.out.println(listRow);
                                    finalList.add(listRow);
                                    k++;
                                }
                            }
                            System.out.println(finalList);
                            try {
                                hs.WriteScores(finalList);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        stage.setScene(scene);
                    }
                }
            });
            stage.setScene(game.scene);
            game.home_button.setOnMouseClicked(mouseEvent1 -> {
                stage.setScene(scene);
            });
        });

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
            HighScore highScore = new HighScore();
            stage.setScene(highScore.scene);
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
