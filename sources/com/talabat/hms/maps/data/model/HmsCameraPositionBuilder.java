package com.talabat.hms.maps.data.model;

import com.huawei.hms.maps.model.CameraPosition;
import com.talabat.hms.maps.data.ExtensionsKt;
import com.talabat.maps.domain.model.CameraPosition;
import com.talabat.maps.domain.model.LatLng;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/hms/maps/data/model/HmsCameraPositionBuilder;", "Lcom/talabat/maps/domain/model/CameraPosition$Builder;", "huaweiCameraPositionBuilder", "Lcom/huawei/hms/maps/model/CameraPosition$Builder;", "(Lcom/huawei/hms/maps/model/CameraPosition$Builder;)V", "bearing", "var1", "", "build", "Lcom/talabat/maps/domain/model/CameraPosition;", "target", "Lcom/talabat/maps/domain/model/LatLng;", "tilt", "zoom", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsCameraPositionBuilder implements CameraPosition.Builder {
    @NotNull
    private final CameraPosition.Builder huaweiCameraPositionBuilder;

    @Inject
    public HmsCameraPositionBuilder(@NotNull CameraPosition.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "huaweiCameraPositionBuilder");
        this.huaweiCameraPositionBuilder = builder;
    }

    @NotNull
    public CameraPosition.Builder bearing(float f11) {
        this.huaweiCameraPositionBuilder.bearing(f11);
        return this;
    }

    @NotNull
    public com.talabat.maps.domain.model.CameraPosition build() {
        com.huawei.hms.maps.model.CameraPosition build = this.huaweiCameraPositionBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "huaweiCameraPositionBuilder.build()");
        return new HmsCameraPositionWrapper(build);
    }

    @NotNull
    public CameraPosition.Builder target(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "var1");
        this.huaweiCameraPositionBuilder.target(ExtensionsKt.toHuaweiLatLng(latLng));
        return this;
    }

    @NotNull
    public CameraPosition.Builder tilt(float f11) {
        this.huaweiCameraPositionBuilder.tilt(f11);
        return this;
    }

    @NotNull
    public CameraPosition.Builder zoom(float f11) {
        this.huaweiCameraPositionBuilder.zoom(f11);
        return this;
    }
}
