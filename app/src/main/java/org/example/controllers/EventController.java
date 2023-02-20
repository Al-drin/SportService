package org.example.controllers;

import org.example.api.SportserviceApi;
import org.example.converters.EventConverter;
import org.example.domain.Competitor;
import org.example.domain.Event;
import org.example.domain.Qualifier;
import org.example.model.InlineObject;
import org.example.repository.CompetitorRepository;
import org.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class EventController implements SportserviceApi {

    CompetitorRepository competitorRepository;

    EventRepository eventRepository;

    @Autowired
    public EventController(CompetitorRepository competitorRepository, EventRepository eventRepository) {
        this.competitorRepository = competitorRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseEntity<Void> addEvents(InlineObject inlineObject) {

        inlineObject.getEvents().stream()
                .map(EventConverter::convertModel)
                .forEach(event -> eventRepository.save(event));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // TODO: 16.02.2023 refactor, perhaps a view object; this method should just get the list of events, a different
    //                  method should handle presentation as a string
    @Override
    public ResponseEntity<String> getEvents(Integer q) {
        List<Event> events;

        switch (q) {
            case 15 -> events = eventRepository.findTop15ByOrderByMostProbableResultDesc();
            case 20 -> events = eventRepository.findTop20ByOrderByMostProbableResultDesc();
            case 100 -> events = eventRepository.findTop100ByOrderByMostProbableResultDesc();
            default -> {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        StringBuilder result = new StringBuilder();

        result.append(q+" most probable results:\n");
        result.append("\n");

        int i = 1;

        Competitor home;
        Competitor away;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (Event event : events) {
            result.append((i++)+"#\n");
            result.append("Start date: "+formatter.format(event.getStartDate().toLocalDateTime())+"\n");
            result.append("Competition: "+event.getCompetitionName()+"\n");

            if (event.getCompetitors().get(0).getQualifier() == Qualifier.HOME) {
                home = event.getCompetitors().get(0);
                away = event.getCompetitors().get(1);
            } else {
                home = event.getCompetitors().get(1);
                away = event.getCompetitors().get(0);
            }

            result.append(home.getName()+" ("+home.getCountry()+")");
            result.append(" vs ");
            result.append(away.getName()+" ("+away.getCountry()+")\n");
            result.append("Venue: "+(event.getVenue()==null?"unknown":event.getVenue().getName())+"\n");
            result.append("Highest probable result: ");

            if (event.getMostProbableResult().equals(event.getHomeTeamWin())) {
                result.append("HOME_TEAM_WIN");
            } else if (event.getMostProbableResult().equals(event.getAwayTeamWin())) {
                result.append("AWAY_TEAM_WIN");
            } else {
                result.append("DRAW");
            }

            result.append(" ("+event.getMostProbableResult()+")\n");
            result.append("\n");
        }


        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }

    // TODO: 15.02.2023 rework to TeamsController
    @Override
    public ResponseEntity<String> getTeams() {
        List<String> teamNames = competitorRepository.getUniqueCompetitorNames();

        if (teamNames.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        StringBuilder result = new StringBuilder();

        result.append("Team names:\n\n");

        for (String name : teamNames) {
            result.append(name+"\n");
        }

        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }
}
