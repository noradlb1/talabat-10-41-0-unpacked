package com.baseflow.geolocator.location;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.tasks.Task;
import java.security.SecureRandom;
import java.util.Objects;
import o3.b;
import o3.c;

class FusedLocationClient implements LocationClient {
    private static final String TAG = "FlutterGeolocator";
    private final int activityRequestCode = generateActivityRequestCode();
    private final Context context;
    /* access modifiers changed from: private */
    @Nullable
    public ErrorCallback errorCallback;
    /* access modifiers changed from: private */
    public final FusedLocationProviderClient fusedLocationProviderClient;
    /* access modifiers changed from: private */
    public final LocationCallback locationCallback;
    @Nullable
    private final LocationOptions locationOptions;
    /* access modifiers changed from: private */
    public final NmeaClient nmeaClient;
    /* access modifiers changed from: private */
    @Nullable
    public PositionChangedCallback positionChangedCallback;

    /* renamed from: com.baseflow.geolocator.location.FusedLocationClient$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43230a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.baseflow.geolocator.location.LocationAccuracy[] r0 = com.baseflow.geolocator.location.LocationAccuracy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f43230a = r0
                com.baseflow.geolocator.location.LocationAccuracy r1 = com.baseflow.geolocator.location.LocationAccuracy.lowest     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f43230a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baseflow.geolocator.location.LocationAccuracy r1 = com.baseflow.geolocator.location.LocationAccuracy.low     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f43230a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baseflow.geolocator.location.LocationAccuracy r1 = com.baseflow.geolocator.location.LocationAccuracy.medium     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baseflow.geolocator.location.FusedLocationClient.AnonymousClass2.<clinit>():void");
        }
    }

    public FusedLocationClient(@NonNull final Context context2, @Nullable LocationOptions locationOptions2) {
        this.context = context2;
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context2);
        this.locationOptions = locationOptions2;
        this.nmeaClient = new NmeaClient(context2, locationOptions2);
        this.locationCallback = new LocationCallback() {
            public synchronized void onLocationAvailability(@NonNull LocationAvailability locationAvailability) {
                if (!locationAvailability.isLocationAvailable() && !FusedLocationClient.this.checkLocationService(context2) && FusedLocationClient.this.errorCallback != null) {
                    FusedLocationClient.this.errorCallback.onError(ErrorCodes.locationServicesDisabled);
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized void onLocationResult(@androidx.annotation.NonNull com.google.android.gms.location.LocationResult r2) {
                /*
                    r1 = this;
                    monitor-enter(r1)
                    com.baseflow.geolocator.location.FusedLocationClient r0 = com.baseflow.geolocator.location.FusedLocationClient.this     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.location.PositionChangedCallback r0 = r0.positionChangedCallback     // Catch:{ all -> 0x004c }
                    if (r0 != 0) goto L_0x0034
                    java.lang.String r2 = "FlutterGeolocator"
                    java.lang.String r0 = "LocationCallback was called with empty locationResult or no positionChangedCallback was registered."
                    android.util.Log.e(r2, r0)     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.location.FusedLocationClient r2 = com.baseflow.geolocator.location.FusedLocationClient.this     // Catch:{ all -> 0x004c }
                    com.google.android.gms.location.FusedLocationProviderClient r2 = r2.fusedLocationProviderClient     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.location.FusedLocationClient r0 = com.baseflow.geolocator.location.FusedLocationClient.this     // Catch:{ all -> 0x004c }
                    com.google.android.gms.location.LocationCallback r0 = r0.locationCallback     // Catch:{ all -> 0x004c }
                    r2.removeLocationUpdates((com.google.android.gms.location.LocationCallback) r0)     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.location.FusedLocationClient r2 = com.baseflow.geolocator.location.FusedLocationClient.this     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.errors.ErrorCallback r2 = r2.errorCallback     // Catch:{ all -> 0x004c }
                    if (r2 == 0) goto L_0x0032
                    com.baseflow.geolocator.location.FusedLocationClient r2 = com.baseflow.geolocator.location.FusedLocationClient.this     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.errors.ErrorCallback r2 = r2.errorCallback     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.errors.ErrorCodes r0 = com.baseflow.geolocator.errors.ErrorCodes.errorWhileAcquiringPosition     // Catch:{ all -> 0x004c }
                    r2.onError(r0)     // Catch:{ all -> 0x004c }
                L_0x0032:
                    monitor-exit(r1)
                    return
                L_0x0034:
                    android.location.Location r2 = r2.getLastLocation()     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.location.FusedLocationClient r0 = com.baseflow.geolocator.location.FusedLocationClient.this     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.location.NmeaClient r0 = r0.nmeaClient     // Catch:{ all -> 0x004c }
                    r0.enrichExtrasWithNmea(r2)     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.location.FusedLocationClient r0 = com.baseflow.geolocator.location.FusedLocationClient.this     // Catch:{ all -> 0x004c }
                    com.baseflow.geolocator.location.PositionChangedCallback r0 = r0.positionChangedCallback     // Catch:{ all -> 0x004c }
                    r0.onPositionChanged(r2)     // Catch:{ all -> 0x004c }
                    monitor-exit(r1)
                    return
                L_0x004c:
                    r2 = move-exception
                    monitor-exit(r1)
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baseflow.geolocator.location.FusedLocationClient.AnonymousClass1.onLocationResult(com.google.android.gms.location.LocationResult):void");
            }
        };
    }

    private static LocationRequest buildLocationRequest(@Nullable LocationOptions locationOptions2) {
        if (Build.VERSION.SDK_INT < 33) {
            return buildLocationRequestDeprecated(locationOptions2);
        }
        LocationRequest.Builder builder = new LocationRequest.Builder(0);
        if (locationOptions2 != null) {
            builder.setPriority(toPriority(locationOptions2.getAccuracy()));
            builder.setIntervalMillis(locationOptions2.getTimeInterval());
            builder.setMinUpdateIntervalMillis(locationOptions2.getTimeInterval());
            builder.setMinUpdateDistanceMeters((float) locationOptions2.getDistanceFilter());
        }
        return builder.build();
    }

    private static LocationRequest buildLocationRequestDeprecated(@Nullable LocationOptions locationOptions2) {
        LocationRequest create = LocationRequest.create();
        if (locationOptions2 != null) {
            create.setPriority(toPriority(locationOptions2.getAccuracy()));
            create.setInterval(locationOptions2.getTimeInterval());
            create.setFastestInterval(locationOptions2.getTimeInterval() / 2);
            create.setSmallestDisplacement((float) locationOptions2.getDistanceFilter());
        }
        return create;
    }

    private static LocationSettingsRequest buildLocationSettingsRequest(LocationRequest locationRequest) {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(locationRequest);
        return builder.build();
    }

    private synchronized int generateActivityRequestCode() {
        return new SecureRandom().nextInt(65536);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getLastKnownPosition$1(ErrorCallback errorCallback2, Exception exc) {
        Log.e("Geolocator", "Error trying to get last the last known GPS location");
        if (errorCallback2 != null) {
            errorCallback2.onError(ErrorCodes.errorWhileAcquiringPosition);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$isLocationServiceEnabled$0(LocationServiceListener locationServiceListener, Task task) {
        boolean z11;
        boolean z12;
        if (!task.isSuccessful()) {
            locationServiceListener.onLocationServiceError(ErrorCodes.locationServicesDisabled);
        }
        LocationSettingsResponse locationSettingsResponse = (LocationSettingsResponse) task.getResult();
        if (locationSettingsResponse != null) {
            LocationSettingsStates locationSettingsStates = locationSettingsResponse.getLocationSettingsStates();
            boolean z13 = true;
            if (locationSettingsStates == null || !locationSettingsStates.isGpsUsable()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (locationSettingsStates == null || !locationSettingsStates.isNetworkLocationUsable()) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (!z11 && !z12) {
                z13 = false;
            }
            locationServiceListener.onLocationServiceResult(z13);
            return;
        }
        locationServiceListener.onLocationServiceError(ErrorCodes.locationServicesDisabled);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startPositionUpdates$2(LocationSettingsResponse locationSettingsResponse) {
        requestPositionUpdates(this.locationOptions);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startPositionUpdates$3(Activity activity, ErrorCallback errorCallback2, Exception exc) {
        if (exc instanceof ResolvableApiException) {
            if (activity == null) {
                errorCallback2.onError(ErrorCodes.locationServicesDisabled);
                return;
            }
            ResolvableApiException resolvableApiException = (ResolvableApiException) exc;
            if (resolvableApiException.getStatusCode() == 6) {
                try {
                    resolvableApiException.startResolutionForResult(activity, this.activityRequestCode);
                } catch (IntentSender.SendIntentException unused) {
                    errorCallback2.onError(ErrorCodes.locationServicesDisabled);
                }
            } else {
                errorCallback2.onError(ErrorCodes.locationServicesDisabled);
            }
        } else if (((ApiException) exc).getStatusCode() == 8502) {
            requestPositionUpdates(this.locationOptions);
        } else {
            errorCallback2.onError(ErrorCodes.locationServicesDisabled);
        }
    }

    @SuppressLint({"MissingPermission"})
    private void requestPositionUpdates(LocationOptions locationOptions2) {
        LocationRequest buildLocationRequest = buildLocationRequest(locationOptions2);
        this.nmeaClient.start();
        this.fusedLocationProviderClient.requestLocationUpdates(buildLocationRequest, this.locationCallback, Looper.getMainLooper());
    }

    private static int toPriority(LocationAccuracy locationAccuracy) {
        int i11 = AnonymousClass2.f43230a[locationAccuracy.ordinal()];
        if (i11 == 1) {
            return 105;
        }
        if (i11 != 2) {
            return i11 != 3 ? 100 : 102;
        }
        return 104;
    }

    public /* synthetic */ boolean checkLocationService(Context context2) {
        return c.a(this, context2);
    }

    @SuppressLint({"MissingPermission"})
    public void getLastKnownPosition(PositionChangedCallback positionChangedCallback2, ErrorCallback errorCallback2) {
        Task<Location> lastLocation = this.fusedLocationProviderClient.getLastLocation();
        Objects.requireNonNull(positionChangedCallback2);
        lastLocation.addOnSuccessListener(new b(positionChangedCallback2)).addOnFailureListener(new a(errorCallback2));
    }

    public void isLocationServiceEnabled(LocationServiceListener locationServiceListener) {
        LocationServices.getSettingsClient(this.context).checkLocationSettings(new LocationSettingsRequest.Builder().build()).addOnCompleteListener(new d(locationServiceListener));
    }

    public boolean onActivityResult(int i11, int i12) {
        if (i11 == this.activityRequestCode) {
            if (i12 == -1) {
                LocationOptions locationOptions2 = this.locationOptions;
                if (locationOptions2 == null || this.positionChangedCallback == null || this.errorCallback == null) {
                    return false;
                }
                requestPositionUpdates(locationOptions2);
                return true;
            }
            ErrorCallback errorCallback2 = this.errorCallback;
            if (errorCallback2 != null) {
                errorCallback2.onError(ErrorCodes.locationServicesDisabled);
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public void startPositionUpdates(@Nullable Activity activity, @NonNull PositionChangedCallback positionChangedCallback2, @NonNull ErrorCallback errorCallback2) {
        this.positionChangedCallback = positionChangedCallback2;
        this.errorCallback = errorCallback2;
        LocationServices.getSettingsClient(this.context).checkLocationSettings(buildLocationSettingsRequest(buildLocationRequest(this.locationOptions))).addOnSuccessListener(new b(this)).addOnFailureListener(new c(this, activity, errorCallback2));
    }

    public void stopPositionUpdates() {
        this.nmeaClient.stop();
        this.fusedLocationProviderClient.removeLocationUpdates(this.locationCallback);
    }
}
