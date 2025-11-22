package de.olech2412.app.adapter.requests;

import de.olech2412.app.adapter.helper.DBVendoProfiles;
import lombok.Getter;
import lombok.Setter;

/**
 * Request, um eine zuvor berechnete Verbindung mit aktuellen Echtzeitdaten zu aktualisieren.
 * Siehe: /journeys/{ref}
 *
 * @author olech2412
 */
@Getter
@Setter
public class RefreshJourneyRequest extends AbstractDBVendoRequest {

    private final String refreshToken;

    private Boolean stopovers;
    private Boolean tickets;
    private Boolean polylines;
    private Boolean subStops;
    private Boolean entrances;
    private Boolean remarks;
    private Boolean scheduledDays;
    private Boolean notOnlyFastRoutes;
    private Boolean bestprice;

    public RefreshJourneyRequest(String refreshToken, DBVendoProfiles profile) {
        super(profile);
        this.refreshToken = refreshToken;
    }
}
