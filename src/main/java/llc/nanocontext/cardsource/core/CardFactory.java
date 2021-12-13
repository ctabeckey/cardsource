package llc.nanocontext.cardsource.core;

import llc.nanocontext.cardsource.model.AbstractCard;

import java.util.List;

/**
 * Defines the interface that a class must implement to regiaster and be treated as
 * a card factory
 */
public interface CardFactory {
    List<String> supportedCardTypes();
    List<AbstractCard> createCard(String cardType, Integer count);
}
