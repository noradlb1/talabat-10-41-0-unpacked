package com.huawei.hms.location;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.b;
import com.huawei.hms.locationSdk.f;
import com.huawei.hms.locationSdk.w;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationRequest;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationResponse;
import com.huawei.hms.support.api.location.common.LocationClientStateManager;

public class FusedLocationProviderClient {
    public static final String KEY_MOCK_LOCATION = "mockLocation";
    public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";
    private static final String TAG = "FusedLocationProviderClient";
    private f locationClient;
    private final Context mContext;

    public FusedLocationProviderClient(Activity activity) {
        this.mContext = activity.getApplicationContext();
        this.locationClient = b.b(activity, (w) null);
    }

    public FusedLocationProviderClient(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.locationClient = b.b(applicationContext, (w) null);
    }

    public Task<Void> disableBackgroundLocation() {
        return this.locationClient.c();
    }

    public Task<Void> enableBackgroundLocation(int i11, Notification notification) {
        return this.locationClient.a(i11, notification);
    }

    public Task<Void> flushLocations() {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.a();
    }

    public Task<Location> getLastLocation() {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.d();
    }

    public Task<HWLocation> getLastLocationWithAddress(LocationRequest locationRequest) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.a(locationRequest);
    }

    public Task<LocationAvailability> getLocationAvailability() {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.b();
    }

    public Task<OfflineLocationResponse> getOfflineLocation(OfflineLocationRequest offlineLocationRequest) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.a(offlineLocationRequest);
    }

    public Task<Void> removeLocationUpdates(PendingIntent pendingIntent) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.a(pendingIntent);
    }

    public Task<Void> removeLocationUpdates(LocationCallback locationCallback) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.a(locationCallback);
    }

    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, PendingIntent pendingIntent) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.a(locationRequest, pendingIntent);
    }

    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.b(locationRequest, locationCallback, looper);
    }

    public Task<Void> requestLocationUpdatesEx(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.a(locationRequest, locationCallback, looper);
    }

    public Task<Void> setMockLocation(Location location) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.a(location);
    }

    public Task<Void> setMockMode(boolean z11) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.a(z11);
    }
}
