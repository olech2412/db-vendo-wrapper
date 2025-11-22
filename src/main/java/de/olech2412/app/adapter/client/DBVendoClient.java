package de.olech2412.app.adapter.client;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;
import de.olech2412.app.adapter.ApiClient;
import de.olech2412.app.adapter.db_vendo_client.DefaultApi;
import de.olech2412.app.adapter.db_vendo_client.models.*;
import de.olech2412.app.adapter.helper.Products;
import de.olech2412.app.adapter.requests.*;
import de.olech2412.app.adapter.responses.*;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

/**
 * Haupt-Client für die db-vendo-client API.
 * Bietet eine benutzerfreundliche Abstraktion über den generierten OpenAPI Client.
 *
 * @author olech2412
 */
public class DBVendoClient {

    private final DefaultApi api;
    private final ClientOptions options;
    private final Cache<String, Object> cache;

    public DBVendoClient(ClientOptions options) {
        this.options = options;
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(options.getBaseUrl());

        if (options.getUserAgent() != null) {
            apiClient.addDefaultHeader("User-Agent", options.getUserAgent());
        }

        this.api = new DefaultApi(apiClient);
        this.cache = buildCache(options.getCacheOptions());
    }

    // Package-private constructor for testing
    DBVendoClient(ClientOptions options, DefaultApi api) {
        this.options = options;
        this.api = api;
        this.cache = buildCache(options.getCacheOptions());
    }

    private Cache<String, Object> buildCache(CacheOptions cacheOptions) {
        if (cacheOptions == null || !cacheOptions.isEnabled()) {
            return null;
        }

        CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder()
                .maximumSize(cacheOptions.getMaximumSize())
                .expireAfterWrite(cacheOptions.getExpireAfterWrite(), cacheOptions.getExpireAfterWriteUnit());

        if (cacheOptions.getExpireAfterAccess() != null) {
            builder.expireAfterAccess(cacheOptions.getExpireAfterAccess(), cacheOptions.getExpireAfterAccessUnit());
        }

        if (cacheOptions.isRecordStats()) {
            builder.recordStats();
        }

        return builder.build();
    }

    /**
     * Gibt Cache-Statistiken zurück (nur wenn recordStats aktiviert ist).
     */
    public CacheStats getCacheStats() {
        if (cache == null) {
            return null;
        }
        return cache.stats();
    }

    /**
     * Leert den Cache.
     */
    public void clearCache() {
        if (cache != null) {
            cache.invalidateAll();
        }
    }

    /**
     * Findet einen Stop/Station anhand der ID.
     */
    public StopResponse getStop(StopByIdRequest request) {
        String cacheKey = "stop:" + request.getId() + ":" + request.getLinesOfStops() + ":" + getLanguageString(request);

        return getFromCacheOrFetch(cacheKey, () -> new StopResponse(api.stopsIdGet(
                request.getId(),
                request.getLinesOfStops(),
                getLanguageString(request),
                request.getPretty()
        )));
    }

    /**
     * Ruft Abfahrten an einem Stop/Station ab.
     */
    public DeparturesResponse getDepartures(DeparturesRequest request) {
        String cacheKey = "departures:" + request.getId() + ":" + request.getWhen() + ":" +
                request.getDuration() + ":" + request.getResults() + ":" + getLanguageString(request);

        return getFromCacheOrFetch(cacheKey, () -> new DeparturesResponse(api.stopsIdDeparturesGet(
                request.getId(),
                request.getWhen(),
                request.getDirection(),
                request.getDuration(),
                request.getResults(),
                request.getLinesOfStops(),
                request.getRemarks(),
                getLanguageString(request),
                convertProducts(request.getProducts()),
                request.getPretty()
        )));
    }

    /**
     * Ruft Ankünfte an einem Stop/Station ab.
     */
    public ArrivalsResponse getArrivals(ArrivalsRequest request) {
        String cacheKey = "arrivals:" + request.getId() + ":" + request.getWhen() + ":" +
                request.getDuration() + ":" + request.getResults() + ":" + getLanguageString(request);

        return getFromCacheOrFetch(cacheKey, () -> new ArrivalsResponse(api.stopsIdArrivalsGet(
                request.getId(),
                request.getWhen(),
                request.getDirection(),
                request.getDuration(),
                request.getResults(),
                request.getLinesOfStops(),
                request.getRemarks(),
                getLanguageString(request),
                convertProducts(request.getProducts()),
                request.getPretty()
        )));
    }

    /**
     * Sucht Verbindungen von A nach B.
     */
    public JourneysResponse getJourneys(JourneysRequest request) {
        String cacheKey = "journeys:" + request.getFrom() + ":" + request.getTo() + ":" +
                request.getDeparture() + ":" + request.getArrival() + ":" + request.getResults() + ":" +
                getLanguageString(request);

        return getFromCacheOrFetch(cacheKey, () -> new JourneysResponse(api.journeysGet(
                request.getFrom(),
                request.getFromId(),
                request.getFromAddress(),
                toBigDecimal(request.getFromLatitude()),
                toBigDecimal(request.getFromLongitude()),
                request.getTo(),
                request.getToId(),
                request.getToAddress(),
                toBigDecimal(request.getToLatitude()),
                toBigDecimal(request.getToLongitude()),
                request.getDeparture(),
                request.getArrival(),
                request.getEarlierThan(),
                request.getLaterThan(),
                request.getResults(),
                request.getStopovers(),
                request.getTransfers(),
                request.getTransferTime(),
                request.getAccessibility(),
                request.getBike(),
                request.getStartWithWalking(),
                request.getWalkingSpeed(),
                request.getTickets(),
                request.getPolylines(),
                request.getSubStops(),
                request.getEntrances(),
                request.getRemarks(),
                request.getScheduledDays(),
                request.getNotOnlyFastRoutes(),
                request.getBestprice(),
                getLanguageString(request),
                request.getLoyaltyCard() != null ? request.getLoyaltyCard().value : null,
                request.getFirstClass(),
                request.getAge(),
                convertProducts(request.getProducts()),
                request.getPretty()
        )));
    }

    /**
     * Ruft eine Fahrt anhand ihrer ID ab.
     */
    public TripResponse getTrip(TripByIdRequest request) {
        String cacheKey = "trip:" + request.getId() + ":" + request.getStopovers() + ":" +
                request.getPolyline() + ":" + getLanguageString(request);

        return getFromCacheOrFetch(cacheKey, () -> new TripResponse(api.tripsIdGet(
                request.getId(),
                request.getStopovers(),
                request.getRemarks(),
                request.getPolyline(),
                getLanguageString(request),
                request.getPretty()
        )));
    }

    /**
     * Findet Stops/Stationen in der Nähe einer Position.
     */
    public NearbyResponse getNearby(NearbyRequest request) {
        String cacheKey = "nearby:" + request.getLatitude() + ":" + request.getLongitude() + ":" +
                request.getResults() + ":" + request.getDistance() + ":" + getLanguageString(request);

        return getFromCacheOrFetch(cacheKey, () -> {
            Location location = new Location();
            location.setLatitude(request.getLatitude() != null ? BigDecimal.valueOf(request.getLatitude()) : null);
            location.setLongitude(request.getLongitude() != null ? BigDecimal.valueOf(request.getLongitude()) : null);

            return new NearbyResponse(api.locationsNearbyGet(
                    location,
                    request.getResults(),
                    request.getDistance(),
                    request.getStops(),
                    request.getPoi(),
                    request.getLinesOfStops(),
                    getLanguageString(request),
                    request.getPretty()
            ));
        });
    }

    /**
     * Sucht Stops/Stationen, POIs und Adressen.
     */
    public LocationsResponse getLocations(LocationsRequest request) {
        String cacheKey = "locations:" + request.getQuery() + ":" + request.getFuzzy() + ":" +
                request.getResults() + ":" + getLanguageString(request);

        return getFromCacheOrFetch(cacheKey, () -> new LocationsResponse(api.locationsGet(
                request.getQuery(),
                request.getFuzzy(),
                request.getResults(),
                request.getStops(),
                request.getAddresses(),
                request.getPoi(),
                request.getLinesOfStops(),
                getLanguageString(request),
                request.getPretty()
        )));
    }

    /**
     * Aktualisiert eine zuvor berechnete Verbindung mit aktuellen Echtzeitdaten.
     */
    public RefreshJourneyResponse refreshJourney(RefreshJourneyRequest request) {
        String cacheKey = "refreshJourney:" + request.getRefreshToken() + ":" + request.getStopovers() + ":" +
                getLanguageString(request);

        return getFromCacheOrFetch(cacheKey, () -> new RefreshJourneyResponse(api.journeysRefGet(
                request.getRefreshToken(),
                request.getStopovers(),
                request.getTickets(),
                request.getPolylines(),
                request.getSubStops(),
                request.getEntrances(),
                request.getRemarks(),
                request.getScheduledDays(),
                request.getNotOnlyFastRoutes(),
                request.getBestprice(),
                getLanguageString(request),
                request.getPretty()
        )));
    }

    // Helper methods

    @SuppressWarnings("unchecked")
    private <T> T getFromCacheOrFetch(String cacheKey, java.util.function.Supplier<T> fetcher) {
        if (cache == null) {
            return fetcher.get();
        }

        try {
            return (T) cache.get(cacheKey, fetcher::get);
        } catch (ExecutionException e) {
            throw new RuntimeException("Cache fetch failed", e);
        }
    }

    private String getLanguageString(AbstractDBVendoRequest request) {
        return request.getLanguage() != null ? request.getLanguage().language : null;
    }

    private BigDecimal toBigDecimal(Double value) {
        return value != null ? BigDecimal.valueOf(value) : null;
    }

    private ProfileSpecificProducts convertProducts(Products products) {
        ProfileSpecificProducts result = new ProfileSpecificProducts();

        if (products == null) {
            return result;
        }
        result.setNationalExpress(products.getNationalExpress());
        result.setNational(products.getNational());
        result.setRegionalExpress(products.getRegionalExpress());
        result.setRegional(products.getRegional());
        result.setSuburban(products.getSuburban());
        result.setBus(products.getBus());
        result.setFerry(products.getFerry());
        result.setSubway(products.getSubway());
        result.setTram(products.getTram());
        result.setTaxi(products.getTaxi());
        return result;
    }
}
