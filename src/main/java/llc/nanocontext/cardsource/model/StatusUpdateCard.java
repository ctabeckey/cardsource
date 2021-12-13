package llc.nanocontext.cardsource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Statusupdatecard
 */
@Validated
@JsonSerialize
public class StatusUpdateCard extends AbstractCard {
  @JsonProperty("icon")
  private String icon = null;

  @JsonProperty("button")
  private String button = null;

  public StatusUpdateCard icon(String icon) {
    this.icon = icon;
    return this;
  }

  /**
   * Get icon
   * @return icon
   **/
  @Schema(description = "")
  
  public String getIcon() {
    return icon;
  }

  public StatusUpdateCard button(String button) {
    this.button = button;
    return this;
  }

  /**
   * Get button
   * @return button
   **/
  @Schema(description = "")
  public String getButton() {
    return button;
  }
}
