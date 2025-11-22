package de.olech2412.app.adapter.responses;

import de.olech2412.app.adapter.db_vendo_client.models.StopsIdGet2XXResponse;
import lombok.Getter;
import lombok.experimental.Delegate;

/**
 * Response für Stop-Anfragen.
 * Delegiert zur generierten Klasse für automatische Synchronisation.
 */
@Getter
public class StopResponse {

    @Delegate
    private final StopsIdGet2XXResponse delegate;

    public StopResponse(StopsIdGet2XXResponse delegate) {
        this.delegate = delegate;
    }
}
