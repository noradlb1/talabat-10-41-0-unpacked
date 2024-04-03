package n3;

import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import io.flutter.plugin.common.EventChannel;

public final /* synthetic */ class b implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f44380a;

    public /* synthetic */ b(EventChannel.EventSink eventSink) {
        this.f44380a = eventSink;
    }

    public final void onError(ErrorCodes errorCodes) {
        this.f44380a.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
    }
}
