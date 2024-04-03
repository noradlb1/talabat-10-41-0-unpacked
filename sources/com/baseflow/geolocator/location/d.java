package com.baseflow.geolocator.location;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class d implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationServiceListener f43237b;

    public /* synthetic */ d(LocationServiceListener locationServiceListener) {
        this.f43237b = locationServiceListener;
    }

    public final void onComplete(Task task) {
        FusedLocationClient.lambda$isLocationServiceEnabled$0(this.f43237b, task);
    }
}
