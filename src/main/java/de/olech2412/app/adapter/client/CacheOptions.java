package de.olech2412.app.adapter.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

/**
 * Konfigurationsoptionen für den API-Cache.
 *
 * @author olech2412
 */
@Getter
@Setter
@Builder
public class CacheOptions {

    /**
     * Cache aktivieren/deaktivieren.
     */
    @Builder.Default
    private boolean enabled = true;

    /**
     * Maximale Anzahl an Cache-Einträgen.
     */
    @Builder.Default
    private long maximumSize = 1000;

    /**
     * Zeit nach dem Schreiben, nach der ein Eintrag abläuft.
     */
    @Builder.Default
    private long expireAfterWrite = 5;

    /**
     * Zeiteinheit für expireAfterWrite.
     */
    @Builder.Default
    private TimeUnit expireAfterWriteUnit = TimeUnit.MINUTES;

    /**
     * Zeit nach dem letzten Zugriff, nach der ein Eintrag abläuft.
     */
    private Long expireAfterAccess;

    /**
     * Zeiteinheit für expireAfterAccess.
     */
    @Builder.Default
    private TimeUnit expireAfterAccessUnit = TimeUnit.MINUTES;

    /**
     * Statistiken aufzeichnen (für Monitoring).
     */
    @Builder.Default
    private boolean recordStats = false;
}
