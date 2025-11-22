package de.olech2412.app.adapter.responses;

import de.olech2412.app.adapter.db_vendo_client.models.StopsIdGet2XXResponse;
import lombok.Getter;

import java.util.List;

/**
 * Response für Nearby-Anfragen.
 */
@Getter
public class NearbyResponse {

    private final List<StopsIdGet2XXResponse> locations;

    public NearbyResponse(List<StopsIdGet2XXResponse> locations) {
        this.locations = locations;
    }
}
