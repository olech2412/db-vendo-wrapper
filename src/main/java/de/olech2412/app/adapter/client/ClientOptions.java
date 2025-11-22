package de.olech2412.app.adapter.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Konfigurationsoptionen für den DBVendoClient.
 *
 * @author olech2412
 */
@Getter
@Setter
@Builder
public class ClientOptions {

    /**
     * Basis-URL der db-vendo-client API.
     * Standard: https://v6.db.transport.rest
     */
    @Builder.Default
    private String baseUrl = "https://v6.db.transport.rest";

    /**
     * Verbindungs-Timeout in Millisekunden.
     */
    private Integer connectTimeout;

    /**
     * Lese-Timeout in Millisekunden.
     */
    private Integer readTimeout;

    /**
     * User-Agent Header für Requests.
     */
    private String userAgent;

    /**
     * Cache-Konfiguration.
     */
    private CacheOptions cacheOptions;
}
