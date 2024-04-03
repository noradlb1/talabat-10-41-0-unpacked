package com.talabat.gms.maps.data.model;

import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.LatLngBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/talabat/gms/maps/data/model/GmsLatLngBoundsWrapper;", "Lcom/talabat/maps/domain/model/LatLngBounds;", "googleLatLngBounds", "Lcom/google/android/gms/maps/model/LatLngBounds;", "(Lcom/google/android/gms/maps/model/LatLngBounds;)V", "center", "Lcom/talabat/maps/domain/model/LatLng;", "getCenter", "()Lcom/talabat/maps/domain/model/LatLng;", "getGoogleLatLngBounds", "()Lcom/google/android/gms/maps/model/LatLngBounds;", "northeast", "getNortheast", "southwest", "getSouthwest", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsLatLngBoundsWrapper implements LatLngBounds {
    @NotNull
    private final com.google.android.gms.maps.model.LatLngBounds googleLatLngBounds;

    public GmsLatLngBoundsWrapper(@NotNull com.google.android.gms.maps.model.LatLngBounds latLngBounds) {
        Intrinsics.checkNotNullParameter(latLngBounds, "googleLatLngBounds");
        this.googleLatLngBounds = latLngBounds;
    }

    @NotNull
    public LatLng getCenter() {
        com.google.android.gms.maps.model.LatLng center = this.googleLatLngBounds.getCenter();
        Intrinsics.checkNotNullExpressionValue(center, "googleLatLngBounds.center");
        return new GmsLatLngWrapper(center);
    }

    @NotNull
    public final com.google.android.gms.maps.model.LatLngBounds getGoogleLatLngBounds() {
        return this.googleLatLngBounds;
    }

    @NotNull
    public LatLng getNortheast() {
        com.google.android.gms.maps.model.LatLng latLng = this.googleLatLngBounds.northeast;
        Intrinsics.checkNotNullExpressionValue(latLng, "googleLatLngBounds.northeast");
        return new GmsLatLngWrapper(latLng);
    }

    @NotNull
    public LatLng getSouthwest() {
        com.google.android.gms.maps.model.LatLng latLng = this.googleLatLngBounds.southwest;
        Intrinsics.checkNotNullExpressionValue(latLng, "googleLatLngBounds.southwest");
        return new GmsLatLngWrapper(latLng);
    }
}
