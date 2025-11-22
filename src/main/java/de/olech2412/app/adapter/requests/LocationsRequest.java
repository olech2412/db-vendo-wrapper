package de.olech2412.app.adapter.requests;

import de.olech2412.app.adapter.helper.DBVendoProfiles;
import lombok.Getter;
import lombok.Setter;

/**
 * Request, um Stops/Stationen, POIs und Adressen zu suchen.
 * Siehe: /locations
 *
 * @author olech2412
 */
@Getter
@Setter
public class LocationsRequest extends AbstractDBVendoRequest {

    private final String query;

    private Boolean fuzzy;
    private Integer results;
    private Boolean stops;
    private Boolean addresses;
    private Boolean poi;
    private Boolean linesOfStops;

    public LocationsRequest(String query, DBVendoProfiles profile) {
        super(profile);
        this.query = query;
    }
}
