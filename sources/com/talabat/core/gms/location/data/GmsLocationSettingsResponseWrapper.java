package com.talabat.core.gms.location.data;

import com.talabat.location.domain.LocationSettingsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/gms/location/data/GmsLocationSettingsResponseWrapper;", "Lcom/talabat/location/domain/LocationSettingsResponse;", "locationSettingsResponse", "Lcom/google/android/gms/location/LocationSettingsResponse;", "(Lcom/google/android/gms/location/LocationSettingsResponse;)V", "getLocationSettingsResponse", "()Lcom/google/android/gms/location/LocationSettingsResponse;", "com_talabat_core_gms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsLocationSettingsResponseWrapper implements LocationSettingsResponse {
    @NotNull
    private final com.google.android.gms.location.LocationSettingsResponse locationSettingsResponse;

    public GmsLocationSettingsResponseWrapper(@NotNull com.google.android.gms.location.LocationSettingsResponse locationSettingsResponse2) {
        Intrinsics.checkNotNullParameter(locationSettingsResponse2, "locationSettingsResponse");
        this.locationSettingsResponse = locationSettingsResponse2;
    }

    @NotNull
    public final com.google.android.gms.location.LocationSettingsResponse getLocationSettingsResponse() {
        return this.locationSettingsResponse;
    }
}
