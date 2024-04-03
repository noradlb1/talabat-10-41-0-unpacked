package com.baseflow.geolocator;

import com.baseflow.geolocator.permission.LocationPermission;
import com.baseflow.geolocator.permission.PermissionResultCallback;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class d implements PermissionResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43212a;

    public /* synthetic */ d(MethodChannel.Result result) {
        this.f43212a = result;
    }

    public final void onResult(LocationPermission locationPermission) {
        this.f43212a.success(Integer.valueOf(locationPermission.toInt()));
    }
}
