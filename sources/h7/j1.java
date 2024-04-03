package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35361a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f35362b;

    public /* synthetic */ j1(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f35361a = eventTime;
        this.f35362b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDrmSessionManagerError(this.f35361a, this.f35362b);
    }
}
