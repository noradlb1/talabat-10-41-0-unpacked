package com.huawei.hms.locationSdk;

import android.app.Notification;
import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationSettingsRequest;
import com.huawei.hms.location.LocationSettingsResponse;
import com.huawei.hms.location.LogConfig;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationRequest;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationResponse;

public interface f {
    Task<Void> a();

    Task<Void> a(int i11, Notification notification);

    Task<Void> a(PendingIntent pendingIntent);

    Task<Void> a(Location location);

    Task<Void> a(LocationCallback locationCallback);

    Task<HWLocation> a(LocationRequest locationRequest);

    Task<Void> a(LocationRequest locationRequest, PendingIntent pendingIntent);

    Task<Void> a(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper);

    Task<LocationSettingsResponse> a(LocationSettingsRequest locationSettingsRequest);

    Task<Void> a(LogConfig logConfig);

    Task<OfflineLocationResponse> a(OfflineLocationRequest offlineLocationRequest);

    Task<Void> a(boolean z11);

    Task<LocationAvailability> b();

    Task<Void> b(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper);

    Task<Void> c();

    Task<Location> d();
}
