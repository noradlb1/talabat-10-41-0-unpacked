package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j11) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j11);
    }

    public ExternalPreferredCacheDiskCacheFactory(final Context context, final String str, long j11) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new DiskLruCacheFactory.CacheDirectoryGetter() {
            @Nullable
            private File getInternalCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                if (str != null) {
                    return new File(cacheDir, str);
                }
                return cacheDir;
            }

            public File getCacheDirectory() {
                File externalCacheDir;
                File internalCacheDirectory = getInternalCacheDirectory();
                if ((internalCacheDirectory != null && internalCacheDirectory.exists()) || (externalCacheDir = context.getExternalCacheDir()) == null || !externalCacheDir.canWrite()) {
                    return internalCacheDirectory;
                }
                if (str != null) {
                    return new File(externalCacheDir, str);
                }
                return externalCacheDir;
            }
        }, j11);
    }
}
