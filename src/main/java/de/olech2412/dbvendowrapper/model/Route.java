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

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A route represents a single set of stations, of a single line.
 */
@JsonPropertyOrder({
        Route.JSON_PROPERTY_TYPE,
        Route.JSON_PROPERTY_ID,
        Route.JSON_PROPERTY_LINE,
        Route.JSON_PROPERTY_MODE,
        Route.JSON_PROPERTY_STOPS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class Route {
    public static final String JSON_PROPERTY_TYPE = "type";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_LINE = "line";
    public static final String JSON_PROPERTY_MODE = "mode";
    public static final String JSON_PROPERTY_STOPS = "stops";
    @jakarta.annotation.Nullable
    private TypeEnum type;
    @jakarta.annotation.Nullable
    private String id;
    @jakarta.annotation.Nullable
    private String line;
    @jakarta.annotation.Nullable
    private ModeEnum mode;
    @jakarta.annotation.Nullable
    private List<String> stops = new ArrayList<>();

    public Route() {
    }

    public Route type(@jakarta.annotation.Nullable TypeEnum type) {

        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(@jakarta.annotation.Nullable TypeEnum type) {
        this.type = type;
    }

    public Route id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(@jakarta.annotation.Nullable String id) {
        this.id = id;
    }

    public Route line(@jakarta.annotation.Nullable String line) {

        this.line = line;
        return this;
    }

    /**
     * Get line
     *
     * @return line
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLine() {
        return line;
    }

    @JsonProperty(JSON_PROPERTY_LINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLine(@jakarta.annotation.Nullable String line) {
        this.line = line;
    }

    public Route mode(@jakarta.annotation.Nullable ModeEnum mode) {

        this.mode = mode;
        return this;
    }

    /**
     * Get mode
     *
     * @return mode
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ModeEnum getMode() {
        return mode;
    }

    @JsonProperty(JSON_PROPERTY_MODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMode(@jakarta.annotation.Nullable ModeEnum mode) {
        this.mode = mode;
    }

    public Route stops(@jakarta.annotation.Nullable List<String> stops) {

        this.stops = stops;
        return this;
    }

    public Route addStopsItem(String stopsItem) {
        if (this.stops == null) {
            this.stops = new ArrayList<>();
        }
        this.stops.add(stopsItem);
        return this;
    }

    /**
     * stop ids
     *
     * @return stops
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STOPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getStops() {
        return stops;
    }

    @JsonProperty(JSON_PROPERTY_STOPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStops(@jakarta.annotation.Nullable List<String> stops) {
        this.stops = stops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Route route = (Route) o;
        return Objects.equals(this.type, route.type) &&
                Objects.equals(this.id, route.id) &&
                Objects.equals(this.line, route.line) &&
                Objects.equals(this.mode, route.mode) &&
                Objects.equals(this.stops, route.stops);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, line, mode, stops);
    }

    @Override
    public String toString() {
        String sb = "class Route {\n" +
                "    type: " + toIndentedString(type) + "\n" +
                "    id: " + toIndentedString(id) + "\n" +
                "    line: " + toIndentedString(line) + "\n" +
                "    mode: " + toIndentedString(mode) + "\n" +
                "    stops: " + toIndentedString(stops) + "\n" +
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

    /**
     * Gets or Sets type
     */
    public enum TypeEnum {
        ROUTE("route");

        private final String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    /**
     * Gets or Sets mode
     */
    public enum ModeEnum {
        AIRCRAFT("aircraft"),

        BICYCLE("bicycle"),

        BUS("bus"),

        CAR("car"),

        GONDOLA("gondola"),

        TAXI("taxi"),

        TRAIN("train"),

        WALKING("walking"),

        WATERCRAFT("watercraft");

        private final String value;

        ModeEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ModeEnum fromValue(String value) {
            for (ModeEnum b : ModeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}

