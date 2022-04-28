package com.detroitlabs.magiceightball.controller;

import com.detroitlabs.magiceightball.data.DeckRepository;
import com.detroitlabs.magiceightball.model.Card;
import com.detroitlabs.magiceightball.model.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
public class BlackJackController {
    @Autowired
    private DeckRepository deckRepository;

    @RequestMapping("/blackjack")
    public String blackJack(ModelMap modelMap) {
        Collections.shuffle(deckRepository.getDeck());

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
        int playerhandNewTotal = deckRepository.getDeck().get(0).getValue() + deckRepository.getDeck().get(1).getValue();                ;
        modelMap.put("playerscards", playerhandNewTotal);


        return "blackjack";
    }



}
