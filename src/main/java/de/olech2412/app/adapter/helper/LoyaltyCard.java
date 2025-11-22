package de.olech2412.app.adapter.helper;

/**
 * Verfügbare Loyalty Cards für Reiseanfragen.
 *
 * @author olech2412
 */
public enum LoyaltyCard {

    BAHNCARD_1ST_25("bahncard-1st-25"),
    BAHNCARD_2ND_25("bahncard-2nd-25"),
    BAHNCARD_1ST_50("bahncard-1st-50"),
    BAHNCARD_2ND_50("bahncard-2nd-50"),
    BAHNCARD_1ST_100("bahncard-1st-100"),
    BAHNCARD_2ND_100("bahncard-2nd-100"),
    VORTEILSCARD("vorteilscard"),
    HALBTAXABO("halbtaxabo"),
    GENERALABONNEMENT_1ST("generalabonnement-1st"),
    GENERALABONNEMENT_2ND("generalabonnement-2nd"),
    NL_40("nl-40"),
    AT_KLIMATICKET("at-klimaticket");

    public final String value;

    LoyaltyCard(String value) {
        this.value = value;
    }
}
