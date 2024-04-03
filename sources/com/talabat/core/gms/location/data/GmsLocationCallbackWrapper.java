package com.talabat.core.gms.location.data;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/gms/location/data/GmsLocationCallbackWrapper;", "Lcom/google/android/gms/location/LocationCallback;", "locationCallback", "Lcom/talabat/location/domain/LocationCallback;", "(Lcom/talabat/location/domain/LocationCallback;)V", "equals", "", "other", "", "hashCode", "", "onLocationAvailability", "", "locationAvailability", "Lcom/google/android/gms/location/LocationAvailability;", "onLocationResult", "locationResult", "Lcom/google/android/gms/location/LocationResult;", "com_talabat_core_gms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsLocationCallbackWrapper extends LocationCallback {
    @NotNull
    private final com.talabat.location.domain.LocationCallback locationCallback;

    public GmsLocationCallbackWrapper(@NotNull com.talabat.location.domain.LocationCallback locationCallback2) {
        Intrinsics.checkNotNullParameter(locationCallback2, "locationCallback");
        this.locationCallback = locationCallback2;
    }

    public boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<GmsLocationCallbackWrapper> cls2 = GmsLocationCallbackWrapper.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual((Object) cls2, (Object) cls)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.gms.location.data.GmsLocationCallbackWrapper");
        } else if (!Intrinsics.areEqual((Object) this.locationCallback, (Object) ((GmsLocationCallbackWrapper) obj).locationCallback)) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return this.locationCallback.hashCode();
    }

    public void onLocationAvailability(@NotNull LocationAvailability locationAvailability) {
        Intrinsics.checkNotNullParameter(locationAvailability, "locationAvailability");
        super.onLocationAvailability(locationAvailability);
        this.locationCallback.onLocationAvailability(new GmsLocationAvailabilityWrapper(locationAvailability));
    }

    public void onLocationResult(@NotNull LocationResult locationResult) {
        Intrinsics.checkNotNullParameter(locationResult, "locationResult");
        super.onLocationResult(locationResult);
        this.locationCallback.onLocationResult(new GmsLocationResultWrapper(locationResult));
    }
}
