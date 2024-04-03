package com.baseflow.geolocator;

import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.location.LocationClient;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class g implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodCallHandlerImpl f43220a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean[] f43221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LocationClient f43222c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f43223d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43224e;

    public /* synthetic */ g(MethodCallHandlerImpl methodCallHandlerImpl, boolean[] zArr, LocationClient locationClient, String str, MethodChannel.Result result) {
        this.f43220a = methodCallHandlerImpl;
        this.f43221b = zArr;
        this.f43222c = locationClient;
        this.f43223d = str;
        this.f43224e = result;
    }

    public final void onError(ErrorCodes errorCodes) {
        this.f43220a.lambda$onGetCurrentPosition$6(this.f43221b, this.f43222c, this.f43223d, this.f43224e, errorCodes);
    }
}
