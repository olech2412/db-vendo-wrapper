package de.olech2412.app.adapter.requests;

import de.olech2412.app.adapter.helper.DBVendoProfiles;
import de.olech2412.app.adapter.helper.LoyaltyCard;
import de.olech2412.app.adapter.helper.Products;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Request, um Verbindungen von A nach B zu finden.
 * Siehe: /journeys
 *
 * @author olech2412
 */
@Getter
@Setter
public class JourneysRequest extends AbstractDBVendoRequest {

    // From location - mindestens eine Option muss gesetzt sein
    private String from;
    private String fromId;
    private String fromAddress;
    private Double fromLatitude;
    private Double fromLongitude;

    // To location - mindestens eine Option muss gesetzt sein
    private String to;
    private String toId;
    private String toAddress;
    private Double toLatitude;
    private Double toLongitude;

    // Optionale Parameter
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private String earlierThan;
    private String laterThan;
    private Integer results;
    private Boolean stopovers;
    private Integer transfers;
    private Integer transferTime;
    private String accessibility;
    private Boolean bike;
    private Boolean startWithWalking;
    private String walkingSpeed;
    private Boolean tickets;
    private Boolean polylines;
    private Boolean subStops;
    private Boolean entrances;
    private Boolean remarks;
    private Boolean scheduledDays;
    private Boolean notOnlyFastRoutes;
    private Boolean bestprice;
    private LoyaltyCard loyaltyCard;
    private Boolean firstClass;
    private Integer age;
    private Products products;

    public JourneysRequest(DBVendoProfiles profile) {
        super(profile);
    }

    /**
     * Convenience Konstruktor für einfache Station-zu-Station Anfragen.
     */
    public JourneysRequest(String from, String to, DBVendoProfiles profile) {
        super(profile);
        this.from = from;
        this.to = to;
    }
}
