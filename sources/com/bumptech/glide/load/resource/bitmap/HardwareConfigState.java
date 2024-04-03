package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public final class HardwareConfigState {
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED;
    private static final File FD_SIZE_LIST = new File("/proc/self/fd");
    public static final boolean HARDWARE_BITMAPS_SUPPORTED;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_O = 700;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    @VisibleForTesting
    static final int MIN_HARDWARE_DIMENSION_O = 128;
    private static final int MIN_HARDWARE_DIMENSION_P = 0;
    public static final int NO_MAX_FD_COUNT = -1;
    private static final String TAG = "HardwareConfig";
    private static volatile HardwareConfigState instance;
    private static volatile int manualOverrideMaxFdCount = -1;
    @GuardedBy("this")
    private int decodesSinceLastFdCheck;
    @GuardedBy("this")
    private boolean isFdSizeBelowHardwareLimit = true;
    private final AtomicBoolean isHardwareConfigAllowedByAppState = new AtomicBoolean(false);
    private final boolean isHardwareConfigAllowedByDeviceModel = isHardwareConfigAllowedByDeviceModel();
    private final int minHardwareDimension;
    private final int sdkBasedMaxFdCount;

    static {
        boolean z11;
        int i11 = Build.VERSION.SDK_INT;
        boolean z12 = true;
        if (i11 < 29) {
            z11 = true;
        } else {
            z11 = false;
        }
        BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = z11;
        if (i11 < 26) {
            z12 = false;
        }
        HARDWARE_BITMAPS_SUPPORTED = z12;
    }

    @VisibleForTesting
    public HardwareConfigState() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.sdkBasedMaxFdCount = 20000;
            this.minHardwareDimension = 0;
            return;
        }
        this.sdkBasedMaxFdCount = 700;
        this.minHardwareDimension = 128;
    }

    private boolean areHardwareBitmapsBlockedByAppState() {
        if (!BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED || this.isHardwareConfigAllowedByAppState.get()) {
            return false;
        }
        return true;
    }

    public static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                if (instance == null) {
                    instance = new HardwareConfigState();
                }
            }
        }
        return instance;
    }

    private int getMaxFdCount() {
        if (manualOverrideMaxFdCount != -1) {
            return manualOverrideMaxFdCount;
        }
        return this.sdkBasedMaxFdCount;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        boolean z11 = true;
        int i11 = this.decodesSinceLastFdCheck + 1;
        this.decodesSinceLastFdCheck = i11;
        if (i11 >= 50) {
            this.decodesSinceLastFdCheck = 0;
            int length = FD_SIZE_LIST.list().length;
            long maxFdCount = (long) getMaxFdCount();
            if (((long) length) >= maxFdCount) {
                z11 = false;
            }
            this.isFdSizeBelowHardwareLimit = z11;
            if (!z11 && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + maxFdCount);
            }
        }
        return this.isFdSizeBelowHardwareLimit;
    }

    private static boolean isHardwareConfigAllowedByDeviceModel() {
        return !isHardwareConfigDisallowedByB112551574() && !isHardwareConfigDisallowedByB147430447();
    }

    private static boolean isHardwareConfigDisallowedByB112551574() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        for (String startsWith : Arrays.asList(new String[]{"SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play"})) {
            if (Build.MODEL.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isHardwareConfigDisallowedByB147430447() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList(new String[]{"LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM"}).contains(Build.MODEL);
    }

    public boolean areHardwareBitmapsBlocked() {
        Util.assertMainThread();
        return !this.isHardwareConfigAllowedByAppState.get();
    }

    public void blockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(false);
    }

    public boolean isHardwareConfigAllowed(int i11, int i12, boolean z11, boolean z12) {
        if (!z11) {
            Log.isLoggable(TAG, 2);
            return false;
        } else if (!this.isHardwareConfigAllowedByDeviceModel) {
            Log.isLoggable(TAG, 2);
            return false;
        } else if (!HARDWARE_BITMAPS_SUPPORTED) {
            Log.isLoggable(TAG, 2);
            return false;
        } else if (areHardwareBitmapsBlockedByAppState()) {
            Log.isLoggable(TAG, 2);
            return false;
        } else if (z12) {
            Log.isLoggable(TAG, 2);
            return false;
        } else {
            int i13 = this.minHardwareDimension;
            if (i11 < i13) {
                Log.isLoggable(TAG, 2);
                return false;
            } else if (i12 < i13) {
                Log.isLoggable(TAG, 2);
                return false;
            } else if (isFdSizeBelowHardwareLimit()) {
                return true;
            } else {
                Log.isLoggable(TAG, 2);
                return false;
            }
        }
    }

    @TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int i11, int i12, BitmapFactory.Options options, boolean z11, boolean z12) {
        boolean isHardwareConfigAllowed = isHardwareConfigAllowed(i11, i12, z11, z12);
        if (isHardwareConfigAllowed) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return isHardwareConfigAllowed;
    }

    public void unblockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(true);
    }
}
