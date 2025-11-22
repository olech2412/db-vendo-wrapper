package de.olech2412.app.adapter.helper;

/**
 * Profile, für die DB-Vendo Schnittstelle.
 * Für mehr Informationen siehe: https://github.com/public-transport/db-vendo-client
 *
 * @author olech2412
 */
public enum DBVendoProfiles {

    DB("db"),
    DB_NAV("dbnav"),
    DB_WEB("dbweb"),
    DB_RIS("dbris");

    public final String profile;

    private DBVendoProfiles(String profile) {
        this.profile = profile;
    }

}
