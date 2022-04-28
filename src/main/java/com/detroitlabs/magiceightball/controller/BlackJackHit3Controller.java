package com.detroitlabs.magiceightball.controller;

import com.detroitlabs.magiceightball.data.DeckRepository;
import com.detroitlabs.magiceightball.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class BlackJackHit3Controller {
    @Autowired
    private DeckRepository deckRepository;

    @RequestMapping("/blackjackHit3")
    public String blackJackHit3(ModelMap modelMap) {
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
        String description5 = fourthCard.describeCard();
        modelMap.put("fourthCardDescription", description5);
        Card fifthCard = deckRepository.getDeck().get(6);
        String description6 = fifthCard.describeCard();
        modelMap.put("fifthCardDescription", description6);
        Card dealerCard = deckRepository.getDeck().get(2);
        String description3 = dealerCard.describeCard();
        modelMap.put("dealerCardDescription", description3);
        Card dealer2Card = deckRepository.getDeck().get(3);

        int playerhandNewTotal = deckRepository.getDeck().get(0).getValue() + deckRepository.getDeck().get(1).getValue() +
                deckRepository.getDeck().get(4).getValue() + deckRepository.getDeck().get(5).getValue() + deckRepository.getDeck().get(6).getValue();
        modelMap.put("playerscards2", playerhandNewTotal);
        String playerResult;
        if(playerhandNewTotal > 21) {
            playerResult = "Busted, Player loses";
        }
        else if (playerhandNewTotal == 21) {
            playerResult = "BlackJack  -- YOU WIN!";
        }
        else { playerResult = "Choose to hit or stay"; }
        modelMap.put("playerResult", playerResult);

        return "blackjackHit3";
    }

}