package com.talabat.feature.pickup.data.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/pickup/data/entity/LatLngDto;", "", "lat", "", "lon", "(DD)V", "getLat", "()D", "getLon", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LatLngDto {
    private final double lat;
    private final double lon;

    public LatLngDto(double d11, double d12) {
        this.lat = d11;
        this.lon = d12;
    }

    public static /* synthetic */ LatLngDto copy$default(LatLngDto latLngDto, double d11, double d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = latLngDto.lat;
        }
        if ((i11 & 2) != 0) {
            d12 = latLngDto.lon;
        }
        return latLngDto.copy(d11, d12);
    }

    public final double component1() {
        return this.lat;
    }

    public final double component2() {
        return this.lon;
    }

    @NotNull
    public final LatLngDto copy(double d11, double d12) {
        return new LatLngDto(d11, d12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngDto)) {
            return false;
        }
        LatLngDto latLngDto = (LatLngDto) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.lat), (Object) Double.valueOf(latLngDto.lat)) && Intrinsics.areEqual((Object) Double.valueOf(this.lon), (Object) Double.valueOf(latLngDto.lon));
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    public int hashCode() {
        return (Double.doubleToLongBits(this.lat) * 31) + Double.doubleToLongBits(this.lon);
    }

    @NotNull
    public String toString() {
        double d11 = this.lat;
        double d12 = this.lon;
        return "LatLngDto(lat=" + d11 + ", lon=" + d12 + ")";
    }
}
