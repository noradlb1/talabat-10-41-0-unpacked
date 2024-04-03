package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    @Nullable
    private static Method sSetIsFromMockProviderMethod;

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static long a(Location location) {
            return location.getElapsedRealtimeNanos();
        }
    }

    @RequiresApi(18)
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static boolean a(Location location) {
            return location.isFromMockProvider();
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float a(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        @DoNotInline
        public static float b(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        @DoNotInline
        public static float c(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        @DoNotInline
        public static boolean d(Location location) {
            return location.hasBearingAccuracy();
        }

        @DoNotInline
        public static boolean e(Location location) {
            return location.hasSpeedAccuracy();
        }

        @DoNotInline
        public static boolean f(Location location) {
            return location.hasVerticalAccuracy();
        }

        @DoNotInline
        public static void g(Location location, float f11) {
            location.setBearingAccuracyDegrees(f11);
        }

        @DoNotInline
        public static void h(Location location, float f11) {
            location.setSpeedAccuracyMetersPerSecond(f11);
        }

        @DoNotInline
        public static void i(Location location, float f11) {
            location.setVerticalAccuracyMeters(f11);
        }
    }

    private LocationCompat() {
    }

    private static boolean containsExtra(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras == null || !extras.containsKey(str)) {
            return false;
        }
        return true;
    }

    public static float getBearingAccuracyDegrees(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    }

    public static long getElapsedRealtimeMillis(@NonNull Location location) {
        return TimeUnit.NANOSECONDS.toMillis(Api17Impl.a(location));
    }

    public static long getElapsedRealtimeNanos(@NonNull Location location) {
        return Api17Impl.a(location);
    }

    @FloatRange(from = 0.0d)
    public static float getMslAltitudeAccuracyMeters(@NonNull Location location) {
        Preconditions.checkState(hasMslAltitudeAccuracy(location), "The Mean Sea Level altitude accuracy of the location is not set.");
        return getOrCreateExtras(location).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static double getMslAltitudeMeters(@NonNull Location location) {
        Preconditions.checkState(hasMslAltitude(location), "The Mean Sea Level altitude of the location is not set.");
        return getOrCreateExtras(location).getDouble(EXTRA_MSL_ALTITUDE);
    }

    private static Bundle getOrCreateExtras(@NonNull Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras;
        }
        location.setExtras(new Bundle());
        return location.getExtras();
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
            sSetIsFromMockProviderMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    }

    public static float getVerticalAccuracyMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.c(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat("verticalAccuracy", 0.0f);
    }

    public static boolean hasBearingAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.d(location);
        }
        return containsExtra(location, EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasMslAltitude(@NonNull Location location) {
        return containsExtra(location, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(@NonNull Location location) {
        return containsExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.e(location);
        }
        return containsExtra(location, EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.f(location);
        }
        return containsExtra(location, "verticalAccuracy");
    }

    public static boolean isMock(@NonNull Location location) {
        return Api18Impl.a(location);
    }

    private static void removeExtra(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            extras.remove(str);
            if (extras.isEmpty()) {
                location.setExtras((Bundle) null);
            }
        }
    }

    public static void removeMslAltitude(@NonNull Location location) {
        removeExtra(location, EXTRA_MSL_ALTITUDE);
    }

    public static void removeMslAltitudeAccuracy(@NonNull Location location) {
        removeExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void setBearingAccuracyDegrees(@NonNull Location location, float f11) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.g(location, f11);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_BEARING_ACCURACY, f11);
        }
    }

    public static void setMock(@NonNull Location location, boolean z11) {
        try {
            getSetIsFromMockProviderMethod().invoke(location, new Object[]{Boolean.valueOf(z11)});
        } catch (NoSuchMethodException e11) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e11);
            throw noSuchMethodError;
        } catch (IllegalAccessException e12) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e12);
            throw illegalAccessError;
        } catch (InvocationTargetException e13) {
            throw new RuntimeException(e13);
        }
    }

    public static void setMslAltitudeAccuracyMeters(@NonNull Location location, @FloatRange(from = 0.0d) float f11) {
        getOrCreateExtras(location).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, f11);
    }

    public static void setMslAltitudeMeters(@NonNull Location location, double d11) {
        getOrCreateExtras(location).putDouble(EXTRA_MSL_ALTITUDE, d11);
    }

    public static void setSpeedAccuracyMetersPerSecond(@NonNull Location location, float f11) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.h(location, f11);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_SPEED_ACCURACY, f11);
        }
    }

    public static void setVerticalAccuracyMeters(@NonNull Location location, float f11) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.i(location, f11);
        } else {
            getOrCreateExtras(location).putFloat("verticalAccuracy", f11);
        }
    }
}
