package com.talabat.core.hms.location.data;

import com.talabat.location.domain.LocationSettingsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/hms/location/data/HmsLocationSettingsResponseWrapper;", "Lcom/talabat/location/domain/LocationSettingsResponse;", "locationSettingsResponse", "Lcom/huawei/hms/location/LocationSettingsResponse;", "(Lcom/huawei/hms/location/LocationSettingsResponse;)V", "getLocationSettingsResponse", "()Lcom/huawei/hms/location/LocationSettingsResponse;", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsLocationSettingsResponseWrapper implements LocationSettingsResponse {
    @NotNull
    private final com.huawei.hms.location.LocationSettingsResponse locationSettingsResponse;

    public HmsLocationSettingsResponseWrapper(@NotNull com.huawei.hms.location.LocationSettingsResponse locationSettingsResponse2) {
        Intrinsics.checkNotNullParameter(locationSettingsResponse2, "locationSettingsResponse");
        this.locationSettingsResponse = locationSettingsResponse2;
    }

    @NotNull
    public final com.huawei.hms.location.LocationSettingsResponse getLocationSettingsResponse() {
        return this.locationSettingsResponse;
    }
}
