package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.talabat.splash.domain.model.location.CurrentLocationWrapper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¨\u0006\f"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/CLInfrastrcture;", "", "getFetchCurrentLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/splash/domain/model/location/CurrentLocationWrapper;", "params", "", "getGpsStatus", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus;", "getLocationPermissionStatus", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CLInfrastrcture {
    @NotNull
    MutableLiveData<CurrentLocationWrapper> getFetchCurrentLocation(int i11);

    @NotNull
    MutableLiveData<GpsStatus> getGpsStatus();

    @NotNull
    LiveData<PermissionStatus> getLocationPermissionStatus();
}
