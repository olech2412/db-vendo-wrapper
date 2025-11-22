package de.olech2412.app.adapter.requests;

import de.olech2412.app.adapter.helper.DBVendoProfiles;
import de.olech2412.app.adapter.helper.Products;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Request, um Ankünfte an einem Stop/Station abzufragen.
 * Siehe: /stops/{id}/arrivals
 *
 * @author olech2412
 */
@Getter
@Setter
public class ArrivalsRequest extends AbstractDBVendoRequest {

    private final String id;

    private LocalDateTime when;
    private String direction;
    private Integer duration;
    private Integer results;
    private Boolean linesOfStops;
    private Boolean remarks;
    private Products products;

    public ArrivalsRequest(String id, DBVendoProfiles profile) {
        super(profile);
        this.id = id;
    }
}
