package de.olech2412.app.adapter.responses;

import de.olech2412.app.adapter.db_vendo_client.models.StopsIdArrivalsGet2XXResponse;
import lombok.Getter;
import lombok.experimental.Delegate;

/**
 * Response für Ankünfte-Anfragen.
 * Delegiert zur generierten Klasse für automatische Synchronisation.
 */
@Getter
public class ArrivalsResponse {

    @Delegate
    private final StopsIdArrivalsGet2XXResponse delegate;

    public ArrivalsResponse(StopsIdArrivalsGet2XXResponse delegate) {
        this.delegate = delegate;
    }
}
