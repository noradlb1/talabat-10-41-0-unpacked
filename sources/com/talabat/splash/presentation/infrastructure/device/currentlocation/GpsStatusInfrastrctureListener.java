package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import android.content.Context;
import android.location.LocationManager;
import androidx.lifecycle.MutableLiveData;
import com.talabat.location.domain.LocationRepository;
import com.talabat.location.domain.LocationRequest;
import com.talabat.location.domain.LocationSettingsRequest;
import com.talabat.location.domain.SettingsClient;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.GpsStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0006\u0010\u0005\u001a\u00020\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006XD¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatusInfrastrctureListener;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus;", "", "e", "turnGPSOn", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/talabat/location/domain/LocationSettingsRequest;", "locationSettingsRequest", "Lcom/talabat/location/domain/LocationSettingsRequest;", "Landroid/location/LocationManager;", "locationManager", "Landroid/location/LocationManager;", "Lcom/talabat/location/domain/SettingsClient;", "settingsClient", "Lcom/talabat/location/domain/SettingsClient;", "", "GPS_REQUEST", "I", "getGPS_REQUEST", "()I", "Lcom/talabat/location/domain/LocationRepository;", "locationRepository", "<init>", "(Landroid/content/Context;Lcom/talabat/location/domain/LocationRepository;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0})
public final class GpsStatusInfrastrctureListener extends MutableLiveData<GpsStatus> {
    private final int GPS_REQUEST;
    @NotNull
    private final Context context;
    @NotNull
    private final LocationManager locationManager;
    @NotNull
    private final LocationSettingsRequest locationSettingsRequest;
    @NotNull
    private final SettingsClient settingsClient;

    public GpsStatusInfrastrctureListener(@NotNull Context context2, @NotNull LocationRepository locationRepository) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(locationRepository, "locationRepository");
        this.context = context2;
        Object systemService = context2.getSystemService("location");
        if (systemService != null) {
            this.locationManager = (LocationManager) systemService;
            this.settingsClient = locationRepository.newSettingsClient();
            this.GPS_REQUEST = 101;
            LocationSettingsRequest.Builder newLocationSettingsRequestBuilder = locationRepository.newLocationSettingsRequestBuilder();
            LocationRequest newLocationRequest = locationRepository.newLocationRequest();
            newLocationRequest.setInterval(LocationLiveDataKt.getUPDATE_INTERVAL_IN_MILLISECONDS());
            newLocationRequest.setFastestInterval(LocationLiveDataKt.getFASTEST_UPDATE_INTERVAL_IN_MILLISECONDS());
            newLocationRequest.setPriority(LocationRequest.Priority.PRIORITY_HIGH_ACCURACY);
            newLocationRequest.setNumUpdates(3);
            LocationSettingsRequest.Builder addLocationRequest = newLocationSettingsRequestBuilder.addLocationRequest(newLocationRequest);
            addLocationRequest.setAlwaysShow(true);
            this.locationSettingsRequest = addLocationRequest.build();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }

    public void e() {
        turnGPSOn();
    }

    public final int getGPS_REQUEST() {
        return this.GPS_REQUEST;
    }

    public final void turnGPSOn() {
        if (this.locationManager.isProviderEnabled("gps")) {
            postValue(new GpsStatus.Enabled(true));
        } else {
            this.settingsClient.checkLocationSettings(this.locationSettingsRequest).addOnSuccessListener(new GpsStatusInfrastrctureListener$turnGPSOn$1(this)).addOnFailureListener(new GpsStatusInfrastrctureListener$turnGPSOn$2(this));
        }
    }
}
