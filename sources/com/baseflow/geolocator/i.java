package com.baseflow.geolocator;

import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import io.flutter.plugin.common.EventChannel;

public final /* synthetic */ class i implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f43226a;

    public /* synthetic */ i(EventChannel.EventSink eventSink) {
        this.f43226a = eventSink;
    }

    public final void onError(ErrorCodes errorCodes) {
        this.f43226a.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
    }
}
