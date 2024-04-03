package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35390a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f35391b;

    public /* synthetic */ o(AnalyticsListener.EventTime eventTime, boolean z11) {
        this.f35390a = eventTime;
        this.f35391b = z11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSkipSilenceEnabledChanged(this.f35390a, this.f35391b);
    }
}
