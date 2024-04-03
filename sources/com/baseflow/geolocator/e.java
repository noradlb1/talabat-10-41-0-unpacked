package com.baseflow.geolocator;

import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class e implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43213a;

    public /* synthetic */ e(MethodChannel.Result result) {
        this.f43213a = result;
    }

    public final void onError(ErrorCodes errorCodes) {
        this.f43213a.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
    }
}
