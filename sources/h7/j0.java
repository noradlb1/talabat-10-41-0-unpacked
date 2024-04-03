package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35359a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35360b;

    public /* synthetic */ j0(AnalyticsListener.EventTime eventTime, int i11) {
        this.f35359a = eventTime;
        this.f35360b = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlaybackSuppressionReasonChanged(this.f35359a, this.f35360b);
    }
}
