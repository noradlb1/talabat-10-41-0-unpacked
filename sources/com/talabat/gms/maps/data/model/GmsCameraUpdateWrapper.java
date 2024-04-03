package com.talabat.gms.maps.data.model;

import com.talabat.maps.domain.CameraUpdate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/gms/maps/data/model/GmsCameraUpdateWrapper;", "Lcom/talabat/maps/domain/CameraUpdate;", "googleCameraUpdate", "Lcom/google/android/gms/maps/CameraUpdate;", "(Lcom/google/android/gms/maps/CameraUpdate;)V", "getGoogleCameraUpdate", "()Lcom/google/android/gms/maps/CameraUpdate;", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsCameraUpdateWrapper implements CameraUpdate {
    @NotNull
    private final com.google.android.gms.maps.CameraUpdate googleCameraUpdate;

    public GmsCameraUpdateWrapper(@NotNull com.google.android.gms.maps.CameraUpdate cameraUpdate) {
        Intrinsics.checkNotNullParameter(cameraUpdate, "googleCameraUpdate");
        this.googleCameraUpdate = cameraUpdate;
    }

    @NotNull
    public final com.google.android.gms.maps.CameraUpdate getGoogleCameraUpdate() {
        return this.googleCameraUpdate;
    }
}
