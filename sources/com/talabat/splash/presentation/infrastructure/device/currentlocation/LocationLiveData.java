package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.location.domain.FusedLocationProviderClient;
import com.talabat.location.domain.LocationRepository;
import com.talabat.location.domain.LocationRequest;
import com.talabat.splash.domain.model.location.CurrentLocationWrapper;
import com.talabat.splash.presentation.infrastructure.thirdparty.Tracking;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.TrackingUtils;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001,\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u001f\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b/\u00100J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002JG\u0010\u0017\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0005H\u0014J\b\u0010\u001a\u001a\u00020\u0005H\u0015J\u000f\u0010\u001d\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u001e\u001a\u00020\u0005R\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010$R\u0014\u0010-\u001a\u00020,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/LocationLiveData;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/splash/domain/model/location/CurrentLocationWrapper;", "Landroid/location/Location;", "location", "", "setCurrentLocation", "", "isLocationFetchSuccess", "setLocationData", "setLocationHome", "", "requestTimeInMSeconds", "getGpsWaitTime", "", "gpsAccuracy", "gpsMaximumWaitTime", "gpsWaitTime", "", "thresholdGpsAccuracy", "", "locationLat", "locationLon", "onGpsInfoReceivedTracking", "(Ljava/lang/Float;JJLjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "f", "e", "startLocationUpdates$com_talabat_talabat_talabat", "()V", "startLocationUpdates", "stopLocationUpdates", "Lcom/talabat/location/domain/LocationRepository;", "locationRepository", "Lcom/talabat/location/domain/LocationRepository;", "", "locationRequestType", "I", "Lcom/talabat/splash/presentation/infrastructure/thirdparty/Tracking;", "tracking", "Lcom/talabat/splash/presentation/infrastructure/thirdparty/Tracking;", "Lcom/talabat/location/domain/FusedLocationProviderClient;", "fusedLocationClient", "Lcom/talabat/location/domain/FusedLocationProviderClient;", "locationUpdateCount", "com/talabat/splash/presentation/infrastructure/device/currentlocation/LocationLiveData$locationCallback$1", "locationCallback", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/LocationLiveData$locationCallback$1;", "<init>", "(Lcom/talabat/location/domain/LocationRepository;ILcom/talabat/splash/presentation/infrastructure/thirdparty/Tracking;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0})
public final class LocationLiveData extends MutableLiveData<CurrentLocationWrapper> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final FusedLocationProviderClient fusedLocationClient;
    @NotNull
    private final LocationLiveData$locationCallback$1 locationCallback = new LocationLiveData$locationCallback$1(this);
    @NotNull
    private final LocationRepository locationRepository;
    private final int locationRequestType;
    /* access modifiers changed from: private */
    public int locationUpdateCount;
    @NotNull

    /* renamed from: tracking  reason: collision with root package name */
    private final Tracking f61502tracking;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/LocationLiveData$Companion;", "", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LocationLiveData(@NotNull LocationRepository locationRepository2, int i11, @NotNull Tracking tracking2) {
        Intrinsics.checkNotNullParameter(locationRepository2, "locationRepository");
        Intrinsics.checkNotNullParameter(tracking2, "tracking");
        this.locationRepository = locationRepository2;
        this.locationRequestType = i11;
        this.f61502tracking = tracking2;
        this.fusedLocationClient = locationRepository2.newFusedLocationProviderClient();
    }

    private final long getGpsWaitTime(long j11) {
        return System.currentTimeMillis() - j11;
    }

    private final void onGpsInfoReceivedTracking(Float f11, long j11, long j12, String str, Double d11, Double d12) {
        this.f61502tracking.onGpsInfoReceived(f11, j11, j12, str, d11, d12, this.locationRequestType);
    }

    /* access modifiers changed from: private */
    public final void setCurrentLocation(Location location) {
        if (location.getAccuracy() < LocationLiveDataKt.LOCATION_ACCURACY) {
            setLocationData(location, true);
            setLocationHome(location);
            stopLocationUpdates();
        } else if (this.locationUpdateCount == LocationLiveDataKt.LOCATION_UPDATE_COUNT) {
            setLocationData((Location) null, false);
            stopLocationUpdates();
        }
    }

    private final void setLocationData(Location location, boolean z11) {
        Float f11;
        Float f12;
        Double d11;
        Double d12 = null;
        if (location != null) {
            f11 = Float.valueOf(location.getAccuracy());
        } else {
            f11 = null;
        }
        setValue(new CurrentLocationWrapper(z11, location, f11));
        if (location != null) {
            f12 = Float.valueOf(location.getAccuracy());
        } else {
            f12 = null;
        }
        long update_interval_in_milliseconds = LocationLiveDataKt.getUPDATE_INTERVAL_IN_MILLISECONDS();
        long gpsWaitTime = getGpsWaitTime(LocationLiveDataKt.mGpsRequestTime);
        String value = TrackingUtils.LocationRequest.PriorityHighAccuracy.getValue();
        if (location != null) {
            d11 = Double.valueOf(location.getLatitude());
        } else {
            d11 = null;
        }
        if (location != null) {
            d12 = Double.valueOf(location.getLongitude());
        }
        onGpsInfoReceivedTracking(f12, update_interval_in_milliseconds, gpsWaitTime, value, d11, d12);
    }

    private final void setLocationHome(Location location) {
        if (location != null) {
            GlobalDataModel.JSON.CurrentLocationFromStart.setValue(new LatLng(location.getLatitude(), location.getLongitude()));
        }
    }

    @SuppressLint({"MissingPermission"})
    public void e() {
        super.e();
        this.fusedLocationClient.getLastLocation().addOnSuccessListener(new LocationLiveData$onActive$1(this));
        startLocationUpdates$com_talabat_talabat_talabat();
    }

    public void f() {
        super.f();
        this.fusedLocationClient.removeLocationUpdates(this.locationCallback);
    }

    @VisibleForTesting(otherwise = 2)
    @SuppressLint({"MissingPermission"})
    public final void startLocationUpdates$com_talabat_talabat_talabat() {
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        LocationRequest newLocationRequest = this.locationRepository.newLocationRequest();
        newLocationRequest.setInterval(LocationLiveDataKt.getUPDATE_INTERVAL_IN_MILLISECONDS());
        newLocationRequest.setFastestInterval(LocationLiveDataKt.getFASTEST_UPDATE_INTERVAL_IN_MILLISECONDS());
        newLocationRequest.setPriority(LocationRequest.Priority.PRIORITY_HIGH_ACCURACY);
        newLocationRequest.setNumUpdates(3);
        fusedLocationProviderClient.requestLocationUpdates(newLocationRequest, this.locationCallback, (Looper) null);
        LocationLiveDataKt.mGpsRequestTime = System.currentTimeMillis();
    }

    public final void stopLocationUpdates() {
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        Intrinsics.checkNotNull(fusedLocationProviderClient);
        LocationLiveData$locationCallback$1 locationLiveData$locationCallback$1 = this.locationCallback;
        Intrinsics.checkNotNull(locationLiveData$locationCallback$1);
        fusedLocationProviderClient.removeLocationUpdates(locationLiveData$locationCallback$1);
    }
}
