package com.baseflow.geolocator.location;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.location.LocationListenerCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.core.location.LocationRequestCompat;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import i1.y;
import java.util.List;
import o3.c;

class LocationManagerClient implements LocationClient, LocationListenerCompat {
    private static final long TWO_MINUTES = 120000;
    public Context context;
    @Nullable
    private Location currentBestLocation;
    @Nullable
    private String currentLocationProvider;
    @Nullable
    private ErrorCallback errorCallback;
    private boolean isListening = false;
    private final LocationManager locationManager;
    @Nullable
    private final LocationOptions locationOptions;
    private final NmeaClient nmeaClient;
    @Nullable
    private PositionChangedCallback positionChangedCallback;

    /* renamed from: com.baseflow.geolocator.location.LocationManagerClient$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43231a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.baseflow.geolocator.location.LocationAccuracy[] r0 = com.baseflow.geolocator.location.LocationAccuracy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f43231a = r0
                com.baseflow.geolocator.location.LocationAccuracy r1 = com.baseflow.geolocator.location.LocationAccuracy.lowest     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f43231a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baseflow.geolocator.location.LocationAccuracy r1 = com.baseflow.geolocator.location.LocationAccuracy.low     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f43231a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baseflow.geolocator.location.LocationAccuracy r1 = com.baseflow.geolocator.location.LocationAccuracy.high     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f43231a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baseflow.geolocator.location.LocationAccuracy r1 = com.baseflow.geolocator.location.LocationAccuracy.best     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f43231a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.baseflow.geolocator.location.LocationAccuracy r1 = com.baseflow.geolocator.location.LocationAccuracy.bestForNavigation     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f43231a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.baseflow.geolocator.location.LocationAccuracy r1 = com.baseflow.geolocator.location.LocationAccuracy.medium     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baseflow.geolocator.location.LocationManagerClient.AnonymousClass1.<clinit>():void");
        }
    }

    public LocationManagerClient(@NonNull Context context2, @Nullable LocationOptions locationOptions2) {
        this.locationManager = (LocationManager) context2.getSystemService("location");
        this.locationOptions = locationOptions2;
        this.context = context2;
        this.nmeaClient = new NmeaClient(context2, locationOptions2);
    }

    public static boolean a(Location location, Location location2) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        if (time > 120000) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (time < -120000) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (time > 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z11) {
            return true;
        }
        if (z12) {
            return false;
        }
        float accuracy = (float) ((int) (location.getAccuracy() - location2.getAccuracy()));
        if (accuracy > 0.0f) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (accuracy < 0.0f) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (accuracy > 200.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (location.getProvider() != null) {
            z17 = location.getProvider().equals(location2.getProvider());
        } else {
            z17 = false;
        }
        if (z15) {
            return true;
        }
        if (z13 && !z14) {
            return true;
        }
        if (!z13 || z16 || !z17) {
            return false;
        }
        return true;
    }

    private static int accuracyToQuality(@NonNull LocationAccuracy locationAccuracy) {
        int i11 = AnonymousClass1.f43231a[locationAccuracy.ordinal()];
        if (i11 == 1 || i11 == 2) {
            return 104;
        }
        return (i11 == 3 || i11 == 4 || i11 == 5) ? 100 : 102;
    }

    @Nullable
    private static String determineProvider(@NonNull LocationManager locationManager2, @NonNull LocationAccuracy locationAccuracy) {
        List<String> providers = locationManager2.getProviders(true);
        if (locationAccuracy == LocationAccuracy.lowest) {
            return "passive";
        }
        if (providers.contains("fused") && Build.VERSION.SDK_INT >= 31) {
            return "fused";
        }
        if (providers.contains("gps")) {
            return "gps";
        }
        if (providers.contains(SDKCoreEvent.Network.TYPE_NETWORK)) {
            return SDKCoreEvent.Network.TYPE_NETWORK;
        }
        if (!providers.isEmpty()) {
            return providers.get(0);
        }
        return null;
    }

    public /* synthetic */ boolean checkLocationService(Context context2) {
        return c.a(this, context2);
    }

    public void getLastKnownPosition(PositionChangedCallback positionChangedCallback2, ErrorCallback errorCallback2) {
        Location location = null;
        for (String lastKnownLocation : this.locationManager.getProviders(true)) {
            Location lastKnownLocation2 = this.locationManager.getLastKnownLocation(lastKnownLocation);
            if (lastKnownLocation2 != null && a(lastKnownLocation2, location)) {
                location = lastKnownLocation2;
            }
        }
        positionChangedCallback2.onPositionChanged(location);
    }

    public void isLocationServiceEnabled(LocationServiceListener locationServiceListener) {
        if (this.locationManager == null) {
            locationServiceListener.onLocationServiceResult(false);
        } else {
            locationServiceListener.onLocationServiceResult(checkLocationService(this.context));
        }
    }

    public boolean onActivityResult(int i11, int i12) {
        return false;
    }

    public /* synthetic */ void onFlushComplete(int i11) {
        y.a(this, i11);
    }

    public synchronized void onLocationChanged(Location location) {
        if (a(location, this.currentBestLocation)) {
            this.currentBestLocation = location;
            if (this.positionChangedCallback != null) {
                this.nmeaClient.enrichExtrasWithNmea(location);
                this.positionChangedCallback.onPositionChanged(this.currentBestLocation);
            }
        }
    }

    public /* synthetic */ void onLocationChanged(List list) {
        y.b(this, list);
    }

    @SuppressLint({"MissingPermission"})
    public void onProviderDisabled(String str) {
        if (str.equals(this.currentLocationProvider)) {
            if (this.isListening) {
                this.locationManager.removeUpdates(this);
            }
            ErrorCallback errorCallback2 = this.errorCallback;
            if (errorCallback2 != null) {
                errorCallback2.onError(ErrorCodes.locationServicesDisabled);
            }
            this.currentLocationProvider = null;
        }
    }

    public void onProviderEnabled(@NonNull String str) {
    }

    @TargetApi(28)
    public void onStatusChanged(@NonNull String str, int i11, Bundle bundle) {
        if (i11 == 2) {
            onProviderEnabled(str);
        } else if (i11 == 0) {
            onProviderDisabled(str);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void startPositionUpdates(Activity activity, PositionChangedCallback positionChangedCallback2, ErrorCallback errorCallback2) {
        float f11;
        int i11;
        long j11;
        if (!checkLocationService(this.context)) {
            errorCallback2.onError(ErrorCodes.locationServicesDisabled);
            return;
        }
        this.positionChangedCallback = positionChangedCallback2;
        this.errorCallback = errorCallback2;
        LocationAccuracy locationAccuracy = LocationAccuracy.best;
        LocationOptions locationOptions2 = this.locationOptions;
        if (locationOptions2 != null) {
            float distanceFilter = (float) locationOptions2.getDistanceFilter();
            LocationAccuracy accuracy = this.locationOptions.getAccuracy();
            if (accuracy == LocationAccuracy.lowest) {
                j11 = Long.MAX_VALUE;
            } else {
                j11 = this.locationOptions.getTimeInterval();
            }
            i11 = accuracyToQuality(accuracy);
            LocationAccuracy locationAccuracy2 = accuracy;
            f11 = distanceFilter;
            locationAccuracy = locationAccuracy2;
        } else {
            j11 = 0;
            f11 = 0.0f;
            i11 = 102;
        }
        String determineProvider = determineProvider(this.locationManager, locationAccuracy);
        this.currentLocationProvider = determineProvider;
        if (determineProvider == null) {
            errorCallback2.onError(ErrorCodes.locationServicesDisabled);
            return;
        }
        LocationRequestCompat build = new LocationRequestCompat.Builder(j11).setMinUpdateDistanceMeters(f11).setQuality(i11).build();
        this.isListening = true;
        this.nmeaClient.start();
        LocationManagerCompat.requestLocationUpdates(this.locationManager, this.currentLocationProvider, build, (LocationListenerCompat) this, Looper.getMainLooper());
    }

    @SuppressLint({"MissingPermission"})
    public void stopPositionUpdates() {
        this.isListening = false;
        this.nmeaClient.stop();
        this.locationManager.removeUpdates(this);
    }
}
