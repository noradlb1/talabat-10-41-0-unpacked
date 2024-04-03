package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35338a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f35339b;

    public /* synthetic */ g1(AnalyticsListener.EventTime eventTime, boolean z11) {
        this.f35338a = eventTime;
        this.f35339b = z11;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onIsLoadingChanged$32(this.f35338a, this.f35339b, (AnalyticsListener) obj);
    }
}
