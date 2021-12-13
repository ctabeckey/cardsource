package llc.nanocontext.cardsource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Dailyquotecard
 */
public class DailyQuoteCard extends AbstractCard {
  @JsonProperty("author")
  private String author = null;

  public DailyQuoteCard author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
   **/
  public String getAuthor() {
    return author;
  }
}
