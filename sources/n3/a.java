package n3;

import android.location.Location;
import com.baseflow.geolocator.location.LocationMapper;
import com.baseflow.geolocator.location.PositionChangedCallback;
import io.flutter.plugin.common.EventChannel;

public final /* synthetic */ class a implements PositionChangedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f44379a;

    public /* synthetic */ a(EventChannel.EventSink eventSink) {
        this.f44379a = eventSink;
    }

    public final void onPositionChanged(Location location) {
        this.f44379a.success(LocationMapper.toHashMap(location));
    }
}
