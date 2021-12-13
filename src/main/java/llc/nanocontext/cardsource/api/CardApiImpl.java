package llc.nanocontext.cardsource.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import llc.nanocontext.cardsource.core.CardFactory;
import llc.nanocontext.cardsource.core.CardFactoryProvider;
import llc.nanocontext.cardsource.model.AbstractCard;
import llc.nanocontext.cardsource.rest.api.CardApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the CardApi endpoints.
 */
@RestController
public class CardApiImpl implements CardApi {
    private final Logger LOGGER = LoggerFactory.getLogger(CardApiImpl.class);
    private static ObjectMapper jsonMapper = new ObjectMapper();

    @Autowired
    private CardFactoryProvider cardFactoryProvider;

    /**
     * The implementation of the "card" endpoint. The card type is a String value passed as an
     * additional path element. The cardCount is an optional value, which should default to 1.
     * @param cardtype
     * @param cardCount
     * @return
     */
    @Override
    public ResponseEntity<String> getCard(final String cardtype, final Integer cardCount) {
        LOGGER.info("getCard({}, {})", cardtype, cardCount);

        // find a CardFactory that can generate the requested card type
        CardFactory cardFactory = cardFactoryProvider.getCardFactory(cardtype);
        LOGGER.info("getCard({}, {}), cardFactory is ",
                cardtype, cardCount, (cardFactory == null ? "null" : "not null"));

        // if the Card Factory is found ythen we should be able to generate the requested card
        if (cardFactory != null) {
            List<AbstractCard> cards = cardFactory.createCard(cardtype, cardCount);
            LOGGER.info("getCard({}, {}), {} cards created", cardtype, cardCount, (cards == null ? 0 : cards.size()));
            try {
                return ResponseEntity.ok(jsonMapper.writeValueAsString(cards));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return ResponseEntity.internalServerError().build();
            }
        } else {
            // No CardFactory available to generate the requested card type
            return ResponseEntity.badRequest().build();
        }
    }
}
