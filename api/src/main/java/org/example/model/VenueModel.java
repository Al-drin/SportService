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
 * VenueModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-05T13:00:35.590383600+01:00[Europe/Warsaw]")
public class VenueModel   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("capacity")
  private Integer capacity;

  @JsonProperty("city_name")
  private String cityName;

  @JsonProperty("country_name")
  private String countryName;

  @JsonProperty("map_coordinates")
  private String mapCoordinates;

  @JsonProperty("country_code")
  private String countryCode;

  public VenueModel id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(example = "sr:venue:18653", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public VenueModel name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "Niko Dovana Stadium", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public VenueModel capacity(Integer capacity) {
    this.capacity = capacity;
    return this;
  }

  /**
   * Get capacity
   * @return capacity
  */
  @ApiModelProperty(example = "12040", value = "")


  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public VenueModel cityName(String cityName) {
    this.cityName = cityName;
    return this;
  }

  /**
   * Get cityName
   * @return cityName
  */
  @ApiModelProperty(example = "Durres", value = "")


  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public VenueModel countryName(String countryName) {
    this.countryName = countryName;
    return this;
  }

  /**
   * Get countryName
   * @return countryName
  */
  @ApiModelProperty(example = "Albania", value = "")


  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public VenueModel mapCoordinates(String mapCoordinates) {
    this.mapCoordinates = mapCoordinates;
    return this;
  }

  /**
   * Get mapCoordinates
   * @return mapCoordinates
  */
  @ApiModelProperty(example = "41.326081,19.449856", value = "")


  public String getMapCoordinates() {
    return mapCoordinates;
  }

  public void setMapCoordinates(String mapCoordinates) {
    this.mapCoordinates = mapCoordinates;
  }

  public VenueModel countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * @return countryCode
  */
  @ApiModelProperty(example = "ALB", value = "")


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VenueModel venueModel = (VenueModel) o;
    return Objects.equals(this.id, venueModel.id) &&
        Objects.equals(this.name, venueModel.name) &&
        Objects.equals(this.capacity, venueModel.capacity) &&
        Objects.equals(this.cityName, venueModel.cityName) &&
        Objects.equals(this.countryName, venueModel.countryName) &&
        Objects.equals(this.mapCoordinates, venueModel.mapCoordinates) &&
        Objects.equals(this.countryCode, venueModel.countryCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, capacity, cityName, countryName, mapCoordinates, countryCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VenueModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    cityName: ").append(toIndentedString(cityName)).append("\n");
    sb.append("    countryName: ").append(toIndentedString(countryName)).append("\n");
    sb.append("    mapCoordinates: ").append(toIndentedString(mapCoordinates)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
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

