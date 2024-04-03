package com.talabat.gms.maps.data.model;

import com.talabat.gms.maps.data.ExtensionsKt;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.Marker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/talabat/gms/maps/data/model/GmsMarkerWrapper;", "Lcom/talabat/maps/domain/model/Marker;", "marker", "Lcom/google/android/gms/maps/model/Marker;", "(Lcom/google/android/gms/maps/model/Marker;)V", "value", "Lcom/talabat/maps/domain/model/LatLng;", "position", "getPosition", "()Lcom/talabat/maps/domain/model/LatLng;", "setPosition", "(Lcom/talabat/maps/domain/model/LatLng;)V", "remove", "", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsMarkerWrapper implements Marker {
    @NotNull
    private final com.google.android.gms.maps.model.Marker marker;

    public GmsMarkerWrapper(@NotNull com.google.android.gms.maps.model.Marker marker2) {
        Intrinsics.checkNotNullParameter(marker2, "marker");
        this.marker = marker2;
    }

    @NotNull
    public LatLng getPosition() {
        com.google.android.gms.maps.model.LatLng position = this.marker.getPosition();
        Intrinsics.checkNotNullExpressionValue(position, "marker.position");
        return new GmsLatLngWrapper(position);
    }

    public void remove() {
        this.marker.remove();
    }

    public void setPosition(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "value");
        this.marker.setPosition(ExtensionsKt.toGoogleLatLng(latLng));
    }
}
