package org.example.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CompetitorModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-12T18:50:44.717575400+01:00[Europe/Warsaw]")
public class CompetitorModel   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("country")
  private String country;

  @JsonProperty("country_code")
  private String countryCode;

  @JsonProperty("abbreviation")
  private String abbreviation;

  @JsonProperty("qualifier")
  private String qualifier;

  @JsonProperty("gender")
  private String gender;

  public CompetitorModel id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(example = "sr:competitor:37863", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CompetitorModel name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "SS Folgore Falciano Calcio", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CompetitorModel country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  */
  @ApiModelProperty(example = "San Marino", value = "")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public CompetitorModel countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * @return countryCode
  */
  @ApiModelProperty(example = "SMR", value = "")


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public CompetitorModel abbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
    return this;
  }

  /**
   * Get abbreviation
   * @return abbreviation
  */
  @ApiModelProperty(example = "FFC", value = "")


  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public CompetitorModel qualifier(String qualifier) {
    this.qualifier = qualifier;
    return this;
  }

  /**
   * Get qualifier
   * @return qualifier
  */
  @ApiModelProperty(example = "home", value = "")


  public String getQualifier() {
    return qualifier;
  }

  public void setQualifier(String qualifier) {
    this.qualifier = qualifier;
  }

  public CompetitorModel gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @ApiModelProperty(example = "male", value = "")


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompetitorModel competitorModel = (CompetitorModel) o;
    return Objects.equals(this.id, competitorModel.id) &&
        Objects.equals(this.name, competitorModel.name) &&
        Objects.equals(this.country, competitorModel.country) &&
        Objects.equals(this.countryCode, competitorModel.countryCode) &&
        Objects.equals(this.abbreviation, competitorModel.abbreviation) &&
        Objects.equals(this.qualifier, competitorModel.qualifier) &&
        Objects.equals(this.gender, competitorModel.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, country, countryCode, abbreviation, qualifier, gender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompetitorModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
    sb.append("    qualifier: ").append(toIndentedString(qualifier)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

