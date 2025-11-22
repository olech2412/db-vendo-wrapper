package de.olech2412.app.adapter.client;

import de.olech2412.app.adapter.db_vendo_client.DefaultApi;
import de.olech2412.app.adapter.db_vendo_client.models.*;
import de.olech2412.app.adapter.helper.DBVendoLanguage;
import de.olech2412.app.adapter.helper.DBVendoProfiles;
import de.olech2412.app.adapter.helper.LoyaltyCard;
import de.olech2412.app.adapter.helper.Products;
import de.olech2412.app.adapter.requests.*;
import de.olech2412.app.adapter.responses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("DBVendoClient Tests")
class DBVendoClientTest {

    @Mock
    private DefaultApi mockApi;

    private DBVendoClient client;
    private ClientOptions options;

    @BeforeEach
    void setUp() {
        options = ClientOptions.builder()
                .baseUrl("http://localhost:3000")
                .build();
        client = new DBVendoClient(options, mockApi);
    }

    @Nested
    @DisplayName("Stop Tests")
    class StopTests {

        @Test
        @DisplayName("getStop returns StopResponse")
        void getStop_ReturnsStopResponse() {
            StopsIdGet2XXResponse apiResponse = new StopsIdGet2XXResponse();
            when(mockApi.stopsIdGet(anyString(), anyBoolean(), anyString(), anyBoolean()))
                    .thenReturn(apiResponse);

            StopByIdRequest request = new StopByIdRequest("8000001", DBVendoProfiles.DB);
            request.setLinesOfStops(true);
            request.setLanguage(DBVendoLanguage.DE);

            StopResponse response = client.getStop(request);

            assertNotNull(response);
            verify(mockApi).stopsIdGet("8000001", true, "de", false);
        }

        @Test
        @DisplayName("getStop with null language")
        void getStop_WithNullLanguage() {
            StopsIdGet2XXResponse apiResponse = new StopsIdGet2XXResponse();
            when(mockApi.stopsIdGet(anyString(), any(), isNull(), anyBoolean()))
                    .thenReturn(apiResponse);

            StopByIdRequest request = new StopByIdRequest("8000001", DBVendoProfiles.DB);

            StopResponse response = client.getStop(request);

            assertNotNull(response);
            verify(mockApi).stopsIdGet("8000001", null, null, false);
        }
    }

    @Nested
    @DisplayName("Departures Tests")
    class DeparturesTests {

        @Test
        @DisplayName("getDepartures returns DeparturesResponse")
        void getDepartures_ReturnsDeparturesResponse() {
            StopsIdDeparturesGet2XXResponse apiResponse = new StopsIdDeparturesGet2XXResponse();
            apiResponse.setDepartures(new ArrayList<>());
            when(mockApi.stopsIdDeparturesGet(anyString(), any(), any(), any(), any(), any(), any(), any(), any(), any()))
                    .thenReturn(apiResponse);

            DeparturesRequest request = new DeparturesRequest("8000001", DBVendoProfiles.DB);
            request.setDuration(30);
            request.setResults(10);

            DeparturesResponse response = client.getDepartures(request);

            assertNotNull(response);
            assertNotNull(response.getDepartures());
        }

        @Test
        @DisplayName("getDepartures with products filter")
        void getDepartures_WithProductsFilter() {
            StopsIdDeparturesGet2XXResponse apiResponse = new StopsIdDeparturesGet2XXResponse();
            apiResponse.setDepartures(new ArrayList<>());
            when(mockApi.stopsIdDeparturesGet(anyString(), any(), any(), any(), any(), any(), any(), any(), any(), any()))
                    .thenReturn(apiResponse);

            DeparturesRequest request = new DeparturesRequest("8000001", DBVendoProfiles.DB);
            Products products = new Products();
            products.setNationalExpress(true);
            products.setRegional(false);
            request.setProducts(products);

            DeparturesResponse response = client.getDepartures(request);

            assertNotNull(response);
        }
    }

    @Nested
    @DisplayName("Arrivals Tests")
    class ArrivalsTests {

        @Test
        @DisplayName("getArrivals returns ArrivalsResponse")
        void getArrivals_ReturnsArrivalsResponse() {
            StopsIdArrivalsGet2XXResponse apiResponse = new StopsIdArrivalsGet2XXResponse();
            apiResponse.setArrivals(new ArrayList<>());
            when(mockApi.stopsIdArrivalsGet(anyString(), any(), any(), any(), any(), any(), any(), any(), any(), any()))
                    .thenReturn(apiResponse);

            ArrivalsRequest request = new ArrivalsRequest("8000001", DBVendoProfiles.DB);

            ArrivalsResponse response = client.getArrivals(request);

            assertNotNull(response);
            assertNotNull(response.getArrivals());
        }
    }

    @Nested
    @DisplayName("Journeys Tests")
    class JourneysTests {

        @Test
        @DisplayName("getJourneys returns JourneysResponse")
        void getJourneys_ReturnsJourneysResponse() {
            JourneysGet2XXResponse apiResponse = new JourneysGet2XXResponse();
            apiResponse.setJourneys(new ArrayList<>());
            when(mockApi.journeysGet(any(), any(), any(), any(), any(), any(), any(), any(), any(), any(),
                    any(), any(), any(), any(), any(), any(), any(), any(), any(), any(),
                    any(), any(), any(), any(), any(), any(), any(), any(), any(), any(),
                    any(), any(), any(), any(), any(), any()))
                    .thenReturn(apiResponse);

            JourneysRequest request = new JourneysRequest("Berlin Hbf", "Hamburg Hbf", DBVendoProfiles.DB);

            JourneysResponse response = client.getJourneys(request);

            assertNotNull(response);
            assertNotNull(response.getJourneys());
        }

        @Test
        @DisplayName("getJourneys with all options")
        void getJourneys_WithAllOptions() {
            JourneysGet2XXResponse apiResponse = new JourneysGet2XXResponse();
            apiResponse.setJourneys(new ArrayList<>());
            when(mockApi.journeysGet(any(), any(), any(), any(), any(), any(), any(), any(), any(), any(),
                    any(), any(), any(), any(), any(), any(), any(), any(), any(), any(),
                    any(), any(), any(), any(), any(), any(), any(), any(), any(), any(),
                    any(), any(), any(), any(), any(), any()))
                    .thenReturn(apiResponse);

            JourneysRequest request = new JourneysRequest(DBVendoProfiles.DB);
            request.setFrom("Berlin Hbf");
            request.setTo("Hamburg Hbf");
            request.setDeparture(LocalDateTime.now());
            request.setResults(5);
            request.setStopovers(true);
            request.setTransfers(2);
            request.setBike(true);
            request.setLoyaltyCard(LoyaltyCard.BAHNCARD_2ND_25);
            request.setFirstClass(false);
            request.setAge(30);

            JourneysResponse response = client.getJourneys(request);

            assertNotNull(response);
        }
    }

    @Nested
    @DisplayName("Trip Tests")
    class TripTests {

        @Test
        @DisplayName("getTrip returns TripResponse")
        void getTrip_ReturnsTripResponse() {
            TripsIdGet2XXResponse apiResponse = new TripsIdGet2XXResponse();
            when(mockApi.tripsIdGet(anyString(), any(), any(), any(), any(), any()))
                    .thenReturn(apiResponse);

            TripByIdRequest request = new TripByIdRequest("trip-id-123", DBVendoProfiles.DB);
            request.setStopovers(true);
            request.setPolyline(true);

            TripResponse response = client.getTrip(request);

            assertNotNull(response);
        }
    }

    @Nested
    @DisplayName("Nearby Tests")
    class NearbyTests {

        @Test
        @DisplayName("getNearby returns NearbyResponse")
        void getNearby_ReturnsNearbyResponse() {
            List<StopsIdGet2XXResponse> apiResponse = new ArrayList<>();
            when(mockApi.locationsNearbyGet(any(), any(), any(), any(), any(), any(), any(), any()))
                    .thenReturn(apiResponse);

            NearbyRequest request = new NearbyRequest(52.5200, 13.4050, DBVendoProfiles.DB);
            request.setResults(10);
            request.setDistance(1000);

            NearbyResponse response = client.getNearby(request);

            assertNotNull(response);
            assertNotNull(response.getLocations());
        }
    }

    @Nested
    @DisplayName("Locations Tests")
    class LocationsTests {

        @Test
        @DisplayName("getLocations returns LocationsResponse")
        void getLocations_ReturnsLocationsResponse() {
            List<StopsIdGet2XXResponse> apiResponse = new ArrayList<>();
            when(mockApi.locationsGet(anyString(), any(), any(), any(), any(), any(), any(), any(), any()))
                    .thenReturn(apiResponse);

            LocationsRequest request = new LocationsRequest("Berlin", DBVendoProfiles.DB);
            request.setFuzzy(true);
            request.setResults(5);

            LocationsResponse response = client.getLocations(request);

            assertNotNull(response);
            assertNotNull(response.getLocations());
        }
    }

    @Nested
    @DisplayName("RefreshJourney Tests")
    class RefreshJourneyTests {

        @Test
        @DisplayName("refreshJourney returns RefreshJourneyResponse")
        void refreshJourney_ReturnsRefreshJourneyResponse() {
            JourneysRefGet2XXResponse apiResponse = new JourneysRefGet2XXResponse();
            when(mockApi.journeysRefGet(anyString(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any()))
                    .thenReturn(apiResponse);

            RefreshJourneyRequest request = new RefreshJourneyRequest("refresh-token-123", DBVendoProfiles.DB);
            request.setStopovers(true);

            RefreshJourneyResponse response = client.refreshJourney(request);

            assertNotNull(response);
        }
    }

    @Nested
    @DisplayName("Cache Tests")
    class CacheTests {

        @Test
        @DisplayName("caching is disabled by default")
        void caching_DisabledByDefault() {
            assertNull(client.getCacheStats());
        }

        @Test
        @DisplayName("clearCache does not throw when cache is disabled")
        void clearCache_WhenDisabled_DoesNotThrow() {
            assertDoesNotThrow(() -> client.clearCache());
        }

        @Test
        @DisplayName("caching returns cached result")
        void caching_ReturnsCachedResult() {
            CacheOptions cacheOptions = CacheOptions.builder()
                    .enabled(true)
                    .maximumSize(100)
                    .expireAfterWrite(10)
                    .expireAfterWriteUnit(TimeUnit.MINUTES)
                    .recordStats(true)
                    .build();

            ClientOptions cachedOptions = ClientOptions.builder()
                    .baseUrl("http://localhost:3000")
                    .cacheOptions(cacheOptions)
                    .build();

            DBVendoClient cachedClient = new DBVendoClient(cachedOptions, mockApi);

            StopsIdGet2XXResponse apiResponse = new StopsIdGet2XXResponse();
            when(mockApi.stopsIdGet(anyString(), any(), any(), anyBoolean()))
                    .thenReturn(apiResponse);

            StopByIdRequest request = new StopByIdRequest("8000001", DBVendoProfiles.DB);

            // First call
            cachedClient.getStop(request);
            // Second call (should be cached)
            cachedClient.getStop(request);

            // API should only be called once
            verify(mockApi, times(1)).stopsIdGet(anyString(), any(), any(), anyBoolean());

            // Cache stats should show 1 hit
            assertNotNull(cachedClient.getCacheStats());
            assertEquals(1, cachedClient.getCacheStats().hitCount());
        }

        @Test
        @DisplayName("clearCache invalidates all entries")
        void clearCache_InvalidatesAllEntries() {
            CacheOptions cacheOptions = CacheOptions.builder()
                    .enabled(true)
                    .maximumSize(100)
                    .expireAfterWrite(10)
                    .expireAfterWriteUnit(TimeUnit.MINUTES)
                    .build();

            ClientOptions cachedOptions = ClientOptions.builder()
                    .baseUrl("http://localhost:3000")
                    .cacheOptions(cacheOptions)
                    .build();

            DBVendoClient cachedClient = new DBVendoClient(cachedOptions, mockApi);

            StopsIdGet2XXResponse apiResponse = new StopsIdGet2XXResponse();
            when(mockApi.stopsIdGet(anyString(), any(), any(), anyBoolean()))
                    .thenReturn(apiResponse);

            StopByIdRequest request = new StopByIdRequest("8000001", DBVendoProfiles.DB);

            cachedClient.getStop(request);
            cachedClient.clearCache();
            cachedClient.getStop(request);

            // API should be called twice (cache was cleared)
            verify(mockApi, times(2)).stopsIdGet(anyString(), any(), any(), anyBoolean());
        }
    }

    @Nested
    @DisplayName("Products Conversion Tests")
    class ProductsConversionTests {

        @Test
        @DisplayName("null products returns empty ProfileSpecificProducts")
        void nullProducts_ReturnsEmptyProfileSpecificProducts() {
            StopsIdDeparturesGet2XXResponse apiResponse = new StopsIdDeparturesGet2XXResponse();
            apiResponse.setDepartures(new ArrayList<>());
            when(mockApi.stopsIdDeparturesGet(anyString(), any(), any(), any(), any(), any(), any(), any(), any(), any()))
                    .thenReturn(apiResponse);

            DeparturesRequest request = new DeparturesRequest("8000001", DBVendoProfiles.DB);
            // products is null

            DeparturesResponse response = client.getDepartures(request);

            assertNotNull(response);
        }
    }
}
