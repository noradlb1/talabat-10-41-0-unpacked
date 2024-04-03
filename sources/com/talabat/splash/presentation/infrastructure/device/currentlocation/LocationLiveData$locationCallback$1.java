package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import android.location.Location;
import com.talabat.location.domain.LocationCallback;
import com.talabat.location.domain.LocationResult;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/splash/presentation/infrastructure/device/currentlocation/LocationLiveData$locationCallback$1", "Lcom/talabat/location/domain/LocationCallback;", "onLocationResult", "", "locationResult", "Lcom/talabat/location/domain/LocationResult;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationLiveData$locationCallback$1 extends LocationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationLiveData f61503a;

    public LocationLiveData$locationCallback$1(LocationLiveData locationLiveData) {
        this.f61503a = locationLiveData;
    }

    public void onLocationResult(@Nullable LocationResult locationResult) {
        Location location;
        if (locationResult != null) {
            location = locationResult.getLastLocation();
        } else {
            location = null;
        }
        if (location != null) {
            LocationLiveData locationLiveData = this.f61503a;
            locationLiveData.locationUpdateCount = locationLiveData.locationUpdateCount + 1;
            this.f61503a.setCurrentLocation(location);
        }
    }
}
