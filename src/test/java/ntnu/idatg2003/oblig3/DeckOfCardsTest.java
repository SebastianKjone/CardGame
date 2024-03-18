package ntnu.idatg2003.oblig3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckOfCardsTest {

  private DeckOfCards deckOfCardsTest;


  @BeforeEach
  void setUp() throws Exception {
    deckOfCardsTest = new DeckOfCards();
  }

  @Test
  void testDeckBuilder() {
    assertEquals(52, deckOfCardsTest.getDeck().size(), "Deck should contain 52 cards");
    assertNotEquals(0, deckOfCardsTest.getDeck().size(), "Deck should not be empty");
  }




}