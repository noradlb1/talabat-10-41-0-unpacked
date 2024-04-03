package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/Point;", "", "longitude", "", "latitude", "(DD)V", "getLatitude", "()D", "getLongitude", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Point {
    private final double latitude;
    private final double longitude;

    public Point(double d11, double d12) {
        this.longitude = d11;
        this.latitude = d12;
    }

    public static /* synthetic */ Point copy$default(Point point, double d11, double d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = point.longitude;
        }
        if ((i11 & 2) != 0) {
            d12 = point.latitude;
        }
        return point.copy(d11, d12);
    }

    public final double component1() {
        return this.longitude;
    }

    public final double component2() {
        return this.latitude;
    }

    @NotNull
    public final Point copy(double d11, double d12) {
        return new Point(d11, d12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(point.longitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(point.latitude));
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        return (Double.doubleToLongBits(this.longitude) * 31) + Double.doubleToLongBits(this.latitude);
    }

    @NotNull
    public String toString() {
        double d11 = this.longitude;
        double d12 = this.latitude;
        return "Point(longitude=" + d11 + ", latitude=" + d12 + ")";
    }
}
