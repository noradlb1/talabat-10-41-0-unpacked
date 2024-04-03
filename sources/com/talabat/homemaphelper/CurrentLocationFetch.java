package com.talabat.homemaphelper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.C;
import com.karumi.dexter.Dexter;
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
import com.talabat.maputils.CurrentLocHelper;
import com.talabat.userandlocation.LatLngRefactorHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.gtm.TrackingUtils;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010/\u001a\u00020\u0014J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000201J\b\u00105\u001a\u00020\bH\u0002J\b\u00106\u001a\u00020#H\u0002J\u0016\u00107\u001a\u0002012\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000bJ\u0006\u0010;\u001a\u00020\u0014J\u000e\u0010<\u001a\u00020\u00142\u0006\u00108\u001a\u000209J/\u0010=\u001a\u0002012\u0006\u00108\u001a\u0002092\u0006\u0010>\u001a\u00020 2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010@¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\u0002012\u0006\u00102\u001a\u000203J\u0010\u0010D\u001a\u0002012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\u0006\u0010E\u001a\u000201J\u0010\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020\u000bH\u0002J\u000e\u0010H\u001a\u0002012\u0006\u0010I\u001a\u00020\u000bJ\u000e\u0010J\u001a\u00020\u00142\u0006\u00108\u001a\u000209R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/talabat/homemaphelper/CurrentLocationFetch;", "", "listener", "Lcom/talabat/homemaphelper/CurrentLocationListener;", "activity", "Landroid/app/Activity;", "(Lcom/talabat/homemaphelper/CurrentLocationListener;Landroid/app/Activity;)V", "FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS", "", "MAXIMUM_WAIT_TIME", "REQUEST_CHECK_NON_MAP", "", "getREQUEST_CHECK_NON_MAP", "()I", "REQUEST_CHECK_SETTINGS", "getREQUEST_CHECK_SETTINGS", "UPDATE_INTERVAL_IN_MILLISECONDS", "getActivity", "()Landroid/app/Activity;", "isNeedToReFreshMap", "", "getListener", "()Lcom/talabat/homemaphelper/CurrentLocationListener;", "loactionRequestType", "locationRequestInited", "locationRequestStatus", "locationRequestTriggered", "mCurrentLocation", "Landroid/location/Location;", "mFusedLocationClient", "Lcom/talabat/location/domain/FusedLocationProviderClient;", "mGpsAccuracy", "", "mGpsRequestTime", "mLastUpdateTime", "", "mLocationCallback", "Lcom/talabat/location/domain/LocationCallback;", "mLocationManager", "Landroid/location/LocationManager;", "mLocationRequest", "Lcom/talabat/location/domain/LocationRequest;", "mLocationSettingsRequest", "Lcom/talabat/location/domain/LocationSettingsRequest;", "mSettingsClient", "Lcom/talabat/location/domain/SettingsClient;", "updateCurrentlocRequired", "checkPermissions", "deliverToCurrentLocation", "", "currentLoc", "Lcom/talabat/maps/domain/model/LatLng;", "fetchCurrentLocation", "getGpsWaitTime", "getSreenName", "initLocationRequest", "context", "Landroid/content/Context;", "isFromType", "isLoactionReequestInitied", "isLocationServiceEnabled", "onGpsInfoReceived", "gpsAccuracy", "locationLat", "", "locationLon", "(Landroid/content/Context;FLjava/lang/Double;Ljava/lang/Double;)V", "setCurrentLoc", "startLocationUpdates", "stopLocationUpdates", "updateCurrentLoc", "requestType", "updateLocationRequestType", "type", "userAllowedAllLocationPermissions", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrentLocationFetch {
    private final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private final long MAXIMUM_WAIT_TIME = 10000;
    private final int REQUEST_CHECK_NON_MAP = 1001;
    private final int REQUEST_CHECK_SETTINGS = 100;
    private final long UPDATE_INTERVAL_IN_MILLISECONDS = 1000;
    @NotNull
    private final Activity activity;
    private boolean isNeedToReFreshMap;
    @Nullable
    private final CurrentLocationListener listener;
    /* access modifiers changed from: private */
    public int loactionRequestType;
    /* access modifiers changed from: private */
    public boolean locationRequestInited;
    /* access modifiers changed from: private */
    public boolean locationRequestStatus;
    /* access modifiers changed from: private */
    public boolean locationRequestTriggered;
    /* access modifiers changed from: private */
    @Nullable
    public Location mCurrentLocation;
    /* access modifiers changed from: private */
    @Nullable
    public FusedLocationProviderClient mFusedLocationClient;
    /* access modifiers changed from: private */
    public float mGpsAccuracy = 200.0f;
    private long mGpsRequestTime;
    @Nullable
    private String mLastUpdateTime;
    /* access modifiers changed from: private */
    @Nullable
    public LocationCallback mLocationCallback;
    @Nullable
    private LocationManager mLocationManager;
    @Nullable
    private LocationRequest mLocationRequest;
    @Nullable
    private LocationSettingsRequest mLocationSettingsRequest;
    @Nullable
    private SettingsClient mSettingsClient;
    /* access modifiers changed from: private */
    public boolean updateCurrentlocRequired;

    public CurrentLocationFetch(@Nullable CurrentLocationListener currentLocationListener, @NotNull Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.listener = currentLocationListener;
        this.activity = activity2;
    }

    private final long getGpsWaitTime() {
        return System.currentTimeMillis() - this.mGpsRequestTime;
    }

    private final String getSreenName() {
        int i11 = this.loactionRequestType;
        CurrentLocHelper currentLocHelper = CurrentLocHelper.INSTANCE;
        if (i11 == currentLocHelper.getIS_FROM_MAP()) {
            return ScreenNames.SCREEN_HOME_MAP;
        }
        if (i11 == currentLocHelper.getIS_FROM_MAP_CURRENT_LOC_ADDRESS()) {
            return ScreenNames.MAPS_SCREEN;
        }
        if (i11 == currentLocHelper.getIS_FROM_CL()) {
            return ScreenNames.SCREEN_CHOOSE_SAVED_ADDRESS;
        }
        return "N/A";
    }

    /* access modifiers changed from: private */
    public final void updateCurrentLoc(int i11) {
        boolean z11;
        CurrentLocHelper currentLocHelper = CurrentLocHelper.INSTANCE;
        if (i11 == currentLocHelper.getIS_FROM_SAVED_LOC() || i11 == currentLocHelper.getIS_FROM_INIT_CL_BG() || i11 == currentLocHelper.getIS_FROM_MAP() || i11 == currentLocHelper.getIS_FROM_CL() || i11 == currentLocHelper.getIS_IGNORE()) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.updateCurrentlocRequired = z11;
    }

    public final boolean checkPermissions() {
        if (ContextCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    public final void deliverToCurrentLocation(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLoc");
        GlobalDataModel.JSON.DeliverCurrentLocation.setValue(LatLngRefactorHelperKt.toGoogle(latLng));
    }

    public final void fetchCurrentLocation() {
        Dexter.withActivity(this.activity).withPermission("android.permission.ACCESS_FINE_LOCATION").withListener(new CurrentLocationFetch$fetchCurrentLocation$1(this)).check();
    }

    @NotNull
    public final Activity getActivity() {
        return this.activity;
    }

    @Nullable
    public final CurrentLocationListener getListener() {
        return this.listener;
    }

    public final int getREQUEST_CHECK_NON_MAP() {
        return this.REQUEST_CHECK_NON_MAP;
    }

    public final int getREQUEST_CHECK_SETTINGS() {
        return this.REQUEST_CHECK_SETTINGS;
    }

    public final void initLocationRequest(@NotNull Context context, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        LocationRepository locationRepository = ((LocationCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(LocationCoreLibApi.class)).getLocationRepository();
        LatLngFactory latLngFactory = ((MapsCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(MapsCoreLibApi.class)).getLatLngFactory();
        Log.e("Location------", "Location request created ");
        this.mFusedLocationClient = locationRepository.newFusedLocationProviderClient();
        this.locationRequestInited = true;
        this.mSettingsClient = locationRepository.newSettingsClient();
        Ref.FloatRef floatRef = new Ref.FloatRef();
        this.loactionRequestType = i11;
        this.mLocationCallback = new CurrentLocationFetch$initLocationRequest$1(floatRef, latLngFactory, this, context);
        LocationRequest newLocationRequest = locationRepository.newLocationRequest();
        this.mLocationRequest = newLocationRequest;
        Intrinsics.checkNotNull(newLocationRequest);
        newLocationRequest.setInterval(this.UPDATE_INTERVAL_IN_MILLISECONDS);
        LocationRequest locationRequest = this.mLocationRequest;
        Intrinsics.checkNotNull(locationRequest);
        locationRequest.setFastestInterval(this.FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        int i12 = this.loactionRequestType;
        CurrentLocHelper currentLocHelper = CurrentLocHelper.INSTANCE;
        if (i12 == currentLocHelper.getIS_FROM_CL() || this.loactionRequestType == currentLocHelper.getIS_FROM_MAP_CURRENT_LOC() || this.loactionRequestType == currentLocHelper.getIS_FROM_MAP()) {
            LocationRequest locationRequest2 = this.mLocationRequest;
            Intrinsics.checkNotNull(locationRequest2);
            locationRequest2.setMaxWaitTime(this.MAXIMUM_WAIT_TIME);
            LocationRequest locationRequest3 = this.mLocationRequest;
            Intrinsics.checkNotNull(locationRequest3);
            locationRequest3.setPriority(LocationRequest.Priority.PRIORITY_HIGH_ACCURACY);
            LocationRequest locationRequest4 = this.mLocationRequest;
            Intrinsics.checkNotNull(locationRequest4);
            locationRequest4.setNumUpdates(1);
        } else if (this.loactionRequestType == currentLocHelper.getIS_FROM_INIT_CL_BG() || this.loactionRequestType == currentLocHelper.getIS_FROM_SAVED_LOC()) {
            LocationRequest locationRequest5 = this.mLocationRequest;
            Intrinsics.checkNotNull(locationRequest5);
            locationRequest5.setPriority(LocationRequest.Priority.PRIORITY_HIGH_ACCURACY);
            LocationRequest locationRequest6 = this.mLocationRequest;
            Intrinsics.checkNotNull(locationRequest6);
            locationRequest6.setNumUpdates(1);
            LocationRequest locationRequest7 = this.mLocationRequest;
            Intrinsics.checkNotNull(locationRequest7);
            locationRequest7.setMaxWaitTime(this.MAXIMUM_WAIT_TIME);
        }
        LocationSettingsRequest.Builder newLocationSettingsRequestBuilder = locationRepository.newLocationSettingsRequestBuilder();
        LocationRequest locationRequest8 = this.mLocationRequest;
        Intrinsics.checkNotNull(locationRequest8);
        newLocationSettingsRequestBuilder.addLocationRequest(locationRequest8);
        this.mLocationSettingsRequest = newLocationSettingsRequestBuilder.build();
        this.mGpsRequestTime = System.currentTimeMillis();
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

    public final void onGpsInfoReceived(@NotNull Context context, float f11, @Nullable Double d11, @Nullable Double d12) {
        Intrinsics.checkNotNullParameter(context, "context");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f11);
        String sb3 = sb2.toString();
        long j11 = this.MAXIMUM_WAIT_TIME;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(j11);
        String sb5 = sb4.toString();
        long gpsWaitTime = getGpsWaitTime();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(gpsWaitTime);
        String sb7 = sb6.toString();
        String value = TrackingUtils.LocationRequest.PriorityHighAccuracy.getValue();
        String sreenName = getSreenName();
        StringBuilder sb8 = new StringBuilder();
        sb8.append(d11);
        String sb9 = sb8.toString();
        StringBuilder sb10 = new StringBuilder();
        sb10.append(d12);
        AppTracker.onGpsInfoReceived(context, sb3, sb5, sb7, value, sreenName, "", sb9, sb10.toString());
    }

    public final void setCurrentLoc(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLoc");
        GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME = LatLngRefactorHelperKt.toGoogle(latLng);
        GlobalDataModel.HOME_SCREEN_MAP.ADDRESS_FUSED_LOCATON = LatLngRefactorHelperKt.toGoogle(latLng);
    }

    @SuppressLint({"MissingPermission"})
    public final void startLocationUpdates(@NotNull Activity activity2) {
        LocationSettingsRequest locationSettingsRequest;
        Intrinsics.checkNotNullParameter(activity2, "activity");
        LocationRequest locationRequest = this.mLocationRequest;
        if (locationRequest != null && (locationSettingsRequest = this.mLocationSettingsRequest) != null) {
            SettingsClient settingsClient = this.mSettingsClient;
            Intrinsics.checkNotNull(settingsClient);
            settingsClient.checkLocationSettings(locationSettingsRequest).addOnSuccessListener(new CurrentLocationFetch$startLocationUpdates$1(this, locationRequest)).addOnFailureListener(new CurrentLocationFetch$startLocationUpdates$2(this, activity2));
        }
    }

    public final void stopLocationUpdates() {
        Log.e("location update stop", "location update stop");
        FusedLocationProviderClient fusedLocationProviderClient = this.mFusedLocationClient;
        if (fusedLocationProviderClient != null) {
            try {
                Intrinsics.checkNotNull(fusedLocationProviderClient);
                LocationCallback locationCallback = this.mLocationCallback;
                if (locationCallback != null) {
                    Task<Void> removeLocationUpdates = fusedLocationProviderClient.removeLocationUpdates(locationCallback);
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

    public final void updateLocationRequestType(int i11) {
        this.loactionRequestType = i11;
    }

    public final boolean userAllowedAllLocationPermissions(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isLocationServiceEnabled(context)) {
            if (checkPermissions()) {
                return true;
            }
            if (this.loactionRequestType == CurrentLocHelper.INSTANCE.getIS_FROM_MAP()) {
                this.isNeedToReFreshMap = true;
            }
        }
        return false;
    }
}
