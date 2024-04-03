package com.talabat.gms.maps.data.model;

import com.talabat.maps.domain.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/talabat/gms/maps/data/model/GmsLatLngWrapper;", "Lcom/talabat/maps/domain/model/LatLng;", "original", "Lcom/google/android/gms/maps/model/LatLng;", "(Lcom/google/android/gms/maps/model/LatLng;)V", "latitude", "", "getLatitude", "()D", "longitude", "getLongitude", "getOriginal", "()Lcom/google/android/gms/maps/model/LatLng;", "equals", "", "other", "", "hashCode", "", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsLatLngWrapper implements LatLng {
    @NotNull
    private final com.google.android.gms.maps.model.LatLng original;

    public GmsLatLngWrapper(@NotNull com.google.android.gms.maps.model.LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "original");
        this.original = latLng;
    }

    public boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<GmsLatLngWrapper> cls2 = GmsLatLngWrapper.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual((Object) cls2, (Object) cls)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.gms.maps.data.model.GmsLatLngWrapper");
        } else if (!Intrinsics.areEqual((Object) this.original, (Object) ((GmsLatLngWrapper) obj).original)) {
            return false;
        } else {
            return true;
        }
    }

    public double getLatitude() {
        return this.original.latitude;
    }

    public double getLongitude() {
        return this.original.longitude;
    }

    @NotNull
    public final com.google.android.gms.maps.model.LatLng getOriginal() {
        return this.original;
    }

    public int hashCode() {
        return this.original.hashCode();
    }
}
