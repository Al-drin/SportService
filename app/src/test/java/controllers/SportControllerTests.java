package controllers;

import org.example.controllers.SportController;
import org.example.model.CompetitorModel;
import org.example.model.EventModel;
import org.example.model.EventsModel;
import org.example.model.VenueModel;
import org.example.repository.CompetitorRepository;
import org.example.service.CompetitorService;
import org.example.service.EventService;
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
class SportControllerTests {

    @InjectMocks
    SportController controller;

    @Mock
    EventService eventService;

    @Mock
    CompetitorService competitorService;

    @Test
    void addEvents_validDataGiven_serviceAccessedValidResponseReturned() {
        //given
        EventsModel data = new EventsModel();
        data.addEventsItem(getTestEventModel());
        //when
        ResponseEntity<Void> response = controller.addEvents(data);
        //then
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), response);
        verify(eventService).addEvents(data);
    }

    @Test
    void getEvents_invalidRequest_badRequestStatusReturned() {
        //given
        ResponseEntity<String> expected = new ResponseEntity<>("Too many results requested, max query size: "
                        + eventService.getMaxQuery(), HttpStatus.BAD_REQUEST);
        //when
        ResponseEntity<String> response = controller.getEvents(300);
        //then
        assertEquals(expected, response);
    }

    @Test
    void getTeams_emptyRepository_notFoundStatusReturned() {
        //given
        when(competitorService.isCompetitorRepositoryEmpty()).thenReturn(true);
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
