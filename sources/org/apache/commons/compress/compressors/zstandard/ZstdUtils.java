package org.apache.commons.compress.compressors.zstandard;

import com.google.common.base.Ascii;
import org.apache.commons.compress.utils.OsgiUtils;

public class ZstdUtils {
    private static final byte[] SKIPPABLE_FRAME_MAGIC = {42, 77, Ascii.CAN};
    private static final byte[] ZSTANDARD_FRAME_MAGIC = {40, -75, 47, -3};
    private static volatile CachedAvailability cachedZstdAvailability = CachedAvailability.DONT_CACHE;

    public enum CachedAvailability {
        DONT_CACHE,
        CACHED_AVAILABLE,
        CACHED_UNAVAILABLE
    }

    static {
        setCacheZstdAvailablity(!OsgiUtils.isRunningInOsgiEnvironment());
    }

    private ZstdUtils() {
    }

    public static CachedAvailability getCachedZstdAvailability() {
        return cachedZstdAvailability;
    }

    private static boolean internalIsZstdCompressionAvailable() {
        try {
            Class.forName("com.github.luben.zstd.ZstdInputStream");
            return true;
        } catch (Exception | NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean isZstdCompressionAvailable() {
        CachedAvailability cachedAvailability = cachedZstdAvailability;
        if (cachedAvailability == CachedAvailability.DONT_CACHE) {
            return internalIsZstdCompressionAvailable();
        }
        if (cachedAvailability == CachedAvailability.CACHED_AVAILABLE) {
            return true;
        }
        return false;
    }

    public static boolean matches(byte[] bArr, int i11) {
        boolean z11;
        if (i11 < ZSTANDARD_FRAME_MAGIC.length) {
            return false;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr2 = ZSTANDARD_FRAME_MAGIC;
            if (i12 >= bArr2.length) {
                z11 = true;
                break;
            } else if (bArr[i12] != bArr2[i12]) {
                z11 = false;
                break;
            } else {
                i12++;
            }
        }
        if (z11) {
            return true;
        }
        if (80 != (bArr[0] & 240)) {
            return false;
        }
        int i13 = 0;
        while (true) {
            byte[] bArr3 = SKIPPABLE_FRAME_MAGIC;
            if (i13 >= bArr3.length) {
                return true;
            }
            int i14 = i13 + 1;
            if (bArr[i14] != bArr3[i13]) {
                return false;
            }
            i13 = i14;
        }
    }

    public static void setCacheZstdAvailablity(boolean z11) {
        CachedAvailability cachedAvailability;
        if (!z11) {
            cachedZstdAvailability = CachedAvailability.DONT_CACHE;
        } else if (cachedZstdAvailability == CachedAvailability.DONT_CACHE) {
            if (internalIsZstdCompressionAvailable()) {
                cachedAvailability = CachedAvailability.CACHED_AVAILABLE;
            } else {
                cachedAvailability = CachedAvailability.CACHED_UNAVAILABLE;
            }
            cachedZstdAvailability = cachedAvailability;
        }
    }
}
