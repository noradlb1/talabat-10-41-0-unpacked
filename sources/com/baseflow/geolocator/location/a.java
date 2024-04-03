package com.baseflow.geolocator.location;

import com.baseflow.geolocator.errors.ErrorCallback;
import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class a implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ErrorCallback f43232a;

    public /* synthetic */ a(ErrorCallback errorCallback) {
        this.f43232a = errorCallback;
    }

    public final void onFailure(Exception exc) {
        FusedLocationClient.lambda$getLastKnownPosition$1(this.f43232a, exc);
    }
}
