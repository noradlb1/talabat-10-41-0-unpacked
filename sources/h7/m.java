package h7;

import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35375a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceInfo f35376b;

    public /* synthetic */ m(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        this.f35375a = eventTime;
        this.f35376b = deviceInfo;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDeviceInfoChanged(this.f35375a, this.f35376b);
    }
}
