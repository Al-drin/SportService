package org.example.converters;

import org.example.domain.Competitor;
import org.example.domain.Gender;
import org.example.domain.Qualifier;
import org.example.model.CompetitorModel;

import java.util.List;

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
                Qualifier.valueOf(model.getQualifier().toUpperCase()),
                Gender.valueOf(model.getGender().toUpperCase()));
    }

    public static CompetitorModel convertCompetitor(Competitor competitor) {

        return new CompetitorModel().id("sr:competitor:"+competitor.getId())
                .name(competitor.getName())
                .country(competitor.getCountry())
                .countryCode(competitor.getCountryCode())
                .abbreviation(competitor.getAbbreviation())
                .qualifier(competitor.getQualifier().toString().toLowerCase())
                .gender(competitor.getGender().toString().toLowerCase());
    }


    public static List<Competitor> convertModels(List<CompetitorModel> models) {
        return models.stream().map(CompetitorConverter::convertModel).toList();
    }

    public static List<CompetitorModel> convertCompetitors(List<Competitor> competitors) {
        return competitors.stream().map(CompetitorConverter::convertCompetitor).toList();
    }
}
