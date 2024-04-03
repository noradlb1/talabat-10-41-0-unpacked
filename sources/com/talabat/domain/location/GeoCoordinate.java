package com.talabat.domain.location;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0010\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\t\u0010\u0014\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/talabat/domain/location/GeoCoordinate;", "", "latitude", "", "longitude", "(DD)V", "getLatitude", "()D", "getLongitude", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toConcatenatedString", "", "delim", "toString", "Companion", "com_talabat_domain_location_location"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GeoCoordinate {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final GeoCoordinate ZERO = new GeoCoordinate(0.0d, 0.0d);
    private final double latitude;
    private final double longitude;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/domain/location/GeoCoordinate$Companion;", "", "()V", "ZERO", "Lcom/talabat/domain/location/GeoCoordinate;", "getZERO", "()Lcom/talabat/domain/location/GeoCoordinate;", "com_talabat_domain_location_location"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GeoCoordinate getZERO() {
            return GeoCoordinate.ZERO;
        }
    }

    public GeoCoordinate(double d11, double d12) {
        this.latitude = d11;
        this.longitude = d12;
    }

    public static /* synthetic */ GeoCoordinate copy$default(GeoCoordinate geoCoordinate, double d11, double d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = geoCoordinate.latitude;
        }
        if ((i11 & 2) != 0) {
            d12 = geoCoordinate.longitude;
        }
        return geoCoordinate.copy(d11, d12);
    }

    public static /* synthetic */ String toConcatenatedString$default(GeoCoordinate geoCoordinate, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = ",";
        }
        return geoCoordinate.toConcatenatedString(str);
    }

    public final double component1() {
        return this.latitude;
    }

    public final double component2() {
        return this.longitude;
    }

    @NotNull
    public final GeoCoordinate copy(double d11, double d12) {
        return new GeoCoordinate(d11, d12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeoCoordinate)) {
            return false;
        }
        GeoCoordinate geoCoordinate = (GeoCoordinate) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(geoCoordinate.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(geoCoordinate.longitude));
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        return (Double.doubleToLongBits(this.latitude) * 31) + Double.doubleToLongBits(this.longitude);
    }

    @NotNull
    public final String toConcatenatedString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "delim");
        double d11 = this.latitude;
        double d12 = this.longitude;
        return d11 + str + d12;
    }

    @NotNull
    public String toString() {
        double d11 = this.latitude;
        double d12 = this.longitude;
        return "GeoCoordinate(latitude=" + d11 + ", longitude=" + d12 + ")";
    }
}
