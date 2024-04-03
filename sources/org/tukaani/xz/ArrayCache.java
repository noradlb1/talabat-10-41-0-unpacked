package org.tukaani.xz;

public class ArrayCache {
    private static volatile ArrayCache defaultCache;
    private static final ArrayCache dummyCache;

    static {
        ArrayCache arrayCache = new ArrayCache();
        dummyCache = arrayCache;
        defaultCache = arrayCache;
    }

    public static ArrayCache getDefaultCache() {
        return defaultCache;
    }

    public static ArrayCache getDummyCache() {
        return dummyCache;
    }

    public static void setDefaultCache(ArrayCache arrayCache) {
        arrayCache.getClass();
        defaultCache = arrayCache;
    }

    public byte[] getByteArray(int i11, boolean z11) {
        return new byte[i11];
    }

    public int[] getIntArray(int i11, boolean z11) {
        return new int[i11];
    }

    public void putArray(byte[] bArr) {
    }

    public void putArray(int[] iArr) {
    }
}
