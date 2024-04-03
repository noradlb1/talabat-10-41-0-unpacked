package com.baseflow.geolocator.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import io.flutter.plugin.common.EventChannel;

public class LocationServiceStatusReceiver extends BroadcastReceiver {
    @NonNull
    private final EventChannel.EventSink events;
    private ServiceStatus lastKnownServiceStatus;

    public LocationServiceStatusReceiver(@NonNull EventChannel.EventSink eventSink) {
        this.events = eventSink;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.location.PROVIDERS_CHANGED".equals(intent.getAction())) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean isProviderEnabled2 = locationManager.isProviderEnabled(SDKCoreEvent.Network.TYPE_NETWORK);
            if (isProviderEnabled || isProviderEnabled2) {
                ServiceStatus serviceStatus = this.lastKnownServiceStatus;
                if (serviceStatus == null || serviceStatus == ServiceStatus.disabled) {
                    ServiceStatus serviceStatus2 = ServiceStatus.enabled;
                    this.lastKnownServiceStatus = serviceStatus2;
                    this.events.success(Integer.valueOf(serviceStatus2.ordinal()));
                    return;
                }
                return;
            }
            ServiceStatus serviceStatus3 = this.lastKnownServiceStatus;
            if (serviceStatus3 == null || serviceStatus3 == ServiceStatus.enabled) {
                ServiceStatus serviceStatus4 = ServiceStatus.disabled;
                this.lastKnownServiceStatus = serviceStatus4;
                this.events.success(Integer.valueOf(serviceStatus4.ordinal()));
            }
        }
    }
}
