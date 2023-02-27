package org.example.service;

import org.example.converters.EventConverter;
import org.example.domain.Competitor;
import org.example.domain.Event;
import org.example.domain.Qualifier;
import org.example.model.EventsModel;
import org.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EventService {

    private static final int MAX_QUERY = 200;

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /*
     * Message format:
     *
     * Start date: 2021-08-10 17:00:00
     * Competition: Soccer
     * Slavia Prague (Czech Republic)  vs. Ferencvarosi Budapest (Hungary),
     * Venue: Sinobo Stadium,
     * Highest probable result: HOME_TEAM_WIN (65.9)
     */
    public String printEvents(Integer q) {
        List<Event> events = eventRepository.findAllByOrderByMostProbableResultDesc(PageRequest.of(0, q));

        StringBuilder message = new StringBuilder();

        //header
        message.append(String.format("%d most probable results:%n%n", q));

        //event specific string
        String eventString = """
                %d#
                Start date: %s
                Competition: %s
                %s (%s) vs. %s (%s)
                Venue: %s
                Highest probable result: %s (%.1f)
                
                """;

        Event event;

        String startDate;

        Competitor home;
        Competitor away;

        String venueName;
        String resultDescription;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (int i=0; i<q; i++) {

            //setting variables
            event = events.get(i);

            startDate = formatter.format(event.getStartDate().toLocalDateTime());

            if (event.getCompetitors().get(0).getQualifier() == Qualifier.HOME) {
                home = event.getCompetitors().get(0);
                away = event.getCompetitors().get(1);
            } else {
                home = event.getCompetitors().get(1);
                away = event.getCompetitors().get(0);
            }

            venueName = event.getVenue()==null ? "unknown" : event.getVenue().getName();

            if (event.getMostProbableResult().equals(event.getHomeTeamWin())) {
                resultDescription = "HOME_TEAM_WIN";
            } else if (event.getMostProbableResult().equals(event.getAwayTeamWin())) {
                resultDescription = "AWAY_TEAM_WIN";
            } else {
                resultDescription = "DRAW";
            }

            //formatting event string, appending the message
            message.append(String.format(eventString,
                    i+1,
                    startDate,
                    event.getCompetitionName(),
                    home.getName(), home.getCountry(), away.getName(), away.getCountry(),
                    venueName, resultDescription, event.getMostProbableResult()));
        }

        return message.toString();
    }

    public void addEvents(EventsModel eventsModel) {
        eventsModel.getEvents().stream()
                .map(EventConverter::convertModel)
                .forEach(eventRepository::save);
    }

    public boolean eventRepositoryEmpty() {
        return eventRepository.count() < 1;
    }

    public boolean queryNumberValid(Integer q) {
        return q <= MAX_QUERY && q <= eventRepository.count();
    }

    public int getMaxQuery() {
        return MAX_QUERY;
    }
}
