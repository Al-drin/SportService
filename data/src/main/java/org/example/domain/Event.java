package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @Column(name = "EVENT_ID")
    private Long id;

    @Column(name = "START_DATE")
    private OffsetDateTime startDate;

    @Column(name = "SPORT_NAME")
    private String sportName;

    @Column(name = "COMPETITION_NAME")
    private String competitionName;

    @Column(name = "COMPETITION_ID")
    private int competitionId;

    @Column(name = "SEASON_NAME")
    private String seasonName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOME_COMPETITOR")
    private Competitor homeCompetitor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AWAY_COMPETITOR")
    private Competitor awayCompetitor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VENUE_ID")
    private Venue venue;

    @Column(name = "PROBABILITY_HOME_TEAM_WINNER")
    private BigDecimal homeTeamWin;

    @Column(name = "PROBABILITY_DRAW")
    private BigDecimal draw;

    @Column(name = "PROBABILITY_AWAY_TEAM_WINNER")
    private BigDecimal awayTeamWin;

    @Column(name = "MOST_PROBABLE_RESULT")
    private BigDecimal mostProbableResult;

    @Column(name = "MOST_PROBABLE_RESULT_DESCRIPTION")
    private ResultDescription mostProbableResultDescription;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", sportName='" + sportName + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", competitionId=" + competitionId +
                ", seasonName='" + seasonName + '\'' +
                ", homeCompetitor=" + homeCompetitor +
                ", awayCompetitor=" + awayCompetitor +
                ", venue=" + venue +
                ", homeTeamWin=" + homeTeamWin +
                ", draw=" + draw +
                ", awayTeamWin=" + awayTeamWin +
                ", mostProbableResult=" + mostProbableResult +
                ", mostProbableResultDescription=" + mostProbableResultDescription +
                '}';
    }

    public String toFormattedString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return "Start date: " + formatter.format(startDate.toLocalDateTime()) + "\n" +
                "Competition: " + competitionName + "\n" +
                homeCompetitor.getName() + " (" + homeCompetitor.getCountry() + ") vs. " +
                awayCompetitor.getName() + " (" + awayCompetitor.getCountry() + ")\n" +
                "Venue: " + venue.getName() + "\n" +
                "Highest probable result: " + mostProbableResultDescription + " (" + mostProbableResult + ")\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;

        if (competitionId != event.competitionId) return false;
        if (!Objects.equals(id, event.id)) return false;
        if (!Objects.equals(startDate, event.startDate)) return false;
        if (!Objects.equals(sportName, event.sportName)) return false;
        if (!Objects.equals(competitionName, event.competitionName)) return false;
        if (!Objects.equals(seasonName, event.seasonName)) return false;
        if (!Objects.equals(homeCompetitor, event.homeCompetitor)) return false;
        if (!Objects.equals(awayCompetitor, event.awayCompetitor)) return false;
        if (!Objects.equals(venue, event.venue)) return false;
        if (!Objects.equals(homeTeamWin, event.homeTeamWin)) return false;
        if (!Objects.equals(draw, event.draw)) return false;
        if (!Objects.equals(awayTeamWin, event.awayTeamWin)) return false;
        if (!Objects.equals(mostProbableResult, event.mostProbableResult)) return false;
        return mostProbableResultDescription == event.mostProbableResultDescription;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (sportName != null ? sportName.hashCode() : 0);
        result = 31 * result + (competitionName != null ? competitionName.hashCode() : 0);
        result = 31 * result + competitionId;
        result = 31 * result + (seasonName != null ? seasonName.hashCode() : 0);
        result = 31 * result + (homeCompetitor != null ? homeCompetitor.hashCode() : 0);
        result = 31 * result + (awayCompetitor != null ? awayCompetitor.hashCode() : 0);
        result = 31 * result + (venue != null ? venue.hashCode() : 0);
        result = 31 * result + (homeTeamWin != null ? homeTeamWin.hashCode() : 0);
        result = 31 * result + (draw != null ? draw.hashCode() : 0);
        result = 31 * result + (awayTeamWin != null ? awayTeamWin.hashCode() : 0);
        result = 31 * result + (mostProbableResult != null ? mostProbableResult.hashCode() : 0);
        result = 31 * result + (mostProbableResultDescription != null ? mostProbableResultDescription.hashCode() : 0);
        return result;
    }
}