package de.olech2412.app.adapter.responses;

import de.olech2412.app.adapter.db_vendo_client.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Response Wrapper Tests")
class ResponsesTest {

    @Nested
    @DisplayName("StopResponse Tests")
    class StopResponseTests {

        @Test
        @DisplayName("wraps StopsIdGet2XXResponse correctly")
        void wrapsResponse_Correctly() {
            StopsIdGet2XXResponse apiResponse = new StopsIdGet2XXResponse();

            StopResponse response = new StopResponse(apiResponse);

            assertNotNull(response);
            assertNotNull(response.getDelegate());
        }
    }

    @Nested
    @DisplayName("DeparturesResponse Tests")
    class DeparturesResponseTests {

        @Test
        @DisplayName("wraps StopsIdDeparturesGet2XXResponse correctly")
        void wrapsResponse_Correctly() {
            StopsIdDeparturesGet2XXResponse apiResponse = new StopsIdDeparturesGet2XXResponse();
            List<Alternative> departures = new ArrayList<>();
            apiResponse.setDepartures(departures);
            apiResponse.setRealtimeDataUpdatedAt(1234567890);

            DeparturesResponse response = new DeparturesResponse(apiResponse);

            assertNotNull(response);
            assertEquals(departures, response.getDepartures());
            assertEquals(1234567890, response.getRealtimeDataUpdatedAt());
        }

        @Test
        @DisplayName("delegates getDepartures to wrapped response")
        void delegatesGetDepartures() {
            StopsIdDeparturesGet2XXResponse apiResponse = new StopsIdDeparturesGet2XXResponse();
            List<Alternative> departures = new ArrayList<>();
            Alternative alt = new Alternative();
            departures.add(alt);
            apiResponse.setDepartures(departures);

            DeparturesResponse response = new DeparturesResponse(apiResponse);

            assertEquals(1, response.getDepartures().size());
        }
    }

    @Nested
    @DisplayName("ArrivalsResponse Tests")
    class ArrivalsResponseTests {

        @Test
        @DisplayName("wraps StopsIdArrivalsGet2XXResponse correctly")
        void wrapsResponse_Correctly() {
            StopsIdArrivalsGet2XXResponse apiResponse = new StopsIdArrivalsGet2XXResponse();
            List<Alternative> arrivals = new ArrayList<>();
            apiResponse.setArrivals(arrivals);

            ArrivalsResponse response = new ArrivalsResponse(apiResponse);

            assertNotNull(response);
            assertEquals(arrivals, response.getArrivals());
        }
    }

    @Nested
    @DisplayName("JourneysResponse Tests")
    class JourneysResponseTests {

        @Test
        @DisplayName("wraps JourneysGet2XXResponse correctly")
        void wrapsResponse_Correctly() {
            JourneysGet2XXResponse apiResponse = new JourneysGet2XXResponse();
            List<Journey> journeys = new ArrayList<>();
            apiResponse.setJourneys(journeys);
            apiResponse.setEarlierRef("earlier");
            apiResponse.setLaterRef("later");

            JourneysResponse response = new JourneysResponse(apiResponse);

            assertNotNull(response);
            assertEquals(journeys, response.getJourneys());
            assertEquals("earlier", response.getEarlierRef());
            assertEquals("later", response.getLaterRef());
        }
    }

    @Nested
    @DisplayName("TripResponse Tests")
    class TripResponseTests {

        @Test
        @DisplayName("wraps TripsIdGet2XXResponse correctly")
        void wrapsResponse_Correctly() {
            TripsIdGet2XXResponse apiResponse = new TripsIdGet2XXResponse();

            TripResponse response = new TripResponse(apiResponse);

            assertNotNull(response);
            assertNotNull(response.getDelegate());
        }
    }

    @Nested
    @DisplayName("LocationsResponse Tests")
    class LocationsResponseTests {

        @Test
        @DisplayName("wraps List correctly")
        void wrapsList_Correctly() {
            List<StopsIdGet2XXResponse> locations = new ArrayList<>();
            locations.add(new StopsIdGet2XXResponse());
            locations.add(new StopsIdGet2XXResponse());

            LocationsResponse response = new LocationsResponse(locations);

            assertNotNull(response);
            assertEquals(2, response.getLocations().size());
        }

        @Test
        @DisplayName("handles empty list")
        void handlesEmptyList() {
            List<StopsIdGet2XXResponse> locations = new ArrayList<>();

            LocationsResponse response = new LocationsResponse(locations);

            assertNotNull(response);
            assertTrue(response.getLocations().isEmpty());
        }
    }

    @Nested
    @DisplayName("NearbyResponse Tests")
    class NearbyResponseTests {

        @Test
        @DisplayName("wraps List correctly")
        void wrapsList_Correctly() {
            List<StopsIdGet2XXResponse> locations = new ArrayList<>();
            locations.add(new StopsIdGet2XXResponse());

            NearbyResponse response = new NearbyResponse(locations);

            assertNotNull(response);
            assertEquals(1, response.getLocations().size());
        }
    }

    @Nested
    @DisplayName("RefreshJourneyResponse Tests")
    class RefreshJourneyResponseTests {

        @Test
        @DisplayName("wraps JourneysRefGet2XXResponse correctly")
        void wrapsResponse_Correctly() {
            JourneysRefGet2XXResponse apiResponse = new JourneysRefGet2XXResponse();

            RefreshJourneyResponse response = new RefreshJourneyResponse(apiResponse);

            assertNotNull(response);
            assertNotNull(response.getDelegate());
        }
    }
}
