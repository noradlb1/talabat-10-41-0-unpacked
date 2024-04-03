package com.talabat.core.hms.location.data;

import android.location.Location;
import android.os.Looper;
import androidx.annotation.RequiresPermission;
import com.talabat.location.domain.FusedLocationProviderClient;
import com.talabat.location.domain.LocationCallback;
import com.talabat.location.domain.LocationRequest;
import com.talabat.location.domain.tasks.Task;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J0\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068WX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/hms/location/data/HmsFusedLocationProviderClient;", "Lcom/talabat/location/domain/FusedLocationProviderClient;", "fusedLocationProviderClient", "Lcom/huawei/hms/location/FusedLocationProviderClient;", "(Lcom/huawei/hms/location/FusedLocationProviderClient;)V", "lastLocation", "Lcom/talabat/location/domain/tasks/Task;", "Landroid/location/Location;", "getLastLocation", "()Lcom/talabat/location/domain/tasks/Task;", "removeLocationUpdates", "Lcom/talabat/core/hms/location/data/HmsTaskWrapper;", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "locationCallback", "Lcom/talabat/location/domain/LocationCallback;", "requestLocationUpdates", "locationRequest", "Lcom/talabat/location/domain/LocationRequest;", "looper", "Landroid/os/Looper;", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsFusedLocationProviderClient implements FusedLocationProviderClient {
    @NotNull
    private final com.huawei.hms.location.FusedLocationProviderClient fusedLocationProviderClient;

    @Inject
    public HmsFusedLocationProviderClient(@NotNull com.huawei.hms.location.FusedLocationProviderClient fusedLocationProviderClient2) {
        Intrinsics.checkNotNullParameter(fusedLocationProviderClient2, "fusedLocationProviderClient");
        this.fusedLocationProviderClient = fusedLocationProviderClient2;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @NotNull
    public Task<Location> getLastLocation() {
        com.huawei.hmf.tasks.Task<Location> lastLocation = this.fusedLocationProviderClient.getLastLocation();
        Intrinsics.checkNotNullExpressionValue(lastLocation, "fusedLocationProviderClient.lastLocation");
        return new HmsTaskWrapper(lastLocation);
    }

    @NotNull
    public HmsTaskWrapper<Void> removeLocationUpdates(@NotNull LocationCallback locationCallback) {
        Intrinsics.checkNotNullParameter(locationCallback, "locationCallback");
        com.huawei.hmf.tasks.Task<Void> removeLocationUpdates = this.fusedLocationProviderClient.removeLocationUpdates((com.huawei.hms.location.LocationCallback) new HmsLocationCallbackWrapper(locationCallback));
        Intrinsics.checkNotNullExpressionValue(removeLocationUpdates, "fusedLocationProviderCli…onCallback)\n            )");
        return new HmsTaskWrapper<>(removeLocationUpdates);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @NotNull
    public HmsTaskWrapper<Void> requestLocationUpdates(@NotNull LocationRequest locationRequest, @NotNull LocationCallback locationCallback, @Nullable Looper looper) {
        Intrinsics.checkNotNullParameter(locationRequest, "locationRequest");
        Intrinsics.checkNotNullParameter(locationCallback, "locationCallback");
        com.huawei.hmf.tasks.Task<Void> requestLocationUpdates = this.fusedLocationProviderClient.requestLocationUpdates(((HmsLocationRequest) locationRequest).getHuaweiLocationRequest(), new HmsLocationCallbackWrapper(locationCallback), looper);
        Intrinsics.checkNotNullExpressionValue(requestLocationUpdates, "fusedLocationProviderCli…         looper\n        )");
        return new HmsTaskWrapper<>(requestLocationUpdates);
    }
}
