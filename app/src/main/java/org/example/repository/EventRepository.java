package org.example.repository;

import org.example.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findTop15ByOrderByMostProbableResultDesc();
    List<Event> findTop20ByOrderByMostProbableResultDesc();
    List<Event> findTop100ByOrderByMostProbableResultDesc();

}
