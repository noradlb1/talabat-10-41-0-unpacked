package com.talabat.core.gms.location.data;

import android.location.Location;
import com.talabat.location.domain.LocationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/core/gms/location/data/GmsLocationResultWrapper;", "Lcom/talabat/location/domain/LocationResult;", "googleLocationResult", "Lcom/google/android/gms/location/LocationResult;", "(Lcom/google/android/gms/location/LocationResult;)V", "lastLocation", "Landroid/location/Location;", "getLastLocation", "()Landroid/location/Location;", "com_talabat_core_gms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsLocationResultWrapper implements LocationResult {
    @NotNull
    private final com.google.android.gms.location.LocationResult googleLocationResult;

    public GmsLocationResultWrapper(@NotNull com.google.android.gms.location.LocationResult locationResult) {
        Intrinsics.checkNotNullParameter(locationResult, "googleLocationResult");
        this.googleLocationResult = locationResult;
    }

    @Nullable
    public Location getLastLocation() {
        return this.googleLocationResult.getLastLocation();
    }
}
