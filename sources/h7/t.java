package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class t implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35425a;

    public /* synthetic */ t(AnalyticsListener.EventTime eventTime) {
        this.f35425a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDrmKeysLoaded(this.f35425a);
    }
}
