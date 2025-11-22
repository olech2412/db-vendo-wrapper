package de.olech2412.app.adapter.responses;

import de.olech2412.app.adapter.db_vendo_client.models.TripsIdGet2XXResponse;
import lombok.Getter;
import lombok.experimental.Delegate;

/**
 * Response für Trip-Anfragen.
 * Delegiert zur generierten Klasse für automatische Synchronisation.
 */
@Getter
public class TripResponse {

    @Delegate
    private final TripsIdGet2XXResponse delegate;

    public TripResponse(TripsIdGet2XXResponse delegate) {
        this.delegate = delegate;
    }
}
