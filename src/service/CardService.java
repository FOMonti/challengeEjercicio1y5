package service;

import entity.Card;

public class CardService {

    public String getInfoCard(Card card) {
        return card.toString();
    }

    public boolean isValid(Card card) {
        return card.isValid();
    }

    public boolean areEqual(Card cardA, Card cardB) {
        return cardA.equals(cardB);
    }

}
