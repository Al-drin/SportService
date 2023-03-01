package org.example.service;

import org.example.converters.EventConverter;
import org.example.domain.Event;
import org.example.model.EventsModel;
import org.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private static final int MAX_QUERY = 200;

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public String printEvents(Integer q) {
        List<Event> events = eventRepository.findAllByOrderByMostProbableResultDesc(PageRequest.of(0, q));

        StringBuilder message = new StringBuilder();

        message.append(q).append(" most probable results:\n\n");

        for (int i=0; i<q; i++) {
            message.append(i+1).append(":\n");
            message.append(events.get(i).toFormattedString());
            message.append("\n");
        }

        return message.toString();
    }

    public void addEvents(EventsModel eventsModel) {
        eventsModel.getEvents().stream()
                .map(EventConverter::convertModel)
                .forEach(eventRepository::save);
    }

    public boolean isEventRepositoryEmpty() {
        return eventRepository.count() < 1;
    }

    public boolean isQueryNumberValid(Integer q) {
        return q <= MAX_QUERY && q <= eventRepository.count();
    }

    public int getMaxQuery() {
        return MAX_QUERY;
    }
}
