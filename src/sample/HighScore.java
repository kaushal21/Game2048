package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighScore {
    public Scene scene;
    public Button home_button;
    public HighScore() {
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

        Label heading = new Label("High Score");
        heading.setFont(Font.font(30));
        heading.setPadding(new Insets(10,0,10,0));
        vBoxHeading.getChildren().add(heading);

        VBox listBox = new VBox();
        // ObservableList name = FXCollections.observableArrayList();
        List<List<String>> scores = ReadScore();
        int i1 = 0;
        for(List<String> temp: scores) {
            HBox listItem = new HBox();
            Label rank = new Label(temp.get(0));
            rank.setMinWidth(60);
            rank.setAlignment(Pos.CENTER);
            rank.getStyleClass().add("instructions");
            rank.setPadding(new Insets(5, 15, 5, 5));

            Label name = new Label(temp.get(1));
            name.setMinWidth(110);
            name.setAlignment(Pos.CENTER);
            name.getStyleClass().add("instructions");
            name.setPadding(new Insets(5, 15, 5, 25));

            Label score = new Label(temp.get(2));
            score.setMinWidth(110);
            score.setAlignment(Pos.CENTER);
            score.getStyleClass().add("instructions");
            score.setPadding(new Insets(5, 15, 5, 50));
            if ( i1 == 0 ) {
                rank.setStyle("-fx-font-weight: bold;");
                name.setStyle("-fx-font-weight: bold;");
                score.setStyle("-fx-font-weight: bold;");
            }

            listItem.getChildren().addAll(rank, name, score);
            listBox.getChildren().add(listItem);
            i1++;
        }
        vBoxHeading.getChildren().add(listBox);

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

    public List<List<String>> ReadScore() {
        String csvFile = "highScore.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<List<String>> finalList = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                List<String> tempList = new ArrayList<>();
                for(String t: country)
                    tempList.add(t);
                finalList.add(tempList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return finalList;
    }

    public void WriteScores(List<List<String>> newScore) throws IOException {
        FileWriter csvWriter = new FileWriter("highScore.csv");
        csvWriter.append("Rank");
        csvWriter.append(',');
        csvWriter.append("Name");
        csvWriter.append(',');
        csvWriter.append("Score");
        csvWriter.append('\n');

        for (List<String> rowData : newScore) {
            String[] data = new String[rowData.size()];
            int i = 0;
            for (String d: rowData) {
                data[i++]= d;
            }
            if ( data.length != 3 ) {
                return;
            } else {
                csvWriter.append(data[0]);
                csvWriter.append(',');
                csvWriter.append(data[1]);
                csvWriter.append(',');
                csvWriter.append(data[2]);
                csvWriter.append('\n');
            }
        }
        csvWriter.flush();
        csvWriter.close();
    }
}
