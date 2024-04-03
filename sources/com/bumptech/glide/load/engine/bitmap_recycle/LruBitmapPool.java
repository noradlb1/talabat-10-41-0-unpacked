package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private long currentSize;
    private int evictions;
    private int hits;
    private final long initialMaxSize;
    private long maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    public interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    public static final class NullBitmapTracker implements BitmapTracker {
        public void add(Bitmap bitmap) {
        }

        public void remove(Bitmap bitmap) {
        }
    }

    public static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + Param.X + bitmap.getHeight() + "]");
        }

        public void remove(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                this.bitmaps.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    public LruBitmapPool(long j11, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = j11;
        this.maxSize = j11;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    @TargetApi(26)
    private static void assertNotHardwareConfig(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap createBitmap(int i11, int i12, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = DEFAULT_CONFIG;
        }
        return Bitmap.createBitmap(i11, i12, config);
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Hits=");
        sb2.append(this.hits);
        sb2.append(", misses=");
        sb2.append(this.misses);
        sb2.append(", puts=");
        sb2.append(this.puts);
        sb2.append(", evictions=");
        sb2.append(this.evictions);
        sb2.append(", currentSize=");
        sb2.append(this.currentSize);
        sb2.append(", maxSize=");
        sb2.append(this.maxSize);
        sb2.append("\nStrategy=");
        sb2.append(this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i11 = Build.VERSION.SDK_INT;
        hashSet.add((Object) null);
        if (i11 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    @Nullable
    private synchronized Bitmap getDirtyOrNull(int i11, int i12, @Nullable Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap bitmap;
        assertNotHardwareConfig(config);
        LruPoolStrategy lruPoolStrategy = this.strategy;
        if (config != null) {
            config2 = config;
        } else {
            config2 = DEFAULT_CONFIG;
        }
        bitmap = lruPoolStrategy.get(i11, i12, config2);
        if (bitmap == null) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Missing bitmap=");
                sb2.append(this.strategy.logBitmap(i11, i12, config));
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= (long) this.strategy.getSize(bitmap);
            this.tracker.remove(bitmap);
            normalize(bitmap);
        }
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Get bitmap=");
            sb3.append(this.strategy.logBitmap(i11, i12, config));
        }
        dump();
        return bitmap;
    }

    @TargetApi(19)
    private static void maybeSetPreMultiplied(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void normalize(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        maybeSetPreMultiplied(bitmap);
    }

    private synchronized void trimToSize(long j11) {
        while (this.currentSize > j11) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Size mismatch, resetting");
                    dumpUnchecked();
                }
                this.currentSize = 0;
                return;
            }
            this.tracker.remove(removeLast);
            this.currentSize -= (long) this.strategy.getSize(removeLast);
            this.evictions++;
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Evicting bitmap=");
                sb2.append(this.strategy.logBitmap(removeLast));
            }
            dump();
            removeLast.recycle();
        }
    }

    public void clearMemory() {
        Log.isLoggable(TAG, 3);
        trimToSize(0);
    }

    public long evictionCount() {
        return (long) this.evictions;
    }

    @NonNull
    public Bitmap get(int i11, int i12, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i11, i12, config);
        if (dirtyOrNull == null) {
            return createBitmap(i11, i12, config);
        }
        dirtyOrNull.eraseColor(0);
        return dirtyOrNull;
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    @NonNull
    public Bitmap getDirty(int i11, int i12, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i11, i12, config);
        if (dirtyOrNull == null) {
            return createBitmap(i11, i12, config);
        }
        return dirtyOrNull;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    public long hitCount() {
        return (long) this.hits;
    }

    public long missCount() {
        return (long) this.misses;
    }

    public synchronized void put(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.strategy.getSize(bitmap)) <= this.maxSize) {
                        if (this.allowedConfigs.contains(bitmap.getConfig())) {
                            int size = this.strategy.getSize(bitmap);
                            this.strategy.put(bitmap);
                            this.tracker.add(bitmap);
                            this.puts++;
                            this.currentSize += (long) size;
                            if (Log.isLoggable(TAG, 2)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Put bitmap in pool=");
                                sb2.append(this.strategy.logBitmap(bitmap));
                            }
                            dump();
                            evict();
                            return;
                        }
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Reject bitmap from pool, bitmap: ");
                        sb3.append(this.strategy.logBitmap(bitmap));
                        sb3.append(", is mutable: ");
                        sb3.append(bitmap.isMutable());
                        sb3.append(", is allowed config: ");
                        sb3.append(this.allowedConfigs.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public synchronized void setSizeMultiplier(float f11) {
        this.maxSize = (long) Math.round(((float) this.initialMaxSize) * f11);
        evict();
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i11) {
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("trimMemory, level=");
            sb2.append(i11);
        }
        if (i11 >= 40 || i11 >= 20) {
            clearMemory();
        } else if (i11 >= 20 || i11 == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }

    public LruBitmapPool(long j11) {
        this(j11, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(long j11, Set<Bitmap.Config> set) {
        this(j11, getDefaultStrategy(), set);
    }
}
