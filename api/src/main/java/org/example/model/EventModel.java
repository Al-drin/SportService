package org.example.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.example.model.CompetitorModel;
import org.example.model.VenueModel;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EventModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-05T13:00:35.590383600+01:00[Europe/Warsaw]")
public class EventModel   {
  @JsonProperty("sport_event_id")
  private String sportEventId;

  @JsonProperty("start_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startDate;

  @JsonProperty("sport_name")
  private String sportName;

  @JsonProperty("competition_name")
  private String competitionName;

  @JsonProperty("competition_id")
  private String competitionId;

  @JsonProperty("season_name")
  private String seasonName;

  @JsonProperty("competitors")
  @Valid
  private List<CompetitorModel> competitors = null;

  @JsonProperty("venue")
  private VenueModel venue;

  @JsonProperty("probability_home_team_winner")
  private BigDecimal probabilityHomeTeamWinner;

  @JsonProperty("probability_draw")
  private BigDecimal probabilityDraw;

  @JsonProperty("probability_away_team_winner")
  private BigDecimal probabilityAwayTeamWinner;

  public EventModel sportEventId(String sportEventId) {
    this.sportEventId = sportEventId;
    return this;
  }

  /**
   * Get sportEventId
   * @return sportEventId
  */
  @ApiModelProperty(example = "sr:sport_event:27636100", value = "")


  public String getSportEventId() {
    return sportEventId;
  }

  public void setSportEventId(String sportEventId) {
    this.sportEventId = sportEventId;
  }

  public EventModel startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public EventModel sportName(String sportName) {
    this.sportName = sportName;
    return this;
  }

  /**
   * Get sportName
   * @return sportName
  */
  @ApiModelProperty(example = "Soccer", value = "")


  public String getSportName() {
    return sportName;
  }

  public void setSportName(String sportName) {
    this.sportName = sportName;
  }

  public EventModel competitionName(String competitionName) {
    this.competitionName = competitionName;
    return this;
  }

  /**
   * Get competitionName
   * @return competitionName
  */
  @ApiModelProperty(example = "UEFA Champions League", value = "")


  public String getCompetitionName() {
    return competitionName;
  }

  public void setCompetitionName(String competitionName) {
    this.competitionName = competitionName;
  }

  public EventModel competitionId(String competitionId) {
    this.competitionId = competitionId;
    return this;
  }

  /**
   * Get competitionId
   * @return competitionId
  */
  @ApiModelProperty(example = "sr:competition:7", value = "")


  public String getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(String competitionId) {
    this.competitionId = competitionId;
  }

  public EventModel seasonName(String seasonName) {
    this.seasonName = seasonName;
    return this;
  }

  /**
   * Get seasonName
   * @return seasonName
  */
  @ApiModelProperty(example = "UEFA Champions League 21/22", value = "")


  public String getSeasonName() {
    return seasonName;
  }

  public void setSeasonName(String seasonName) {
    this.seasonName = seasonName;
  }

  public EventModel competitors(List<CompetitorModel> competitors) {
    this.competitors = competitors;
    return this;
  }

  public EventModel addCompetitorsItem(CompetitorModel competitorsItem) {
    if (this.competitors == null) {
      this.competitors = new ArrayList<>();
    }
    this.competitors.add(competitorsItem);
    return this;
  }

  /**
   * Get competitors
   * @return competitors
  */
  @ApiModelProperty(value = "")

  @Valid
@Size(min = 2, max = 2) 
  public List<CompetitorModel> getCompetitors() {
    return competitors;
  }

  public void setCompetitors(List<CompetitorModel> competitors) {
    this.competitors = competitors;
  }

  public EventModel venue(VenueModel venue) {
    this.venue = venue;
    return this;
  }

  /**
   * Get venue
   * @return venue
  */
  @ApiModelProperty(value = "")

  @Valid

  public VenueModel getVenue() {
    return venue;
  }

  public void setVenue(VenueModel venue) {
    this.venue = venue;
  }

  public EventModel probabilityHomeTeamWinner(BigDecimal probabilityHomeTeamWinner) {
    this.probabilityHomeTeamWinner = probabilityHomeTeamWinner;
    return this;
  }

  /**
   * Get probabilityHomeTeamWinner
   * @return probabilityHomeTeamWinner
  */
  @ApiModelProperty(example = "2.5", value = "")

  @Valid

  public BigDecimal getProbabilityHomeTeamWinner() {
    return probabilityHomeTeamWinner;
  }

  public void setProbabilityHomeTeamWinner(BigDecimal probabilityHomeTeamWinner) {
    this.probabilityHomeTeamWinner = probabilityHomeTeamWinner;
  }

  public EventModel probabilityDraw(BigDecimal probabilityDraw) {
    this.probabilityDraw = probabilityDraw;
    return this;
  }

  /**
   * Get probabilityDraw
   * @return probabilityDraw
  */
  @ApiModelProperty(example = "88.1", value = "")

  @Valid

  public BigDecimal getProbabilityDraw() {
    return probabilityDraw;
  }

  public void setProbabilityDraw(BigDecimal probabilityDraw) {
    this.probabilityDraw = probabilityDraw;
  }

  public EventModel probabilityAwayTeamWinner(BigDecimal probabilityAwayTeamWinner) {
    this.probabilityAwayTeamWinner = probabilityAwayTeamWinner;
    return this;
  }

  /**
   * Get probabilityAwayTeamWinner
   * @return probabilityAwayTeamWinner
  */
  @ApiModelProperty(example = "9.4", value = "")

  @Valid

  public BigDecimal getProbabilityAwayTeamWinner() {
    return probabilityAwayTeamWinner;
  }

  public void setProbabilityAwayTeamWinner(BigDecimal probabilityAwayTeamWinner) {
    this.probabilityAwayTeamWinner = probabilityAwayTeamWinner;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventModel eventModel = (EventModel) o;
    return Objects.equals(this.sportEventId, eventModel.sportEventId) &&
        Objects.equals(this.startDate, eventModel.startDate) &&
        Objects.equals(this.sportName, eventModel.sportName) &&
        Objects.equals(this.competitionName, eventModel.competitionName) &&
        Objects.equals(this.competitionId, eventModel.competitionId) &&
        Objects.equals(this.seasonName, eventModel.seasonName) &&
        Objects.equals(this.competitors, eventModel.competitors) &&
        Objects.equals(this.venue, eventModel.venue) &&
        Objects.equals(this.probabilityHomeTeamWinner, eventModel.probabilityHomeTeamWinner) &&
        Objects.equals(this.probabilityDraw, eventModel.probabilityDraw) &&
        Objects.equals(this.probabilityAwayTeamWinner, eventModel.probabilityAwayTeamWinner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sportEventId, startDate, sportName, competitionName, competitionId, seasonName, competitors, venue, probabilityHomeTeamWinner, probabilityDraw, probabilityAwayTeamWinner);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventModel {\n");
    
    sb.append("    sportEventId: ").append(toIndentedString(sportEventId)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    sportName: ").append(toIndentedString(sportName)).append("\n");
    sb.append("    competitionName: ").append(toIndentedString(competitionName)).append("\n");
    sb.append("    competitionId: ").append(toIndentedString(competitionId)).append("\n");
    sb.append("    seasonName: ").append(toIndentedString(seasonName)).append("\n");
    sb.append("    competitors: ").append(toIndentedString(competitors)).append("\n");
    sb.append("    venue: ").append(toIndentedString(venue)).append("\n");
    sb.append("    probabilityHomeTeamWinner: ").append(toIndentedString(probabilityHomeTeamWinner)).append("\n");
    sb.append("    probabilityDraw: ").append(toIndentedString(probabilityDraw)).append("\n");
    sb.append("    probabilityAwayTeamWinner: ").append(toIndentedString(probabilityAwayTeamWinner)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

