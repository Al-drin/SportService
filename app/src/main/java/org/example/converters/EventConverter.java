package org.example.converters;

import org.example.domain.Event;
import org.example.model.EventModel;

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

        return new Event(eventId,
                model.getStartDate(),
                model.getSportName(),
                model.getCompetitionName(),
                competitionId,
                model.getSeasonName(),
                CompetitorConverter.convertModels(model.getCompetitors()),
                VenueConverter.convertModel(model.getVenue()),
                model.getProbabilityHomeTeamWinner(),
                model.getProbabilityDraw(),
                model.getProbabilityAwayTeamWinner());
    }

    public static EventModel convertEvent(Event event) {
        return new EventModel().sportEventId("sr:sport_event:"+event.getId())
                .startDate(event.getStartDate())
                .sportName(event.getSportName())
                .competitionName(event.getCompetitionName())
                .competitionId("sr:competition:"+event.getCompetitionId())
                .seasonName(event.getSeasonName())
                .competitors(CompetitorConverter.convertCompetitors(event.getCompetitors()))
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
