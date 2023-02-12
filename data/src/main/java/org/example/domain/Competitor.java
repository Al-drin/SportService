package org.example.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COMPETITORS")
public class Competitor {

    @Id
    @Column(name = "COMPETITOR_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    @Column(name = "ABBREVIATION")
    private String abbreviation;

    @Enumerated(EnumType.STRING)
    @Column(name = "QUALIFIER")
    private Qualifier qualifier;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private Gender gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Competitor that)) return false;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!country.equals(that.country)) return false;
        if (!countryCode.equals(that.countryCode)) return false;
        if (!abbreviation.equals(that.abbreviation)) return false;
        if (qualifier != that.qualifier) return false;
        return gender == that.gender;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + countryCode.hashCode();
        result = 31 * result + abbreviation.hashCode();
        result = 31 * result + qualifier.hashCode();
        result = 31 * result + gender.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", qualifier=" + qualifier +
                ", gender=" + gender +
                '}';
    }
}
