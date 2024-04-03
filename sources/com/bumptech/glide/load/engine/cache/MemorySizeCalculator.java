package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;

public final class MemorySizeCalculator {
    @VisibleForTesting
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    public static final class Builder {
        static final int ARRAY_POOL_SIZE_BYTES = 4194304;
        static final int BITMAP_POOL_TARGET_SCREENS = (Build.VERSION.SDK_INT < 26 ? 4 : 1);
        static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        static final float MAX_SIZE_MULTIPLIER = 0.4f;
        @VisibleForTesting
        static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        ActivityManager activityManager;
        int arrayPoolSizeBytes = 4194304;
        float bitmapPoolScreens = ((float) BITMAP_POOL_TARGET_SCREENS);
        final Context context;
        float lowMemoryMaxSizeMultiplier = LOW_MEMORY_MAX_SIZE_MULTIPLIER;
        float maxSizeMultiplier = 0.4f;
        float memoryCacheScreens = 2.0f;
        ScreenDimensions screenDimensions;

        public Builder(Context context2) {
            this.context = context2;
            this.activityManager = (ActivityManager) context2.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(context2.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && MemorySizeCalculator.isLowMemoryDevice(this.activityManager)) {
                this.bitmapPoolScreens = 0.0f;
            }
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        @VisibleForTesting
        public Builder setActivityManager(ActivityManager activityManager2) {
            this.activityManager = activityManager2;
            return this;
        }

        public Builder setArrayPoolSize(int i11) {
            this.arrayPoolSizeBytes = i11;
            return this;
        }

        public Builder setBitmapPoolScreens(float f11) {
            boolean z11;
            if (f11 >= 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "Bitmap pool screens must be greater than or equal to 0");
            this.bitmapPoolScreens = f11;
            return this;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f11) {
            boolean z11;
            if (f11 < 0.0f || f11 > 1.0f) {
                z11 = false;
            } else {
                z11 = true;
            }
            Preconditions.checkArgument(z11, "Low memory max size multiplier must be between 0 and 1");
            this.lowMemoryMaxSizeMultiplier = f11;
            return this;
        }

        public Builder setMaxSizeMultiplier(float f11) {
            boolean z11;
            if (f11 < 0.0f || f11 > 1.0f) {
                z11 = false;
            } else {
                z11 = true;
            }
            Preconditions.checkArgument(z11, "Size multiplier must be between 0 and 1");
            this.maxSizeMultiplier = f11;
            return this;
        }

        public Builder setMemoryCacheScreens(float f11) {
            boolean z11;
            if (f11 >= 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "Memory cache screens must be greater than or equal to 0");
            this.memoryCacheScreens = f11;
            return this;
        }

        @VisibleForTesting
        public Builder setScreenDimensions(ScreenDimensions screenDimensions2) {
            this.screenDimensions = screenDimensions2;
            return this;
        }
    }

    public static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics2) {
            this.displayMetrics = displayMetrics2;
        }

        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(Builder builder) {
        int i11;
        boolean z11;
        this.context = builder.context;
        if (isLowMemoryDevice(builder.activityManager)) {
            i11 = builder.arrayPoolSizeBytes / 2;
        } else {
            i11 = builder.arrayPoolSizeBytes;
        }
        this.arrayPoolSize = i11;
        int maxSize = getMaxSize(builder.activityManager, builder.maxSizeMultiplier, builder.lowMemoryMaxSizeMultiplier);
        float widthPixels = (float) (builder.screenDimensions.getWidthPixels() * builder.screenDimensions.getHeightPixels() * 4);
        int round = Math.round(builder.bitmapPoolScreens * widthPixels);
        int round2 = Math.round(widthPixels * builder.memoryCacheScreens);
        int i12 = maxSize - i11;
        int i13 = round2 + round;
        if (i13 <= i12) {
            this.memoryCacheSize = round2;
            this.bitmapPoolSize = round;
        } else {
            float f11 = (float) i12;
            float f12 = builder.bitmapPoolScreens;
            float f13 = builder.memoryCacheScreens;
            float f14 = f11 / (f12 + f13);
            this.memoryCacheSize = Math.round(f13 * f14);
            this.bitmapPoolSize = Math.round(f14 * builder.bitmapPoolScreens);
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Calculation complete, Calculated memory cache size: ");
            sb2.append(toMb(this.memoryCacheSize));
            sb2.append(", pool size: ");
            sb2.append(toMb(this.bitmapPoolSize));
            sb2.append(", byte array size: ");
            sb2.append(toMb(i11));
            sb2.append(", memory class limited? ");
            if (i13 > maxSize) {
                z11 = true;
            } else {
                z11 = false;
            }
            sb2.append(z11);
            sb2.append(", max size: ");
            sb2.append(toMb(maxSize));
            sb2.append(", memoryClass: ");
            sb2.append(builder.activityManager.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(isLowMemoryDevice(builder.activityManager));
        }
    }

    private static int getMaxSize(ActivityManager activityManager, float f11, float f12) {
        boolean isLowMemoryDevice = isLowMemoryDevice(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (isLowMemoryDevice) {
            f11 = f12;
        }
        return Math.round(memoryClass * f11);
    }

    @TargetApi(19)
    public static boolean isLowMemoryDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String toMb(int i11) {
        return Formatter.formatFileSize(this.context, (long) i11);
    }

    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }
}
