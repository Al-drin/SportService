package controllers;

import org.example.controllers.EventController;
import org.example.converters.EventConverter;
import org.example.model.CompetitorModel;
import org.example.model.EventModel;
import org.example.model.EventsModel;
import org.example.model.VenueModel;
import org.example.repository.CompetitorRepository;
import org.example.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventControllerTests {

    @InjectMocks
    EventController controller;

    @Mock
    EventRepository eventRepository;

    @Mock
    CompetitorRepository competitorRepository;

    @Test
    void addEvents_validDataGiven_repositoryWrittenValidResponseReturned() {
        //given
        EventsModel data = new EventsModel();
        data.addEventsItem(getTestEventModel());
        //when
        ResponseEntity<Void> response = controller.addEvents(data);
        //then
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), response);
        verify(eventRepository).save(EventConverter.convertModel(getTestEventModel()));
    }

    @Test
    void addEvents_invalidDataGiven_exceptionThrown() {
        //given
        EventsModel data = new EventsModel();
        data.addEventsItem(new EventModel());
        //when
        //then
        assertThrows(NullPointerException.class, () -> controller.addEvents(data));
    }

    /*
     * getEvents method accepts either 15, 20 or 100 query number
     */
    @Test
    void getEvents_validRequestEmptyRepository_notFoundStatusReturned() {
        //given
        ResponseEntity<String> expected =
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //when
        ResponseEntity<String> response = controller.getEvents(1);
        //then
        assertEquals(expected, response);
    }

    @Test
    void getEvents_invalidRequest_badRequestStatusReturned() {
        //given
        when(eventRepository.count()).thenReturn(1L);
        ResponseEntity<String> expected = new ResponseEntity<>("Too many results requested, max query size: "
                        + EventController.EVENTS_MAX_QUERY, HttpStatus.BAD_REQUEST);
        //when
        ResponseEntity<String> response = controller.getEvents(EventController.EVENTS_MAX_QUERY + 1);
        //then
        assertEquals(expected, response);
    }

    @Test
    void getTeams_emptyRepository_notFoundStatusReturned() {
        //given
        ResponseEntity<String> expected = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //when
        ResponseEntity<String> response = controller.getTeams();
        //then
        assertEquals(expected, response);
    }

    EventModel getTestEventModel() {
        List<CompetitorModel> competitors = new ArrayList<>();
        competitors.add(getTestCompetitorModel1());
        competitors.add(getTestCompetitorModel2());

        return new EventModel()
                .sportEventId("sr:sport_event:27636100")
                .startDate(OffsetDateTime.parse("2021-06-22T18:00:00+00:00"))
                .sportName("Soccer")
                .competitionName("UEFA Champions League")
                .competitionId("sr:competition:7")
                .seasonName("UEFA Champions League 21/22")
                .competitors(competitors)
                .venue(new VenueModel().id("sr:venue:8329")
                        .name("Elbasan Arena")
                        .capacity(12500)
                        .cityName("Elbasan")
                        .countryName("Albania")
                        .mapCoordinates("41.115875,20.091992")
                        .countryCode("ALB"))
                .probabilityHomeTeamWinner(BigDecimal.valueOf(2.5))
                .probabilityDraw(BigDecimal.valueOf(88.1))
                .probabilityAwayTeamWinner(BigDecimal.valueOf(9.4));
    }

    CompetitorModel getTestCompetitorModel1() {
        return new CompetitorModel().id("sr:competitor:37863")
                .name("SS Folgore Falciano Calcio")
                .country("San Marino")
                .countryCode("SMR")
                .abbreviation("FFC")
                .qualifier("home")
                .gender("male");
    }

    CompetitorModel getTestCompetitorModel2() {
        return new CompetitorModel().id("sr:competitor:277829")
                .name("FC Prishtina")
                .country("Kosovo")
                .countryCode("KOS")
                .abbreviation("PRI")
                .qualifier("away")
                .gender("male");
    }
}
