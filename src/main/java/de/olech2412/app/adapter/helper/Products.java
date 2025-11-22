package de.olech2412.app.adapter.helper;

import lombok.Getter;
import lombok.Setter;

/**
 * Filter für Verkehrsmittel.
 *
 * @author olech2412
 */
@Getter
@Setter
public class Products {

    private Boolean nationalExpress;
    private Boolean national;
    private Boolean regionalExpress;
    private Boolean regional;
    private Boolean suburban;
    private Boolean bus;
    private Boolean ferry;
    private Boolean subway;
    private Boolean tram;
    private Boolean taxi;
}
