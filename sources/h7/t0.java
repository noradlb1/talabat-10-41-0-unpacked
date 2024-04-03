package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class t0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35426a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f35427b;

    public /* synthetic */ t0(AnalyticsListener.EventTime eventTime, float f11) {
        this.f35426a = eventTime;
        this.f35427b = f11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onVolumeChanged(this.f35426a, this.f35427b);
    }
}
