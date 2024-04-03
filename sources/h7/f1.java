package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35333a;

    public /* synthetic */ f1(AnalyticsListener.EventTime eventTime) {
        this.f35333a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDrmKeysRestored(this.f35333a);
    }
}
