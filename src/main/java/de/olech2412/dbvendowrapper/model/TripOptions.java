/*
 * db-vendo-client
 * Schema for db-vendo-client/hafas-rest-api's Friendly Public Transport Format REST API
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.olech2412.dbvendowrapper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

/**
 * TripOptions
 */
@JsonPropertyOrder({
        TripOptions.JSON_PROPERTY_STOPOVERS,
        TripOptions.JSON_PROPERTY_POLYLINE,
        TripOptions.JSON_PROPERTY_SUB_STOPS,
        TripOptions.JSON_PROPERTY_ENTRANCES,
        TripOptions.JSON_PROPERTY_REMARKS,
        TripOptions.JSON_PROPERTY_SCHEDULED_DAYS,
        TripOptions.JSON_PROPERTY_LANGUAGE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class TripOptions {
    public static final String JSON_PROPERTY_STOPOVERS = "stopovers";
    public static final String JSON_PROPERTY_POLYLINE = "polyline";
    public static final String JSON_PROPERTY_SUB_STOPS = "subStops";
    public static final String JSON_PROPERTY_ENTRANCES = "entrances";
    public static final String JSON_PROPERTY_REMARKS = "remarks";
    public static final String JSON_PROPERTY_SCHEDULED_DAYS = "scheduledDays";
    public static final String JSON_PROPERTY_LANGUAGE = "language";
    @jakarta.annotation.Nullable
    private Boolean stopovers = true;
    @jakarta.annotation.Nullable
    private Boolean polyline = false;
    @jakarta.annotation.Nullable
    private Boolean subStops = true;
    @jakarta.annotation.Nullable
    private Boolean entrances = true;
    @jakarta.annotation.Nullable
    private Boolean remarks = true;
    @jakarta.annotation.Nullable
    private Boolean scheduledDays = false;
    @jakarta.annotation.Nullable
    private String language = "en";

    public TripOptions() {
    }

    public TripOptions stopovers(@jakarta.annotation.Nullable Boolean stopovers) {

        this.stopovers = stopovers;
        return this;
    }

    /**
     * return stations on the way?
     *
     * @return stopovers
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STOPOVERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getStopovers() {
        return stopovers;
    }


    @JsonProperty(JSON_PROPERTY_STOPOVERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStopovers(@jakarta.annotation.Nullable Boolean stopovers) {
        this.stopovers = stopovers;
    }

    public TripOptions polyline(@jakarta.annotation.Nullable Boolean polyline) {

        this.polyline = polyline;
        return this;
    }

    /**
     * return a shape for the trip?
     *
     * @return polyline
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_POLYLINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getPolyline() {
        return polyline;
    }


    @JsonProperty(JSON_PROPERTY_POLYLINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPolyline(@jakarta.annotation.Nullable Boolean polyline) {
        this.polyline = polyline;
    }

    public TripOptions subStops(@jakarta.annotation.Nullable Boolean subStops) {

        this.subStops = subStops;
        return this;
    }

    /**
     * parse &amp; expose sub-stops of stations?
     *
     * @return subStops
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUB_STOPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getSubStops() {
        return subStops;
    }


    @JsonProperty(JSON_PROPERTY_SUB_STOPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSubStops(@jakarta.annotation.Nullable Boolean subStops) {
        this.subStops = subStops;
    }

    public TripOptions entrances(@jakarta.annotation.Nullable Boolean entrances) {

        this.entrances = entrances;
        return this;
    }

    /**
     * parse &amp; expose entrances of stops/stations?
     *
     * @return entrances
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENTRANCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getEntrances() {
        return entrances;
    }


    @JsonProperty(JSON_PROPERTY_ENTRANCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEntrances(@jakarta.annotation.Nullable Boolean entrances) {
        this.entrances = entrances;
    }

    public TripOptions remarks(@jakarta.annotation.Nullable Boolean remarks) {

        this.remarks = remarks;
        return this;
    }

    /**
     * parse &amp; expose hints &amp; warnings?
     *
     * @return remarks
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REMARKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getRemarks() {
        return remarks;
    }


    @JsonProperty(JSON_PROPERTY_REMARKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRemarks(@jakarta.annotation.Nullable Boolean remarks) {
        this.remarks = remarks;
    }

    public TripOptions scheduledDays(@jakarta.annotation.Nullable Boolean scheduledDays) {

        this.scheduledDays = scheduledDays;
        return this;
    }

    /**
     * parse which days each journey is valid on
     *
     * @return scheduledDays
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SCHEDULED_DAYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getScheduledDays() {
        return scheduledDays;
    }


    @JsonProperty(JSON_PROPERTY_SCHEDULED_DAYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setScheduledDays(@jakarta.annotation.Nullable Boolean scheduledDays) {
        this.scheduledDays = scheduledDays;
    }

    public TripOptions language(@jakarta.annotation.Nullable String language) {

        this.language = language;
        return this;
    }

    /**
     * Language of the results
     *
     * @return language
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LANGUAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLanguage() {
        return language;
    }


    @JsonProperty(JSON_PROPERTY_LANGUAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLanguage(@jakarta.annotation.Nullable String language) {
        this.language = language;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TripOptions tripOptions = (TripOptions) o;
        return Objects.equals(this.stopovers, tripOptions.stopovers) &&
                Objects.equals(this.polyline, tripOptions.polyline) &&
                Objects.equals(this.subStops, tripOptions.subStops) &&
                Objects.equals(this.entrances, tripOptions.entrances) &&
                Objects.equals(this.remarks, tripOptions.remarks) &&
                Objects.equals(this.scheduledDays, tripOptions.scheduledDays) &&
                Objects.equals(this.language, tripOptions.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopovers, polyline, subStops, entrances, remarks, scheduledDays, language);
    }

    @Override
    public String toString() {
        String sb = "class TripOptions {\n" +
                "    stopovers: " + toIndentedString(stopovers) + "\n" +
                "    polyline: " + toIndentedString(polyline) + "\n" +
                "    subStops: " + toIndentedString(subStops) + "\n" +
                "    entrances: " + toIndentedString(entrances) + "\n" +
                "    remarks: " + toIndentedString(remarks) + "\n" +
                "    scheduledDays: " + toIndentedString(scheduledDays) + "\n" +
                "    language: " + toIndentedString(language) + "\n" +
                "}";
        return sb;
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

