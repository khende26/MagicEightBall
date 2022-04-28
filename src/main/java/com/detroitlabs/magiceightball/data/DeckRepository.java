package com.detroitlabs.magiceightball.data;

import com.detroitlabs.magiceightball.model.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeckRepository {
    private List<Card> deck = new ArrayList<>();

    public List<Card> getDeck() {
        return deck;
    }

    public DeckRepository() {
        List<String> suits = new ArrayList<>();
        suits.add("Diamonds");
        suits.add("Hearts");
        suits.add("Spades");
        suits.add("Clubs");

        List<String> ranks = new ArrayList<>();
        ranks.add("Ace");
        ranks.add("2");
        ranks.add("3");
        ranks.add("4");
        ranks.add("5");
        ranks.add("6");
        ranks.add("7");
        ranks.add("8");
        ranks.add("9");
        ranks.add("10");
        ranks.add("Jack");
        ranks.add("Queen");
        ranks.add("King");

        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        values.add(6);
        values.add(7);
        values.add(8);
        values.add(9);
        values.add(10);
        values.add(10);
        values.add(10);
        values.add(10);


        for (int i = 0; i < suits.size(); i++) {        //iterate through index of suits  index = 4
            for (int j = 0; j < ranks.size(); j++) {     //iterate through index of ranks &values index = 13
                String suit = suits.get(i);     //attach the value at each iteration of suit.
                String rank = ranks.get(j);     //attach the value at each iteration of rank.
                int value = values.get(j);      //attach the value at each iteration of value.
                Card myCard = new Card(suit, rank, value);  //create a new card using each suit,rank,value found above
                myCard.setSuit(suit);                  //set the suit  for each card
                myCard.setRank(rank);                  //set the rank  for each card
                myCard.setValue(value);                //set the value for each card
                deck.add(myCard);                      //add each card through the deck (4 suits(i) x times 13(j) = 52
            }
        }


    }
}