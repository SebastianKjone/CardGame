package ntnu.idatg2003.oblig3;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

  private ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();

  private final char[] suits = {'S', 'H', 'D', 'C'};


  public DeckOfCards() {
    deckBuilder();
  }

  protected void deckBuilder() {
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        deck.add(new PlayingCard(suit, face));
      }
    }
  }

  protected void dealHand(int n){
    for (int i = 0; i < n; i++) {
      int randomCardNumber = new Random().nextInt(deck.size());
      if(!checkIfCardIsInDeck(randomCardNumber)) {
        i--;
      }
    }
  }

  private boolean checkIfCardIsInDeck(int randomCardNumber) {
    boolean cardInDeckFlag = false;
    if (deck.contains(randomCardNumber)){
      deck.remove(randomCardNumber);
      cardInDeckFlag = true;
    } return cardInDeckFlag;
  }


  protected ArrayList<PlayingCard> getDeck() {
    return deck;
  }


}
