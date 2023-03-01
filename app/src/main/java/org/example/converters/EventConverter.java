package org.example.converters;

import org.example.domain.Competitor;
import org.example.domain.Event;
import org.example.domain.Qualifier;
import org.example.domain.ResultDescription;
import org.example.model.CompetitorModel;
import org.example.model.EventModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EventConverter {

    private EventConverter() {

    }

    public static Event convertModel(EventModel model) {
        if (model == null) {
            return null;
        }

        String eventIdString = model.getSportEventId();
        Long eventId = Long.valueOf(eventIdString.substring(eventIdString.lastIndexOf(":")+1));

        String competitionIdString = model.getCompetitionId();
        int competitionId = Integer.parseInt(competitionIdString.substring(competitionIdString.lastIndexOf(":")+1));

        BigDecimal mostProbableResult = model.getProbabilityHomeTeamWinner();
        ResultDescription mostProbableResultDescription = ResultDescription.HOME_TEAM_WIN;

        if (model.getProbabilityAwayTeamWinner().compareTo(mostProbableResult) > 0) {
            mostProbableResult = model.getProbabilityAwayTeamWinner();
            mostProbableResultDescription = ResultDescription.AWAY_TEAM_WIN;
        }

        if (model.getProbabilityDraw().compareTo(mostProbableResult) > 0) {
            mostProbableResult = model.getProbabilityDraw();
            mostProbableResultDescription = ResultDescription.DRAW;
        }

        Competitor home;
        Competitor away;

        if (model.getCompetitors().get(0).getQualifier().equals(Qualifier.HOME.toString())) {
            home = CompetitorConverter.convertModel(model.getCompetitors().get(0));
            away = CompetitorConverter.convertModel(model.getCompetitors().get(1));
        } else {
            home = CompetitorConverter.convertModel(model.getCompetitors().get(1));
            away = CompetitorConverter.convertModel(model.getCompetitors().get(0));
        }

        return new Event(eventId,
                model.getStartDate(),
                model.getSportName(),
                model.getCompetitionName(),
                competitionId,
                model.getSeasonName(),
                home,
                away,
                VenueConverter.convertModel(model.getVenue()),
                model.getProbabilityHomeTeamWinner(),
                model.getProbabilityDraw(),
                model.getProbabilityAwayTeamWinner(),
                mostProbableResult,
                mostProbableResultDescription);
    }

    public static EventModel convertEvent(Event event) {
        List<CompetitorModel> competitors = new ArrayList<>();
        competitors.add(CompetitorConverter.convertCompetitor(event.getHomeCompetitor(), Qualifier.HOME));
        competitors.add(CompetitorConverter.convertCompetitor(event.getAwayCompetitor(), Qualifier.AWAY));

        return new EventModel().sportEventId("sr:sport_event:"+event.getId())
                .startDate(event.getStartDate())
                .sportName(event.getSportName())
                .competitionName(event.getCompetitionName())
                .competitionId("sr:competition:"+event.getCompetitionId())
                .seasonName(event.getSeasonName())
                .competitors(competitors)
                .venue(VenueConverter.convertVenue(event.getVenue()))
                .probabilityHomeTeamWinner(event.getHomeTeamWin())
                .probabilityDraw(event.getDraw())
                .probabilityAwayTeamWinner(event.getAwayTeamWin());

    }


    public static List<EventModel> convertEvents(List<Event> events) {
        return events.stream().map(EventConverter::convertEvent).toList();
    }

    public static List<Event> convertModels(List<EventModel> models) {
        return models.stream().map(EventConverter::convertModel).toList();
    }
}
