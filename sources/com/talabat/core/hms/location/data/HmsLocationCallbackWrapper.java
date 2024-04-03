package com.talabat.core.hms.location.data;

import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/hms/location/data/HmsLocationCallbackWrapper;", "Lcom/huawei/hms/location/LocationCallback;", "locationCallback", "Lcom/talabat/location/domain/LocationCallback;", "(Lcom/talabat/location/domain/LocationCallback;)V", "equals", "", "other", "", "hashCode", "", "onLocationAvailability", "", "locationAvailability", "Lcom/huawei/hms/location/LocationAvailability;", "onLocationResult", "locationResult", "Lcom/huawei/hms/location/LocationResult;", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsLocationCallbackWrapper extends LocationCallback {
    @NotNull
    private final com.talabat.location.domain.LocationCallback locationCallback;

    public HmsLocationCallbackWrapper(@NotNull com.talabat.location.domain.LocationCallback locationCallback2) {
        Intrinsics.checkNotNullParameter(locationCallback2, "locationCallback");
        this.locationCallback = locationCallback2;
    }

    public boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<HmsLocationCallbackWrapper> cls2 = HmsLocationCallbackWrapper.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual((Object) cls2, (Object) cls)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.hms.location.data.HmsLocationCallbackWrapper");
        } else if (!Intrinsics.areEqual((Object) this.locationCallback, (Object) ((HmsLocationCallbackWrapper) obj).locationCallback)) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return this.locationCallback.hashCode();
    }

    public void onLocationAvailability(@Nullable LocationAvailability locationAvailability) {
        super.onLocationAvailability(locationAvailability);
        this.locationCallback.onLocationAvailability(new HmsLocationAvailabilityWrapper(locationAvailability));
    }

    public void onLocationResult(@Nullable LocationResult locationResult) {
        if (locationResult != null) {
            super.onLocationResult(locationResult);
            this.locationCallback.onLocationResult(new HmsLocationResultWrapper(locationResult));
        }
    }
}
