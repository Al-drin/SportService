package org.example.controllers;

import org.example.api.SportserviceApi;
import org.example.model.EventsModel;
import org.example.service.CompetitorService;
import org.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class SportController implements SportserviceApi {

    private final CompetitorService competitorService;

    private final EventService eventService;

    @Autowired
    public SportController(CompetitorService competitorService, EventService eventService) {
        this.competitorService = competitorService;
        this.eventService = eventService;
    }

    @Override
    public ResponseEntity<Void> addEvents(EventsModel eventsModel) {

        eventService.addEvents(eventsModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> getEvents(Integer q) {

        if (eventService.isEventRepositoryEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!eventService.isQueryNumberValid(q)) {
            return new ResponseEntity<>("Too many results requested, max query size: "
                    + eventService.getMaxQuery(), HttpStatus.BAD_REQUEST);
        }

        String response = eventService.printEvents(q);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getTeams() {

        if (competitorService.isCompetitorRepositoryEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String response = competitorService.printTeamNames();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
