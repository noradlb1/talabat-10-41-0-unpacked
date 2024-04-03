package com.talabat.location.domain;

import android.location.Location;
import android.os.Looper;
import com.talabat.location.domain.tasks.Task;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\nH&J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/location/domain/FusedLocationProviderClient;", "", "lastLocation", "Lcom/talabat/location/domain/tasks/Task;", "Landroid/location/Location;", "getLastLocation", "()Lcom/talabat/location/domain/tasks/Task;", "removeLocationUpdates", "Ljava/lang/Void;", "locationCallback", "Lcom/talabat/location/domain/LocationCallback;", "requestLocationUpdates", "locationRequest", "Lcom/talabat/location/domain/LocationRequest;", "looper", "Landroid/os/Looper;", "com_talabat_core_location_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FusedLocationProviderClient {
    @NotNull
    Task<Location> getLastLocation();

    @NotNull
    Task<Void> removeLocationUpdates(@NotNull LocationCallback locationCallback);

    @NotNull
    Task<Void> requestLocationUpdates(@NotNull LocationRequest locationRequest, @NotNull LocationCallback locationCallback, @Nullable Looper looper);
}
