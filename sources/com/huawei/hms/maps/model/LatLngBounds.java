package com.huawei.hms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.common.util.Objects;
import com.huawei.hms.maps.HuaweiMapOptions;
import com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl;
import java.math.BigDecimal;

public class LatLngBounds implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new Parcelable.Creator<LatLngBounds>() {
        public LatLngBounds createFromParcel(Parcel parcel) {
            return new LatLngBounds(parcel);
        }

        public LatLngBounds[] newArray(int i11) {
            return new LatLngBounds[i11];
        }
    };
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private double f49490a = Double.MAX_VALUE;

        /* renamed from: b  reason: collision with root package name */
        private double f49491b = -1.7976931348623157E308d;

        /* renamed from: c  reason: collision with root package name */
        private double f49492c = Double.NaN;

        /* renamed from: d  reason: collision with root package name */
        private double f49493d = Double.NaN;

        public LatLngBounds build() {
            Preconditions.checkState(!Double.isNaN(this.f49492c), "no points in the bounds");
            return new LatLngBounds(new LatLng(this.f49490a, this.f49492c), new LatLng(this.f49491b, this.f49493d));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
            if (java.lang.Math.abs(r0 - r2) >= 1.0E-6d) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
            if (java.lang.Math.abs(r0 - r2) >= 1.0E-6d) goto L_0x004f;
         */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0083  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x008f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.huawei.hms.maps.model.LatLngBounds.Builder include(com.huawei.hms.maps.model.LatLng r11) {
            /*
                r10 = this;
                double r0 = r10.f49490a
                double r2 = r11.latitude
                double r0 = java.lang.Math.min(r0, r2)
                r10.f49490a = r0
                double r0 = r10.f49491b
                double r2 = r11.latitude
                double r0 = java.lang.Math.max(r0, r2)
                r10.f49491b = r0
                double r0 = r11.longitude
                double r2 = r10.f49492c
                double r4 = r10.f49493d
                int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                r6 = 0
                r7 = 1
                r8 = 4517329193108106637(0x3eb0c6f7a0b5ed8d, double:1.0E-6)
                if (r11 < 0) goto L_0x0053
                double r2 = r2 - r4
                double r2 = java.lang.Math.abs(r2)
                int r11 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r11 >= 0) goto L_0x002f
                goto L_0x0053
            L_0x002f:
                double r2 = r10.f49492c
                int r11 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r11 < 0) goto L_0x0051
                double r2 = r2 - r0
                double r2 = java.lang.Math.abs(r2)
                int r11 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r11 < 0) goto L_0x0051
                double r2 = r10.f49493d
                int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r11 < 0) goto L_0x0051
                double r2 = r0 - r2
                double r2 = java.lang.Math.abs(r2)
                int r11 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r11 >= 0) goto L_0x004f
                goto L_0x0051
            L_0x004f:
                r11 = r6
                goto L_0x0073
            L_0x0051:
                r11 = r7
                goto L_0x0073
            L_0x0053:
                double r2 = r10.f49492c
                int r11 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r11 < 0) goto L_0x0062
                double r2 = r2 - r0
                double r2 = java.lang.Math.abs(r2)
                int r11 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r11 >= 0) goto L_0x004f
            L_0x0062:
                double r2 = r10.f49493d
                int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r11 < 0) goto L_0x0051
                double r2 = r0 - r2
                double r2 = java.lang.Math.abs(r2)
                int r11 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r11 >= 0) goto L_0x004f
                goto L_0x0051
            L_0x0073:
                double r2 = r10.f49492c
                double r2 = com.huawei.hms.maps.model.LatLngBounds.c(r2, r0)
                double r4 = r10.f49493d
                double r4 = com.huawei.hms.maps.model.LatLngBounds.d(r4, r0)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 >= 0) goto L_0x0084
                r6 = r7
            L_0x0084:
                double r2 = r10.f49492c
                boolean r2 = java.lang.Double.isNaN(r2)
                if (r2 == 0) goto L_0x008f
                r10.f49492c = r0
                goto L_0x0097
            L_0x008f:
                if (r11 == 0) goto L_0x0092
                return r10
            L_0x0092:
                if (r6 == 0) goto L_0x0097
                r10.f49492c = r0
                return r10
            L_0x0097:
                r10.f49493d = r0
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.maps.model.LatLngBounds.Builder.include(com.huawei.hms.maps.model.LatLng):com.huawei.hms.maps.model.LatLngBounds$Builder");
        }
    }

    public LatLngBounds(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        Parcelable.Creator creator = LatLng.CREATOR;
        this.southwest = (LatLng) parcelReader.readParcelable(2, creator, null);
        this.northeast = (LatLng) parcelReader.readParcelable(3, creator, null);
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        Preconditions.checkNotNull(latLng, "southwest can not be null");
        Preconditions.checkNotNull(latLng2, "northeast can not be null");
        if (!Double.isNaN(latLng2.latitude) && !Double.isNaN(latLng.latitude)) {
            double d11 = latLng2.latitude;
            double d12 = latLng.latitude;
            Preconditions.checkArgument(d11 >= d12, "southern latitude >= northern latitude", Double.valueOf(d12), Double.valueOf(latLng2.latitude));
        }
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    private boolean a(double d11) {
        double d12 = this.southwest.longitude;
        if (d12 > this.northeast.longitude) {
            if (d12 >= d11 && Math.abs(d12 - d11) >= 1.0E-6d) {
                double d13 = this.northeast.longitude;
                if (d11 >= d13 && Math.abs(d11 - d13) >= 1.0E-6d) {
                    return false;
                }
            }
            return true;
        } else if (d12 >= d11 && Math.abs(d12 - d11) >= 1.0E-6d) {
            return false;
        } else {
            double d14 = this.northeast.longitude;
            return d11 < d14 || Math.abs(d11 - d14) < 1.0E-6d;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    public static double c(double d11, double d12) {
        return ((d11 - d12) + 360.0d) % 360.0d;
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attributeSet) {
        return HuaweiMapOptions.buildLatLngBounds(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public static double d(double d11, double d12) {
        return ((d12 - d11) + 360.0d) % 360.0d;
    }

    public final boolean contains(LatLng latLng) {
        double d11 = latLng.latitude;
        return this.southwest.latitude <= d11 && d11 <= this.northeast.latitude && a(latLng.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final LatLng getCenter() {
        double doubleValue = new BigDecimal(this.southwest.latitude).add(new BigDecimal(this.northeast.latitude)).divide(new BigDecimal(BNPLManagerRepositoryImpl.VERSION_NUMBER)).doubleValue();
        double d11 = this.northeast.longitude;
        double d12 = this.southwest.longitude;
        if (d12 > d11) {
            d11 += 360.0d;
        }
        return new LatLng(doubleValue, (d11 + d12) / 2.0d);
    }

    public final int hashCode() {
        return Objects.hashCode(this.southwest, this.northeast);
    }

    public final LatLngBounds including(LatLng latLng) {
        LatLng latLng2 = new LatLng(Math.min(this.southwest.latitude, latLng.latitude), this.southwest.longitude);
        LatLng latLng3 = new LatLng(Math.max(this.northeast.latitude, latLng.latitude), this.northeast.longitude);
        if (a(latLng.longitude)) {
            return new LatLngBounds(latLng2, latLng3);
        }
        double d11 = c(latLng2.longitude, latLng.longitude) < d(latLng3.longitude, latLng.longitude) ? latLng.longitude : latLng2.longitude;
        latLng2.longitude = d11;
        latLng3.longitude = c(d11, latLng.longitude) < d(latLng3.longitude, latLng.longitude) ? latLng3.longitude : latLng.longitude;
        return new LatLngBounds(latLng2, latLng3);
    }

    public final String toString() {
        return "LatLngBounds:southwest point is" + this.southwest + ",northeast point is" + this.northeast;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeParcelable(2, this.southwest, i11, false);
        parcelWrite.writeParcelable(3, this.northeast, i11, false);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
