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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * WarningsWithRealtimeData
 */
@JsonPropertyOrder({
        WarningsWithRealtimeData.JSON_PROPERTY_REMARKS,
        WarningsWithRealtimeData.JSON_PROPERTY_REALTIME_DATA_UPDATED_AT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class WarningsWithRealtimeData {
    public static final String JSON_PROPERTY_REMARKS = "remarks";
    public static final String JSON_PROPERTY_REALTIME_DATA_UPDATED_AT = "realtimeDataUpdatedAt";
    @jakarta.annotation.Nullable
    private List<Warning> remarks = new ArrayList<>();
    @jakarta.annotation.Nullable
    private BigDecimal realtimeDataUpdatedAt;

    public WarningsWithRealtimeData() {
    }

    public WarningsWithRealtimeData remarks(@jakarta.annotation.Nullable List<Warning> remarks) {

        this.remarks = remarks;
        return this;
    }

    public WarningsWithRealtimeData addRemarksItem(Warning remarksItem) {
        if (this.remarks == null) {
            this.remarks = new ArrayList<>();
        }
        this.remarks.add(remarksItem);
        return this;
    }

    /**
     * Get remarks
     *
     * @return remarks
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REMARKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Warning> getRemarks() {
        return remarks;
    }


    @JsonProperty(JSON_PROPERTY_REMARKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRemarks(@jakarta.annotation.Nullable List<Warning> remarks) {
        this.remarks = remarks;
    }

    public WarningsWithRealtimeData realtimeDataUpdatedAt(@jakarta.annotation.Nullable BigDecimal realtimeDataUpdatedAt) {

        this.realtimeDataUpdatedAt = realtimeDataUpdatedAt;
        return this;
    }

    /**
     * Get realtimeDataUpdatedAt
     *
     * @return realtimeDataUpdatedAt
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REALTIME_DATA_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getRealtimeDataUpdatedAt() {
        return realtimeDataUpdatedAt;
    }


    @JsonProperty(JSON_PROPERTY_REALTIME_DATA_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRealtimeDataUpdatedAt(@jakarta.annotation.Nullable BigDecimal realtimeDataUpdatedAt) {
        this.realtimeDataUpdatedAt = realtimeDataUpdatedAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WarningsWithRealtimeData warningsWithRealtimeData = (WarningsWithRealtimeData) o;
        return Objects.equals(this.remarks, warningsWithRealtimeData.remarks) &&
                Objects.equals(this.realtimeDataUpdatedAt, warningsWithRealtimeData.realtimeDataUpdatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remarks, realtimeDataUpdatedAt);
    }

    @Override
    public String toString() {
        String sb = "class WarningsWithRealtimeData {\n" +
                "    remarks: " + toIndentedString(remarks) + "\n" +
                "    realtimeDataUpdatedAt: " + toIndentedString(realtimeDataUpdatedAt) + "\n" +
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

