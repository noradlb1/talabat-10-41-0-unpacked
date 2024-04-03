package com.talabat.gms.maps.data;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolygonOptions;
import com.talabat.gms.maps.data.model.GmsCameraPositionWrapper;
import com.talabat.gms.maps.data.model.GmsCameraUpdateWrapper;
import com.talabat.gms.maps.data.model.GmsLatLngBoundsWrapper;
import com.talabat.gms.maps.data.model.GmsLatLngWrapper;
import com.talabat.gms.maps.data.model.GmsPolygonOptionsWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0000¨\u0006\u000f"}, d2 = {"googleCameraUpdate", "Lcom/google/android/gms/maps/CameraUpdate;", "Lcom/talabat/maps/domain/CameraUpdate;", "googleLatLngBounds", "Lcom/google/android/gms/maps/model/LatLngBounds;", "Lcom/talabat/maps/domain/model/LatLngBounds;", "googlePolygonOptions", "Lcom/google/android/gms/maps/model/PolygonOptions;", "Lcom/talabat/maps/domain/model/PolygonOptions;", "toGoogleCameraPosition", "Lcom/google/android/gms/maps/model/CameraPosition;", "Lcom/talabat/maps/domain/model/CameraPosition;", "toGoogleLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "Lcom/talabat/maps/domain/model/LatLng;", "com_talabat_core_gms_maps_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsKt {
    @NotNull
    public static final CameraUpdate googleCameraUpdate(@NotNull com.talabat.maps.domain.CameraUpdate cameraUpdate) {
        Intrinsics.checkNotNullParameter(cameraUpdate, "<this>");
        return ((GmsCameraUpdateWrapper) cameraUpdate).getGoogleCameraUpdate();
    }

    @NotNull
    public static final LatLngBounds googleLatLngBounds(@NotNull com.talabat.maps.domain.model.LatLngBounds latLngBounds) {
        Intrinsics.checkNotNullParameter(latLngBounds, "<this>");
        return ((GmsLatLngBoundsWrapper) latLngBounds).getGoogleLatLngBounds();
    }

    @NotNull
    public static final PolygonOptions googlePolygonOptions(@NotNull com.talabat.maps.domain.model.PolygonOptions polygonOptions) {
        Intrinsics.checkNotNullParameter(polygonOptions, "<this>");
        return ((GmsPolygonOptionsWrapper) polygonOptions).getGooglePolygonOptions();
    }

    @NotNull
    public static final CameraPosition toGoogleCameraPosition(@NotNull com.talabat.maps.domain.model.CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(cameraPosition, "<this>");
        return ((GmsCameraPositionWrapper) cameraPosition).getOriginal();
    }

    @NotNull
    public static final LatLng toGoogleLatLng(@NotNull com.talabat.maps.domain.model.LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "<this>");
        return ((GmsLatLngWrapper) latLng).getOriginal();
    }
}
