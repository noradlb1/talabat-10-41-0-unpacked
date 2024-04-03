package com.baseflow.geolocator.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.google.android.gms.common.GoogleApiAvailability;
import io.flutter.plugin.common.PluginRegistry;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GeolocationManager implements PluginRegistry.ActivityResultListener {
    private final List<LocationClient> locationClients = new CopyOnWriteArrayList();

    private boolean isGooglePlayServicesAvailable(Context context) {
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                return true;
            }
            return false;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public LocationClient createLocationClient(Context context, boolean z11, @Nullable LocationOptions locationOptions) {
        if (z11) {
            return new LocationManagerClient(context, locationOptions);
        }
        if (isGooglePlayServicesAvailable(context)) {
            return new FusedLocationClient(context, locationOptions);
        }
        return new LocationManagerClient(context, locationOptions);
    }

    public void getLastKnownPosition(Context context, boolean z11, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback) {
        createLocationClient(context, z11, (LocationOptions) null).getLastKnownPosition(positionChangedCallback, errorCallback);
    }

    public void isLocationServiceEnabled(@Nullable Context context, LocationServiceListener locationServiceListener) {
        if (context == null) {
            locationServiceListener.onLocationServiceError(ErrorCodes.locationServicesDisabled);
        }
        createLocationClient(context, false, (LocationOptions) null).isLocationServiceEnabled(locationServiceListener);
    }

    public boolean onActivityResult(int i11, int i12, Intent intent) {
        for (LocationClient onActivityResult : this.locationClients) {
            if (onActivityResult.onActivityResult(i11, i12)) {
                return true;
            }
        }
        return false;
    }

    public void startPositionUpdates(@NonNull LocationClient locationClient, @Nullable Activity activity, @NonNull PositionChangedCallback positionChangedCallback, @NonNull ErrorCallback errorCallback) {
        this.locationClients.add(locationClient);
        locationClient.startPositionUpdates(activity, positionChangedCallback, errorCallback);
    }

    public void stopPositionUpdates(@NonNull LocationClient locationClient) {
        this.locationClients.remove(locationClient);
        locationClient.stopPositionUpdates();
    }
}
