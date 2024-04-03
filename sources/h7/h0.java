package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35343a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f35344b;

    public /* synthetic */ h0(AnalyticsListener.EventTime eventTime, long j11) {
        this.f35343a = eventTime;
        this.f35344b = j11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSeekBackIncrementChanged(this.f35343a, this.f35344b);
    }
}
