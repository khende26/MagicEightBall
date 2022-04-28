package com.detroitlabs.magiceightball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dealer {
    Deck myDeck = new Deck();
    List<Card> playingCards = myDeck.deckOfCards();             // import a deck of cards from Deck class
    private List<Card> player = new ArrayList<>();              //Create a player
    private List<Card> dealer = new ArrayList<>();              //Create a dealer

    public void deal(int playerHand, int dealerHand, List<Card> playingCards) {                                        //create a deal method
        Collections.shuffle(playingCards);                      //shuffle cards
        player.add(playingCards.get(0));                        //pull first card for player from the deck
        playingCards.remove(0);                           //remove first card from the deck
        player.add(playingCards.get(0));                         //pull second card for player from the deck
        playingCards.remove(0);                           //remove second card for player from the deck
        dealer.add(playingCards.get(0));                        //pull first card  for dealer from the deck
        playingCards.remove(0);                           //remove the fire card for dealer from the deck
        dealer.add(playingCards.get(0));                        //pull second card for dealer from the deck
        playingCards.remove(0);
        for (int i = 0; i < player.size(); i++) {                //loop over player list to get card description and value of eac card
            player.get(i).describeCard();
            playerHand = playerHand + player.get(i).getValue();
            if (playerHand == 21) {
                System.out.println("BLACKJACK You Win!");
            }
        }
        System.out.println(" Player total = " + playerHand);

        for (int i = 0; i < dealer.size(); i++) {
            dealerHand = dealerHand + dealer.get(i).getValue();
        }
        System.out.println("Dealer shows:  " + dealer.get(0).getRank() + " of " + dealer.get(0).getSuit() + ": value of " + dealer.get(0).getValue());
        if (playerHand == 21) {
            System.out.println("BLACKJACK You Win!!! - GAME OVER");
        }
    }

    public void playerDraw() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to hit or stay: Press 1 for hit, Press 2 for stay");
        int play = input.nextInt();
        int playerHand = 0;
        int dealerHand = 0;
        while (play == 1) {
            player.add(playingCards.get(0));                        //pull first card for player from the deck
            playingCards.remove(0);                           //remove first card from the deck
            playerHand = playerHand + player.get(player.size() - 1).getValue();
            player.get(player.size() - 1).describeCard();
            System.out.println(playerHand);
            if (playerHand == 21) {
                System.out.println("BlackJack!  You Win!");
                break;
            } else if (playerHand > 21) {
                System.out.println("Bust - You lose");
                break;
            } else if (playerHand < 20) {
                System.out.println("Do you want to hit or stay: Press 1 for hit, press 2 for stay");
                play = input.nextInt();
                if (play == 2) {
                    dealerPlay();
                }
            }

        }
        if (play == 2) {
            dealerPlay();
        }
    }

    public void dealerPlay() {

        int playerHand = 0;
        int dealerHand = 0;
        do {

            System.out.println("Dealer shows:  " + dealer.get(0).getRank() + " of " + dealer.get(0).getSuit() + ": value of " + dealer.get(0).getValue());
            System.out.println("Dealer shows:  " + dealer.get(1).getRank() + " of " + dealer.get(1).getSuit() + ": value of " + dealer.get(1).getValue());
            if (dealerHand < 16) {
                dealer.add(playingCards.get(0));                        //pull first card for player from the deck
                playingCards.remove(0);                           //remove first card from the deck
                dealerHand = dealerHand + dealer.get(dealer.size() - 1).getValue();
                dealer.get(dealer.size() - 1).describeCard();
                System.out.println("Dealer new total:  " + dealerHand);
            }
            if (dealerHand == 21) {
                System.out.println("Dealer has " + dealerHand + "  Player has " + playerHand);
                System.out.println("Dealer has BlackJack - You lose");
                break;
            } else if (dealerHand > 21) {
                System.out.println("Dealer has " + dealerHand + "  Player has " + playerHand);
                System.out.println("Dealer Bust - You Win!");
                break;
            } else if (dealerHand >= 17) {
                if (dealerHand == playerHand) {
                    System.out.println("Dealer has " + dealerHand + "  Player has " + playerHand);
                    System.out.println("Push  -  Game Over");
                    break;
                } else if (dealerHand < playerHand) {
                    System.out.println("Dealer has " + dealerHand + "  Player has " + playerHand);
                    System.out.println("Player Wins  -  Game Over");
                    break;
                } else if (dealerHand > playerHand) {
                    System.out.println("Dealer has " + dealerHand + "  Player has " + playerHand);
                    System.out.println("Dealer Wins  - Game Over ");
                    break;
                }
            }
        } while (dealerHand < 16);
    }
}
