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
    System.out.println("Deck has been built, " + deck.size() + " cards");

  }

  protected PlayingCard findMatchingPlayingCard(int randomCardNumber) {
    deck.stream().
        filter(playingCard -> playingCard.
            getFace() == randomCardNumber);
    if (deck.contains(randomCardNumber)) {
      System.out.println(deck.get(randomCardNumber).getAsString());
    }  return deck.get(randomCardNumber);
  }




  protected ArrayList<PlayingCard> getDeck() {
    return deck;
  }

}
