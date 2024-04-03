package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import tracking.deeplink.AppUrlResult;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class GpsStatusWrapper extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;
    @GuardedBy("mWrapped")
    private Iterator<GpsSatellite> mCachedIterator;
    @GuardedBy("mWrapped")
    private int mCachedIteratorPosition;
    @GuardedBy("mWrapped")
    private GpsSatellite mCachedSatellite;
    @GuardedBy("mWrapped")
    private int mCachedSatelliteCount = -1;
    private final GpsStatus mWrapped;

    public GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.mWrapped = gpsStatus2;
        this.mCachedIterator = gpsStatus2.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    private static int getConstellationFromPrn(int i11) {
        if (i11 > 0 && i11 <= 32) {
            return 1;
        }
        if (i11 >= 33 && i11 <= 64) {
            return 2;
        }
        if (i11 > 64 && i11 <= 88) {
            return 3;
        }
        if (i11 <= 200 || i11 > 235) {
            return (i11 < 193 || i11 > 200) ? 0 : 4;
        }
        return 5;
    }

    private GpsSatellite getSatellite(int i11) {
        GpsSatellite gpsSatellite;
        synchronized (this.mWrapped) {
            if (i11 < this.mCachedIteratorPosition) {
                this.mCachedIterator = this.mWrapped.getSatellites().iterator();
                this.mCachedIteratorPosition = -1;
            }
            while (true) {
                int i12 = this.mCachedIteratorPosition;
                if (i12 >= i11) {
                    break;
                }
                this.mCachedIteratorPosition = i12 + 1;
                if (!this.mCachedIterator.hasNext()) {
                    this.mCachedSatellite = null;
                    break;
                }
                this.mCachedSatellite = this.mCachedIterator.next();
            }
            gpsSatellite = this.mCachedSatellite;
        }
        return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
    }

    private static int getSvidFromPrn(int i11) {
        int constellationFromPrn = getConstellationFromPrn(i11);
        return constellationFromPrn != 2 ? constellationFromPrn != 3 ? constellationFromPrn != 5 ? i11 : i11 + AppUrlResult.dataError : i11 - 64 : i11 + 87;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GpsStatusWrapper)) {
            return false;
        }
        return this.mWrapped.equals(((GpsStatusWrapper) obj).mWrapped);
    }

    public float getAzimuthDegrees(int i11) {
        return getSatellite(i11).getAzimuth();
    }

    public float getBasebandCn0DbHz(int i11) {
        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int i11) {
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int i11) {
        return getSatellite(i11).getSnr();
    }

    public int getConstellationType(int i11) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return getConstellationFromPrn(getSatellite(i11).getPrn());
    }

    public float getElevationDegrees(int i11) {
        return getSatellite(i11).getElevation();
    }

    public int getSatelliteCount() {
        int i11;
        synchronized (this.mWrapped) {
            if (this.mCachedSatelliteCount == -1) {
                for (GpsSatellite next : this.mWrapped.getSatellites()) {
                    this.mCachedSatelliteCount++;
                }
                this.mCachedSatelliteCount++;
            }
            i11 = this.mCachedSatelliteCount;
        }
        return i11;
    }

    public int getSvid(int i11) {
        if (Build.VERSION.SDK_INT < 24) {
            return getSatellite(i11).getPrn();
        }
        return getSvidFromPrn(getSatellite(i11).getPrn());
    }

    public boolean hasAlmanacData(int i11) {
        return getSatellite(i11).hasAlmanac();
    }

    public boolean hasBasebandCn0DbHz(int i11) {
        return false;
    }

    public boolean hasCarrierFrequencyHz(int i11) {
        return false;
    }

    public boolean hasEphemerisData(int i11) {
        return getSatellite(i11).hasEphemeris();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int i11) {
        return getSatellite(i11).usedInFix();
    }
}
