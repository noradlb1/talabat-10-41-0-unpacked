package com.talabat.core.hms.location.data;

import com.talabat.location.domain.LocationSettingsRequest;
import com.talabat.location.domain.LocationSettingsResponse;
import com.talabat.location.domain.SettingsClient;
import com.talabat.location.domain.tasks.Task;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/core/hms/location/data/HmsSettingsClientWrapper;", "Lcom/talabat/location/domain/SettingsClient;", "settingsClient", "Lcom/huawei/hms/location/SettingsClient;", "(Lcom/huawei/hms/location/SettingsClient;)V", "checkLocationSettings", "Lcom/talabat/location/domain/tasks/Task;", "Lcom/talabat/location/domain/LocationSettingsResponse;", "locationSettingsRequest", "Lcom/talabat/location/domain/LocationSettingsRequest;", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsSettingsClientWrapper implements SettingsClient {
    @NotNull
    private final com.huawei.hms.location.SettingsClient settingsClient;

    @Inject
    public HmsSettingsClientWrapper(@NotNull com.huawei.hms.location.SettingsClient settingsClient2) {
        Intrinsics.checkNotNullParameter(settingsClient2, "settingsClient");
        this.settingsClient = settingsClient2;
    }

    @NotNull
    public Task<LocationSettingsResponse> checkLocationSettings(@NotNull LocationSettingsRequest locationSettingsRequest) {
        Intrinsics.checkNotNullParameter(locationSettingsRequest, "locationSettingsRequest");
        com.huawei.hmf.tasks.Task<com.huawei.hms.location.LocationSettingsResponse> checkLocationSettings = this.settingsClient.checkLocationSettings(((HmsLocationSettingsRequestWrapper) locationSettingsRequest).getHuaweiLocationSettingsRequest());
        Intrinsics.checkNotNullExpressionValue(checkLocationSettings, "settingsClient.checkLoca…SettingsRequest\n        )");
        return new LocationResponseTaskWrapper(checkLocationSettings);
    }
}
