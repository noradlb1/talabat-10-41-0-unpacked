package org.apache.commons.compress.compressors.brotli;

import org.apache.commons.compress.utils.OsgiUtils;

public class BrotliUtils {
    private static volatile CachedAvailability cachedBrotliAvailability = CachedAvailability.DONT_CACHE;

    public enum CachedAvailability {
        DONT_CACHE,
        CACHED_AVAILABLE,
        CACHED_UNAVAILABLE
    }

    static {
        setCacheBrotliAvailablity(!OsgiUtils.isRunningInOsgiEnvironment());
    }

    private BrotliUtils() {
    }

    public static CachedAvailability getCachedBrotliAvailability() {
        return cachedBrotliAvailability;
    }

    private static boolean internalIsBrotliCompressionAvailable() {
        try {
            Class.forName("org.brotli.dec.BrotliInputStream");
            return true;
        } catch (Exception | NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean isBrotliCompressionAvailable() {
        CachedAvailability cachedAvailability = cachedBrotliAvailability;
        if (cachedAvailability == CachedAvailability.DONT_CACHE) {
            return internalIsBrotliCompressionAvailable();
        }
        if (cachedAvailability == CachedAvailability.CACHED_AVAILABLE) {
            return true;
        }
        return false;
    }

    public static void setCacheBrotliAvailablity(boolean z11) {
        CachedAvailability cachedAvailability;
        if (!z11) {
            cachedBrotliAvailability = CachedAvailability.DONT_CACHE;
        } else if (cachedBrotliAvailability == CachedAvailability.DONT_CACHE) {
            if (internalIsBrotliCompressionAvailable()) {
                cachedAvailability = CachedAvailability.CACHED_AVAILABLE;
            } else {
                cachedAvailability = CachedAvailability.CACHED_UNAVAILABLE;
            }
            cachedBrotliAvailability = cachedAvailability;
        }
    }
}
