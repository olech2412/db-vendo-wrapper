package de.olech2412.app.adapter.requests;

import de.olech2412.app.adapter.helper.DBVendoProfiles;
import lombok.Getter;
import lombok.Setter;

/**
 * Request, um einen Stop oder eine Station anhand seiner Id zu finden.
 * Siehe: /stops/{id}
 *
 * @author olech2412
 */
@Getter
@Setter
public class StopByIdRequest extends AbstractDBVendoRequest {

    private final String id;

    private Boolean linesOfStops;

    public StopByIdRequest(String id, DBVendoProfiles profile) {
        super(profile);
        this.id = id;
    }
}
