package com.baseflow.geolocator;

import android.location.Location;
import com.baseflow.geolocator.location.LocationMapper;
import com.baseflow.geolocator.location.PositionChangedCallback;
import io.flutter.plugin.common.EventChannel;

public final /* synthetic */ class h implements PositionChangedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f43225a;

    public /* synthetic */ h(EventChannel.EventSink eventSink) {
        this.f43225a = eventSink;
    }

    public final void onPositionChanged(Location location) {
        this.f43225a.success(LocationMapper.toHashMap(location));
    }
}
