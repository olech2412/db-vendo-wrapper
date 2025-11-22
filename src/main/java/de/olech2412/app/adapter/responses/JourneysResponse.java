package de.olech2412.app.adapter.responses;

import de.olech2412.app.adapter.db_vendo_client.models.JourneysGet2XXResponse;
import lombok.Getter;
import lombok.experimental.Delegate;

/**
 * Response für Verbindungs-Anfragen.
 * Delegiert zur generierten Klasse für automatische Synchronisation.
 */
@Getter
public class JourneysResponse {

    @Delegate
    private final JourneysGet2XXResponse delegate;

    public JourneysResponse(JourneysGet2XXResponse delegate) {
        this.delegate = delegate;
    }
}
