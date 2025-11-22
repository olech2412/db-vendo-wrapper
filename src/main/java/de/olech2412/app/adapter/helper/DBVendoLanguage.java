package de.olech2412.app.adapter.helper;

/**
 * Sprache, die für Abfragen verwendet werden soll.
 *
 * @author olech2412
 */
public enum DBVendoLanguage {

    DE("de"),
    EN("en");

    public final String language;

    private DBVendoLanguage(String language) {
        this.language = language;
    }

}
