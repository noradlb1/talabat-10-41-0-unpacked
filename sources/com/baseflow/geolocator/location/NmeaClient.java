package com.baseflow.geolocator.location;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Calendar;
import o3.g;

public class NmeaClient {
    public static final String NMEA_ALTITUDE_EXTRA = "geolocator_mslAltitude";
    private final Context context;
    private String lastNmeaMessage;
    @Nullable
    private Calendar lastNmeaMessageTime;
    private boolean listenerAdded = false;
    private final LocationManager locationManager;
    @Nullable
    private final LocationOptions locationOptions;
    @TargetApi(24)
    private OnNmeaMessageListener nmeaMessageListener;

    public NmeaClient(@NonNull Context context2, @Nullable LocationOptions locationOptions2) {
        this.context = context2;
        this.locationOptions = locationOptions2;
        this.locationManager = (LocationManager) context2.getSystemService("location");
        if (Build.VERSION.SDK_INT >= 24) {
            this.nmeaMessageListener = new g(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str, long j11) {
        if (str.startsWith("$GPGGA")) {
            this.lastNmeaMessage = str;
            this.lastNmeaMessageTime = Calendar.getInstance();
        }
    }

    public void enrichExtrasWithNmea(@Nullable Location location) {
        if (location != null && this.lastNmeaMessage != null && this.locationOptions != null && this.listenerAdded) {
            Calendar instance = Calendar.getInstance();
            instance.add(13, -5);
            Calendar calendar = this.lastNmeaMessageTime;
            if ((calendar == null || !calendar.before(instance)) && this.locationOptions.isUseMSLAltitude()) {
                String[] split = this.lastNmeaMessage.split(",");
                if (split[0].startsWith("$GPGGA") && split.length > 9 && !split[9].isEmpty()) {
                    double parseDouble = Double.parseDouble(split[9]);
                    if (location.getExtras() == null) {
                        location.setExtras(Bundle.EMPTY);
                    }
                    location.getExtras().putDouble(NMEA_ALTITUDE_EXTRA, parseDouble);
                }
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public void start() {
        LocationOptions locationOptions2;
        LocationManager locationManager2;
        if (!this.listenerAdded && (locationOptions2 = this.locationOptions) != null && locationOptions2.isUseMSLAltitude() && Build.VERSION.SDK_INT >= 24 && (locationManager2 = this.locationManager) != null) {
            boolean unused = locationManager2.addNmeaListener(this.nmeaMessageListener, (Handler) null);
            this.listenerAdded = true;
        }
    }

    public void stop() {
        LocationManager locationManager2;
        LocationOptions locationOptions2 = this.locationOptions;
        if (locationOptions2 != null && locationOptions2.isUseMSLAltitude() && Build.VERSION.SDK_INT >= 24 && (locationManager2 = this.locationManager) != null) {
            locationManager2.removeNmeaListener(this.nmeaMessageListener);
            this.listenerAdded = false;
        }
    }
}
