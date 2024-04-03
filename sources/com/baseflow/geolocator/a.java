package com.baseflow.geolocator;

import android.location.Location;
import com.baseflow.geolocator.location.LocationMapper;
import com.baseflow.geolocator.location.PositionChangedCallback;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements PositionChangedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43209a;

    public /* synthetic */ a(MethodChannel.Result result) {
        this.f43209a = result;
    }

    public final void onPositionChanged(Location location) {
        this.f43209a.success(LocationMapper.toHashMap(location));
    }
}
