package de.olech2412.app.adapter.requests;

import de.olech2412.app.adapter.helper.DBVendoLanguage;
import de.olech2412.app.adapter.helper.DBVendoProfiles;
import de.olech2412.app.adapter.helper.LoyaltyCard;
import de.olech2412.app.adapter.helper.Products;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Request Classes Tests")
class RequestsTest {

    @Nested
    @DisplayName("StopByIdRequest Tests")
    class StopByIdRequestTests {

        @Test
        @DisplayName("constructor sets id and profile")
        void constructor_SetsIdAndProfile() {
            StopByIdRequest request = new StopByIdRequest("8000001", DBVendoProfiles.DB);

            assertEquals("8000001", request.getId());
            assertEquals(DBVendoProfiles.DB, request.getProfile());
        }

        @Test
        @DisplayName("default values are set correctly")
        void defaultValues_AreSetCorrectly() {
            StopByIdRequest request = new StopByIdRequest("8000001", DBVendoProfiles.DB);

            assertNull(request.getLinesOfStops());
            assertNull(request.getLanguage());
            assertFalse(request.getPretty());
        }

        @Test
        @DisplayName("setters work correctly")
        void setters_WorkCorrectly() {
            StopByIdRequest request = new StopByIdRequest("8000001", DBVendoProfiles.DB);
            request.setLinesOfStops(true);
            request.setLanguage(DBVendoLanguage.DE);

            assertTrue(request.getLinesOfStops());
            assertEquals(DBVendoLanguage.DE, request.getLanguage());
        }
    }

    @Nested
    @DisplayName("DeparturesRequest Tests")
    class DeparturesRequestTests {

        @Test
        @DisplayName("constructor sets id and profile")
        void constructor_SetsIdAndProfile() {
            DeparturesRequest request = new DeparturesRequest("8000001", DBVendoProfiles.DB_NAV);

            assertEquals("8000001", request.getId());
            assertEquals(DBVendoProfiles.DB_NAV, request.getProfile());
        }

        @Test
        @DisplayName("all optional parameters can be set")
        void allOptionalParameters_CanBeSet() {
            DeparturesRequest request = new DeparturesRequest("8000001", DBVendoProfiles.DB);
            LocalDateTime when = LocalDateTime.now();

            request.setWhen(when);
            request.setDirection("8000002");
            request.setDuration(30);
            request.setResults(10);
            request.setLinesOfStops(true);
            request.setRemarks(true);

            Products products = new Products();
            products.setNationalExpress(true);
            request.setProducts(products);

            assertEquals(when, request.getWhen());
            assertEquals("8000002", request.getDirection());
            assertEquals(30, request.getDuration());
            assertEquals(10, request.getResults());
            assertTrue(request.getLinesOfStops());
            assertTrue(request.getRemarks());
            assertNotNull(request.getProducts());
        }
    }

    @Nested
    @DisplayName("ArrivalsRequest Tests")
    class ArrivalsRequestTests {

        @Test
        @DisplayName("constructor sets id and profile")
        void constructor_SetsIdAndProfile() {
            ArrivalsRequest request = new ArrivalsRequest("8000001", DBVendoProfiles.DB_WEB);

            assertEquals("8000001", request.getId());
            assertEquals(DBVendoProfiles.DB_WEB, request.getProfile());
        }
    }

    @Nested
    @DisplayName("JourneysRequest Tests")
    class JourneysRequestTests {

        @Test
        @DisplayName("simple constructor sets profile")
        void simpleConstructor_SetsProfile() {
            JourneysRequest request = new JourneysRequest(DBVendoProfiles.DB);

            assertEquals(DBVendoProfiles.DB, request.getProfile());
            assertNull(request.getFrom());
            assertNull(request.getTo());
        }

        @Test
        @DisplayName("convenience constructor sets from, to, and profile")
        void convenienceConstructor_SetsFromToAndProfile() {
            JourneysRequest request = new JourneysRequest("Berlin Hbf", "Hamburg Hbf", DBVendoProfiles.DB);

            assertEquals("Berlin Hbf", request.getFrom());
            assertEquals("Hamburg Hbf", request.getTo());
            assertEquals(DBVendoProfiles.DB, request.getProfile());
        }

        @Test
        @DisplayName("all journey options can be set")
        void allJourneyOptions_CanBeSet() {
            JourneysRequest request = new JourneysRequest(DBVendoProfiles.DB);

            // From location options
            request.setFrom("Berlin Hbf");
            request.setFromId("poi-123");
            request.setFromAddress("Street 1");
            request.setFromLatitude(52.5200);
            request.setFromLongitude(13.4050);

            // To location options
            request.setTo("Hamburg Hbf");
            request.setToId("poi-456");
            request.setToAddress("Street 2");
            request.setToLatitude(53.5511);
            request.setToLongitude(9.9937);

            // Time options
            LocalDateTime departure = LocalDateTime.now();
            LocalDateTime arrival = LocalDateTime.now().plusHours(3);
            request.setDeparture(departure);
            request.setArrival(arrival);
            request.setEarlierThan("earlier-ref");
            request.setLaterThan("later-ref");

            // Journey options
            request.setResults(5);
            request.setStopovers(true);
            request.setTransfers(2);
            request.setTransferTime(10);
            request.setAccessibility("wheelchair");
            request.setBike(true);
            request.setStartWithWalking(false);
            request.setWalkingSpeed("slow");
            request.setTickets(true);
            request.setPolylines(true);
            request.setSubStops(false);
            request.setEntrances(false);
            request.setRemarks(true);
            request.setScheduledDays(true);
            request.setNotOnlyFastRoutes(true);
            request.setBestprice(true);

            // Personal options
            request.setLoyaltyCard(LoyaltyCard.BAHNCARD_2ND_50);
            request.setFirstClass(true);
            request.setAge(25);

            // Products
            Products products = new Products();
            products.setNationalExpress(true);
            request.setProducts(products);

            // Verify all values
            assertEquals("Berlin Hbf", request.getFrom());
            assertEquals(52.5200, request.getFromLatitude());
            assertEquals("Hamburg Hbf", request.getTo());
            assertEquals(departure, request.getDeparture());
            assertEquals(5, request.getResults());
            assertTrue(request.getStopovers());
            assertEquals(LoyaltyCard.BAHNCARD_2ND_50, request.getLoyaltyCard());
            assertTrue(request.getFirstClass());
            assertEquals(25, request.getAge());
        }
    }

    @Nested
    @DisplayName("TripByIdRequest Tests")
    class TripByIdRequestTests {

        @Test
        @DisplayName("constructor sets id and profile")
        void constructor_SetsIdAndProfile() {
            TripByIdRequest request = new TripByIdRequest("trip-123", DBVendoProfiles.DB);

            assertEquals("trip-123", request.getId());
            assertEquals(DBVendoProfiles.DB, request.getProfile());
        }

        @Test
        @DisplayName("optional parameters can be set")
        void optionalParameters_CanBeSet() {
            TripByIdRequest request = new TripByIdRequest("trip-123", DBVendoProfiles.DB);
            request.setStopovers(true);
            request.setRemarks(true);
            request.setPolyline(true);

            assertTrue(request.getStopovers());
            assertTrue(request.getRemarks());
            assertTrue(request.getPolyline());
        }
    }

    @Nested
    @DisplayName("NearbyRequest Tests")
    class NearbyRequestTests {

        @Test
        @DisplayName("constructor sets coordinates and profile")
        void constructor_SetsCoordinatesAndProfile() {
            NearbyRequest request = new NearbyRequest(52.5200, 13.4050, DBVendoProfiles.DB);

            assertEquals(52.5200, request.getLatitude());
            assertEquals(13.4050, request.getLongitude());
            assertEquals(DBVendoProfiles.DB, request.getProfile());
        }

        @Test
        @DisplayName("optional parameters can be set")
        void optionalParameters_CanBeSet() {
            NearbyRequest request = new NearbyRequest(52.5200, 13.4050, DBVendoProfiles.DB);
            request.setResults(20);
            request.setDistance(2000);
            request.setStops(true);
            request.setPoi(true);
            request.setLinesOfStops(true);

            assertEquals(20, request.getResults());
            assertEquals(2000, request.getDistance());
            assertTrue(request.getStops());
            assertTrue(request.getPoi());
            assertTrue(request.getLinesOfStops());
        }
    }

    @Nested
    @DisplayName("LocationsRequest Tests")
    class LocationsRequestTests {

        @Test
        @DisplayName("constructor sets query and profile")
        void constructor_SetsQueryAndProfile() {
            LocationsRequest request = new LocationsRequest("Berlin", DBVendoProfiles.DB);

            assertEquals("Berlin", request.getQuery());
            assertEquals(DBVendoProfiles.DB, request.getProfile());
        }

        @Test
        @DisplayName("optional parameters can be set")
        void optionalParameters_CanBeSet() {
            LocationsRequest request = new LocationsRequest("Berlin", DBVendoProfiles.DB);
            request.setFuzzy(true);
            request.setResults(10);
            request.setStops(true);
            request.setAddresses(true);
            request.setPoi(true);
            request.setLinesOfStops(true);

            assertTrue(request.getFuzzy());
            assertEquals(10, request.getResults());
            assertTrue(request.getStops());
            assertTrue(request.getAddresses());
            assertTrue(request.getPoi());
            assertTrue(request.getLinesOfStops());
        }
    }

    @Nested
    @DisplayName("RefreshJourneyRequest Tests")
    class RefreshJourneyRequestTests {

        @Test
        @DisplayName("constructor sets refreshToken and profile")
        void constructor_SetsRefreshTokenAndProfile() {
            RefreshJourneyRequest request = new RefreshJourneyRequest("refresh-token", DBVendoProfiles.DB);

            assertEquals("refresh-token", request.getRefreshToken());
            assertEquals(DBVendoProfiles.DB, request.getProfile());
        }

        @Test
        @DisplayName("optional parameters can be set")
        void optionalParameters_CanBeSet() {
            RefreshJourneyRequest request = new RefreshJourneyRequest("refresh-token", DBVendoProfiles.DB);
            request.setStopovers(true);
            request.setTickets(true);
            request.setPolylines(true);
            request.setSubStops(true);
            request.setEntrances(true);
            request.setRemarks(true);
            request.setScheduledDays(true);
            request.setNotOnlyFastRoutes(true);
            request.setBestprice(true);

            assertTrue(request.getStopovers());
            assertTrue(request.getTickets());
            assertTrue(request.getPolylines());
        }
    }

    @Nested
    @DisplayName("AbstractDBVendoRequest Tests")
    class AbstractDBVendoRequestTests {

        @Test
        @DisplayName("language can be set on any request")
        void language_CanBeSetOnAnyRequest() {
            StopByIdRequest request = new StopByIdRequest("8000001", DBVendoProfiles.DB);
            request.setLanguage(DBVendoLanguage.EN);

            assertEquals(DBVendoLanguage.EN, request.getLanguage());
            assertEquals("en", request.getLanguage().language);
        }

        @Test
        @DisplayName("pretty defaults to false")
        void pretty_DefaultsToFalse() {
            StopByIdRequest request = new StopByIdRequest("8000001", DBVendoProfiles.DB);

            assertFalse(request.getPretty());
        }
    }
}
