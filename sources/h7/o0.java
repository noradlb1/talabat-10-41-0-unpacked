package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35392a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f35393b;

    public /* synthetic */ o0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f35392a = eventTime;
        this.f35393b = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onUpstreamDiscarded(this.f35392a, this.f35393b);
    }
}
