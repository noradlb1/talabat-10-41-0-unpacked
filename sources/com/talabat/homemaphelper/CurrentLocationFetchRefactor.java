package com.talabat.homemaphelper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.location.domain.FusedLocationProviderClient;
import com.talabat.location.domain.LocationCallback;
import com.talabat.location.domain.LocationRepository;
import com.talabat.location.domain.LocationRequest;
import com.talabat.location.domain.LocationSettingsRequest;
import com.talabat.location.domain.SettingsClient;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.location.domain.tasks.Task;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.userandlocation.LatLngRefactorHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TrackingUtils;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010&\u001a\u00020\u0014J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020(J\u000e\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020(2\u0006\u0010-\u001a\u00020.J\u0006\u00100\u001a\u00020\u0014J\u000e\u00101\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.J\u0010\u00102\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\u0006\u00103\u001a\u00020(J\u000e\u00104\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/talabat/homemaphelper/CurrentLocationFetchRefactor;", "", "activity", "Landroid/app/Activity;", "listener", "Lcom/talabat/homemaphelper/CurrentLocationFetchRefactor$onLocationListener;", "(Landroid/app/Activity;Lcom/talabat/homemaphelper/CurrentLocationFetchRefactor$onLocationListener;)V", "FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS", "", "MAXIMUM_WAIT_TIME", "REQUEST_CHECK_SETTINGS", "", "UPDATE_INTERVAL_IN_MILLISECONDS", "getActivity", "()Landroid/app/Activity;", "countryCode", "", "getListener", "()Lcom/talabat/homemaphelper/CurrentLocationFetchRefactor$onLocationListener;", "locationRequestInited", "", "mCurrentLocation", "Landroid/location/Location;", "mFusedLocationClient", "Lcom/talabat/location/domain/FusedLocationProviderClient;", "mLocationCallback", "Lcom/talabat/location/domain/LocationCallback;", "mLocationManager", "Landroid/location/LocationManager;", "mLocationRequest", "Lcom/talabat/location/domain/LocationRequest;", "mLocationSettingsRequest", "Lcom/talabat/location/domain/LocationSettingsRequest;", "mRequestingLocationUpdates", "Ljava/lang/Boolean;", "mSettingsClient", "Lcom/talabat/location/domain/SettingsClient;", "updateCount", "checkPermissions", "currentLocation", "", "currentLoc", "Lcom/talabat/maps/domain/model/LatLng;", "fetchCurrentGpsLocation", "getLocationTrackingStatus", "context", "Landroid/content/Context;", "initLocationRequest", "isLoactionReequestInitied", "isLocationServiceEnabled", "startLocationUpdates", "stopLocationUpdates", "userAllowedAllLocationPermissions", "onLocationListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrentLocationFetchRefactor {
    private final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000;
    private final long MAXIMUM_WAIT_TIME = 7000;
    /* access modifiers changed from: private */
    public final int REQUEST_CHECK_SETTINGS = 100;
    private final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;
    @NotNull
    private final Activity activity;
    @Nullable
    private String countryCode;
    @NotNull
    private final onLocationListener listener;
    /* access modifiers changed from: private */
    public boolean locationRequestInited;
    /* access modifiers changed from: private */
    @Nullable
    public Location mCurrentLocation;
    /* access modifiers changed from: private */
    @Nullable
    public FusedLocationProviderClient mFusedLocationClient;
    /* access modifiers changed from: private */
    @Nullable
    public LocationCallback mLocationCallback;
    @Nullable
    private LocationManager mLocationManager;
    @Nullable
    private LocationRequest mLocationRequest;
    @Nullable
    private LocationSettingsRequest mLocationSettingsRequest;
    /* access modifiers changed from: private */
    @Nullable
    public Boolean mRequestingLocationUpdates;
    @Nullable
    private SettingsClient mSettingsClient;
    /* access modifiers changed from: private */
    public int updateCount;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/talabat/homemaphelper/CurrentLocationFetchRefactor$onLocationListener;", "", "OnCurrentLocationPermissionStatus", "", "response", "Lcom/karumi/dexter/listener/PermissionDeniedResponse;", "onCurrentLocationReceived", "isLocationFetchSuccess", "", "mCurrentLocation", "Landroid/location/Location;", "accuracy", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface onLocationListener {
        void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse);

        void onCurrentLocationReceived(boolean z11, @Nullable Location location, float f11);
    }

    public CurrentLocationFetchRefactor(@NotNull Activity activity2, @NotNull onLocationListener onlocationlistener) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(onlocationlistener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.activity = activity2;
        this.listener = onlocationlistener;
    }

    public final boolean checkPermissions() {
        if (ContextCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    public final void currentLocation(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLoc");
        GlobalDataModel.JSON.CurrentLocationFromStart.setValue(LatLngRefactorHelperKt.toGoogle(latLng));
    }

    public final void fetchCurrentGpsLocation() {
        Dexter.withActivity(this.activity).withPermission("android.permission.ACCESS_FINE_LOCATION").withListener(new CurrentLocationFetchRefactor$fetchCurrentGpsLocation$1(this)).check();
    }

    @NotNull
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    public final onLocationListener getListener() {
        return this.listener;
    }

    @NotNull
    public final String getLocationTrackingStatus(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isLocationServiceEnabled(context)) {
            return TrackingUtils.TrackingGpsStatus.Disabled.getValue();
        }
        if (checkPermissions()) {
            return TrackingUtils.TrackingGpsStatus.Enabled.getValue();
        }
        return TrackingUtils.TrackingGpsStatus.PermissionDenied.getValue();
    }

    public final void initLocationRequest(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LocationRepository locationRepository = ((LocationCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(LocationCoreLibApi.class)).getLocationRepository();
        LatLngFactory latLngFactory = ((MapsCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(MapsCoreLibApi.class)).getLatLngFactory();
        this.mFusedLocationClient = locationRepository.newFusedLocationProviderClient();
        this.mSettingsClient = locationRepository.newSettingsClient();
        this.mLocationCallback = new CurrentLocationFetchRefactor$initLocationRequest$1(this, latLngFactory, context);
        this.mRequestingLocationUpdates = Boolean.FALSE;
        LocationRequest newLocationRequest = locationRepository.newLocationRequest();
        this.mLocationRequest = newLocationRequest;
        Intrinsics.checkNotNull(newLocationRequest);
        newLocationRequest.setInterval(this.UPDATE_INTERVAL_IN_MILLISECONDS);
        LocationRequest locationRequest = this.mLocationRequest;
        Intrinsics.checkNotNull(locationRequest);
        locationRequest.setFastestInterval(this.FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        LocationRequest locationRequest2 = this.mLocationRequest;
        Intrinsics.checkNotNull(locationRequest2);
        locationRequest2.setPriority(LocationRequest.Priority.PRIORITY_HIGH_ACCURACY);
        LocationRequest locationRequest3 = this.mLocationRequest;
        Intrinsics.checkNotNull(locationRequest3);
        locationRequest3.setNumUpdates(3);
        LocationSettingsRequest.Builder newLocationSettingsRequestBuilder = locationRepository.newLocationSettingsRequestBuilder();
        LocationRequest locationRequest4 = this.mLocationRequest;
        Intrinsics.checkNotNull(locationRequest4);
        newLocationSettingsRequestBuilder.addLocationRequest(locationRequest4);
        this.mLocationSettingsRequest = newLocationSettingsRequestBuilder.build();
        this.locationRequestInited = true;
    }

    public final boolean isLoactionReequestInitied() {
        return this.locationRequestInited;
    }

    public final boolean isLocationServiceEnabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.mLocationManager == null) {
            Object systemService = context.getSystemService("location");
            if (systemService != null) {
                this.mLocationManager = (LocationManager) systemService;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
            }
        }
        try {
            LocationManager locationManager = this.mLocationManager;
            Intrinsics.checkNotNull(locationManager);
            return locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void startLocationUpdates(@NotNull Activity activity2) {
        LocationSettingsRequest locationSettingsRequest;
        Intrinsics.checkNotNullParameter(activity2, "activity");
        LocationRequest locationRequest = this.mLocationRequest;
        if (locationRequest != null && (locationSettingsRequest = this.mLocationSettingsRequest) != null) {
            SettingsClient settingsClient = this.mSettingsClient;
            Intrinsics.checkNotNull(settingsClient);
            settingsClient.checkLocationSettings(locationSettingsRequest).addOnSuccessListener(new CurrentLocationFetchRefactor$startLocationUpdates$1(this, locationRequest)).addOnFailureListener(new CurrentLocationFetchRefactor$startLocationUpdates$2(this, activity2));
        }
    }

    public final void stopLocationUpdates() {
        Log.e("location update stop", "location update stop");
        FusedLocationProviderClient fusedLocationProviderClient = this.mFusedLocationClient;
        Intrinsics.checkNotNull(fusedLocationProviderClient);
        LocationCallback locationCallback = this.mLocationCallback;
        Intrinsics.checkNotNull(locationCallback);
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        FusedLocationProviderClient fusedLocationProviderClient2 = this.mFusedLocationClient;
        if (fusedLocationProviderClient2 != null) {
            try {
                Intrinsics.checkNotNull(fusedLocationProviderClient2);
                LocationCallback locationCallback2 = this.mLocationCallback;
                if (locationCallback2 != null) {
                    Task<Void> removeLocationUpdates = fusedLocationProviderClient2.removeLocationUpdates(locationCallback2);
                    if (!removeLocationUpdates.isSuccessful()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("StopLocation updates unsuccessful! ");
                        sb2.append(removeLocationUpdates);
                    }
                }
            } catch (SecurityException unused) {
            }
        }
    }

    public final boolean userAllowedAllLocationPermissions(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isLocationServiceEnabled(context) || !checkPermissions()) {
            return false;
        }
        return true;
    }
}
