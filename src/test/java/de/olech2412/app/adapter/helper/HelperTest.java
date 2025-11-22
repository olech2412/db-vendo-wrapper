package de.olech2412.app.adapter.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Helper Classes Tests")
class HelperTest {

    @Nested
    @DisplayName("DBVendoProfiles Tests")
    class DBVendoProfilesTests {

        @Test
        @DisplayName("DB profile has correct value")
        void dbProfile_HasCorrectValue() {
            assertEquals("db", DBVendoProfiles.DB.profile);
        }

        @Test
        @DisplayName("DB_NAV profile has correct value")
        void dbNavProfile_HasCorrectValue() {
            assertEquals("dbnav", DBVendoProfiles.DB_NAV.profile);
        }

        @Test
        @DisplayName("DB_WEB profile has correct value")
        void dbWebProfile_HasCorrectValue() {
            assertEquals("dbweb", DBVendoProfiles.DB_WEB.profile);
        }

        @Test
        @DisplayName("DB_RIS profile has correct value")
        void dbRisProfile_HasCorrectValue() {
            assertEquals("dbris", DBVendoProfiles.DB_RIS.profile);
        }

        @Test
        @DisplayName("all profiles are available")
        void allProfiles_AreAvailable() {
            DBVendoProfiles[] profiles = DBVendoProfiles.values();
            assertEquals(4, profiles.length);
        }
    }

    @Nested
    @DisplayName("DBVendoLanguage Tests")
    class DBVendoLanguageTests {

        @Test
        @DisplayName("DE language has correct value")
        void deLanguage_HasCorrectValue() {
            assertEquals("de", DBVendoLanguage.DE.language);
        }

        @Test
        @DisplayName("EN language has correct value")
        void enLanguage_HasCorrectValue() {
            assertEquals("en", DBVendoLanguage.EN.language);
        }

        @Test
        @DisplayName("all languages are available")
        void allLanguages_AreAvailable() {
            DBVendoLanguage[] languages = DBVendoLanguage.values();
            assertEquals(2, languages.length);
        }
    }

    @Nested
    @DisplayName("LoyaltyCard Tests")
    class LoyaltyCardTests {

        @Test
        @DisplayName("BahnCard 25 2nd class has correct value")
        void bahncard25_2nd_HasCorrectValue() {
            assertEquals("bahncard-2nd-25", LoyaltyCard.BAHNCARD_2ND_25.value);
        }

        @Test
        @DisplayName("BahnCard 50 1st class has correct value")
        void bahncard50_1st_HasCorrectValue() {
            assertEquals("bahncard-1st-50", LoyaltyCard.BAHNCARD_1ST_50.value);
        }

        @Test
        @DisplayName("BahnCard 100 2nd class has correct value")
        void bahncard100_2nd_HasCorrectValue() {
            assertEquals("bahncard-2nd-100", LoyaltyCard.BAHNCARD_2ND_100.value);
        }

        @Test
        @DisplayName("Vorteilscard has correct value")
        void vorteilscard_HasCorrectValue() {
            assertEquals("vorteilscard", LoyaltyCard.VORTEILSCARD.value);
        }

        @Test
        @DisplayName("Halbtax has correct value")
        void halbtax_HasCorrectValue() {
            assertEquals("halbtaxabo", LoyaltyCard.HALBTAXABO.value);
        }

        @Test
        @DisplayName("GA 1st class has correct value")
        void ga1st_HasCorrectValue() {
            assertEquals("generalabonnement-1st", LoyaltyCard.GENERALABONNEMENT_1ST.value);
        }

        @Test
        @DisplayName("NL 40 has correct value")
        void nl40_HasCorrectValue() {
            assertEquals("nl-40", LoyaltyCard.NL_40.value);
        }

        @Test
        @DisplayName("Klimaticket has correct value")
        void klimaticket_HasCorrectValue() {
            assertEquals("at-klimaticket", LoyaltyCard.AT_KLIMATICKET.value);
        }

        @Test
        @DisplayName("all loyalty cards are available")
        void allLoyaltyCards_AreAvailable() {
            LoyaltyCard[] cards = LoyaltyCard.values();
            assertTrue(cards.length >= 12);
        }
    }

    @Nested
    @DisplayName("Products Tests")
    class ProductsTests {

        @Test
        @DisplayName("default constructor creates empty products")
        void defaultConstructor_CreatesEmptyProducts() {
            Products products = new Products();

            assertNull(products.getNationalExpress());
            assertNull(products.getNational());
            assertNull(products.getRegionalExpress());
            assertNull(products.getRegional());
            assertNull(products.getSuburban());
            assertNull(products.getBus());
            assertNull(products.getFerry());
            assertNull(products.getSubway());
            assertNull(products.getTram());
            assertNull(products.getTaxi());
        }

        @Test
        @DisplayName("all product types can be set")
        void allProductTypes_CanBeSet() {
            Products products = new Products();

            products.setNationalExpress(true);
            products.setNational(true);
            products.setRegionalExpress(true);
            products.setRegional(false);
            products.setSuburban(false);
            products.setBus(true);
            products.setFerry(false);
            products.setSubway(true);
            products.setTram(true);
            products.setTaxi(false);

            assertTrue(products.getNationalExpress());
            assertTrue(products.getNational());
            assertTrue(products.getRegionalExpress());
            assertFalse(products.getRegional());
            assertFalse(products.getSuburban());
            assertTrue(products.getBus());
            assertFalse(products.getFerry());
            assertTrue(products.getSubway());
            assertTrue(products.getTram());
            assertFalse(products.getTaxi());
        }

        @Test
        @DisplayName("products can be partially set")
        void products_CanBePartiallySet() {
            Products products = new Products();

            products.setNationalExpress(true);
            products.setRegional(true);

            assertTrue(products.getNationalExpress());
            assertNull(products.getNational());
            assertNull(products.getRegionalExpress());
            assertTrue(products.getRegional());
        }
    }
}
