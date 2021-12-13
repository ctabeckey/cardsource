package llc.nanocontext.cardsource.core;

import llc.nanocontext.cardsource.model.AbstractCard;

import java.util.List;

public interface CardFactory {
    List<String> supportedCardTypes();
    List<AbstractCard> createCard(String cardType, Integer count);
}
