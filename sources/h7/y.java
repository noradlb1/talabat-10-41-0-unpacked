package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35449a;

    public /* synthetic */ y(AnalyticsListener.EventTime eventTime) {
        this.f35449a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDrmSessionReleased(this.f35449a);
    }
}
