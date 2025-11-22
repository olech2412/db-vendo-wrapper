package de.olech2412.app.adapter.requests;

import de.olech2412.app.adapter.helper.DBVendoProfiles;
import lombok.Getter;
import lombok.Setter;

/**
 * Request, um eine Fahrt anhand ihrer ID abzufragen.
 * Siehe: /trips/{id}
 *
 * @author olech2412
 */
@Getter
@Setter
public class TripByIdRequest extends AbstractDBVendoRequest {

    private final String id;

    private Boolean stopovers;
    private Boolean remarks;
    private Boolean polyline;

    public TripByIdRequest(String id, DBVendoProfiles profile) {
        super(profile);
        this.id = id;
    }
}
