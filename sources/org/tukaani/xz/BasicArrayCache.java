package org.tukaani.xz;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class BasicArrayCache extends ArrayCache {
    private static final int CACHEABLE_SIZE_MIN = 32768;
    private static final int ELEMENTS_PER_STACK = 512;
    private static final int STACKS_MAX = 32;
    private final CacheMap<byte[]> byteArrayCache = new CacheMap<>();
    private final CacheMap<int[]> intArrayCache = new CacheMap<>();

    public static class CacheMap<T> extends LinkedHashMap<Integer, CyclicStack<Reference<T>>> {
        private static final long serialVersionUID = 1;

        public CacheMap() {
            super(64, 0.75f, true);
        }

        public boolean removeEldestEntry(Map.Entry<Integer, CyclicStack<Reference<T>>> entry) {
            return size() > 32;
        }
    }

    public static class CyclicStack<T> {
        private final T[] elements;
        private int pos;

        private CyclicStack() {
            this.elements = new Object[512];
            this.pos = 0;
        }

        public synchronized T pop() {
            T t11;
            T[] tArr = this.elements;
            int i11 = this.pos;
            t11 = tArr[i11];
            tArr[i11] = null;
            this.pos = (i11 - 1) & 511;
            return t11;
        }

        public synchronized void push(T t11) {
            int i11 = (this.pos + 1) & 511;
            this.pos = i11;
            this.elements[i11] = t11;
        }
    }

    public static final class LazyHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final BasicArrayCache f63397a = new BasicArrayCache();

        private LazyHolder() {
        }
    }

    private static <T> T getArray(CacheMap<T> cacheMap, int i11) {
        CyclicStack cyclicStack;
        T t11;
        if (i11 < 32768) {
            return null;
        }
        synchronized (cacheMap) {
            cyclicStack = (CyclicStack) cacheMap.get(Integer.valueOf(i11));
        }
        if (cyclicStack == null) {
            return null;
        }
        do {
            Reference reference = (Reference) cyclicStack.pop();
            if (reference == null) {
                return null;
            }
            t11 = reference.get();
        } while (t11 == null);
        return t11;
    }

    public static BasicArrayCache getInstance() {
        return LazyHolder.f63397a;
    }

    private static <T> void putArray(CacheMap<T> cacheMap, T t11, int i11) {
        CyclicStack cyclicStack;
        if (i11 >= 32768) {
            synchronized (cacheMap) {
                cyclicStack = (CyclicStack) cacheMap.get(Integer.valueOf(i11));
                if (cyclicStack == null) {
                    cyclicStack = new CyclicStack();
                    cacheMap.put(Integer.valueOf(i11), cyclicStack);
                }
            }
            cyclicStack.push(new SoftReference(t11));
        }
    }

    public byte[] getByteArray(int i11, boolean z11) {
        byte[] bArr = (byte[]) getArray(this.byteArrayCache, i11);
        if (bArr == null) {
            return new byte[i11];
        }
        if (!z11) {
            return bArr;
        }
        Arrays.fill(bArr, (byte) 0);
        return bArr;
    }

    public int[] getIntArray(int i11, boolean z11) {
        int[] iArr = (int[]) getArray(this.intArrayCache, i11);
        if (iArr == null) {
            return new int[i11];
        }
        if (!z11) {
            return iArr;
        }
        Arrays.fill(iArr, 0);
        return iArr;
    }

    public void putArray(byte[] bArr) {
        putArray(this.byteArrayCache, bArr, bArr.length);
    }

    public void putArray(int[] iArr) {
        putArray(this.intArrayCache, iArr, iArr.length);
    }
}
