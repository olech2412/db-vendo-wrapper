package de.olech2412.app.adapter.responses;

import de.olech2412.app.adapter.db_vendo_client.models.StopsIdDeparturesGet2XXResponse;
import lombok.Getter;
import lombok.experimental.Delegate;

/**
 * Response für Abfahrten-Anfragen.
 * Delegiert zur generierten Klasse für automatische Synchronisation.
 */
@Getter
public class DeparturesResponse {

    @Delegate
    private final StopsIdDeparturesGet2XXResponse delegate;

    public DeparturesResponse(StopsIdDeparturesGet2XXResponse delegate) {
        this.delegate = delegate;
    }
}
