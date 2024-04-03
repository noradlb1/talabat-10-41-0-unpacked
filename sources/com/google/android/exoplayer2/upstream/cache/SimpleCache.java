package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import m8.c;

public final class SimpleCache implements Cache {
    private static final int SUBDIRECTORY_COUNT = 10;
    private static final String TAG = "SimpleCache";
    private static final String UID_FILE_SUFFIX = ".uid";
    private static final HashSet<File> lockedCacheDirs = new HashSet<>();
    private final File cacheDir;
    private final CachedContentIndex contentIndex;
    /* access modifiers changed from: private */
    public final CacheEvictor evictor;
    @Nullable
    private final CacheFileMetadataIndex fileIndex;
    private Cache.CacheException initializationException;
    private final HashMap<String, ArrayList<Cache.Listener>> listeners;
    private final Random random;
    private boolean released;
    private long totalSpace;
    private final boolean touchCacheSpans;
    private long uid;

    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, (byte[]) null, false);
    }

    private void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.contentIndex.getOrAdd(simpleCacheSpan.key).addSpan(simpleCacheSpan);
        this.totalSpace += simpleCacheSpan.length;
        notifySpanAdded(simpleCacheSpan);
    }

    private static void createCacheDirectories(File file) throws Cache.CacheException {
        if (!file.mkdirs() && !file.isDirectory()) {
            String str = "Failed to create cache directory: " + file;
            Log.e(TAG, str);
            throw new Cache.CacheException(str);
        }
    }

    private static long createUid(File file) throws IOException {
        long j11;
        long nextLong = new SecureRandom().nextLong();
        if (nextLong == Long.MIN_VALUE) {
            j11 = 0;
        } else {
            j11 = Math.abs(nextLong);
        }
        String l11 = Long.toString(j11, 16);
        File file2 = new File(file, l11 + UID_FILE_SUFFIX);
        if (file2.createNewFile()) {
            return j11;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    @WorkerThread
    public static void delete(File file, @Nullable DatabaseProvider databaseProvider) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.delete();
                return;
            }
            if (databaseProvider != null) {
                long loadUid = loadUid(listFiles);
                if (loadUid != -1) {
                    try {
                        CacheFileMetadataIndex.delete(databaseProvider, loadUid);
                    } catch (DatabaseIOException unused) {
                        Log.w(TAG, "Failed to delete file metadata: " + loadUid);
                    }
                    try {
                        CachedContentIndex.delete(databaseProvider, loadUid);
                    } catch (DatabaseIOException unused2) {
                        Log.w(TAG, "Failed to delete file metadata: " + loadUid);
                    }
                }
            }
            Util.recursiveDelete(file);
        }
    }

    private SimpleCacheSpan getSpan(String str, long j11, long j12) {
        SimpleCacheSpan span;
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent == null) {
            return SimpleCacheSpan.createHole(str, j11, j12);
        }
        while (true) {
            span = cachedContent.getSpan(j11, j12);
            if (!span.isCached || span.file.length() == span.length) {
                return span;
            }
            removeStaleSpans();
        }
        return span;
    }

    /* access modifiers changed from: private */
    public void initialize() {
        if (!this.cacheDir.exists()) {
            try {
                createCacheDirectories(this.cacheDir);
            } catch (Cache.CacheException e11) {
                this.initializationException = e11;
                return;
            }
        }
        File[] listFiles = this.cacheDir.listFiles();
        if (listFiles == null) {
            String str = "Failed to list cache directory files: " + this.cacheDir;
            Log.e(TAG, str);
            this.initializationException = new Cache.CacheException(str);
            return;
        }
        long loadUid = loadUid(listFiles);
        this.uid = loadUid;
        if (loadUid == -1) {
            try {
                this.uid = createUid(this.cacheDir);
            } catch (IOException e12) {
                String str2 = "Failed to create cache UID: " + this.cacheDir;
                Log.e(TAG, str2, e12);
                this.initializationException = new Cache.CacheException(str2, e12);
                return;
            }
        }
        try {
            this.contentIndex.initialize(this.uid);
            CacheFileMetadataIndex cacheFileMetadataIndex = this.fileIndex;
            if (cacheFileMetadataIndex != null) {
                cacheFileMetadataIndex.initialize(this.uid);
                Map<String, CacheFileMetadata> all = this.fileIndex.getAll();
                loadDirectory(this.cacheDir, true, listFiles, all);
                this.fileIndex.removeAll(all.keySet());
            } else {
                loadDirectory(this.cacheDir, true, listFiles, (Map<String, CacheFileMetadata>) null);
            }
            this.contentIndex.removeEmpty();
            try {
                this.contentIndex.store();
            } catch (IOException e13) {
                Log.e(TAG, "Storing index file failed", e13);
            }
        } catch (IOException e14) {
            String str3 = "Failed to initialize cache indices: " + this.cacheDir;
            Log.e(TAG, str3, e14);
            this.initializationException = new Cache.CacheException(str3, e14);
        }
    }

    public static synchronized boolean isCacheFolderLocked(File file) {
        boolean contains;
        synchronized (SimpleCache.class) {
            contains = lockedCacheDirs.contains(file.getAbsoluteFile());
        }
        return contains;
    }

    private void loadDirectory(File file, boolean z11, @Nullable File[] fileArr, @Nullable Map<String, CacheFileMetadata> map) {
        CacheFileMetadata cacheFileMetadata;
        long j11;
        long j12;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                String name2 = file2.getName();
                if (z11 && name2.indexOf(46) == -1) {
                    loadDirectory(file2, false, file2.listFiles(), map);
                } else if (!z11 || (!CachedContentIndex.isIndexFile(name2) && !name2.endsWith(UID_FILE_SUFFIX))) {
                    if (map != null) {
                        cacheFileMetadata = map.remove(name2);
                    } else {
                        cacheFileMetadata = null;
                    }
                    if (cacheFileMetadata != null) {
                        j12 = cacheFileMetadata.length;
                        j11 = cacheFileMetadata.lastTouchTimestamp;
                    } else {
                        j11 = -9223372036854775807L;
                        j12 = -1;
                    }
                    SimpleCacheSpan createCacheEntry = SimpleCacheSpan.createCacheEntry(file2, j12, j11, this.contentIndex);
                    if (createCacheEntry != null) {
                        addSpan(createCacheEntry);
                    } else {
                        file2.delete();
                    }
                }
            }
        } else if (!z11) {
            file.delete();
        }
    }

    private static long loadUid(File[] fileArr) {
        int length = fileArr.length;
        int i11 = 0;
        while (i11 < length) {
            File file = fileArr[i11];
            String name2 = file.getName();
            if (name2.endsWith(UID_FILE_SUFFIX)) {
                try {
                    return parseUid(name2);
                } catch (NumberFormatException unused) {
                    Log.e(TAG, "Malformed UID file: " + file);
                    file.delete();
                }
            } else {
                i11++;
            }
        }
        return -1;
    }

    private static synchronized boolean lockFolder(File file) {
        boolean add;
        synchronized (SimpleCache.class) {
            add = lockedCacheDirs.add(file.getAbsoluteFile());
        }
        return add;
    }

    private void notifySpanAdded(SimpleCacheSpan simpleCacheSpan) {
        ArrayList arrayList = this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanAdded(this, simpleCacheSpan);
            }
        }
        this.evictor.onSpanAdded(this, simpleCacheSpan);
    }

    private void notifySpanRemoved(CacheSpan cacheSpan) {
        ArrayList arrayList = this.listeners.get(cacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanRemoved(this, cacheSpan);
            }
        }
        this.evictor.onSpanRemoved(this, cacheSpan);
    }

    private void notifySpanTouched(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        ArrayList arrayList = this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanTouched(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.evictor.onSpanTouched(this, simpleCacheSpan, cacheSpan);
    }

    private static long parseUid(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private void removeSpanInternal(CacheSpan cacheSpan) {
        CachedContent cachedContent = this.contentIndex.get(cacheSpan.key);
        if (cachedContent != null && cachedContent.removeSpan(cacheSpan)) {
            this.totalSpace -= cacheSpan.length;
            if (this.fileIndex != null) {
                String name2 = cacheSpan.file.getName();
                try {
                    this.fileIndex.remove(name2);
                } catch (IOException unused) {
                    Log.w(TAG, "Failed to remove file index entry for: " + name2);
                }
            }
            this.contentIndex.maybeRemove(cachedContent.key);
            notifySpanRemoved(cacheSpan);
        }
    }

    private void removeStaleSpans() {
        ArrayList arrayList = new ArrayList();
        for (CachedContent spans : this.contentIndex.getAll()) {
            Iterator<SimpleCacheSpan> it = spans.getSpans().iterator();
            while (it.hasNext()) {
                CacheSpan next = it.next();
                if (next.file.length() != next.length) {
                    arrayList.add(next);
                }
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            removeSpanInternal((CacheSpan) arrayList.get(i11));
        }
    }

    private SimpleCacheSpan touchSpan(String str, SimpleCacheSpan simpleCacheSpan) {
        boolean z11;
        if (!this.touchCacheSpans) {
            return simpleCacheSpan;
        }
        String name2 = ((File) Assertions.checkNotNull(simpleCacheSpan.file)).getName();
        long j11 = simpleCacheSpan.length;
        long currentTimeMillis = System.currentTimeMillis();
        CacheFileMetadataIndex cacheFileMetadataIndex = this.fileIndex;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.set(name2, j11, currentTimeMillis);
            } catch (IOException unused) {
                Log.w(TAG, "Failed to update index with new touch timestamp.");
            }
            z11 = false;
        } else {
            z11 = true;
        }
        SimpleCacheSpan lastTouchTimestamp = this.contentIndex.get(str).setLastTouchTimestamp(simpleCacheSpan, currentTimeMillis, z11);
        notifySpanTouched(simpleCacheSpan, lastTouchTimestamp);
        return lastTouchTimestamp;
    }

    private static synchronized void unlockFolder(File file) {
        synchronized (SimpleCache.class) {
            lockedCacheDirs.remove(file.getAbsoluteFile());
        }
    }

    public synchronized NavigableSet<CacheSpan> addListener(String str, Cache.Listener listener) {
        boolean z11;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(listener);
        ArrayList arrayList = this.listeners.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.listeners.put(str, arrayList);
        }
        arrayList.add(listener);
        return getCachedSpans(str);
    }

    public synchronized void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) throws Cache.CacheException {
        boolean z11;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        checkInitialization();
        this.contentIndex.applyContentMetadataMutations(str, contentMetadataMutations);
        try {
            this.contentIndex.store();
        } catch (IOException e11) {
            throw new Cache.CacheException((Throwable) e11);
        }
    }

    public synchronized void checkInitialization() throws Cache.CacheException {
        Cache.CacheException cacheException = this.initializationException;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public synchronized void commitFile(File file, long j11) throws Cache.CacheException {
        boolean z11;
        boolean z12 = true;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        if (file.exists()) {
            if (j11 == 0) {
                file.delete();
                return;
            }
            SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) Assertions.checkNotNull(SimpleCacheSpan.createCacheEntry(file, j11, this.contentIndex));
            CachedContent cachedContent = (CachedContent) Assertions.checkNotNull(this.contentIndex.get(simpleCacheSpan.key));
            Assertions.checkState(cachedContent.isFullyLocked(simpleCacheSpan.position, simpleCacheSpan.length));
            long a11 = c.a(cachedContent.getMetadata());
            if (a11 != -1) {
                if (simpleCacheSpan.position + simpleCacheSpan.length > a11) {
                    z12 = false;
                }
                Assertions.checkState(z12);
            }
            if (this.fileIndex != null) {
                try {
                    this.fileIndex.set(file.getName(), simpleCacheSpan.length, simpleCacheSpan.lastTouchTimestamp);
                } catch (IOException e11) {
                    throw new Cache.CacheException((Throwable) e11);
                } catch (IOException e12) {
                    throw new Cache.CacheException((Throwable) e12);
                }
            }
            addSpan(simpleCacheSpan);
            this.contentIndex.store();
            notifyAll();
        }
    }

    public synchronized long getCacheSpace() {
        boolean z11;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        return this.totalSpace;
    }

    public synchronized long getCachedBytes(String str, long j11, long j12) {
        long j13;
        long j14;
        long j15;
        if (j12 == -1) {
            j13 = Long.MAX_VALUE;
        } else {
            j13 = j11 + j12;
        }
        if (j13 < 0) {
            j14 = Long.MAX_VALUE;
        } else {
            j14 = j13;
        }
        long j16 = j11;
        j15 = 0;
        while (j16 < j14) {
            try {
                long cachedLength = getCachedLength(str, j16, j14 - j16);
                if (cachedLength > 0) {
                    j15 += cachedLength;
                } else {
                    cachedLength = -cachedLength;
                }
                j16 += cachedLength;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j15;
    }

    public synchronized long getCachedLength(String str, long j11, long j12) {
        boolean z11;
        long j13;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        if (j12 == -1) {
            j12 = Long.MAX_VALUE;
        }
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent != null) {
            j13 = cachedContent.getCachedBytesLength(j11, j12);
        } else {
            j13 = -j12;
        }
        return j13;
    }

    public synchronized NavigableSet<CacheSpan> getCachedSpans(String str) {
        boolean z11;
        TreeSet treeSet;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent != null) {
            if (!cachedContent.isEmpty()) {
                treeSet = new TreeSet(cachedContent.getSpans());
            }
        }
        treeSet = new TreeSet();
        return treeSet;
    }

    public synchronized ContentMetadata getContentMetadata(String str) {
        boolean z11;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        return this.contentIndex.getContentMetadata(str);
    }

    public synchronized Set<String> getKeys() {
        boolean z11;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        return new HashSet(this.contentIndex.getKeys());
    }

    public synchronized long getUid() {
        return this.uid;
    }

    public synchronized boolean isCached(String str, long j11, long j12) {
        boolean z11;
        boolean z12;
        z11 = true;
        if (!this.released) {
            z12 = true;
        } else {
            z12 = false;
        }
        Assertions.checkState(z12);
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent == null || cachedContent.getCachedBytesLength(j11, j12) < j12) {
            z11 = false;
        }
        return z11;
    }

    public synchronized void release() {
        if (!this.released) {
            this.listeners.clear();
            removeStaleSpans();
            try {
                this.contentIndex.store();
                unlockFolder(this.cacheDir);
            } catch (IOException e11) {
                try {
                    Log.e(TAG, "Storing index file failed", e11);
                    unlockFolder(this.cacheDir);
                } catch (Throwable th2) {
                    unlockFolder(this.cacheDir);
                    this.released = true;
                    throw th2;
                }
            }
            this.released = true;
            return;
        }
        return;
    }

    public synchronized void releaseHoleSpan(CacheSpan cacheSpan) {
        boolean z11;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        CachedContent cachedContent = (CachedContent) Assertions.checkNotNull(this.contentIndex.get(cacheSpan.key));
        cachedContent.unlockRange(cacheSpan.position);
        this.contentIndex.maybeRemove(cachedContent.key);
        notifyAll();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeListener(java.lang.String r2, com.google.android.exoplayer2.upstream.cache.Cache.Listener r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.released     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache$Listener>> r0 = r1.listeners     // Catch:{ all -> 0x0021 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0021 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001f
            r0.remove(r3)     // Catch:{ all -> 0x0021 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0021 }
            if (r3 == 0) goto L_0x001f
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache$Listener>> r3 = r1.listeners     // Catch:{ all -> 0x0021 }
            r3.remove(r2)     // Catch:{ all -> 0x0021 }
        L_0x001f:
            monitor-exit(r1)
            return
        L_0x0021:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.SimpleCache.removeListener(java.lang.String, com.google.android.exoplayer2.upstream.cache.Cache$Listener):void");
    }

    public synchronized void removeResource(String str) {
        boolean z11;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        for (CacheSpan removeSpanInternal : getCachedSpans(str)) {
            removeSpanInternal(removeSpanInternal);
        }
    }

    public synchronized void removeSpan(CacheSpan cacheSpan) {
        boolean z11;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        removeSpanInternal(cacheSpan);
    }

    public synchronized File startFile(String str, long j11, long j12) throws Cache.CacheException {
        boolean z11;
        CachedContent cachedContent;
        File file;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        checkInitialization();
        cachedContent = this.contentIndex.get(str);
        Assertions.checkNotNull(cachedContent);
        Assertions.checkState(cachedContent.isFullyLocked(j11, j12));
        if (!this.cacheDir.exists()) {
            createCacheDirectories(this.cacheDir);
            removeStaleSpans();
        }
        this.evictor.onStartFile(this, str, j11, j12);
        file = new File(this.cacheDir, Integer.toString(this.random.nextInt(10)));
        if (!file.exists()) {
            createCacheDirectories(file);
        }
        return SimpleCacheSpan.getCacheFile(file, cachedContent.f35064id, j11, System.currentTimeMillis());
    }

    public synchronized CacheSpan startReadWrite(String str, long j11, long j12) throws InterruptedException, Cache.CacheException {
        boolean z11;
        CacheSpan startReadWriteNonBlocking;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        checkInitialization();
        while (true) {
            startReadWriteNonBlocking = startReadWriteNonBlocking(str, j11, j12);
            if (startReadWriteNonBlocking == null) {
                wait();
            }
        }
        return startReadWriteNonBlocking;
    }

    @Nullable
    public synchronized CacheSpan startReadWriteNonBlocking(String str, long j11, long j12) throws Cache.CacheException {
        boolean z11;
        if (!this.released) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        checkInitialization();
        SimpleCacheSpan span = getSpan(str, j11, j12);
        if (span.isCached) {
            return touchSpan(str, span);
        } else if (this.contentIndex.getOrAdd(str).lockRange(j11, span.length)) {
            return span;
        } else {
            return null;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor, @Nullable byte[] bArr) {
        this(file, cacheEvictor, bArr, bArr != null);
    }

    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor, @Nullable byte[] bArr, boolean z11) {
        this(file, cacheEvictor, (DatabaseProvider) null, bArr, z11, true);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, (byte[]) null, false, false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleCache(File file, CacheEvictor cacheEvictor, @Nullable DatabaseProvider databaseProvider, @Nullable byte[] bArr, boolean z11, boolean z12) {
        this(file, cacheEvictor, new CachedContentIndex(databaseProvider, file, bArr, z11, z12), (databaseProvider == null || z12) ? null : new CacheFileMetadataIndex(databaseProvider));
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex, @Nullable CacheFileMetadataIndex cacheFileMetadataIndex) {
        if (lockFolder(file)) {
            this.cacheDir = file;
            this.evictor = cacheEvictor;
            this.contentIndex = cachedContentIndex;
            this.fileIndex = cacheFileMetadataIndex;
            this.listeners = new HashMap<>();
            this.random = new Random();
            this.touchCacheSpans = cacheEvictor.requiresCacheSpanTouches();
            this.uid = -1;
            final ConditionVariable conditionVariable = new ConditionVariable();
            new Thread("ExoPlayer:SimpleCacheInit") {
                public void run() {
                    synchronized (SimpleCache.this) {
                        conditionVariable.open();
                        SimpleCache.this.initialize();
                        SimpleCache.this.evictor.onCacheInitialized();
                    }
                }
            }.start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }
}
