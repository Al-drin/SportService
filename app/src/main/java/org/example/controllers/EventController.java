package org.example.controllers;

import org.example.api.SportserviceApi;
import org.example.converters.EventConverter;
import org.example.model.EventModel;
import org.example.model.InlineObject;
import org.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EventController implements SportserviceApi {

    @Autowired
    EventRepository eventRepository;

    @Override
    public ResponseEntity<Void> addEvents(InlineObject inlineObject) {

        inlineObject.getEvents().stream()
                .map(EventConverter::convertModel)
                .forEach(event -> eventRepository.save(event));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<EventModel>> getEvents() {
        List<EventModel> eventModels =
                EventConverter.convertEvents(eventRepository.findTop10ByOrderByMostProbableResultDesc());

        return new ResponseEntity<>(eventModels, HttpStatus.OK);
    }
}
