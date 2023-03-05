package org.example.service;

import org.example.repository.CompetitorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompetitorService {

    private static final int MAX_QUERY = 200;

    private final CompetitorRepository competitorRepository;

    @Autowired
    public CompetitorService(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    public String printTeamNames() {
        List<String> teamNames = competitorRepository.getUniqueCompetitorNames();

        StringBuilder result = new StringBuilder();

        result.append("Team names:\n\n");

        for (String name : teamNames) {
            result.append(name);
            result.append("\n");
        }

        return result.toString();
    }

    public boolean isCompetitorRepositoryEmpty() {
        return competitorRepository.count() < 1;
    }

    public boolean isQueryNumberValid(Integer q) {
        return q <= MAX_QUERY && q <= competitorRepository.count();
    }

    public int getMaxQuery() {
        return MAX_QUERY;
    }

}
