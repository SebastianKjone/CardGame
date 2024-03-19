package ntnu.idatg2003.oblig3.engine;
import java.util.ArrayList;

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


  public void sendSuitToDealer(PlayingCard card) {
    card.getSuit();
  }
  public void removeDealtCards(int randomCardNumber) {
    deck.remove(randomCardNumber);
  }

  public ArrayList<PlayingCard> getDeck() {
    return deck;
  }

}
