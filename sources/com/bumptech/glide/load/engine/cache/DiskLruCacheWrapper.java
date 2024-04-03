package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final long maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();

    @Deprecated
    public DiskLruCacheWrapper(File file, long j11) {
        this.directory = file;
        this.maxSize = j11;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    public static DiskCache create(File file, long j11) {
        return new DiskLruCacheWrapper(file, j11);
    }

    @Deprecated
    public static synchronized DiskCache get(File file, long j11) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            if (wrapper == null) {
                wrapper = new DiskLruCacheWrapper(file, j11);
            }
            diskLruCacheWrapper = wrapper;
        }
        return diskLruCacheWrapper;
    }

    private synchronized DiskLruCache getDiskCache() throws IOException {
        if (this.diskLruCache == null) {
            this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);
        }
        return this.diskLruCache;
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }

    public synchronized void clear() {
        try {
            getDiskCache().delete();
        } catch (IOException e11) {
            try {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to clear disk cache or disk cache cleared externally", e11);
                }
            } catch (Throwable th2) {
                resetDiskCache();
                throw th2;
            }
        }
        resetDiskCache();
    }

    public void delete(Key key) {
        try {
            getDiskCache().remove(this.safeKeyGenerator.getSafeKey(key));
        } catch (IOException e11) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to delete from disk cache", e11);
            }
        }
    }

    public void put(Key key, DiskCache.Writer writer) {
        DiskLruCache.Editor edit;
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(safeKey);
        try {
            if (Log.isLoggable(TAG, 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Put: Obtained: ");
                sb2.append(safeKey);
                sb2.append(" for for Key: ");
                sb2.append(key);
            }
            try {
                DiskLruCache diskCache = getDiskCache();
                if (diskCache.get(safeKey) == null) {
                    edit = diskCache.edit(safeKey);
                    if (edit != null) {
                        if (writer.write(edit.getFile(0))) {
                            edit.commit();
                        }
                        edit.abortUnlessCommitted();
                        this.writeLocker.release(safeKey);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + safeKey);
                }
            } catch (IOException e11) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to put to disk cache", e11);
                }
            } catch (Throwable th2) {
                edit.abortUnlessCommitted();
                throw th2;
            }
        } finally {
            this.writeLocker.release(safeKey);
        }
    }

    public File get(Key key) {
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get: Obtained: ");
            sb2.append(safeKey);
            sb2.append(" for for Key: ");
            sb2.append(key);
        }
        try {
            DiskLruCache.Value value = getDiskCache().get(safeKey);
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException e11) {
            if (!Log.isLoggable(TAG, 5)) {
                return null;
            }
            Log.w(TAG, "Unable to get from disk cache", e11);
            return null;
        }
    }
}
