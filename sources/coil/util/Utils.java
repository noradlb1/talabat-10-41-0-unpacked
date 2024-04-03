package coil.util;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.StatFs;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0014\u001a\u00020\n2\b\b\u0001\u0010\u0015\u001a\u00020\n2\b\b\u0001\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcoil/util/Utils;", "", "()V", "CACHE_DIRECTORY_NAME", "", "DEFAULT_BITMAP_CONFIG", "Landroid/graphics/Bitmap$Config;", "getDEFAULT_BITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "DEFAULT_MEMORY_CLASS_MEGABYTES", "", "DISK_CACHE_PERCENTAGE", "", "LOW_MEMORY_MULTIPLIER", "MAX_DISK_CACHE_SIZE_BYTES", "", "MIN_DISK_CACHE_SIZE_BYTES", "REQUEST_TYPE_ENQUEUE", "REQUEST_TYPE_EXECUTE", "STANDARD_MULTIPLIER", "calculateAllocationByteCount", "width", "height", "config", "calculateAvailableMemorySize", "context", "Landroid/content/Context;", "percentage", "calculateDiskCacheSize", "cacheDirectory", "Ljava/io/File;", "getDefaultAvailableMemoryPercentage", "getDefaultBitmapPoolPercentage", "getDefaultCacheDirectory", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Utils {
    @NotNull
    private static final String CACHE_DIRECTORY_NAME = "image_cache";
    private static final int DEFAULT_MEMORY_CLASS_MEGABYTES = 256;
    private static final double DISK_CACHE_PERCENTAGE = 0.02d;
    @NotNull
    public static final Utils INSTANCE = new Utils();
    private static final double LOW_MEMORY_MULTIPLIER = 0.15d;
    private static final long MAX_DISK_CACHE_SIZE_BYTES = 262144000;
    private static final long MIN_DISK_CACHE_SIZE_BYTES = 10485760;
    public static final int REQUEST_TYPE_ENQUEUE = 0;
    public static final int REQUEST_TYPE_EXECUTE = 1;
    private static final double STANDARD_MULTIPLIER = 0.2d;

    private Utils() {
    }

    public final int calculateAllocationByteCount(@Px int i11, @Px int i12, @Nullable Bitmap.Config config) {
        return i11 * i12 * Bitmaps.getBytesPerPixel(config);
    }

    public final long calculateAvailableMemorySize(@NotNull Context context, double d11) {
        int i11;
        boolean z11;
        Class cls = ActivityManager.class;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = ContextCompat.getSystemService(context, cls);
            if (systemService != null) {
                ActivityManager activityManager = (ActivityManager) systemService;
                if ((context.getApplicationInfo().flags & 1048576) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    i11 = activityManager.getLargeMemoryClass();
                } else {
                    i11 = activityManager.getMemoryClass();
                }
                double d12 = (double) 1024;
                return (long) (d11 * ((double) i11) * d12 * d12);
            }
            throw new IllegalStateException(("System service of type " + cls + " was not found.").toString());
        } catch (Exception unused) {
            i11 = 256;
        }
    }

    public final long calculateDiskCacheSize(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "cacheDirectory");
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return RangesKt___RangesKt.coerceIn((long) (DISK_CACHE_PERCENTAGE * ((double) statFs.getBlockCountLong()) * ((double) statFs.getBlockSizeLong())), (long) MIN_DISK_CACHE_SIZE_BYTES, (long) MAX_DISK_CACHE_SIZE_BYTES);
        } catch (Exception unused) {
            return MIN_DISK_CACHE_SIZE_BYTES;
        }
    }

    @NotNull
    public final Bitmap.Config getDEFAULT_BITMAP_CONFIG() {
        return Build.VERSION.SDK_INT >= 26 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }

    public final double getDefaultAvailableMemoryPercentage(@NotNull Context context) {
        boolean z11;
        Class cls = ActivityManager.class;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = ContextCompat.getSystemService(context, cls);
            if (systemService != null) {
                if (((ActivityManager) systemService).isLowRamDevice()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    return LOW_MEMORY_MULTIPLIER;
                }
                return STANDARD_MULTIPLIER;
            }
            throw new IllegalStateException(("System service of type " + cls + " was not found.").toString());
        } catch (Exception unused) {
            return STANDARD_MULTIPLIER;
        }
    }

    public final double getDefaultBitmapPoolPercentage() {
        return Build.VERSION.SDK_INT >= 24 ? 0.0d : 0.5d;
    }

    @NotNull
    public final File getDefaultCacheDirectory(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(context.getCacheDir(), CACHE_DIRECTORY_NAME);
        file.mkdirs();
        return file;
    }
}
