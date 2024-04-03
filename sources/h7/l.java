package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class l implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35369a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f35370b;

    public /* synthetic */ l(AnalyticsListener.EventTime eventTime, long j11) {
        this.f35369a = eventTime;
        this.f35370b = j11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSeekForwardIncrementChanged(this.f35369a, this.f35370b);
    }
}
