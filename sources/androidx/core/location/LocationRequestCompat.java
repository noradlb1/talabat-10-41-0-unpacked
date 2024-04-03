package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.LocationRequest;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class LocationRequestCompat {
    private static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
    public static final long PASSIVE_INTERVAL = Long.MAX_VALUE;
    public static final int QUALITY_BALANCED_POWER_ACCURACY = 102;
    public static final int QUALITY_HIGH_ACCURACY = 100;
    public static final int QUALITY_LOW_POWER = 104;

    /* renamed from: a  reason: collision with root package name */
    public final int f11319a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11320b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11321c;

    /* renamed from: d  reason: collision with root package name */
    public final long f11322d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11323e;

    /* renamed from: f  reason: collision with root package name */
    public final float f11324f;

    /* renamed from: g  reason: collision with root package name */
    public final long f11325g;

    @RequiresApi(19)
    public static class Api19Impl {
        private static Method sCreateFromDeprecatedProviderMethod;
        private static Class<?> sLocationRequestClass;
        private static Method sSetExpireInMethod;
        private static Method sSetFastestIntervalMethod;
        private static Method sSetNumUpdatesMethod;
        private static Method sSetQualityMethod;

        private Api19Impl() {
        }

        public static Object toLocationRequest(LocationRequestCompat locationRequestCompat, String str) {
            try {
                if (sLocationRequestClass == null) {
                    sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                if (sCreateFromDeprecatedProviderMethod == null) {
                    Method declaredMethod = sLocationRequestClass.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE});
                    sCreateFromDeprecatedProviderMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Object invoke = sCreateFromDeprecatedProviderMethod.invoke((Object) null, new Object[]{str, Long.valueOf(locationRequestCompat.getIntervalMillis()), Float.valueOf(locationRequestCompat.getMinUpdateDistanceMeters()), Boolean.FALSE});
                if (invoke == null) {
                    return null;
                }
                if (sSetQualityMethod == null) {
                    Method declaredMethod2 = sLocationRequestClass.getDeclaredMethod("setQuality", new Class[]{Integer.TYPE});
                    sSetQualityMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                sSetQualityMethod.invoke(invoke, new Object[]{Integer.valueOf(locationRequestCompat.getQuality())});
                if (sSetFastestIntervalMethod == null) {
                    Method declaredMethod3 = sLocationRequestClass.getDeclaredMethod("setFastestInterval", new Class[]{Long.TYPE});
                    sSetFastestIntervalMethod = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                sSetFastestIntervalMethod.invoke(invoke, new Object[]{Long.valueOf(locationRequestCompat.getMinUpdateIntervalMillis())});
                if (locationRequestCompat.getMaxUpdates() < Integer.MAX_VALUE) {
                    if (sSetNumUpdatesMethod == null) {
                        Method declaredMethod4 = sLocationRequestClass.getDeclaredMethod("setNumUpdates", new Class[]{Integer.TYPE});
                        sSetNumUpdatesMethod = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    sSetNumUpdatesMethod.invoke(invoke, new Object[]{Integer.valueOf(locationRequestCompat.getMaxUpdates())});
                }
                if (locationRequestCompat.getDurationMillis() < Long.MAX_VALUE) {
                    if (sSetExpireInMethod == null) {
                        Method declaredMethod5 = sLocationRequestClass.getDeclaredMethod("setExpireIn", new Class[]{Long.TYPE});
                        sSetExpireInMethod = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    sSetExpireInMethod.invoke(invoke, new Object[]{Long.valueOf(locationRequestCompat.getDurationMillis())});
                }
                return invoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static LocationRequest toLocationRequest(LocationRequestCompat locationRequestCompat) {
            return new LocationRequest.Builder(locationRequestCompat.getIntervalMillis()).setQuality(locationRequestCompat.getQuality()).setMinUpdateIntervalMillis(locationRequestCompat.getMinUpdateIntervalMillis()).setDurationMillis(locationRequestCompat.getDurationMillis()).setMaxUpdates(locationRequestCompat.getMaxUpdates()).setMinUpdateDistanceMeters(locationRequestCompat.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(locationRequestCompat.getMaxUpdateDelayMillis()).build();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
    }

    public LocationRequestCompat(long j11, int i11, long j12, int i12, long j13, float f11, long j14) {
        this.f11320b = j11;
        this.f11319a = i11;
        this.f11321c = j13;
        this.f11322d = j12;
        this.f11323e = i12;
        this.f11324f = f11;
        this.f11325g = j14;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequestCompat)) {
            return false;
        }
        LocationRequestCompat locationRequestCompat = (LocationRequestCompat) obj;
        if (this.f11319a == locationRequestCompat.f11319a && this.f11320b == locationRequestCompat.f11320b && this.f11321c == locationRequestCompat.f11321c && this.f11322d == locationRequestCompat.f11322d && this.f11323e == locationRequestCompat.f11323e && Float.compare(locationRequestCompat.f11324f, this.f11324f) == 0 && this.f11325g == locationRequestCompat.f11325g) {
            return true;
        }
        return false;
    }

    @IntRange(from = 1)
    public long getDurationMillis() {
        return this.f11322d;
    }

    @IntRange(from = 0)
    public long getIntervalMillis() {
        return this.f11320b;
    }

    @IntRange(from = 0)
    public long getMaxUpdateDelayMillis() {
        return this.f11325g;
    }

    @IntRange(from = 1, to = 2147483647L)
    public int getMaxUpdates() {
        return this.f11323e;
    }

    @FloatRange(from = 0.0d, to = 3.4028234663852886E38d)
    public float getMinUpdateDistanceMeters() {
        return this.f11324f;
    }

    @IntRange(from = 0)
    public long getMinUpdateIntervalMillis() {
        long j11 = this.f11321c;
        if (j11 == -1) {
            return this.f11320b;
        }
        return j11;
    }

    public int getQuality() {
        return this.f11319a;
    }

    public int hashCode() {
        long j11 = this.f11320b;
        long j12 = this.f11321c;
        return (((this.f11319a * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)));
    }

    @RequiresApi(31)
    @NonNull
    public LocationRequest toLocationRequest() {
        return Api31Impl.toLocationRequest(this);
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request[");
        if (this.f11320b != Long.MAX_VALUE) {
            sb2.append("@");
            TimeUtils.formatDuration(this.f11320b, sb2);
            int i11 = this.f11319a;
            if (i11 == 100) {
                sb2.append(" HIGH_ACCURACY");
            } else if (i11 == 102) {
                sb2.append(" BALANCED");
            } else if (i11 == 104) {
                sb2.append(" LOW_POWER");
            }
        } else {
            sb2.append("PASSIVE");
        }
        if (this.f11322d != Long.MAX_VALUE) {
            sb2.append(", duration=");
            TimeUtils.formatDuration(this.f11322d, sb2);
        }
        if (this.f11323e != Integer.MAX_VALUE) {
            sb2.append(", maxUpdates=");
            sb2.append(this.f11323e);
        }
        long j11 = this.f11321c;
        if (j11 != -1 && j11 < this.f11320b) {
            sb2.append(", minUpdateInterval=");
            TimeUtils.formatDuration(this.f11321c, sb2);
        }
        if (((double) this.f11324f) > 0.0d) {
            sb2.append(", minUpdateDistance=");
            sb2.append(this.f11324f);
        }
        if (this.f11325g / 2 > this.f11320b) {
            sb2.append(", maxUpdateDelay=");
            TimeUtils.formatDuration(this.f11325g, sb2);
        }
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    @RequiresApi(19)
    @SuppressLint({"NewApi"})
    @Nullable
    public LocationRequest toLocationRequest(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return toLocationRequest();
        }
        return (LocationRequest) Api19Impl.toLocationRequest(this, str);
    }

    public static final class Builder {
        private long mDurationMillis;
        private long mIntervalMillis;
        private long mMaxUpdateDelayMillis;
        private int mMaxUpdates;
        private float mMinUpdateDistanceMeters;
        private long mMinUpdateIntervalMillis;
        private int mQuality;

        public Builder(long j11) {
            setIntervalMillis(j11);
            this.mQuality = 102;
            this.mDurationMillis = Long.MAX_VALUE;
            this.mMaxUpdates = Integer.MAX_VALUE;
            this.mMinUpdateIntervalMillis = -1;
            this.mMinUpdateDistanceMeters = 0.0f;
            this.mMaxUpdateDelayMillis = 0;
        }

        @NonNull
        public LocationRequestCompat build() {
            boolean z11;
            if (this.mIntervalMillis == Long.MAX_VALUE && this.mMinUpdateIntervalMillis == -1) {
                z11 = false;
            } else {
                z11 = true;
            }
            Preconditions.checkState(z11, "passive location requests must have an explicit minimum update interval");
            long j11 = this.mIntervalMillis;
            return new LocationRequestCompat(j11, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, j11), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
        }

        @NonNull
        public Builder clearMinUpdateIntervalMillis() {
            this.mMinUpdateIntervalMillis = -1;
            return this;
        }

        @NonNull
        public Builder setDurationMillis(@IntRange(from = 1) long j11) {
            this.mDurationMillis = Preconditions.checkArgumentInRange(j11, 1, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        @NonNull
        public Builder setIntervalMillis(@IntRange(from = 0) long j11) {
            this.mIntervalMillis = Preconditions.checkArgumentInRange(j11, 0, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        @NonNull
        public Builder setMaxUpdateDelayMillis(@IntRange(from = 0) long j11) {
            this.mMaxUpdateDelayMillis = j11;
            this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(j11, 0, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        @NonNull
        public Builder setMaxUpdates(@IntRange(from = 1, to = 2147483647L) int i11) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(i11, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        @NonNull
        public Builder setMinUpdateDistanceMeters(@FloatRange(from = 0.0d, to = 3.4028234663852886E38d) float f11) {
            this.mMinUpdateDistanceMeters = f11;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(f11, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        @NonNull
        public Builder setMinUpdateIntervalMillis(@IntRange(from = 0) long j11) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(j11, 0, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        @NonNull
        public Builder setQuality(int i11) {
            boolean z11;
            if (i11 == 104 || i11 == 102 || i11 == 100) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i11));
            this.mQuality = i11;
            return this;
        }

        public Builder(@NonNull LocationRequestCompat locationRequestCompat) {
            this.mIntervalMillis = locationRequestCompat.f11320b;
            this.mQuality = locationRequestCompat.f11319a;
            this.mDurationMillis = locationRequestCompat.f11322d;
            this.mMaxUpdates = locationRequestCompat.f11323e;
            this.mMinUpdateIntervalMillis = locationRequestCompat.f11321c;
            this.mMinUpdateDistanceMeters = locationRequestCompat.f11324f;
            this.mMaxUpdateDelayMillis = locationRequestCompat.f11325g;
        }
    }
}
