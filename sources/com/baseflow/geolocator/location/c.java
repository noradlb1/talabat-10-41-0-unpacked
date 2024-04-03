package com.baseflow.geolocator.location;

import android.app.Activity;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class c implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FusedLocationClient f43234a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f43235b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ErrorCallback f43236c;

    public /* synthetic */ c(FusedLocationClient fusedLocationClient, Activity activity, ErrorCallback errorCallback) {
        this.f43234a = fusedLocationClient;
        this.f43235b = activity;
        this.f43236c = errorCallback;
    }

    public final void onFailure(Exception exc) {
        this.f43234a.lambda$startPositionUpdates$3(this.f43235b, this.f43236c, exc);
    }
}
