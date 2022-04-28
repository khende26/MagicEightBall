package com.detroitlabs.magiceightball.controller;

import com.detroitlabs.magiceightball.data.DeckRepository;
import com.detroitlabs.magiceightball.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class blackJackStay2Controller {
@Autowired
private DeckRepository deckRepository;

    @RequestMapping("/blackjackStay2")
    public String blackJackStay2(ModelMap modelMap) {


        Card firstCard = deckRepository.getDeck().get(0);
        String description = firstCard.describeCard();
        modelMap.put("firstCardDescription", description);
        Card secondCard = deckRepository.getDeck().get(1);
        String description2 = secondCard.describeCard();
        modelMap.put("secondCardDescription", description2);
        Card thirdCard = deckRepository.getDeck().get(4);
        String description4 = thirdCard.describeCard();
        modelMap.put("thirdCardDescription", description4);
        Card fourthCard = deckRepository.getDeck().get(5);
        String description5 = thirdCard.describeCard();
        modelMap.put("fourthCardDescription", description5);
        Card dealerCard = deckRepository.getDeck().get(2);
        String description3 = dealerCard.describeCard();
        modelMap.put("dealerCardDescription", description3);
        Card dealer2Card = deckRepository.getDeck().get(3);
        String description7 = dealer2Card.describeCard();
        modelMap.put("dealer2CardDescription", description7);
        ;
        int playerhandNewTotal =  deckRepository.getDeck().get(0).getValue() + deckRepository.getDeck().get(1).getValue() +
                deckRepository.getDeck().get(4).getValue() + deckRepository.getDeck().get(5).getValue();
         modelMap.put("playerNewHandTotal", playerhandNewTotal);
        int dealerhand = deckRepository.getDeck().get(2).getValue() + deckRepository.getDeck().get(3).getValue();
        modelMap.put("dealerhand", dealerhand);
        String result;
        if (dealerhand > 21) {
            result = "Deaaler Busts - PLAYER WINS"; }
        else if (dealerhand > playerhandNewTotal) {
            result = "Dealer Wins";
        } else if (dealerhand == playerhandNewTotal) {
            result = "Push, it is a tie";
        } else {
            result = "Player Wins";
        }
        if (dealerhand < 16) {
            return "blackjackStay2";

        }  modelMap.put("result", result);

        return "blackjackStay2";
    }


}



