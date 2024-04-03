package com.baseflow.geolocator;

import android.location.Location;
import com.baseflow.geolocator.location.LocationClient;
import com.baseflow.geolocator.location.PositionChangedCallback;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class f implements PositionChangedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodCallHandlerImpl f43215a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean[] f43216b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LocationClient f43217c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f43218d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43219e;

    public /* synthetic */ f(MethodCallHandlerImpl methodCallHandlerImpl, boolean[] zArr, LocationClient locationClient, String str, MethodChannel.Result result) {
        this.f43215a = methodCallHandlerImpl;
        this.f43216b = zArr;
        this.f43217c = locationClient;
        this.f43218d = str;
        this.f43219e = result;
    }

    public final void onPositionChanged(Location location) {
        this.f43215a.lambda$onGetCurrentPosition$5(this.f43216b, this.f43217c, this.f43218d, this.f43219e, location);
    }
}
