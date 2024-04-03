package com.talabat.core.hms.location.data;

import android.location.Location;
import com.talabat.location.domain.LocationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/core/hms/location/data/HmsLocationResultWrapper;", "Lcom/talabat/location/domain/LocationResult;", "huaweiLocationResult", "Lcom/huawei/hms/location/LocationResult;", "(Lcom/huawei/hms/location/LocationResult;)V", "lastLocation", "Landroid/location/Location;", "getLastLocation", "()Landroid/location/Location;", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsLocationResultWrapper implements LocationResult {
    @NotNull
    private final com.huawei.hms.location.LocationResult huaweiLocationResult;

    public HmsLocationResultWrapper(@NotNull com.huawei.hms.location.LocationResult locationResult) {
        Intrinsics.checkNotNullParameter(locationResult, "huaweiLocationResult");
        this.huaweiLocationResult = locationResult;
    }

    @NotNull
    public Location getLastLocation() {
        Location lastLocation = this.huaweiLocationResult.getLastLocation();
        Intrinsics.checkNotNullExpressionValue(lastLocation, "huaweiLocationResult.lastLocation");
        return lastLocation;
    }
}
