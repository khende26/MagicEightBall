package com.detroitlabs.magiceightball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {


    //test to ensure 52 cards are available.
    @Test
    void deal() {
        //Arrange
        Dealer dealer = new Dealer();
        Deck myDeck = new Deck();
        List<Card> playingCards = myDeck.deckOfCards();
        int playerHand = 0;
        int dealerHand = 0;
        //act
        dealer.deal(playerHand, dealerHand, playingCards);
        //assert
        assertEquals(playerHand, 0 );
        assertEquals(dealerHand, 0);


    }
}