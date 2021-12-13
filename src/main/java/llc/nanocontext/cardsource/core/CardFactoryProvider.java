package llc.nanocontext.cardsource.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.support.SpringFactoriesLoader;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * This class loads the card factories and makes them available to the calling client (the REST facade).
 *
 */
public class CardFactoryProvider {
    private AtomicReference<List<CardFactory>> cardFactories = new AtomicReference<>(null);

    @PostConstruct
    public void refreshServices() {
        cardFactories.set((List<CardFactory>)SpringFactoriesLoader.loadFactories(CardFactory.class, null));
    }

    public CardFactory getCardFactory(final String cardType) {
        List<CardFactory> installedCardFactories = cardFactories.get();
        CardFactory selectedCardFactory = installedCardFactories.stream()
                .filter(cf -> cf.supportedCardTypes().contains(cardType))
                .findFirst()
                .orElse(null);
        return selectedCardFactory;
    }
}
