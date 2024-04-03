package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import java.util.Calendar;

class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState = new TwilightState();

    public static class TwilightState {

        /* renamed from: a  reason: collision with root package name */
        public boolean f615a;

        /* renamed from: b  reason: collision with root package name */
        public long f616b;
    }

    @VisibleForTesting
    public TwilightManager(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    public static TwilightManager a(@NonNull Context context) {
        if (sInstance == null) {
            Context applicationContext = context.getApplicationContext();
            sInstance = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return sInstance;
    }

    @SuppressLint({"MissingPermission"})
    private Location getLastKnownLocation() {
        Location location;
        Location location2 = null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            location = getLastKnownLocationForProvider(SDKCoreEvent.Network.TYPE_NETWORK);
        } else {
            location = null;
        }
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location2 = getLastKnownLocationForProvider("gps");
        }
        if (location2 == null || location == null) {
            if (location2 != null) {
                return location2;
            }
            return location;
        } else if (location2.getTime() > location.getTime()) {
            return location2;
        } else {
            return location;
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location getLastKnownLocationForProvider(String str) {
        try {
            if (this.mLocationManager.isProviderEnabled(str)) {
                return this.mLocationManager.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean isStateValid() {
        return this.mTwilightState.f616b > System.currentTimeMillis();
    }

    private void updateState(@NonNull Location location) {
        long j11;
        long j12;
        TwilightState twilightState = this.mTwilightState;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator a11 = TwilightCalculator.a();
        TwilightCalculator twilightCalculator = a11;
        twilightCalculator.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        twilightCalculator.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z11 = true;
        if (a11.state != 1) {
            z11 = false;
        }
        boolean z12 = z11;
        long j13 = a11.sunrise;
        long j14 = a11.sunset;
        long j15 = j14;
        double latitude = location.getLatitude();
        long j16 = j13;
        a11.calculateTwilight(currentTimeMillis + 86400000, latitude, location.getLongitude());
        long j17 = a11.sunrise;
        if (j16 == -1 || j15 == -1) {
            j11 = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j15) {
                j12 = j17 + 0;
            } else if (currentTimeMillis > j16) {
                j12 = j15 + 0;
            } else {
                j12 = j16 + 0;
            }
            j11 = j12 + 60000;
        }
        twilightState.f615a = z12;
        twilightState.f616b = j11;
    }

    public boolean b() {
        TwilightState twilightState = this.mTwilightState;
        if (isStateValid()) {
            return twilightState.f615a;
        }
        Location lastKnownLocation = getLastKnownLocation();
        if (lastKnownLocation != null) {
            updateState(lastKnownLocation);
            return twilightState.f615a;
        }
        Log.i(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i11 = Calendar.getInstance().get(11);
        if (i11 < 6 || i11 >= 22) {
            return true;
        }
        return false;
    }
}
