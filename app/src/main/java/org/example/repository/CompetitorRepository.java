package org.example.repository;

import org.example.domain.Competitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitorRepository extends JpaRepository<Competitor, Long> {

    @Query(value = "SELECT DISTINCT NAME FROM COMPETITORS", nativeQuery = true)
    List<String> getUniqueCompetitorNames();
}
