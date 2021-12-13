package llc.nanocontext.cardsource.core;

import llc.nanocontext.cardsource.model.AbstractCard;
import llc.nanocontext.cardsource.model.DailyQuoteCard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DailyQuoteCardFactory implements CardFactory {
    private final static List<String> supportedCardTypes = Collections.unmodifiableList(Arrays.asList("dailyquote"));
    private final AtomicInteger authorSerialNumber = new AtomicInteger(0);
    private final AtomicInteger quoteSerialNumber = new AtomicInteger(0);

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
                DailyQuoteCard element = new DailyQuoteCard();
                element.title("Daily Quote");
                element.author("author" + authorSerialNumber.getAndIncrement());
                element.message("quote" + quoteSerialNumber.getAndIncrement());

                result.add(element);
            }

            return result;
        }
        return null;
    }
}
