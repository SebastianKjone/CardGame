package ntnu.idatg2003.oblig3;

import java.util.ArrayList;
import java.util.Random;

public class Dealer {

  private DeckOfCards deckOfCards;
  protected ArrayList<PlayingCard> dealtHand;

  public static void main(String[] args) {
    Dealer dealer = new Dealer();
    dealer.startGame();
  }

  protected void startGame() {
    deckOfCards = new DeckOfCards();
    dealtHand = new ArrayList<PlayingCard>();
    dealHand(5);
  }

  protected void dealHand(int cardsToDeal) {
    System.out.println("Dealing " + cardsToDeal + " cards"); // For testing
    for (int i = 0; i < cardsToDeal; i++) {
      int randomCardNumber = new Random().nextInt(deckOfCards.getDeck().size());
      System.out.println(deckOfCards.findMatchingPlayingCard(randomCardNumber).getAsString()); //Terminal Print for testing

    }


  }
}