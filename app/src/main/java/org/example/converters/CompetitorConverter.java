package org.example.converters;

import org.example.domain.Competitor;
import org.example.domain.Gender;
import org.example.domain.Qualifier;
import org.example.model.CompetitorModel;

public class CompetitorConverter {

    private CompetitorConverter() {

    }

    public static Competitor convertModel(CompetitorModel model) {
        if (model == null) {
            return null;
        }

        String idString = model.getId();
        Long id = Long.valueOf(idString.substring(idString.lastIndexOf(":")+1));

        return new Competitor(id,
                model.getName(),
                model.getCountry(),
                model.getCountryCode(),
                model.getAbbreviation(),
                Gender.valueOf(model.getGender().toUpperCase()));
    }

    public static CompetitorModel convertCompetitor(Competitor competitor, Qualifier qualifier) {

        return new CompetitorModel().id("sr:competitor:"+competitor.getId())
                .name(competitor.getName())
                .country(competitor.getCountry())
                .countryCode(competitor.getCountryCode())
                .abbreviation(competitor.getAbbreviation())
                .qualifier(qualifier.toString().toLowerCase())
                .gender(competitor.getGender().toString().toLowerCase());
    }
}
