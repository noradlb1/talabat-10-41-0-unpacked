package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35340a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35341b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f35342c;

    public /* synthetic */ h(AnalyticsListener.EventTime eventTime, int i11, boolean z11) {
        this.f35340a = eventTime;
        this.f35341b = i11;
        this.f35342c = z11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDeviceVolumeChanged(this.f35340a, this.f35341b, this.f35342c);
    }
}
