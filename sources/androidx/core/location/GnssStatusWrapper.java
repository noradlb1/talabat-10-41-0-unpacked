package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float a(GnssStatus gnssStatus, int i11) {
            return gnssStatus.getCarrierFrequencyHz(i11);
        }

        @DoNotInline
        public static boolean b(GnssStatus gnssStatus, int i11) {
            return gnssStatus.hasCarrierFrequencyHz(i11);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static float a(GnssStatus gnssStatus, int i11) {
            return gnssStatus.getBasebandCn0DbHz(i11);
        }

        @DoNotInline
        public static boolean b(GnssStatus gnssStatus, int i11) {
            return gnssStatus.hasBasebandCn0DbHz(i11);
        }
    }

    public GnssStatusWrapper(Object obj) {
        this.mWrapped = (GnssStatus) Preconditions.checkNotNull((GnssStatus) obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GnssStatusWrapper)) {
            return false;
        }
        return this.mWrapped.equals(((GnssStatusWrapper) obj).mWrapped);
    }

    public float getAzimuthDegrees(int i11) {
        return this.mWrapped.getAzimuthDegrees(i11);
    }

    public float getBasebandCn0DbHz(int i11) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.a(this.mWrapped, i11);
        }
        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int i11) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(this.mWrapped, i11);
        }
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int i11) {
        return this.mWrapped.getCn0DbHz(i11);
    }

    public int getConstellationType(int i11) {
        return this.mWrapped.getConstellationType(i11);
    }

    public float getElevationDegrees(int i11) {
        return this.mWrapped.getElevationDegrees(i11);
    }

    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    public int getSvid(int i11) {
        return this.mWrapped.getSvid(i11);
    }

    public boolean hasAlmanacData(int i11) {
        return this.mWrapped.hasAlmanacData(i11);
    }

    public boolean hasBasebandCn0DbHz(int i11) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.b(this.mWrapped, i11);
        }
        return false;
    }

    public boolean hasCarrierFrequencyHz(int i11) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(this.mWrapped, i11);
        }
        return false;
    }

    public boolean hasEphemerisData(int i11) {
        return this.mWrapped.hasEphemerisData(i11);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int i11) {
        return this.mWrapped.usedInFix(i11);
    }
}
