package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class k1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35367a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35368b;

    public /* synthetic */ k1(AnalyticsListener.EventTime eventTime, int i11) {
        this.f35367a = eventTime;
        this.f35368b = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onTimelineChanged(this.f35367a, this.f35368b);
    }
}
