package com.talabat.gms.maps.data.model;

import com.talabat.maps.domain.model.BitmapDescriptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/gms/maps/data/model/GmsBitmapDescriptor;", "Lcom/talabat/maps/domain/model/BitmapDescriptor;", "googleBitmapDescriptor", "Lcom/google/android/gms/maps/model/BitmapDescriptor;", "(Lcom/google/android/gms/maps/model/BitmapDescriptor;)V", "getGoogleBitmapDescriptor", "()Lcom/google/android/gms/maps/model/BitmapDescriptor;", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsBitmapDescriptor implements BitmapDescriptor {
    @NotNull
    private final com.google.android.gms.maps.model.BitmapDescriptor googleBitmapDescriptor;

    public GmsBitmapDescriptor(@NotNull com.google.android.gms.maps.model.BitmapDescriptor bitmapDescriptor) {
        Intrinsics.checkNotNullParameter(bitmapDescriptor, "googleBitmapDescriptor");
        this.googleBitmapDescriptor = bitmapDescriptor;
    }

    @NotNull
    public final com.google.android.gms.maps.model.BitmapDescriptor getGoogleBitmapDescriptor() {
        return this.googleBitmapDescriptor;
    }
}
