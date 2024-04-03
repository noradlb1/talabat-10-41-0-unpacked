package com.talabat.hms.maps.data.model;

import com.talabat.maps.domain.model.CameraPosition;
import com.talabat.maps.domain.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/talabat/hms/maps/data/model/HmsCameraPositionWrapper;", "Lcom/talabat/maps/domain/model/CameraPosition;", "original", "Lcom/huawei/hms/maps/model/CameraPosition;", "(Lcom/huawei/hms/maps/model/CameraPosition;)V", "bearing", "", "getBearing", "()F", "getOriginal", "()Lcom/huawei/hms/maps/model/CameraPosition;", "target", "Lcom/talabat/maps/domain/model/LatLng;", "getTarget", "()Lcom/talabat/maps/domain/model/LatLng;", "tilt", "getTilt", "zoom", "getZoom", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsCameraPositionWrapper implements CameraPosition {
    @NotNull
    private final com.huawei.hms.maps.model.CameraPosition original;

    public HmsCameraPositionWrapper(@NotNull com.huawei.hms.maps.model.CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(cameraPosition, "original");
        this.original = cameraPosition;
    }

    public float getBearing() {
        return this.original.bearing;
    }

    @NotNull
    public final com.huawei.hms.maps.model.CameraPosition getOriginal() {
        return this.original;
    }

    @NotNull
    public LatLng getTarget() {
        com.huawei.hms.maps.model.LatLng latLng = this.original.target;
        Intrinsics.checkNotNullExpressionValue(latLng, "original.target");
        return new HmsLatLngWrapper(latLng);
    }

    public float getTilt() {
        return this.original.tilt;
    }

    public float getZoom() {
        return this.original.zoom;
    }
}
