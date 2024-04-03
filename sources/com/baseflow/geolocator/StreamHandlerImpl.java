package com.baseflow.geolocator;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.errors.PermissionUndefinedException;
import com.baseflow.geolocator.location.ForegroundNotificationOptions;
import com.baseflow.geolocator.location.GeolocationManager;
import com.baseflow.geolocator.location.LocationClient;
import com.baseflow.geolocator.location.LocationOptions;
import com.baseflow.geolocator.permission.PermissionManager;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import java.util.Map;

class StreamHandlerImpl implements EventChannel.StreamHandler {
    private static final String TAG = "FlutterGeolocator";
    @Nullable
    private Activity activity;
    @Nullable
    private EventChannel channel;
    @Nullable
    private Context context;
    @Nullable
    private GeolocatorLocationService foregroundLocationService;
    @Nullable
    private GeolocationManager geolocationManager = new GeolocationManager();
    @Nullable
    private LocationClient locationClient;
    private final PermissionManager permissionManager;

    public StreamHandlerImpl(PermissionManager permissionManager2) {
        this.permissionManager = permissionManager2;
    }

    private void disposeListeners(boolean z11) {
        GeolocationManager geolocationManager2;
        Log.e(TAG, "Geolocator position updates stopped");
        GeolocatorLocationService geolocatorLocationService = this.foregroundLocationService;
        if (geolocatorLocationService == null || !geolocatorLocationService.canStopLocationService(z11)) {
            Log.e(TAG, "There is still another flutter engine connected, not stopping location service");
        } else {
            this.foregroundLocationService.stopLocationService();
            this.foregroundLocationService.disableBackgroundMode();
        }
        LocationClient locationClient2 = this.locationClient;
        if (locationClient2 != null && (geolocationManager2 = this.geolocationManager) != null) {
            geolocationManager2.stopPositionUpdates(locationClient2);
            this.locationClient = null;
        }
    }

    public void c(Context context2, BinaryMessenger binaryMessenger) {
        if (this.channel != null) {
            Log.w(TAG, "Setting a event call handler before the last was disposed.");
            d();
        }
        EventChannel eventChannel = new EventChannel(binaryMessenger, "flutter.baseflow.com/geolocator_updates_android");
        this.channel = eventChannel;
        eventChannel.setStreamHandler(this);
        this.context = context2;
    }

    public void d() {
        if (this.channel != null) {
            disposeListeners(false);
            this.channel.setStreamHandler((EventChannel.StreamHandler) null);
            this.channel = null;
        }
    }

    public void onCancel(Object obj) {
        disposeListeners(true);
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        boolean z11;
        ForegroundNotificationOptions foregroundNotificationOptions = null;
        try {
            if (!this.permissionManager.hasPermission(this.context)) {
                ErrorCodes errorCodes = ErrorCodes.permissionDenied;
                eventSink.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
            } else if (this.foregroundLocationService == null) {
                Log.e(TAG, "Location background service has not started correctly");
            } else {
                Map map = (Map) obj;
                if (map == null || map.get("forceLocationManager") == null) {
                    z11 = false;
                } else {
                    z11 = ((Boolean) map.get("forceLocationManager")).booleanValue();
                }
                LocationOptions parseArguments = LocationOptions.parseArguments(map);
                if (map != null) {
                    foregroundNotificationOptions = ForegroundNotificationOptions.parseArguments((Map) map.get("foregroundNotificationConfig"));
                }
                if (foregroundNotificationOptions != null) {
                    Log.e(TAG, "Geolocator position updates started using Android foreground service");
                    this.foregroundLocationService.startLocationService(z11, parseArguments, eventSink);
                    this.foregroundLocationService.enableBackgroundMode(foregroundNotificationOptions);
                    return;
                }
                Log.e(TAG, "Geolocator position updates started");
                LocationClient createLocationClient = this.geolocationManager.createLocationClient(this.context, Boolean.TRUE.equals(Boolean.valueOf(z11)), parseArguments);
                this.locationClient = createLocationClient;
                this.geolocationManager.startPositionUpdates(createLocationClient, this.activity, new h(eventSink), new i(eventSink));
            }
        } catch (PermissionUndefinedException unused) {
            ErrorCodes errorCodes2 = ErrorCodes.permissionDefinitionsNotFound;
            eventSink.error(errorCodes2.toString(), errorCodes2.toDescription(), (Object) null);
        }
    }

    public void setActivity(@Nullable Activity activity2) {
        if (!(activity2 != null || this.locationClient == null || this.channel == null)) {
            d();
        }
        this.activity = activity2;
    }

    public void setForegroundLocationService(@Nullable GeolocatorLocationService geolocatorLocationService) {
        this.foregroundLocationService = geolocatorLocationService;
    }
}
