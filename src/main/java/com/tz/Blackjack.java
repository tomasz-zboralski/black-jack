package com.tz;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Blackjack extends Application {

    private final Image imageBack = new Image("file:src/main/resources/table.png");
    private Image card = new Image("file:src/main/resources/card-deck.png");
    private FlowPane cards = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);

        ImageView card1 = new ImageView(card);
        ImageView card2 = new ImageView(card);
//        card1.setFitWidth(150);
//        card1.setPreserveRatio(true);
//        card1.setSmooth(true);
//        card1.setCache(true);

        // Use mask to display a card from card deck
        Rectangle2D mask1 = new Rectangle2D(500, 450, 100, 150);
        card1.setViewport(mask1);

        Rectangle2D mask2 = new Rectangle2D(0,150,100,150);
        card2.setViewport(mask2);

//        GridPane.setRowIndex(cards, 0);
//        GridPane.setColumnIndex(cards, 1);
//        cards.getChildren().addAll(cards);
        grid.add(card1, 150, 15); // column=1 row=0
        grid.add(card2, 0, 0);

        //grid.add(cards, 0, 0, 3, 1);

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}