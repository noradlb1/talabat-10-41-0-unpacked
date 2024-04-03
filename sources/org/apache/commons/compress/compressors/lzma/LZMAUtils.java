package org.apache.commons.compress.compressors.lzma;

import java.util.HashMap;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.compress.utils.OsgiUtils;

public class LZMAUtils {
    private static final byte[] HEADER_MAGIC = {93, 0, 0};
    private static volatile CachedAvailability cachedLZMAAvailability = CachedAvailability.DONT_CACHE;
    private static final FileNameUtil fileNameUtil;

    public enum CachedAvailability {
        DONT_CACHE,
        CACHED_AVAILABLE,
        CACHED_UNAVAILABLE
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(".lzma", "");
        hashMap.put("-lzma", "");
        fileNameUtil = new FileNameUtil(hashMap, ".lzma");
        setCacheLZMAAvailablity(!OsgiUtils.isRunningInOsgiEnvironment());
    }

    private LZMAUtils() {
    }

    public static CachedAvailability getCachedLZMAAvailability() {
        return cachedLZMAAvailability;
    }

    public static String getCompressedFilename(String str) {
        return fileNameUtil.getCompressedFilename(str);
    }

    public static String getUncompressedFilename(String str) {
        return fileNameUtil.getUncompressedFilename(str);
    }

    private static boolean internalIsLZMACompressionAvailable() {
        try {
            LZMACompressorInputStream.matches((byte[]) null, 0);
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean isCompressedFilename(String str) {
        return fileNameUtil.isCompressedFilename(str);
    }

    public static boolean isLZMACompressionAvailable() {
        CachedAvailability cachedAvailability = cachedLZMAAvailability;
        if (cachedAvailability == CachedAvailability.DONT_CACHE) {
            return internalIsLZMACompressionAvailable();
        }
        if (cachedAvailability == CachedAvailability.CACHED_AVAILABLE) {
            return true;
        }
        return false;
    }

    public static boolean matches(byte[] bArr, int i11) {
        if (i11 < HEADER_MAGIC.length) {
            return false;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr2 = HEADER_MAGIC;
            if (i12 >= bArr2.length) {
                return true;
            }
            if (bArr[i12] != bArr2[i12]) {
                return false;
            }
            i12++;
        }
    }

    public static void setCacheLZMAAvailablity(boolean z11) {
        CachedAvailability cachedAvailability;
        if (!z11) {
            cachedLZMAAvailability = CachedAvailability.DONT_CACHE;
        } else if (cachedLZMAAvailability == CachedAvailability.DONT_CACHE) {
            if (internalIsLZMACompressionAvailable()) {
                cachedAvailability = CachedAvailability.CACHED_AVAILABLE;
            } else {
                cachedAvailability = CachedAvailability.CACHED_UNAVAILABLE;
            }
            cachedLZMAAvailability = cachedAvailability;
        }
    }
}
