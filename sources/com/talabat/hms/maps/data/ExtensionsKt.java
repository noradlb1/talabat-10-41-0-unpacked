package com.talabat.hms.maps.data;

import com.huawei.hms.maps.CameraUpdate;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.PolygonOptions;
import com.talabat.hms.maps.data.model.HmsCameraPositionWrapper;
import com.talabat.hms.maps.data.model.HmsCameraUpdateWrapper;
import com.talabat.hms.maps.data.model.HmsLatLngBoundsWrapper;
import com.talabat.hms.maps.data.model.HmsLatLngWrapper;
import com.talabat.hms.maps.data.model.HmsPolygonOptionsWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0000¨\u0006\u000f"}, d2 = {"huaweiCameraUpdate", "Lcom/huawei/hms/maps/CameraUpdate;", "Lcom/talabat/maps/domain/CameraUpdate;", "huaweiLatLngBounds", "Lcom/huawei/hms/maps/model/LatLngBounds;", "Lcom/talabat/maps/domain/model/LatLngBounds;", "huaweiPolygonOptions", "Lcom/huawei/hms/maps/model/PolygonOptions;", "Lcom/talabat/maps/domain/model/PolygonOptions;", "toHuaweiCameraPosition", "Lcom/huawei/hms/maps/model/CameraPosition;", "Lcom/talabat/maps/domain/model/CameraPosition;", "toHuaweiLatLng", "Lcom/huawei/hms/maps/model/LatLng;", "Lcom/talabat/maps/domain/model/LatLng;", "com_talabat_core_hms_maps_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsKt {
    @NotNull
    public static final CameraUpdate huaweiCameraUpdate(@NotNull com.talabat.maps.domain.CameraUpdate cameraUpdate) {
        Intrinsics.checkNotNullParameter(cameraUpdate, "<this>");
        return ((HmsCameraUpdateWrapper) cameraUpdate).getHuaweiCameraUpdate();
    }

    @NotNull
    public static final LatLngBounds huaweiLatLngBounds(@NotNull com.talabat.maps.domain.model.LatLngBounds latLngBounds) {
        Intrinsics.checkNotNullParameter(latLngBounds, "<this>");
        return ((HmsLatLngBoundsWrapper) latLngBounds).getHuaweiLatLngBounds();
    }

    @NotNull
    public static final PolygonOptions huaweiPolygonOptions(@NotNull com.talabat.maps.domain.model.PolygonOptions polygonOptions) {
        Intrinsics.checkNotNullParameter(polygonOptions, "<this>");
        return ((HmsPolygonOptionsWrapper) polygonOptions).getHuaweiPolygonOptions();
    }

    @NotNull
    public static final CameraPosition toHuaweiCameraPosition(@NotNull com.talabat.maps.domain.model.CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(cameraPosition, "<this>");
        return ((HmsCameraPositionWrapper) cameraPosition).getOriginal();
    }

    @NotNull
    public static final LatLng toHuaweiLatLng(@NotNull com.talabat.maps.domain.model.LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "<this>");
        return ((HmsLatLngWrapper) latLng).getOriginal();
    }
}
