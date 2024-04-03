package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35304a;

    public /* synthetic */ b0(AnalyticsListener.EventTime eventTime) {
        this.f35304a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayerReleased(this.f35304a);
    }
}
