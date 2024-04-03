package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import com.huawei.hms.flutter.map.constants.Param;

public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        public static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        public static ModeCompat a(@NonNull Context context, @NonNull Display display) {
            Display.Mode mode = display.getMode();
            Point a11 = DisplayCompat.a(context, display);
            if (a11 == null || c(mode, a11)) {
                return new ModeCompat(mode, true);
            }
            return new ModeCompat(mode, a11);
        }

        public static boolean b(@NonNull Display display) {
            Display.Mode mode = display.getMode();
            for (Display.Mode mode2 : display.getSupportedModes()) {
                if (mode.getPhysicalHeight() < mode2.getPhysicalHeight() || mode.getPhysicalWidth() < mode2.getPhysicalWidth()) {
                    return false;
                }
            }
            return true;
        }

        public static boolean c(Display.Mode mode, Point point) {
            if ((mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x)) {
                return true;
            }
            return false;
        }

        public static boolean d(Display.Mode mode, Display.Mode mode2) {
            if (mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight()) {
                return true;
            }
            return false;
        }

        @SuppressLint({"ArrayReturn"})
        @NonNull
        public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
            ModeCompat modeCompat;
            Display.Mode[] supportedModes = display.getSupportedModes();
            ModeCompat[] modeCompatArr = new ModeCompat[supportedModes.length];
            Display.Mode mode = display.getMode();
            Point a11 = DisplayCompat.a(context, display);
            if (a11 == null || c(mode, a11)) {
                for (int i11 = 0; i11 < supportedModes.length; i11++) {
                    modeCompatArr[i11] = new ModeCompat(supportedModes[i11], d(supportedModes[i11], mode));
                }
            } else {
                for (int i12 = 0; i12 < supportedModes.length; i12++) {
                    if (d(supportedModes[i12], mode)) {
                        modeCompat = new ModeCompat(supportedModes[i12], a11);
                    } else {
                        modeCompat = new ModeCompat(supportedModes[i12], false);
                    }
                    modeCompatArr[i12] = modeCompat;
                }
            }
            return modeCompatArr;
        }
    }

    private DisplayCompat() {
    }

    public static Point a(@NonNull Context context, @NonNull Display display) {
        Point point;
        if (Build.VERSION.SDK_INT < 28) {
            point = parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display);
        } else {
            point = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        }
        if (point != null) {
            return point;
        }
        if (!isSonyBravia4kTv(context) || !b(display)) {
            return null;
        }
        return new Point(DISPLAY_SIZE_4K_WIDTH, DISPLAY_SIZE_4K_HEIGHT);
    }

    public static boolean b(@NonNull Display display) {
        return Api23Impl.b(display);
    }

    @NonNull
    private static Point getDisplaySize(@NonNull Context context, @NonNull Display display) {
        Point a11 = a(context, display);
        if (a11 != null) {
            return a11;
        }
        Point point = new Point();
        Api17Impl.a(display, point);
        return point;
    }

    @NonNull
    public static ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
        return Api23Impl.a(context, display);
    }

    @SuppressLint({"ArrayReturn"})
    @NonNull
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        return Api23Impl.getSupportedModes(context, display);
    }

    @Nullable
    private static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean isSonyBravia4kTv(@NonNull Context context) {
        if (!isTv(context) || !"Sony".equals(Build.MANUFACTURER) || !Build.MODEL.startsWith("BRAVIA") || !context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
            return false;
        }
        return true;
    }

    private static boolean isTv(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager == null || uiModeManager.getCurrentModeType() != 4) {
            return false;
        }
        return true;
    }

    private static Point parseDisplaySize(@NonNull String str) throws NumberFormatException {
        String[] split = str.trim().split(Param.X, -1);
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new Point(parseInt, parseInt2);
            }
        }
        throw new NumberFormatException();
    }

    @Nullable
    private static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String str, @NonNull Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String systemProperty = getSystemProperty(str);
        if (!TextUtils.isEmpty(systemProperty) && systemProperty != null) {
            try {
                return parseDisplaySize(systemProperty);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalSize;

        @RequiresApi(23)
        public static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            public static int a(Display.Mode mode) {
                return mode.getPhysicalHeight();
            }

            @DoNotInline
            public static int b(Display.Mode mode) {
                return mode.getPhysicalWidth();
            }
        }

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode mode, boolean z11) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(Api23Impl.b(mode), Api23Impl.a(mode));
            this.mMode = mode;
            this.mIsNative = z11;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalSize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalSize.x;
        }

        @Deprecated
        public boolean isNative() {
            return this.mIsNative;
        }

        @RequiresApi(23)
        @Nullable
        public Display.Mode toMode() {
            return this.mMode;
        }

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode mode, @NonNull Point point) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = mode;
            this.mIsNative = true;
        }
    }
}
