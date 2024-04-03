package com.talabat.core.gms.location.data;

import com.talabat.location.domain.LocationSettingsRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/gms/location/data/GmsLocationSettingsRequestWrapper;", "Lcom/talabat/location/domain/LocationSettingsRequest;", "googleLocationSettingsRequest", "Lcom/google/android/gms/location/LocationSettingsRequest;", "(Lcom/google/android/gms/location/LocationSettingsRequest;)V", "getGoogleLocationSettingsRequest", "()Lcom/google/android/gms/location/LocationSettingsRequest;", "com_talabat_core_gms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsLocationSettingsRequestWrapper implements LocationSettingsRequest {
    @NotNull
    private final com.google.android.gms.location.LocationSettingsRequest googleLocationSettingsRequest;

    public GmsLocationSettingsRequestWrapper(@NotNull com.google.android.gms.location.LocationSettingsRequest locationSettingsRequest) {
        Intrinsics.checkNotNullParameter(locationSettingsRequest, "googleLocationSettingsRequest");
        this.googleLocationSettingsRequest = locationSettingsRequest;
    }

    @NotNull
    public final com.google.android.gms.location.LocationSettingsRequest getGoogleLocationSettingsRequest() {
        return this.googleLocationSettingsRequest;
    }
}
