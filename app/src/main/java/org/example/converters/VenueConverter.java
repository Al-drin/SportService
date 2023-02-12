package org.example.converters;

import org.example.domain.Venue;
import org.example.model.VenueModel;

public class VenueConverter {

    private VenueConverter() {

    }

    public static Venue convertModel(VenueModel model) {
        if (model == null) {
            return null;
        }

        String idString = model.getId();
        Long id = Long.valueOf(idString.substring(idString.lastIndexOf(":")+1));

        return new Venue(id,
                model.getName(),
                model.getCapacity(),
                model.getCityName(),
                model.getCountryName(),
                model.getMapCoordinates(),
                model.getCountryCode());
    }

    public static VenueModel convertVenue(Venue venue) {
        return new VenueModel().id("sr:venue:"+venue.getId())
                .name(venue.getName())
                .capacity(venue.getCapacity())
                .cityName(venue.getCityName())
                .countryName(venue.getCountryName())
                .mapCoordinates(venue.getMapCoordinates())
                .countryCode(venue.getCountryCode());
    }
}
