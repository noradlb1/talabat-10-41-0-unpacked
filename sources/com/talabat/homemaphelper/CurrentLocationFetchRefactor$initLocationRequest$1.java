package com.talabat.homemaphelper;

import android.content.Context;
import android.location.Location;
import com.talabat.location.domain.LocationCallback;
import com.talabat.location.domain.LocationResult;
import com.talabat.maps.domain.LatLngFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/homemaphelper/CurrentLocationFetchRefactor$initLocationRequest$1", "Lcom/talabat/location/domain/LocationCallback;", "onLocationResult", "", "locationResult", "Lcom/talabat/location/domain/LocationResult;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrentLocationFetchRefactor$initLocationRequest$1 extends LocationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CurrentLocationFetchRefactor f60955a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LatLngFactory f60956b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f60957c;

    public CurrentLocationFetchRefactor$initLocationRequest$1(CurrentLocationFetchRefactor currentLocationFetchRefactor, LatLngFactory latLngFactory, Context context) {
        this.f60955a = currentLocationFetchRefactor;
        this.f60956b = latLngFactory;
        this.f60957c = context;
    }

    public void onLocationResult(@Nullable LocationResult locationResult) {
        super.onLocationResult(locationResult);
        if (locationResult != null) {
            CurrentLocationFetchRefactor currentLocationFetchRefactor = this.f60955a;
            currentLocationFetchRefactor.updateCount = currentLocationFetchRefactor.updateCount + 1;
            Location lastLocation = locationResult.getLastLocation();
            if (lastLocation != null) {
                this.f60955a.mCurrentLocation = lastLocation;
                if (lastLocation.getAccuracy() < 150.0f) {
                    this.f60955a.mRequestingLocationUpdates = Boolean.FALSE;
                    this.f60955a.currentLocation(this.f60956b.createLatLng(lastLocation.getLatitude(), lastLocation.getLongitude()));
                    if (!(this.f60955a.getActivity() == null || this.f60957c == null)) {
                        this.f60955a.getListener().onCurrentLocationReceived(true, this.f60955a.mCurrentLocation, lastLocation.getAccuracy());
                    }
                    this.f60955a.stopLocationUpdates();
                } else if (this.f60955a.updateCount == 3) {
                    this.f60955a.stopLocationUpdates();
                    if (this.f60955a.getActivity() != null && this.f60957c != null) {
                        this.f60955a.getListener().onCurrentLocationReceived(false, (Location) null, lastLocation.getAccuracy());
                    }
                }
            }
        } else {
            this.f60955a.stopLocationUpdates();
            if (this.f60955a.getActivity() != null && this.f60957c != null) {
                this.f60955a.getListener().onCurrentLocationReceived(false, (Location) null, 0.0f);
            }
        }
    }
}
