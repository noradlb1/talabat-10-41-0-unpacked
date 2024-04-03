package com.baseflow.geolocator.location;

import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class b implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FusedLocationClient f43233a;

    public /* synthetic */ b(FusedLocationClient fusedLocationClient) {
        this.f43233a = fusedLocationClient;
    }

    public final void onSuccess(Object obj) {
        this.f43233a.lambda$startPositionUpdates$2((LocationSettingsResponse) obj);
    }
}
