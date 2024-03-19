package ntnu.idatg2003.oblig3.engine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Dealer {

  private DeckOfCards deckOfCards;
  protected ArrayList<PlayingCard> dealtHand;

  /*
  public static void main(String[] args) {
    Dealer dealer = new Dealer();
    dealer.startGame();
  }

*/

  public void startGame() {
    deckOfCards = new DeckOfCards();
    dealtHand = new ArrayList<PlayingCard>();
    dealHand(5);



  }

  public void dealHand(int cardsToDeal) {
    if(cardsToDeal > deckOfCards.getDeck().size()) {
      shuffle();
    }
    System.out.println("Dealing " + cardsToDeal + " cards"); // For testing
    dealtHand.clear();
    for (int i = 0; i < cardsToDeal; i++) {
      int randomCardNumber = new Random().
          nextInt(deckOfCards.getDeck().size());

      PlayingCard tempCard = deckOfCards.
          findMatchingPlayingCard(randomCardNumber);
      dealtHand.add(tempCard);

      System.out.println(tempCard.getAsString()); //Terminal Print for testing
      deckOfCards.removeDealtCards(randomCardNumber);
    }
    System.out.println(deckOfCards.getDeck().size() + " & " + dealtHand.size()); //Terminal Print for testing

  }

  public void forceFlush (){
    boolean flushFoundFlag = false;
    while(!flushFoundFlag)
    dealHand(5);
    if (recognizeFlush(dealtHand)){
      flushFoundFlag = true;
    }
  }

  public boolean recognizeFlush(ArrayList<PlayingCard> handToCheck) {
    boolean flushFlag = false;
    if (handToCheck.stream().allMatch(card ->
        card.getSuit() == handToCheck.get(0).getSuit())) {
      flushFlag = true;
    }
    return flushFlag;
  }

  public ArrayList<PlayingCard> getDealtHand() {
    return dealtHand;
  }

  public int calculateFaceValue(ArrayList<PlayingCard> hand) {
    int faceValue = 0;
    for (PlayingCard card : hand) {
      faceValue += card.getFace();
    }
    return faceValue;
  }


  public ArrayList<PlayingCard> getHeartsFromHand() {
    ArrayList <PlayingCard> heartsInHand = new ArrayList<PlayingCard>();

    dealtHand.stream().filter(card -> card.getSuit() == 'H').forEach(card -> {
      heartsInHand.add(card);
    });
    return heartsInHand;
  }

  public boolean isQueenOfSpadesInHand() {
    dealtHand.stream().filter(card -> card.getFace() == 12 && card.getSuit() == 'S');
    return dealtHand.contains(new PlayingCard('S', 12));
  }

  public void shuffle() {
    deckOfCards.getDeck().clear();
    deckOfCards.deckBuilder();
  }

}