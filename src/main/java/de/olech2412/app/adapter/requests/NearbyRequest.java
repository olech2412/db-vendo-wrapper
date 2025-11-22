package de.olech2412.app.adapter.requests;

import de.olech2412.app.adapter.helper.DBVendoProfiles;
import lombok.Getter;
import lombok.Setter;

/**
 * Request, um Stops/Stationen in der Nähe einer Position zu finden.
 * Siehe: /locations/nearby
 *
 * @author olech2412
 */
@Getter
@Setter
public class NearbyRequest extends AbstractDBVendoRequest {

    private final Double latitude;
    private final Double longitude;

    private Integer results;
    private Integer distance;
    private Boolean stops;
    private Boolean poi;
    private Boolean linesOfStops;

    public NearbyRequest(Double latitude, Double longitude, DBVendoProfiles profile) {
        super(profile);
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
