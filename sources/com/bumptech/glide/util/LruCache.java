package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {
    private final Map<T, Entry<Y>> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    public static final class Entry<Y> {
        final int size;
        final Y value;

        public Entry(Y y11, int i11) {
            this.value = y11;
            this.size = i11;
        }
    }

    public LruCache(long j11) {
        this.initialMaxSize = j11;
        this.maxSize = j11;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public synchronized boolean contains(@NonNull T t11) {
        return this.cache.containsKey(t11);
    }

    @Nullable
    public synchronized Y get(@NonNull T t11) {
        Y y11;
        Entry entry = this.cache.get(t11);
        if (entry != null) {
            y11 = entry.value;
        } else {
            y11 = null;
        }
        return y11;
    }

    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public int getSize(@Nullable Y y11) {
        return 1;
    }

    public void onItemEvicted(@NonNull T t11, @Nullable Y y11) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return r4;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized Y put(@androidx.annotation.NonNull T r8, @androidx.annotation.Nullable Y r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.getSize(r9)     // Catch:{ all -> 0x004a }
            long r1 = (long) r0     // Catch:{ all -> 0x004a }
            long r3 = r7.maxSize     // Catch:{ all -> 0x004a }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r4 = 0
            if (r3 < 0) goto L_0x0012
            r7.onItemEvicted(r8, r9)     // Catch:{ all -> 0x004a }
            monitor-exit(r7)
            return r4
        L_0x0012:
            if (r9 == 0) goto L_0x0019
            long r5 = r7.currentSize     // Catch:{ all -> 0x004a }
            long r5 = r5 + r1
            r7.currentSize = r5     // Catch:{ all -> 0x004a }
        L_0x0019:
            java.util.Map<T, com.bumptech.glide.util.LruCache$Entry<Y>> r1 = r7.cache     // Catch:{ all -> 0x004a }
            if (r9 != 0) goto L_0x001f
            r2 = r4
            goto L_0x0024
        L_0x001f:
            com.bumptech.glide.util.LruCache$Entry r2 = new com.bumptech.glide.util.LruCache$Entry     // Catch:{ all -> 0x004a }
            r2.<init>(r9, r0)     // Catch:{ all -> 0x004a }
        L_0x0024:
            java.lang.Object r0 = r1.put(r8, r2)     // Catch:{ all -> 0x004a }
            com.bumptech.glide.util.LruCache$Entry r0 = (com.bumptech.glide.util.LruCache.Entry) r0     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0041
            long r1 = r7.currentSize     // Catch:{ all -> 0x004a }
            int r3 = r0.size     // Catch:{ all -> 0x004a }
            long r5 = (long) r3     // Catch:{ all -> 0x004a }
            long r1 = r1 - r5
            r7.currentSize = r1     // Catch:{ all -> 0x004a }
            Y r1 = r0.value     // Catch:{ all -> 0x004a }
            boolean r9 = r1.equals(r9)     // Catch:{ all -> 0x004a }
            if (r9 != 0) goto L_0x0041
            Y r9 = r0.value     // Catch:{ all -> 0x004a }
            r7.onItemEvicted(r8, r9)     // Catch:{ all -> 0x004a }
        L_0x0041:
            r7.evict()     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0048
            Y r4 = r0.value     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r7)
            return r4
        L_0x004a:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.LruCache.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Nullable
    public synchronized Y remove(@NonNull T t11) {
        Entry remove = this.cache.remove(t11);
        if (remove == null) {
            return null;
        }
        this.currentSize -= (long) remove.size;
        return remove.value;
    }

    public synchronized void setSizeMultiplier(float f11) {
        if (f11 >= 0.0f) {
            this.maxSize = (long) Math.round(((float) this.initialMaxSize) * f11);
            evict();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    public synchronized void trimToSize(long j11) {
        while (this.currentSize > j11) {
            Iterator<Map.Entry<T, Entry<Y>>> it = this.cache.entrySet().iterator();
            Map.Entry next = it.next();
            Entry entry = (Entry) next.getValue();
            this.currentSize -= (long) entry.size;
            Object key = next.getKey();
            it.remove();
            onItemEvicted(key, entry.value);
        }
    }
}
