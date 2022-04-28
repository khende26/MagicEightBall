package com.detroitlabs.magiceightball.controller;

import com.detroitlabs.magiceightball.data.DeckRepository;
import com.detroitlabs.magiceightball.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class BlackJackHit1Controller {
    @Autowired
    private DeckRepository deckRepository;

    @RequestMapping("/blackjackHit")
    public String blackJackHit1(ModelMap modelMap) {
        Card firstCard = deckRepository.getDeck().get(0);
        String description = firstCard.describeCard();
        modelMap.put("firstCardDescription", description);
        Card secondCard = deckRepository.getDeck().get(1);
        String description2 = secondCard.describeCard();
        modelMap.put("secondCardDescription", description2);
        Card dealerCard = deckRepository.getDeck().get(2);
        String description3 = dealerCard.describeCard();
        modelMap.put("dealerCardDescription", description3);
        Card dealer2Card = deckRepository.getDeck().get(3);
        Card thirdCard = deckRepository.getDeck().get(4);
        String description4 = thirdCard.describeCard();
        modelMap.put("thirdCardDescription", description4);
        int playerhand = deckRepository.getDeck().get(0).getValue() + deckRepository.getDeck().get(1).getValue() +
                deckRepository.getDeck().get(4).getValue();
        modelMap.put("playerscards2", playerhand);
        String playerResult;
        if(playerhand > 21) {
            playerResult = "Busted, Player loses";
        }
        else if (playerhand == 21) {
            playerResult = "BlackJack  -- YOU WIN!";
        }
        else { playerResult = ""; }
        modelMap.put("playerResult", playerResult);

        return "blackjackHit";
    }
}