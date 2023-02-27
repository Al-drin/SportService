package org.example.controllers;

import org.example.api.SportserviceApi;
import org.example.model.EventsModel;
import org.example.repository.CompetitorRepository;
import org.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EventController implements SportserviceApi {

    public static final int TEAMS_MAX_QUERY = 200;

    private final CompetitorRepository competitorRepository;

    private final EventService eventService;

    @Autowired
    public EventController(CompetitorRepository competitorRepository, EventService eventService) {
        this.competitorRepository = competitorRepository;
        this.eventService = eventService;
    }

    @Override
    public ResponseEntity<Void> addEvents(EventsModel eventsModel) {

        eventService.addEvents(eventsModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> getEvents(Integer q) {

        if (eventService.eventRepositoryEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!eventService.queryNumberValid(q)) {
            return new ResponseEntity<>("Too many results requested, max query size: "
                    + eventService.getMaxQuery(), HttpStatus.BAD_REQUEST);
        }

        String response = eventService.printEvents(q);

        return new ResponseEntity<>(response, HttpStatus.OK);
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
