package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class d0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35320a;

    public /* synthetic */ d0(AnalyticsListener.EventTime eventTime) {
        this.f35320a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDrmKeysRemoved(this.f35320a);
    }
}
