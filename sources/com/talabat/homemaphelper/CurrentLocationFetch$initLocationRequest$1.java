package com.talabat.homemaphelper;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.talabat.location.domain.LocationCallback;
import com.talabat.location.domain.LocationResult;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maputils.CurrentLocHelper;
import com.talabat.userandlocation.LatLngRefactorHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/homemaphelper/CurrentLocationFetch$initLocationRequest$1", "Lcom/talabat/location/domain/LocationCallback;", "onLocationResult", "", "locationResult", "Lcom/talabat/location/domain/LocationResult;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrentLocationFetch$initLocationRequest$1 extends LocationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f60946a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LatLngFactory f60947b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrentLocationFetch f60948c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f60949d;

    public CurrentLocationFetch$initLocationRequest$1(Ref.FloatRef floatRef, LatLngFactory latLngFactory, CurrentLocationFetch currentLocationFetch, Context context) {
        this.f60946a = floatRef;
        this.f60947b = latLngFactory;
        this.f60948c = currentLocationFetch;
        this.f60949d = context;
    }

    public void onLocationResult(@Nullable LocationResult locationResult) {
        CurrentLocationListener listener;
        CurrentLocationListener listener2;
        CurrentLocationListener listener3;
        CurrentLocationListener listener4;
        CurrentLocationListener listener5;
        super.onLocationResult(locationResult);
        if (locationResult != null) {
            Location lastLocation = locationResult.getLastLocation();
            if (lastLocation != null) {
                this.f60946a.element = lastLocation.getAccuracy();
                LatLng createLatLng = this.f60947b.createLatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
                this.f60948c.mCurrentLocation = locationResult.getLastLocation();
                float accuracy = lastLocation.getAccuracy();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(accuracy);
                Log.e("LOCATION_REC_Accuracy", sb2.toString());
                boolean z11 = true;
                if (!lastLocation.hasAccuracy() || lastLocation.getAccuracy() >= this.f60948c.mGpsAccuracy) {
                    int access$getLoactionRequestType$p = this.f60948c.loactionRequestType;
                    CurrentLocHelper currentLocHelper = CurrentLocHelper.INSTANCE;
                    if (access$getLoactionRequestType$p == currentLocHelper.getIS_FROM_CL() || this.f60948c.loactionRequestType == currentLocHelper.getIS_FROM_MAP() || this.f60948c.loactionRequestType == currentLocHelper.getIS_FROM_MAP_CURRENT_LOC_ADDRESS()) {
                        CurrentLocationListener listener6 = this.f60948c.getListener();
                        if (listener6 != null) {
                            listener6.onCurrentLocationReceivedWithLowAccuracy(LatLngRefactorHelperKt.toGoogle(createLatLng), this.f60946a.element);
                        }
                    } else if (this.f60948c.updateCurrentlocRequired && (listener3 = this.f60948c.getListener()) != null) {
                        listener3.onCurrentLocationReceived((com.google.android.gms.maps.model.LatLng) null, true, this.f60946a.element);
                    }
                } else {
                    CurrentLocationFetch currentLocationFetch = this.f60948c;
                    currentLocationFetch.updateCurrentLoc(currentLocationFetch.loactionRequestType);
                    int access$getLoactionRequestType$p2 = this.f60948c.loactionRequestType;
                    CurrentLocHelper currentLocHelper2 = CurrentLocHelper.INSTANCE;
                    if (access$getLoactionRequestType$p2 == currentLocHelper2.getIS_FROM_SAVED_LOC()) {
                        this.f60948c.setCurrentLoc(createLatLng);
                    } else if (access$getLoactionRequestType$p2 == currentLocHelper2.getIS_FROM_MAP()) {
                        CurrentLocationListener listener7 = this.f60948c.getListener();
                        if (listener7 != null) {
                            listener7.isRefreshMap(true, LatLngRefactorHelperKt.toGoogle(createLatLng));
                        }
                    } else if (access$getLoactionRequestType$p2 == currentLocHelper2.getIS_FROM_INIT_CL_BG()) {
                        this.f60948c.deliverToCurrentLocation(createLatLng);
                    } else if (access$getLoactionRequestType$p2 == currentLocHelper2.getIS_FROM_CL()) {
                        CurrentLocationListener listener8 = this.f60948c.getListener();
                        if (listener8 != null) {
                            listener8.deliverToCLRecived(LatLngRefactorHelperKt.toGoogle(createLatLng));
                        }
                    } else {
                        if (!(access$getLoactionRequestType$p2 == currentLocHelper2.getIS_FROM_MAP_CURRENT_LOC() || access$getLoactionRequestType$p2 == currentLocHelper2.getIS_FROM_MAP_CURRENT_LOC_ADDRESS())) {
                            z11 = false;
                        }
                        if (z11 && (listener5 = this.f60948c.getListener()) != null) {
                            listener5.mapCurrentLocReceived(LatLngRefactorHelperKt.toGoogle(createLatLng));
                        }
                    }
                    if (this.f60948c.updateCurrentlocRequired && (listener4 = this.f60948c.getListener()) != null) {
                        listener4.onCurrentLocationReceived(LatLngRefactorHelperKt.toGoogle(createLatLng), false, this.f60946a.element);
                    }
                }
                if (createLatLng != null) {
                    this.f60948c.onGpsInfoReceived(this.f60949d, this.f60946a.element, Double.valueOf(createLatLng.getLatitude()), Double.valueOf(createLatLng.getLongitude()));
                }
            } else if (this.f60948c.updateCurrentlocRequired && (listener2 = this.f60948c.getListener()) != null) {
                listener2.onCurrentLocationReceived((com.google.android.gms.maps.model.LatLng) null, false, this.f60946a.element);
            }
        } else if (this.f60948c.updateCurrentlocRequired && (listener = this.f60948c.getListener()) != null) {
            listener.onCurrentLocationReceived((com.google.android.gms.maps.model.LatLng) null, false, this.f60946a.element);
        }
        int access$getLoactionRequestType$p3 = this.f60948c.loactionRequestType;
        CurrentLocHelper currentLocHelper3 = CurrentLocHelper.INSTANCE;
        if (access$getLoactionRequestType$p3 == currentLocHelper3.getIS_FROM_SAVED_LOC() || this.f60948c.loactionRequestType == currentLocHelper3.getIS_FROM_MAP() || this.f60948c.loactionRequestType == currentLocHelper3.getIS_FROM_MAP_CURRENT_LOC_ADDRESS()) {
            this.f60948c.stopLocationUpdates();
        }
    }
}
