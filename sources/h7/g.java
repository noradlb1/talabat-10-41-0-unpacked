package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35334a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f35335b;

    public /* synthetic */ g(AnalyticsListener.EventTime eventTime, boolean z11) {
        this.f35334a = eventTime;
        this.f35335b = z11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onShuffleModeChanged(this.f35334a, this.f35335b);
    }
}
