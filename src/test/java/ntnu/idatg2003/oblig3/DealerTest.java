package ntnu.idatg2003.oblig3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class DealerTest {

  private Dealer dealerTest;
  @BeforeEach
  void setUp() {
    dealerTest = new Dealer();

  }
  @Test
  void testDealHand() {
    assertEquals(5, dealerTest.dealtHand.size(), "Hand should contain 5 cards");
  }





}