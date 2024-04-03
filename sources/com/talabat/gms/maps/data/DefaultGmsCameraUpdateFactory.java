package com.talabat.gms.maps.data;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.gms.maps.data.model.GmsCameraUpdateWrapper;
import com.talabat.gms.maps.domain.GmsCameraUpdateFactory;
import com.talabat.maps.domain.CameraUpdate;
import com.talabat.maps.domain.model.CameraPosition;
import com.talabat.maps.domain.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/talabat/gms/maps/data/DefaultGmsCameraUpdateFactory;", "Lcom/talabat/gms/maps/domain/GmsCameraUpdateFactory;", "()V", "newCameraPosition", "Lcom/talabat/maps/domain/CameraUpdate;", "cameraPosition", "Lcom/talabat/maps/domain/model/CameraPosition;", "newLatLngZoom", "latLng", "Lcom/talabat/maps/domain/model/LatLng;", "i", "", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultGmsCameraUpdateFactory implements GmsCameraUpdateFactory {
    @NotNull
    public CameraUpdate newCameraPosition(@NotNull CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(cameraPosition, "cameraPosition");
        com.google.android.gms.maps.CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(ExtensionsKt.toGoogleCameraPosition(cameraPosition));
        Intrinsics.checkNotNullExpressionValue(newCameraPosition, "newCameraPosition(\n     …aPosition()\n            )");
        return new GmsCameraUpdateWrapper(newCameraPosition);
    }

    @NotNull
    public CameraUpdate newLatLngZoom(@NotNull LatLng latLng, float f11) {
        Intrinsics.checkNotNullParameter(latLng, Param.LAT_LNG);
        com.google.android.gms.maps.CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(ExtensionsKt.toGoogleLatLng(latLng), f11);
        Intrinsics.checkNotNullExpressionValue(newLatLngZoom, "newLatLngZoom(\n         …          i\n            )");
        return new GmsCameraUpdateWrapper(newLatLngZoom);
    }
}
