package org.apache.commons.compress.compressors.xz;

import java.util.HashMap;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.compress.utils.OsgiUtils;

public class XZUtils {
    private static final byte[] HEADER_MAGIC = {-3, TarConstants.LF_CONTIG, 122, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 90, 0};
    private static volatile CachedAvailability cachedXZAvailability = CachedAvailability.DONT_CACHE;
    private static final FileNameUtil fileNameUtil;

    public enum CachedAvailability {
        DONT_CACHE,
        CACHED_AVAILABLE,
        CACHED_UNAVAILABLE
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(".txz", ".tar");
        hashMap.put(".xz", "");
        hashMap.put("-xz", "");
        fileNameUtil = new FileNameUtil(hashMap, ".xz");
        setCacheXZAvailablity(!OsgiUtils.isRunningInOsgiEnvironment());
    }

    private XZUtils() {
    }

    public static CachedAvailability getCachedXZAvailability() {
        return cachedXZAvailability;
    }

    public static String getCompressedFilename(String str) {
        return fileNameUtil.getCompressedFilename(str);
    }

    public static String getUncompressedFilename(String str) {
        return fileNameUtil.getUncompressedFilename(str);
    }

    private static boolean internalIsXZCompressionAvailable() {
        try {
            XZCompressorInputStream.matches((byte[]) null, 0);
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean isCompressedFilename(String str) {
        return fileNameUtil.isCompressedFilename(str);
    }

    public static boolean isXZCompressionAvailable() {
        CachedAvailability cachedAvailability = cachedXZAvailability;
        if (cachedAvailability == CachedAvailability.DONT_CACHE) {
            return internalIsXZCompressionAvailable();
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

    public static void setCacheXZAvailablity(boolean z11) {
        CachedAvailability cachedAvailability;
        if (!z11) {
            cachedXZAvailability = CachedAvailability.DONT_CACHE;
        } else if (cachedXZAvailability == CachedAvailability.DONT_CACHE) {
            if (internalIsXZCompressionAvailable()) {
                cachedAvailability = CachedAvailability.CACHED_AVAILABLE;
            } else {
                cachedAvailability = CachedAvailability.CACHED_UNAVAILABLE;
            }
            cachedXZAvailability = cachedAvailability;
        }
    }
}
