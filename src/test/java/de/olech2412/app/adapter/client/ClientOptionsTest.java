package de.olech2412.app.adapter.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Client Options Tests")
class ClientOptionsTest {

    @Nested
    @DisplayName("ClientOptions Tests")
    class ClientOptionsTests {

        @Test
        @DisplayName("builder creates options with baseUrl")
        void builder_CreatesOptionsWithBaseUrl() {
            ClientOptions options = ClientOptions.builder()
                    .baseUrl("http://localhost:3000")
                    .build();

            assertEquals("http://localhost:3000", options.getBaseUrl());
        }

        @Test
        @DisplayName("builder creates options with userAgent")
        void builder_CreatesOptionsWithUserAgent() {
            ClientOptions options = ClientOptions.builder()
                    .baseUrl("http://localhost:3000")
                    .userAgent("MyApp/1.0")
                    .build();

            assertEquals("MyApp/1.0", options.getUserAgent());
        }

        @Test
        @DisplayName("builder creates options with cacheOptions")
        void builder_CreatesOptionsWithCacheOptions() {
            CacheOptions cacheOptions = CacheOptions.builder()
                    .enabled(true)
                    .maximumSize(100)
                    .expireAfterWrite(10)
                    .expireAfterWriteUnit(TimeUnit.MINUTES)
                    .build();

            ClientOptions options = ClientOptions.builder()
                    .baseUrl("http://localhost:3000")
                    .cacheOptions(cacheOptions)
                    .build();

            assertNotNull(options.getCacheOptions());
            assertTrue(options.getCacheOptions().isEnabled());
        }

        @Test
        @DisplayName("cacheOptions is null by default")
        void cacheOptions_IsNullByDefault() {
            ClientOptions options = ClientOptions.builder()
                    .baseUrl("http://localhost:3000")
                    .build();

            assertNull(options.getCacheOptions());
        }

        @Test
        @DisplayName("userAgent is null by default")
        void userAgent_IsNullByDefault() {
            ClientOptions options = ClientOptions.builder()
                    .baseUrl("http://localhost:3000")
                    .build();

            assertNull(options.getUserAgent());
        }
    }

    @Nested
    @DisplayName("CacheOptions Tests")
    class CacheOptionsTests {

        @Test
        @DisplayName("builder creates enabled cache options")
        void builder_CreatesEnabledCacheOptions() {
            CacheOptions options = CacheOptions.builder()
                    .enabled(true)
                    .maximumSize(100)
                    .expireAfterWrite(10)
                    .expireAfterWriteUnit(TimeUnit.MINUTES)
                    .build();

            assertTrue(options.isEnabled());
            assertEquals(100, options.getMaximumSize());
            assertEquals(10, options.getExpireAfterWrite());
            assertEquals(TimeUnit.MINUTES, options.getExpireAfterWriteUnit());
        }

        @Test
        @DisplayName("builder creates cache options with expireAfterAccess")
        void builder_CreatesOptionsWithExpireAfterAccess() {
            CacheOptions options = CacheOptions.builder()
                    .enabled(true)
                    .maximumSize(100)
                    .expireAfterWrite(10)
                    .expireAfterWriteUnit(TimeUnit.MINUTES)
                    .expireAfterAccess(5L)
                    .expireAfterAccessUnit(TimeUnit.MINUTES)
                    .build();

            assertEquals(5, options.getExpireAfterAccess());
            assertEquals(TimeUnit.MINUTES, options.getExpireAfterAccessUnit());
        }

        @Test
        @DisplayName("builder creates cache options with recordStats")
        void builder_CreatesOptionsWithRecordStats() {
            CacheOptions options = CacheOptions.builder()
                    .enabled(true)
                    .maximumSize(100)
                    .expireAfterWrite(10)
                    .expireAfterWriteUnit(TimeUnit.MINUTES)
                    .recordStats(true)
                    .build();

            assertTrue(options.isRecordStats());
        }

        @Test
        @DisplayName("recordStats is false by default")
        void recordStats_IsFalseByDefault() {
            CacheOptions options = CacheOptions.builder()
                    .enabled(true)
                    .maximumSize(100)
                    .expireAfterWrite(10)
                    .expireAfterWriteUnit(TimeUnit.MINUTES)
                    .build();

            assertFalse(options.isRecordStats());
        }

        @Test
        @DisplayName("expireAfterAccess is null by default")
        void expireAfterAccess_IsNullByDefault() {
            CacheOptions options = CacheOptions.builder()
                    .enabled(true)
                    .maximumSize(100)
                    .expireAfterWrite(10)
                    .expireAfterWriteUnit(TimeUnit.MINUTES)
                    .build();

            assertNull(options.getExpireAfterAccess());
        }

        @Test
        @DisplayName("disabled cache options")
        void disabledCacheOptions() {
            CacheOptions options = CacheOptions.builder()
                    .enabled(false)
                    .build();

            assertFalse(options.isEnabled());
        }
    }
}
