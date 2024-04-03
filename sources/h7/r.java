package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35411a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f35412b;

    public /* synthetic */ r(AnalyticsListener.EventTime eventTime, long j11) {
        this.f35411a = eventTime;
        this.f35412b = j11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMaxSeekToPreviousPositionChanged(this.f35411a, this.f35412b);
    }
}
