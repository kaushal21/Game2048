package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    boolean enterValidMove;
    Movement movement = new Movement();
    int number;
    int block;
    boolean termination = false, invalidEntry = false;
    GridPane gridPane;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("2048");
        primaryStage.getIcons().add(new Image("sample/static/2048_logo.png"));
        final Group root = new Group();
        root.getStyleClass().add("background");

        Label heading = new Label("2048");
        heading.setFont(Font.font(30));
        heading.setPadding(new Insets(10,0,10,0));
        root.getChildren().add(heading);

        number = movement.numberGeneration();
        block = movement.blockGeneration();
        movement.setA(block, number);
        movement.setGrid(block);
        gridPane = board();
        root.getChildren().add(gridPane);

        Scene scene = new Scene(root, 500, 600);
        scene.getStylesheets().add("sample/static/A2048.css");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        scene.setOnKeyPressed(event -> {
            enterValidMove = false;
            invalidEntry = false;
            while ( !enterValidMove ) {
                switch (event.getCode()) {
                    case ESCAPE:
                        if ( ConfirmationBox.confirmationBox("Are You Sure You Want To Quit?") )
                            primaryStage.close();
                        invalidEntry = true;
                        enterValidMove = true;
                        break;
                    case UP:
                        String moveCheck = movement.up();
                        if ( moveCheck.equals("u") ) {
                            System.out.println("Enter A Valid Move");
                            AlertBox.alertBox("Enter A Valid Move");
                            invalidEntry = true;
                        }
                        enterValidMove = true;
                        break;
                    case DOWN:
                        moveCheck = movement.down();
                        if ( moveCheck.equals("d") ) {
                            System.out.println("Enter A Valid Move");
                            AlertBox.alertBox("Enter A Valid Move");
                            invalidEntry = true;
                        }
                        enterValidMove = true;
                        break;
                    case LEFT:
                        moveCheck = movement.left();
                        if ( moveCheck.equals("l") ) {
                            System.out.println("Enter A Valid Move");
                            AlertBox.alertBox("Enter A Valid Move");
                            invalidEntry = true;
                        }
                        enterValidMove = true;
                        break;
                    case RIGHT:
                        moveCheck = movement.right();
                        if ( moveCheck.equals("r") ) {
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
            if ( !invalidEntry ) {
                root.getChildren().remove(gridPane);
                number = movement.numberGeneration();
                block = movement.blockGeneration();
                movement.setA(block, number);
                movement.setGrid(block);
                gridPane = board();
                root.getChildren().add(gridPane);

                if (movement.gameOver()) {
                    System.out.println("Final Score: " + movement.getScore());
                    GameOver.gameOver(movement.getScore());
                    primaryStage.close();
                }
            }
        });
    }

    public GridPane board() {
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

    public static void main(String[] args) {
        launch(args);
    }
}
