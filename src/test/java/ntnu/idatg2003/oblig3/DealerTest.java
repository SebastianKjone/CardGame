package ntnu.idatg2003.oblig3;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import ntnu.idatg2003.oblig3.engine.Dealer;
import ntnu.idatg2003.oblig3.engine.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DealerTest {

  private Dealer dealerTest;
  @BeforeEach
  void setUp() {
    dealerTest = new Dealer();

  }
  @Test
  void testDealHand() {
    assertEquals(5, dealerTest.getDealtHand().size(), "Hand should contain 5 cards");
  }


  @Test
  void forceFlushValTest() {
    ArrayList<PlayingCard> flushHand = new ArrayList<PlayingCard>();
    flushHand.add(new PlayingCard('H', 1));
    flushHand.add(new PlayingCard('H', 2));
    flushHand.add(new PlayingCard('H', 3));
    flushHand.add(new PlayingCard('H', 4));
    flushHand.add(new PlayingCard('H', 5));
    assertTrue(dealerTest.recognizeFlush(flushHand));
  }


}