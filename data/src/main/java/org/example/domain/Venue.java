package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "VENUES")
public class Venue {

    @Id
    @Column(name = "VENUE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CAPACITY")
    private int capacity;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "MAP_COORDINATES")
    private String mapCoordinates;

    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venue venue)) return false;

        if (capacity != venue.capacity) return false;
        if (!id.equals(venue.id)) return false;
        if (!name.equals(venue.name)) return false;
        if (!cityName.equals(venue.cityName)) return false;
        if (!countryName.equals(venue.countryName)) return false;
        if (!mapCoordinates.equals(venue.mapCoordinates)) return false;
        return countryCode.equals(venue.countryCode);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + capacity;
        result = 31 * result + cityName.hashCode();
        result = 31 * result + countryName.hashCode();
        result = 31 * result + mapCoordinates.hashCode();
        result = 31 * result + countryCode.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", mapCoordinates='" + mapCoordinates + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
