package com.detroitlabs.magiceightball.controller;

import com.detroitlabs.magiceightball.data.DeckRepository;
import com.detroitlabs.magiceightball.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class blackJackStay1Controller {
    @Autowired
    private DeckRepository deckRepository;

    @RequestMapping("/blackjackStay1")
    public String blackJackStay1(ModelMap modelMap) {
        Card firstCard = deckRepository.getDeck().get(0);
        String description = firstCard.describeCard();
        modelMap.put("firstCardDescription", description);
        Card secondCard = deckRepository.getDeck().get(1);
        String description2 = secondCard.describeCard();
        modelMap.put("secondCardDescription", description2);
        Card thirdCard = deckRepository.getDeck().get(4);
        String description3 = thirdCard.describeCard();
        modelMap.put("thirdCardDescription", description3);
        Card dealerCard = deckRepository.getDeck().get(2);
        String description6 = dealerCard.describeCard();
        modelMap.put("dealerCardDescription", description6);
        Card dealer2Card = deckRepository.getDeck().get(3);
        String description7 = dealer2Card.describeCard();
        modelMap.put("dealer2CardDescription", description7);


        ;
        int playerhandStay1total =  deckRepository.getDeck().get(0).getValue() + deckRepository.getDeck().get(1).getValue() +
                deckRepository.getDeck().get(4).getValue();
        modelMap.put("playerscardsstay1", playerhandStay1total);
        int dealerhand1 = deckRepository.getDeck().get(2).getValue() + deckRepository.getDeck().get(3).getValue();
   ;
        modelMap.put("dealerhand", dealerhand1);
        String result;
        if (dealerhand1 > 21) {
            result = "Deaaler Busts - PLAYER WINS"; }
        else if (dealerhand1 > playerhandStay1total) {
                result = "Dealer Wins";
            } else if (dealerhand1 == playerhandStay1total) {
                result = "Push, it is a tie";
            } else {
                result = "Player Wins";
            }
        if (dealerhand1 < 16) {
            return "blackjackStay1";


        }  modelMap.put("result", result);

        return "blackjackStay1";
        }


    }



