package com.baseflow.geolocator;

import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class b implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43210a;

    public /* synthetic */ b(MethodChannel.Result result) {
        this.f43210a = result;
    }

    public final void onError(ErrorCodes errorCodes) {
        this.f43210a.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
    }
}
