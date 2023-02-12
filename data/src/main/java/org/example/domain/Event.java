package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name="COMPETITORS_EVENTS",
//            joinColumns=@JoinColumn(name="EVENT_ID"), inverseJoinColumns=@JoinColumn(name="COMPETITOR_ID"))
    @JoinColumn(name = "COMPETITORS")
    private List<Competitor> competitors;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VENUE_ID")
    private Venue venue;

    @Column(name = "PROBABILITY_HOME_TEAM_WINNER")
    private BigDecimal homeTeamWin;

    @Column(name = "PROBABILITY_DRAW")
    private BigDecimal draw;

    @Column(name = "PROBABILITY_AWAY_TEAM_WINNER")
    private BigDecimal awayTeamWin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;

        if (competitionId != event.competitionId) return false;
        if (!id.equals(event.id)) return false;
        if (!startDate.equals(event.startDate)) return false;
        if (!sportName.equals(event.sportName)) return false;
        if (!competitionName.equals(event.competitionName)) return false;
        if (!seasonName.equals(event.seasonName)) return false;
        if (!competitors.equals(event.competitors)) return false;
        if (!venue.equals(event.venue)) return false;
        if (!homeTeamWin.equals(event.homeTeamWin)) return false;
        if (!draw.equals(event.draw)) return false;
        return awayTeamWin.equals(event.awayTeamWin);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + sportName.hashCode();
        result = 31 * result + competitionName.hashCode();
        result = 31 * result + competitionId;
        result = 31 * result + seasonName.hashCode();
        result = 31 * result + competitors.hashCode();
        result = 31 * result + venue.hashCode();
        result = 31 * result + homeTeamWin.hashCode();
        result = 31 * result + draw.hashCode();
        result = 31 * result + awayTeamWin.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", sportName='" + sportName + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", competitionId=" + competitionId +
                ", seasonName='" + seasonName + '\'' +
                ", competitors=" + competitors +
                ", venue=" + venue +
                ", homeTeamWin=" + homeTeamWin +
                ", draw=" + draw +
                ", awayTeamWin=" + awayTeamWin +
                '}';
    }
}
