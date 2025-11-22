package de.olech2412.app.adapter.requests;

import de.olech2412.app.adapter.helper.DBVendoLanguage;
import de.olech2412.app.adapter.helper.DBVendoProfiles;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class AbstractDBVendoRequest implements DBVendoRequests {

    protected final DBVendoProfiles profile;

    @Setter
    protected DBVendoLanguage language;

    protected Boolean pretty = false;

    protected AbstractDBVendoRequest(DBVendoProfiles profile) {
        this.profile = profile;
    }
}
