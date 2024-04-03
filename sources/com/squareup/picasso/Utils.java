package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import okio.BufferedSource;
import okio.ByteString;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class Utils {
    private static final int KEY_PADDING = 50;
    private static final int MAX_DISK_CACHE_SIZE = 52428800;
    private static final int MIN_DISK_CACHE_SIZE = 5242880;
    private static final String PICASSO_CACHE = "picasso-cache";
    private static final ByteString WEBP_FILE_HEADER_RIFF = ByteString.encodeUtf8("RIFF");
    private static final ByteString WEBP_FILE_HEADER_WEBP = ByteString.encodeUtf8("WEBP");

    /* renamed from: a  reason: collision with root package name */
    public static final StringBuilder f53477a = new StringBuilder();

    public static class PicassoThread extends Thread {
        public PicassoThread(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public static class PicassoThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            return new PicassoThread(runnable);
        }
    }

    private Utils() {
    }

    @TargetApi(18)
    public static long a(File file) {
        long j11;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j11 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            j11 = 5242880;
        }
        return Math.max(Math.min(j11, 52428800), CacheDataSink.DEFAULT_FRAGMENT_SIZE);
    }

    public static int b(Context context) {
        boolean z11;
        int i11;
        ActivityManager activityManager = (ActivityManager) o(context, "activity");
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
        return (int) ((((long) i11) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) / 7);
    }

    public static void c() {
        if (!r()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    public static void d() {
        if (r()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    public static <T> T e(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static File f(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), PICASSO_CACHE);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String g(Request request) {
        StringBuilder sb2 = f53477a;
        String h11 = h(request, sb2);
        sb2.setLength(0);
        return h11;
    }

    public static String h(Request request, StringBuilder sb2) {
        String str = request.stableKey;
        if (str != null) {
            sb2.ensureCapacity(str.length() + 50);
            sb2.append(request.stableKey);
        } else {
            Uri uri = request.uri;
            if (uri != null) {
                String uri2 = uri.toString();
                sb2.ensureCapacity(uri2.length() + 50);
                sb2.append(uri2);
            } else {
                sb2.ensureCapacity(50);
                sb2.append(request.resourceId);
            }
        }
        sb2.append(10);
        if (request.rotationDegrees != 0.0f) {
            sb2.append("rotation:");
            sb2.append(request.rotationDegrees);
            if (request.hasRotationPivot) {
                sb2.append('@');
                sb2.append(request.rotationPivotX);
                sb2.append('x');
                sb2.append(request.rotationPivotY);
            }
            sb2.append(10);
        }
        if (request.hasSize()) {
            sb2.append("resize:");
            sb2.append(request.targetWidth);
            sb2.append('x');
            sb2.append(request.targetHeight);
            sb2.append(10);
        }
        if (request.centerCrop) {
            sb2.append("centerCrop:");
            sb2.append(request.centerCropGravity);
            sb2.append(10);
        } else if (request.centerInside) {
            sb2.append("centerInside");
            sb2.append(10);
        }
        List<Transformation> list = request.transformations;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                sb2.append(request.transformations.get(i11).key());
                sb2.append(10);
            }
        }
        return sb2.toString();
    }

    public static void i(Looper looper) {
        AnonymousClass1 r02 = new Handler(looper) {
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        r02.sendMessageDelayed(r02.obtainMessage(), 1000);
    }

    public static int j(Bitmap bitmap) {
        int allocationByteCount = bitmap.getAllocationByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    public static String k(BitmapHunter bitmapHunter) {
        return l(bitmapHunter, "");
    }

    public static String l(BitmapHunter bitmapHunter, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        Action g11 = bitmapHunter.g();
        if (g11 != null) {
            sb2.append(g11.f53359b.c());
        }
        List<Action> h11 = bitmapHunter.h();
        if (h11 != null) {
            int size = h11.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (i11 > 0 || g11 != null) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(h11.get(i11).f53359b.c());
            }
        }
        return sb2.toString();
    }

    public static int m(Resources resources, Request request) throws FileNotFoundException {
        Uri uri;
        int i11 = request.resourceId;
        if (i11 != 0 || (uri = request.uri) == null) {
            return i11;
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            List<String> pathSegments = request.uri.getPathSegments();
            if (pathSegments == null || pathSegments.isEmpty()) {
                throw new FileNotFoundException("No path segments: " + request.uri);
            } else if (pathSegments.size() == 1) {
                try {
                    return Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Last path segment is not a resource ID: " + request.uri);
                }
            } else if (pathSegments.size() == 2) {
                return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + request.uri);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + request.uri);
        }
    }

    public static Resources n(Context context, Request request) throws FileNotFoundException {
        Uri uri;
        if (request.resourceId != 0 || (uri = request.uri) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            try {
                return context.getPackageManager().getResourcesForApplication(authority);
            } catch (PackageManager.NameNotFoundException unused) {
                throw new FileNotFoundException("Unable to obtain resources for package: " + request.uri);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + request.uri);
        }
    }

    public static <T> T o(Context context, String str) {
        return context.getSystemService(str);
    }

    public static boolean p(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean q(Context context) {
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
                return true;
            }
            return false;
        } catch (NullPointerException | SecurityException unused) {
            return false;
        }
    }

    public static boolean r() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean s(BufferedSource bufferedSource) throws IOException {
        if (!bufferedSource.rangeEquals(0, WEBP_FILE_HEADER_RIFF) || !bufferedSource.rangeEquals(8, WEBP_FILE_HEADER_WEBP)) {
            return false;
        }
        return true;
    }

    public static void t(String str, String str2, String str3) {
        u(str, str2, str3, "");
    }

    public static void u(String str, String str2, String str3, String str4) {
        String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4});
    }
}
