package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35311a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f35312b;

    public /* synthetic */ c0(AnalyticsListener.EventTime eventTime, boolean z11) {
        this.f35311a = eventTime;
        this.f35312b = z11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onIsPlayingChanged(this.f35311a, this.f35312b);
    }
}
