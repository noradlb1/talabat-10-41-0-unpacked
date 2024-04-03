package com.baseflow.geolocator;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baseflow.geolocator.location.LocationServiceStatusReceiver;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;

public class LocationServiceHandlerImpl implements EventChannel.StreamHandler {
    private static final String TAG = "LocationServiceHandler";
    @Nullable
    private EventChannel channel;
    @Nullable
    private Context context;
    @Nullable
    private LocationServiceStatusReceiver receiver;

    private void disposeListeners() {
        LocationServiceStatusReceiver locationServiceStatusReceiver;
        Context context2 = this.context;
        if (context2 != null && (locationServiceStatusReceiver = this.receiver) != null) {
            context2.unregisterReceiver(locationServiceStatusReceiver);
        }
    }

    public void a(@Nullable Context context2) {
        this.context = context2;
    }

    public void b(Context context2, BinaryMessenger binaryMessenger) {
        if (this.channel != null) {
            Log.w(TAG, "Setting a event call handler before the last was disposed.");
            c();
        }
        EventChannel eventChannel = new EventChannel(binaryMessenger, "flutter.baseflow.com/geolocator_service_updates_android");
        this.channel = eventChannel;
        eventChannel.setStreamHandler(this);
        this.context = context2;
    }

    public void c() {
        if (this.channel != null) {
            disposeListeners();
            this.channel.setStreamHandler((EventChannel.StreamHandler) null);
            this.channel = null;
        }
    }

    public void onCancel(Object obj) {
        disposeListeners();
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        if (this.context != null) {
            IntentFilter intentFilter = new IntentFilter("android.location.PROVIDERS_CHANGED");
            intentFilter.addAction("android.intent.action.PROVIDER_CHANGED");
            LocationServiceStatusReceiver locationServiceStatusReceiver = new LocationServiceStatusReceiver(eventSink);
            this.receiver = locationServiceStatusReceiver;
            this.context.registerReceiver(locationServiceStatusReceiver, intentFilter);
        }
    }
}
