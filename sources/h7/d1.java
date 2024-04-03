package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class d1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35321a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35322b;

    public /* synthetic */ d1(AnalyticsListener.EventTime eventTime, int i11) {
        this.f35321a = eventTime;
        this.f35322b = i11;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onDrmSessionAcquired$62(this.f35321a, this.f35322b, (AnalyticsListener) obj);
    }
}
