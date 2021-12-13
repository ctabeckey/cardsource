package llc.nanocontext.cardsource.core;

import llc.nanocontext.cardsource.model.AbstractCard;
import llc.nanocontext.cardsource.model.DailyQuoteCard;
import llc.nanocontext.cardsource.model.StatusUpdateCard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class StatusUpdateCardFactory implements CardFactory {
    private final static List<String> supportedCardTypes = Collections.unmodifiableList(Arrays.asList("statusupdate"));

    @Override
    public List<String> supportedCardTypes() {
        return supportedCardTypes;
    }

    @Override
    public List<AbstractCard> createCard(final String cardType, final Integer cardCount) {
        if (supportedCardTypes.contains(cardType)) {
            final int effectiveCardCount = (cardCount == null ? 1 : cardCount.intValue());
            List<AbstractCard> result = new ArrayList<>(effectiveCardCount);

            for (int index=0; index < effectiveCardCount; ++index) {
                StatusUpdateCard element = new StatusUpdateCard();
                element.title("Important Security Update");
                element.icon("https://tinyurl.com/y5mdph2g");
                element.message("For your security, we support 2 factor authentication, and would recommend that you turn it on.");
                element.button("Got it, thanks");

                result.add(element);
            }

            return result;
        }
        return null;
    }
}
