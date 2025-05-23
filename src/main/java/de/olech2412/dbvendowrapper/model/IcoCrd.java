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

import java.math.BigDecimal;
import java.util.Objects;

/**
 * IcoCrd
 */
@JsonPropertyOrder({
        IcoCrd.JSON_PROPERTY_X,
        IcoCrd.JSON_PROPERTY_Y,
        IcoCrd.JSON_PROPERTY_TYPE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class IcoCrd {
    public static final String JSON_PROPERTY_X = "x";
    public static final String JSON_PROPERTY_Y = "y";
    public static final String JSON_PROPERTY_TYPE = "type";
    @jakarta.annotation.Nullable
    private BigDecimal x;
    @jakarta.annotation.Nullable
    private BigDecimal y;
    @jakarta.annotation.Nullable
    private String type;

    public IcoCrd() {
    }

    public IcoCrd x(@jakarta.annotation.Nullable BigDecimal x) {

        this.x = x;
        return this;
    }

    /**
     * Get x
     *
     * @return x
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_X)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getX() {
        return x;
    }


    @JsonProperty(JSON_PROPERTY_X)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setX(@jakarta.annotation.Nullable BigDecimal x) {
        this.x = x;
    }

    public IcoCrd y(@jakarta.annotation.Nullable BigDecimal y) {

        this.y = y;
        return this;
    }

    /**
     * Get y
     *
     * @return y
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_Y)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getY() {
        return y;
    }


    @JsonProperty(JSON_PROPERTY_Y)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setY(@jakarta.annotation.Nullable BigDecimal y) {
        this.y = y;
    }

    public IcoCrd type(@jakarta.annotation.Nullable String type) {

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

    public String getType() {
        return type;
    }


    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(@jakarta.annotation.Nullable String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IcoCrd icoCrd = (IcoCrd) o;
        return Objects.equals(this.x, icoCrd.x) &&
                Objects.equals(this.y, icoCrd.y) &&
                Objects.equals(this.type, icoCrd.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, type);
    }

    @Override
    public String toString() {
        String sb = "class IcoCrd {\n" +
                "    x: " + toIndentedString(x) + "\n" +
                "    y: " + toIndentedString(y) + "\n" +
                "    type: " + toIndentedString(type) + "\n" +
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

