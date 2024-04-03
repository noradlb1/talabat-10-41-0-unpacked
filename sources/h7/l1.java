package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class l1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35374a;

    public /* synthetic */ l1(AnalyticsListener.EventTime eventTime) {
        this.f35374a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSeekProcessed(this.f35374a);
    }
}
