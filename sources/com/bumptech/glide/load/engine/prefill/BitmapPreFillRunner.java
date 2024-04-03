package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import com.huawei.hms.flutter.map.constants.Param;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class BitmapPreFillRunner implements Runnable {
    static final int BACKOFF_RATIO = 4;
    private static final Clock DEFAULT_CLOCK = new Clock();
    static final long INITIAL_BACKOFF_MS = 40;
    static final long MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1);
    static final long MAX_DURATION_MS = 32;
    @VisibleForTesting
    static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final Clock clock;
    private long currentDelay;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set<PreFillType> seenTypes;
    private final PreFillQueue toPrefill;

    @VisibleForTesting
    public static class Clock {
        public long now() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    public static final class UniqueKey implements Key {
        public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public BitmapPreFillRunner(BitmapPool bitmapPool2, MemoryCache memoryCache2, PreFillQueue preFillQueue) {
        this(bitmapPool2, memoryCache2, preFillQueue, DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }

    private long getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    private long getNextDelay() {
        long j11 = this.currentDelay;
        this.currentDelay = Math.min(4 * j11, MAX_BACKOFF_MS);
        return j11;
    }

    private boolean isGcDetected(long j11) {
        return this.clock.now() - j11 >= 32;
    }

    @VisibleForTesting
    public boolean allocate() {
        Bitmap bitmap;
        long now = this.clock.now();
        while (!this.toPrefill.isEmpty() && !isGcDetected(now)) {
            PreFillType remove = this.toPrefill.remove();
            if (!this.seenTypes.contains(remove)) {
                this.seenTypes.add(remove);
                bitmap = this.bitmapPool.getDirty(remove.getWidth(), remove.getHeight(), remove.getConfig());
            } else {
                bitmap = Bitmap.createBitmap(remove.getWidth(), remove.getHeight(), remove.getConfig());
            }
            int bitmapByteSize = Util.getBitmapByteSize(bitmap);
            if (getFreeMemoryCacheBytes() >= ((long) bitmapByteSize)) {
                this.memoryCache.put(new UniqueKey(), BitmapResource.obtain(bitmap, this.bitmapPool));
            } else {
                this.bitmapPool.put(bitmap);
            }
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("allocated [");
                sb2.append(remove.getWidth());
                sb2.append(Param.X);
                sb2.append(remove.getHeight());
                sb2.append("] ");
                sb2.append(remove.getConfig());
                sb2.append(" size: ");
                sb2.append(bitmapByteSize);
            }
        }
        if (this.isCancelled || this.toPrefill.isEmpty()) {
            return false;
        }
        return true;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    public void run() {
        if (allocate()) {
            this.handler.postDelayed(this, getNextDelay());
        }
    }

    @VisibleForTesting
    public BitmapPreFillRunner(BitmapPool bitmapPool2, MemoryCache memoryCache2, PreFillQueue preFillQueue, Clock clock2, Handler handler2) {
        this.seenTypes = new HashSet();
        this.currentDelay = INITIAL_BACKOFF_MS;
        this.bitmapPool = bitmapPool2;
        this.memoryCache = memoryCache2;
        this.toPrefill = preFillQueue;
        this.clock = clock2;
        this.handler = handler2;
    }
}
