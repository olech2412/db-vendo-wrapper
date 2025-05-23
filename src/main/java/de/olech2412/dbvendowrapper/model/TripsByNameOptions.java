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

import java.time.OffsetDateTime;
import java.util.*;

/**
 * TripsByNameOptions
 */
@JsonPropertyOrder({
        TripsByNameOptions.JSON_PROPERTY_WHEN,
        TripsByNameOptions.JSON_PROPERTY_FROM_WHEN,
        TripsByNameOptions.JSON_PROPERTY_UNTIL_WHEN,
        TripsByNameOptions.JSON_PROPERTY_ONLY_CURRENTLY_RUNNING,
        TripsByNameOptions.JSON_PROPERTY_PRODUCTS,
        TripsByNameOptions.JSON_PROPERTY_CURRENTLY_STOPPING_AT,
        TripsByNameOptions.JSON_PROPERTY_LINE_NAME,
        TripsByNameOptions.JSON_PROPERTY_OPERATOR_NAMES,
        TripsByNameOptions.JSON_PROPERTY_ADDITIONAL_FILTERS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class TripsByNameOptions {
    public static final String JSON_PROPERTY_WHEN = "when";
    public static final String JSON_PROPERTY_FROM_WHEN = "fromWhen";
    public static final String JSON_PROPERTY_UNTIL_WHEN = "untilWhen";
    public static final String JSON_PROPERTY_ONLY_CURRENTLY_RUNNING = "onlyCurrentlyRunning";
    public static final String JSON_PROPERTY_PRODUCTS = "products";
    public static final String JSON_PROPERTY_CURRENTLY_STOPPING_AT = "currentlyStoppingAt";
    public static final String JSON_PROPERTY_LINE_NAME = "lineName";
    public static final String JSON_PROPERTY_OPERATOR_NAMES = "operatorNames";
    public static final String JSON_PROPERTY_ADDITIONAL_FILTERS = "additionalFilters";
    @jakarta.annotation.Nullable
    private OffsetDateTime when;
    @jakarta.annotation.Nullable
    private OffsetDateTime fromWhen;
    @jakarta.annotation.Nullable
    private OffsetDateTime untilWhen;
    @jakarta.annotation.Nullable
    private Boolean onlyCurrentlyRunning;
    @jakarta.annotation.Nullable
    private Map<String, Boolean> products = new HashMap<>();
    @jakarta.annotation.Nullable
    private String currentlyStoppingAt;
    @jakarta.annotation.Nullable
    private String lineName;
    @jakarta.annotation.Nullable
    private List<String> operatorNames = new ArrayList<>();
    @jakarta.annotation.Nullable
    private List<Filter> additionalFilters = new ArrayList<>();

    public TripsByNameOptions() {
    }

    public TripsByNameOptions when(@jakarta.annotation.Nullable OffsetDateTime when) {

        this.when = when;
        return this;
    }

    /**
     * departure date, undefined corresponds to Date.Now
     *
     * @return when
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WHEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getWhen() {
        return when;
    }


    @JsonProperty(JSON_PROPERTY_WHEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWhen(@jakarta.annotation.Nullable OffsetDateTime when) {
        this.when = when;
    }

    public TripsByNameOptions fromWhen(@jakarta.annotation.Nullable OffsetDateTime fromWhen) {

        this.fromWhen = fromWhen;
        return this;
    }

    /**
     * Get fromWhen
     *
     * @return fromWhen
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FROM_WHEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getFromWhen() {
        return fromWhen;
    }


    @JsonProperty(JSON_PROPERTY_FROM_WHEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFromWhen(@jakarta.annotation.Nullable OffsetDateTime fromWhen) {
        this.fromWhen = fromWhen;
    }

    public TripsByNameOptions untilWhen(@jakarta.annotation.Nullable OffsetDateTime untilWhen) {

        this.untilWhen = untilWhen;
        return this;
    }

    /**
     * Get untilWhen
     *
     * @return untilWhen
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UNTIL_WHEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getUntilWhen() {
        return untilWhen;
    }


    @JsonProperty(JSON_PROPERTY_UNTIL_WHEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUntilWhen(@jakarta.annotation.Nullable OffsetDateTime untilWhen) {
        this.untilWhen = untilWhen;
    }

    public TripsByNameOptions onlyCurrentlyRunning(@jakarta.annotation.Nullable Boolean onlyCurrentlyRunning) {

        this.onlyCurrentlyRunning = onlyCurrentlyRunning;
        return this;
    }

    /**
     * Get onlyCurrentlyRunning
     *
     * @return onlyCurrentlyRunning
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ONLY_CURRENTLY_RUNNING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getOnlyCurrentlyRunning() {
        return onlyCurrentlyRunning;
    }


    @JsonProperty(JSON_PROPERTY_ONLY_CURRENTLY_RUNNING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOnlyCurrentlyRunning(@jakarta.annotation.Nullable Boolean onlyCurrentlyRunning) {
        this.onlyCurrentlyRunning = onlyCurrentlyRunning;
    }

    public TripsByNameOptions products(@jakarta.annotation.Nullable Map<String, Boolean> products) {

        this.products = products;
        return this;
    }

    public TripsByNameOptions putProductsItem(String key, Boolean productsItem) {
        if (this.products == null) {
            this.products = new HashMap<>();
        }
        this.products.put(key, productsItem);
        return this;
    }

    /**
     * Each public transportation network exposes its products as boolean properties. See {@link ProductType}
     *
     * @return products
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRODUCTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Map<String, Boolean> getProducts() {
        return products;
    }


    @JsonProperty(JSON_PROPERTY_PRODUCTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProducts(@jakarta.annotation.Nullable Map<String, Boolean> products) {
        this.products = products;
    }

    public TripsByNameOptions currentlyStoppingAt(@jakarta.annotation.Nullable String currentlyStoppingAt) {

        this.currentlyStoppingAt = currentlyStoppingAt;
        return this;
    }

    /**
     * Get currentlyStoppingAt
     *
     * @return currentlyStoppingAt
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CURRENTLY_STOPPING_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCurrentlyStoppingAt() {
        return currentlyStoppingAt;
    }


    @JsonProperty(JSON_PROPERTY_CURRENTLY_STOPPING_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCurrentlyStoppingAt(@jakarta.annotation.Nullable String currentlyStoppingAt) {
        this.currentlyStoppingAt = currentlyStoppingAt;
    }

    public TripsByNameOptions lineName(@jakarta.annotation.Nullable String lineName) {

        this.lineName = lineName;
        return this;
    }

    /**
     * Get lineName
     *
     * @return lineName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLineName() {
        return lineName;
    }


    @JsonProperty(JSON_PROPERTY_LINE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLineName(@jakarta.annotation.Nullable String lineName) {
        this.lineName = lineName;
    }

    public TripsByNameOptions operatorNames(@jakarta.annotation.Nullable List<String> operatorNames) {

        this.operatorNames = operatorNames;
        return this;
    }

    public TripsByNameOptions addOperatorNamesItem(String operatorNamesItem) {
        if (this.operatorNames == null) {
            this.operatorNames = new ArrayList<>();
        }
        this.operatorNames.add(operatorNamesItem);
        return this;
    }

    /**
     * Get operatorNames
     *
     * @return operatorNames
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OPERATOR_NAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getOperatorNames() {
        return operatorNames;
    }


    @JsonProperty(JSON_PROPERTY_OPERATOR_NAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOperatorNames(@jakarta.annotation.Nullable List<String> operatorNames) {
        this.operatorNames = operatorNames;
    }

    public TripsByNameOptions additionalFilters(@jakarta.annotation.Nullable List<Filter> additionalFilters) {

        this.additionalFilters = additionalFilters;
        return this;
    }

    public TripsByNameOptions addAdditionalFiltersItem(Filter additionalFiltersItem) {
        if (this.additionalFilters == null) {
            this.additionalFilters = new ArrayList<>();
        }
        this.additionalFilters.add(additionalFiltersItem);
        return this;
    }

    /**
     * Get additionalFilters
     *
     * @return additionalFilters
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ADDITIONAL_FILTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Filter> getAdditionalFilters() {
        return additionalFilters;
    }


    @JsonProperty(JSON_PROPERTY_ADDITIONAL_FILTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAdditionalFilters(@jakarta.annotation.Nullable List<Filter> additionalFilters) {
        this.additionalFilters = additionalFilters;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TripsByNameOptions tripsByNameOptions = (TripsByNameOptions) o;
        return Objects.equals(this.when, tripsByNameOptions.when) &&
                Objects.equals(this.fromWhen, tripsByNameOptions.fromWhen) &&
                Objects.equals(this.untilWhen, tripsByNameOptions.untilWhen) &&
                Objects.equals(this.onlyCurrentlyRunning, tripsByNameOptions.onlyCurrentlyRunning) &&
                Objects.equals(this.products, tripsByNameOptions.products) &&
                Objects.equals(this.currentlyStoppingAt, tripsByNameOptions.currentlyStoppingAt) &&
                Objects.equals(this.lineName, tripsByNameOptions.lineName) &&
                Objects.equals(this.operatorNames, tripsByNameOptions.operatorNames) &&
                Objects.equals(this.additionalFilters, tripsByNameOptions.additionalFilters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(when, fromWhen, untilWhen, onlyCurrentlyRunning, products, currentlyStoppingAt, lineName, operatorNames, additionalFilters);
    }

    @Override
    public String toString() {
        String sb = "class TripsByNameOptions {\n" +
                "    when: " + toIndentedString(when) + "\n" +
                "    fromWhen: " + toIndentedString(fromWhen) + "\n" +
                "    untilWhen: " + toIndentedString(untilWhen) + "\n" +
                "    onlyCurrentlyRunning: " + toIndentedString(onlyCurrentlyRunning) + "\n" +
                "    products: " + toIndentedString(products) + "\n" +
                "    currentlyStoppingAt: " + toIndentedString(currentlyStoppingAt) + "\n" +
                "    lineName: " + toIndentedString(lineName) + "\n" +
                "    operatorNames: " + toIndentedString(operatorNames) + "\n" +
                "    additionalFilters: " + toIndentedString(additionalFilters) + "\n" +
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

