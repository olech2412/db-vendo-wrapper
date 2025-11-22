package de.olech2412.app.adapter.responses;

import de.olech2412.app.adapter.db_vendo_client.models.JourneysRefGet2XXResponse;
import lombok.Getter;
import lombok.experimental.Delegate;

/**
 * Response für RefreshJourney-Anfragen.
 * Delegiert zur generierten Klasse für automatische Synchronisation.
 */
@Getter
public class RefreshJourneyResponse {

    @Delegate
    private final JourneysRefGet2XXResponse delegate;

    public RefreshJourneyResponse(JourneysRefGet2XXResponse delegate) {
        this.delegate = delegate;
    }
}
