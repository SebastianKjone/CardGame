package ntnu.idatg2003.oblig3.gui;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import ntnu.idatg2003.oblig3.engine.Dealer;
import ntnu.idatg2003.oblig3.engine.PlayingCard;


public class GUI extends Application {


  private Dealer dealer;

  private Label cardOne;
  private Label cardTwo;
  private Label cardThree;
  private Label cardFour;
  private Label cardFive;

  private Label totalAmountOfHand;

  private Label heartFaceCards;

  private Label isQueenOfSpadesText;

  private Label youGotAFlushText;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    init();
    startGame(stage);
  }

  public void init() {
    dealer = new Dealer();
    dealer.startGame();
  }

  private void startGame(Stage stage) {
    stage.setTitle("Poker Game");
    VBox root = new VBox();
    root.setSpacing(70);

    // Initialize the Label objects
    cardOne = new Label();
    cardTwo = new Label();
    cardThree = new Label();
    cardFour = new Label();
    cardFive = new Label();

    totalAmountOfHand = new Label();

    heartFaceCards = new Label();
    isQueenOfSpadesText = new Label();
    youGotAFlushText = new Label();

    root.getChildren().addAll(createMainMenuTextBox(),
        extraInformationBox(), setMainMenuCardHolders(),
        createMainMenuButtons());

    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.show();
  }

  private HBox createMainMenuButtons() {
    HBox buttonHolder = new HBox();
    buttonHolder.setSpacing(20);
    buttonHolder.getChildren().addAll(createForceFlushButton(),createDealButton(), createShuffleButton());
    buttonHolder.setAlignment(Pos.BOTTOM_CENTER);
    buttonHolder.setPadding(new Insets(0, 0, 70, 0));
    return buttonHolder;

  }

  private VBox extraInformationBox() {
    VBox extraInformationBox = new VBox();
    extraInformationBox.setSpacing(30);
    extraInformationBox.setAlignment(Pos.CENTER_RIGHT);
    extraInformationBox.setPadding(new Insets(10, 35, 10, 0));
    extraInformationBox.getChildren().addAll(totalAmountOfHand,
        heartFaceCards, isQueenOfSpadesText, youGotAFlushText);


    return extraInformationBox;
  }
  private HBox createMainMenuTextBox() {
    HBox mainMenuTextBox = new HBox();
    Label text = new Label("Welcome to the Poker Game");
    text.setStyle("-fx-font-size: 24");
    text.setTextFill(Color.web("#0076a3"));
    mainMenuTextBox.getChildren().add(text);
    mainMenuTextBox.setAlignment(Pos.CENTER);
    mainMenuTextBox.setPadding(new Insets(20, 0, 0, 0));
    return mainMenuTextBox;
  }
  private HBox setMainMenuCardHolders() {
    HBox cardHolder = new HBox ();
    cardHolder.setSpacing(40);
    cardHolder.setAlignment(Pos.CENTER);
    cardHolder.setPadding(new Insets(0, 0, 100, 0));
    cardHolder.getChildren().addAll(cardOne, cardTwo, cardThree, cardFour, cardFive);
    updateCardLabel();
    return cardHolder;
  }

  private Label card(int cardNumber) {
    String cardText = dealer.getDealtHand().get(cardNumber).getAsString();
    Label cardBox = new Label(cardText);
    return cardBox;
  }

  private void updateCardLabel() {
    cardOne.
        setText(dealer.getDealtHand().get(0).getAsString());
    cardTwo.
        setText(dealer.getDealtHand().get(1).getAsString());
    cardThree.
        setText(dealer.getDealtHand().get(2).getAsString());
    cardFour.
        setText(dealer.getDealtHand().get(3).getAsString());
    cardFive.
        setText(dealer.getDealtHand().get(4).getAsString());

    totalAmountOfHand.setText
        ("Total amount of cards in hand: " +
            dealer.calculateFaceValue(dealer.getDealtHand()));

    heartFaceCards.setText
        ("Heart face cards in hand: " +
            arrayListToString(dealer.getHeartsFromHand()));


    if (dealer.isQueenOfSpadesInHand()) {
      isQueenOfSpadesText.setText("Queen of Spades is in hand");
    } else {
      isQueenOfSpadesText.setText("Queen of Spades is not in hand");
    }

    if(dealer.recognizeFlush(dealer.getDealtHand())) {
    youGotAFlushText.setText("You got a flush");
    }
    else {
      youGotAFlushText.setText("No Flush");
    }

  }
  private String arrayListToString(ArrayList<PlayingCard> heartsInHand) {
    StringBuilder stringBuild = new StringBuilder();
    if (heartsInHand.isEmpty()) {
      return "No Hearts";
    } else {
      for (int i = 0; i < heartsInHand.size(); i++) {
        stringBuild.append(heartsInHand.get(i).getAsString());
        if (i < heartsInHand.size() - 1) {
          stringBuild.append(", ");
        }
      }
    } return stringBuild.toString();
  }

  private Button createDealButton() {
    Button dealButton = new Button("Deal");
    dealButton.setOnAction(event -> {
      dealer.dealHand(5);
      updateCardLabel();
    });
    return dealButton;
  }
  private Button createForceFlushButton() {
    Button forceFlushButton = new Button("Force Flush");
    forceFlushButton.setOnAction(event -> {
      dealer.forceFlush();
    });
    return forceFlushButton;
  }

  private Button createShuffleButton() {
    Button shuffleButton = new Button("Shuffle");
    shuffleButton.setOnAction(event -> {
      dealer.shuffle();
    });
    return shuffleButton;
  }

  private void displayHand() {
    dealer.getDealtHand().forEach(card -> {
      System.out.println(card.getAsString());
    });
    updateCardLabel();
  }



}



