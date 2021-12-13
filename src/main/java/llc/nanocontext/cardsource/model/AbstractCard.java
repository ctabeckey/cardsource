package llc.nanocontext.cardsource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Objects;

/**
 * Card
 */
public class AbstractCard {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("message")
  private String message = null;

  public AbstractCard title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  @Schema(required = true, description = "")
  @NotNull
  public String getTitle() {
    return title;
  }

  public AbstractCard message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  @Schema(required = true, description = "")
  @NotNull

  public String getMessage() {
    return message;
  }
}
